//
// Created by nicko on 12/11/18.
//

#ifndef PACE_MAN_GAME_H
#define PACE_MAN_GAME_H

#include <stdio.h>
#include <stdlib.h>

#define ROW 21
#define COL 19

extern int enemigos;
extern struct state game;


int rowConfig[ROW][COL];


void setRow(int *row, int *newRow);

struct celda** setBoard(struct celda** board);

struct celda** setDots(struct celda** board);

struct celda** setSuperDot(struct celda** board);

struct celda** setFruit(struct celda** board);

struct state game_core();

void move_player(struct state* game, char dir);

void move_ghost(struct state* game);

void update_game(struct state* game);

void update_player(struct state* game, char dir);

void update_ghost(struct state* game, int row, int col);

void crearPastilla(struct state* game, int row, int col);

void crearFruta(struct state* game, int row, int col);

void update_ghostSpeed(struct state* game, int speed);

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
    int superDot;   // 0 = no, 1 = si;
    int fruta;      // 0 = no, 1 = si;
};

struct state{
    struct player player1;
    struct alien* fantasmas;
    struct celda** board;
    int score, win;
};

#endif //PACE_MAN_GAME_H
