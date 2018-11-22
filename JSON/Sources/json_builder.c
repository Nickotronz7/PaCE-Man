//
// Created by nicko on 10/04/18.
//

#include "../Headers/json_builder.h"

cJSON* game_state(struct state* game){

    cJSON* root = cJSON_CreateObject();
    cJSON* player = game_player(&(game->player1));
    cJSON* aliens = game_aliens(game->fantasmas);
    cJSON* board = game_board(&(*game).board);
    cJSON* score = cJSON_CreateNumber((*game).score);

    cJSON_AddItemToObject(root, "board", board);
    cJSON_AddItemToObject(root, "player", player);
    cJSON_AddItemToObject(root, "aliens", aliens);
    cJSON_AddItemToObject(root, "score", score);

    return  root;
}

cJSON* game_player(struct player* player1){
    cJSON* root = cJSON_CreateObject();

    cJSON* row = cJSON_CreateNumber((*player1).row);
    cJSON* col = cJSON_CreateNumber((*player1).col);
    cJSON* lives = cJSON_CreateNumber((*player1).vidas);


    cJSON_AddItemToObject(root, "row", row);
    cJSON_AddItemToObject(root, "col", col);
    cJSON_AddItemToObject(root, "vidas", lives);

    return root;

}

cJSON* game_board(struct celda*** board) {
    cJSON* root = cJSON_CreateObject();
    cJSON* jBoard = cJSON_CreateArray();

    cJSON_AddItemToObject(root, "rows", jBoard);

    for (int i = 0; i < ROW; ++i) {
        cJSON* row = cJSON_CreateArray();

        for (int j = 0; j < COL; ++j) {
            cJSON* celda = cJSON_CreateObject();
            cJSON_AddItemToArray(row, celda);

            cJSON* dot = cJSON_CreateNumber((*board)[i][j].dot);
            cJSON* superDot = cJSON_CreateNumber((*board)[i][j].superDot);
            cJSON* fruta = cJSON_CreateNumber((*board)[i][j].fruta);


            cJSON_AddItemToObject(celda, "dot", dot);
            cJSON_AddItemToObject(celda, "superDot", superDot);
            cJSON_AddItemToObject(celda, "fruta", fruta);
        }

        cJSON_AddItemToArray(jBoard, row);
    }

    return root;
}

cJSON* game_aliens(struct alien* aliens){
    cJSON* root = cJSON_CreateObject();
    cJSON* alien_Array = cJSON_CreateArray();
    cJSON* alien = NULL;
    cJSON_AddItemToObject(root, "aliens", alien_Array);
    for (int i = 0; i < enemigos; ++i) {
        alien = cJSON_CreateObject();
        cJSON_AddItemToArray(alien_Array, alien);
        cJSON* state = cJSON_CreateNumber(aliens[i].state);
        cJSON* row = cJSON_CreateNumber(aliens[i].row);
        cJSON* col = cJSON_CreateNumber(aliens[i].col);
        cJSON* vivo = cJSON_CreateNumber(aliens[i].vivo);
        cJSON* speed = cJSON_CreateNumber(aliens[i].velocidad);

        cJSON_AddItemToObject(alien, "row", row);
        cJSON_AddItemToObject(alien, "col", col);
        cJSON_AddItemToObject(alien, "state", state);
        cJSON_AddItemToObject(alien, "vivo", vivo);
        cJSON_AddItemToObject(alien, "speed", speed);
    }

    return root;
}

