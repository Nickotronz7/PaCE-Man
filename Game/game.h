//
// Created by nicko on 12/11/18.
//

#ifndef PACE_MAN_GAME_H
#define PACE_MAN_GAME_H

#include <stdio.h>
#include <stdlib.h>

#define ROW 21
#define COL 19

int rowConfig[ROW][COL];
void setRow(int *row, int *newRow);
struct celda setBoard(struct celda** board);
struct celda setDots(struct celda** board);


struct state game_core();

struct player{
    int row, col;
    int vidas;
};

struct alien{
    int row, col;
    int state; // 0 = hostil, 1 = comible
    int vivo; // 0 = muerto, 1 = vivo
    int velocidad;
};

struct celda{
    int available;  // 0 = no, 1 = si;
    int dot;        // 0 = no, 1 = si;
    int superDot;   // 0 = no, 1 = si
    int fruta;      //
};

struct state{
    struct player player1;
    struct alien fantasmas;
    struct celda** board;
};

#endif //PACE_MAN_GAME_H
