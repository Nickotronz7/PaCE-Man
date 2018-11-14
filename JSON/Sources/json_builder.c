//
// Created by nicko on 10/04/18.
//

#include "../Headers/json_builder.h"

cJSON* game_state(struct state* game){

    cJSON* root = cJSON_CreateObject();
    cJSON* player = game_player(&(game->player1));
    cJSON* aliens = game_aliens(game->fantasmas);
    cJSON* board = game_board(&(*game).board);

    cJSON_AddItemToObject(root, "board", board);
    cJSON_AddItemToObject(root, "player", player);
    cJSON_AddItemToObject(root, "aliens", aliens);

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
    cJSON* row = NULL;
    cJSON* celda = NULL;
    cJSON* nRow = NULL;
    cJSON* nCelda = NULL;
    cJSON_AddItemToObject(root, "rows", jBoard);

    for (int i = 0; i < ROW; ++i) {
        row = cJSON_CreateArray();
        nRow = cJSON_CreateObject();
        for (int j = 0; j < COL; ++j) {
            char* index = malloc(sizeof(char));
            sprintf(index,"%d",j);
            celda = cJSON_CreateObject();
            nCelda = cJSON_CreateObject();
            cJSON_AddItemToObject(nCelda, index,celda);
            cJSON_AddItemToArray(row, nCelda);

            cJSON* available = cJSON_CreateNumber((*board)[i][j].available);
            cJSON* dot = cJSON_CreateNumber((*board)[i][j].dot);
            cJSON* superDot = cJSON_CreateNumber((*board)[i][j].superDot);
            cJSON* fruta = cJSON_CreateNumber((*board)[i][j].fruta);

            cJSON_AddItemToObject(celda, "available", available);
            cJSON_AddItemToObject(celda, "dot", dot);
            cJSON_AddItemToObject(celda, "superDot", superDot);
            cJSON_AddItemToObject(celda, "fruta", fruta);
            free(index);
        }
        char* index = malloc(sizeof(char));
        sprintf(index,"%d",i);
        cJSON_AddItemToObject(nRow, index, row);
        cJSON_AddItemToArray(jBoard,nRow);
        free(index);
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

//cJSON* game_data(unsigned int* currentShots,unsigned int* currentBombs, unsigned int* currentAliens, int* score,
//                 int* win){
//    cJSON* root = cJSON_CreateObject();
//
//    cJSON* cShots = cJSON_CreateNumber(*currentShots);
//    cJSON* cBombs = cJSON_CreateNumber(*currentBombs);
//    cJSON* cAliens = cJSON_CreateNumber(*currentAliens);
//    cJSON* points = cJSON_CreateNumber(*score);
//    cJSON* cWin = cJSON_CreateNumber(*win);
//
//    cJSON_AddItemToObject(root,"currentShots", cShots);
//    cJSON_AddItemToObject(root, "currenteBombs", cBombs);
//    cJSON_AddItemToObject(root, "currentAliens", cAliens);
//    cJSON_AddItemToObject(root, "score", points);
//    cJSON_AddItemToObject(root, "win", cWin);
//
//    return root;
//}