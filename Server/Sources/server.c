//
// Created by nicko on 10/04/18.
//

#include "../Headers/server.h"
#include "../../JSON/Headers/json_builder.h"

void* socketHandler(void*);
struct sockaddr_in sadr;
struct state game;


void server(int host_port) {
    struct sockaddr_in my_addr;
    int hsock;
    int* p_int;
    int err;
    socklen_t  addr_size = 0;
    int* csock;

    pthread_t thread_id=0;


    hsock = socket(AF_INET, SOCK_STREAM, 0);
    if(hsock == -1){
        printf("Error iniciando el socket %d\n", errno);
        goto FINISH;
    }

    p_int = (int*)malloc(sizeof(int));
    *p_int = 1;

    if( (setsockopt(hsock, SOL_SOCKET, SO_REUSEADDR, (char*)p_int, sizeof(int)) == -1 )||
        (setsockopt(hsock, SOL_SOCKET, SO_KEEPALIVE, (char*)p_int, sizeof(int)) == -1 ) ){
        printf("Error al setear las opciones %d\n", errno);
        free(p_int);
        goto FINISH;
    }
    free(p_int);

    my_addr.sin_family = AF_INET ;
    my_addr.sin_port = htons(host_port);

    memset(&(my_addr.sin_zero), 0, 8);
    my_addr.sin_addr.s_addr = INADDR_ANY ;

    if( bind( hsock, (struct sockaddr*)&my_addr, sizeof(my_addr)) == -1 ){
        fprintf(stderr,"Error uniendo al socket, asegurece de que el puerto esta libre %d\n",errno);
        goto FINISH;
    }
    if(listen( hsock, 10) == -1 ){
        fprintf(stderr, "Error al escuchar %d\n",errno);
        goto FINISH;
    }

    //Now lets do the Server stuff

    addr_size = sizeof(struct sockaddr_in);

    while(true){
        printf("Esperando una connecion escuchando %i port\n", host_port);
        csock = (int*)malloc(sizeof(int));
        if((*csock = accept( hsock, (struct sockaddr*)&sadr, &addr_size))!= -1){
            printf("---------------------\nConexion recivida de  %s\n",
                   inet_ntoa(sadr.sin_addr));
            pthread_create(&thread_id,0,&socketHandler, (void*)csock );
            pthread_detach(thread_id);
        }
        else{
            fprintf(stderr, "Error al aceptar conexion %d\n", errno);
        }
    }

    FINISH:
    ;
}

void* socketHandler(void* lp){
    int *csock = (int*)lp;

    int buffer_len = 1024;
    int respuesta_len = 21737;
    char respuesta[respuesta_len];
    char buffer[buffer_len];
    int bytecount;

    memset(buffer, '\0', buffer_len);

    if((bytecount = recv(*csock, buffer, buffer_len, 0))== -1){
        fprintf(stderr, "Error al recivir data %d\n", errno);
        //goto FINISH;
    }

    printf("Bytes recividos %d\nMensaje recivido \"%s\"\nDe %s\n", bytecount, buffer,inet_ntoa(sadr.sin_addr));

    char* msg = (char*)malloc(strlen(buffer));
    for (int i = 0; i < strlen(buffer); ++i) {
        *(msg+i) = buffer[i];
    }

    char* resp = analyze_msg(msg);

    char* rRep = (char*)malloc(respuesta_len+1* sizeof(char));
    int x = 0;
    int espcChars = 0;
    while (*(resp+x)!='\0') {
        if (!((*(resp+x) == '\n') || (*(resp+x) == '\t') || (*(resp+x) == ' '))) {
            *(rRep+espcChars) = *(resp+x);
            espcChars += 1;
        }
        x+=1;
    }

    strcat(rRep,"\n");


    free(msg);

    if((bytecount = send(*csock, rRep, strlen(rRep), 0))== -1){
        fprintf(stderr, "Error al responder data %d\n", errno);
        goto FINISH;
    }

//    free(rRep);

//    printf("%s\n", rRep);
    printf("Sent bytes %d\n", bytecount);


    FINISH:
    free(csock);
}

char* analyze_msg(char* msg){
    cJSON* root = cJSON_Parse(msg);
    cJSON* respuesta = NULL;
    char* respuesta_STRING;

    char* message_type = cJSON_GetObjectItem(root, "message_type")->valuestring;

    if (strcmp(message_type, "get_update") == 0){
        respuesta = game_state(&game);
        respuesta_STRING = cJSON_Print(respuesta);
        return respuesta_STRING;
    }

    else if (strcmp(message_type, "player_move") == 0){
        char* move = cJSON_GetObjectItem(root, "dir")->valuestring;
        update_player(&game, *move);
        respuesta = game_state(&game);
        respuesta_STRING = cJSON_Print(respuesta);
        return respuesta_STRING;
    }

    else if (strcmp(message_type, "begin_game") == 0){
        game = game_core();
        respuesta = game_state(&game);
        respuesta_STRING = cJSON_Print(respuesta);
        return respuesta_STRING;
    }

    else if (strcmp(message_type, "watch_game") == 0){
        respuesta = game_state(&game);
        respuesta_STRING = cJSON_Print(respuesta);
        return respuesta_STRING;
    }

    else if (strcmp(message_type, "1") == 0) {
        int row, col;
        row = cJSON_GetObjectItem(root, "row")->valueint;
        col = cJSON_GetObjectItem(root, "col")->valueint;
        update_ghost(&game, row, col);
        return "Done!";
    }

    else if (strcmp(message_type, "2") == 0) {
        int row, col;
        row = cJSON_GetObjectItem(root, "row")->valueint;
        col = cJSON_GetObjectItem(root, "col")->valueint;
        crearPastilla(&game, row, col);
        return "Done!";
    }

    else if (strcmp(message_type, "3") == 0) {
        int row, col;
        row = cJSON_GetObjectItem(root, "row")->valueint;
        col = cJSON_GetObjectItem(root, "col")->valueint;
        crearFruta(&game, row, col);
        return "Done!";
    }

    else if (strcmp(message_type, "4") == 0) {
        int speed;
        speed = cJSON_GetObjectItem(root, "speed")->valueint;
        update_ghostSpeed(&game, speed);
        return "Done!";
    }

    else {
        cJSON* rRoot = cJSON_CreateObject();
        cJSON* value = cJSON_CreateString("FUERA DEL PROTOCOLO");
        cJSON_AddItemToObject(rRoot, "WARNING!", value);
        return cJSON_Print(rRoot);
    }
}