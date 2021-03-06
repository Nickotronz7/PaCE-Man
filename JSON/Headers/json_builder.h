//
// Created by nicko on 10/04/18.
//

#ifndef TAREA_3_JSON_BUILDER_H
#define TAREA_3_JSON_BUILDER_H

#include "cJSON.h"
#include "../../Game/Headers/game.h"


cJSON* game_state(struct state* game);

cJSON* game_player(struct player* player1);

cJSON* game_aliens(struct alien* aliens);

cJSON* game_board(struct celda*** board);


#endif //TAREA_3_JSON_BUILDER_H
