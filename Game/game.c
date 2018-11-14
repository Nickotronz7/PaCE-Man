//
// Created by nicko on 12/11/18.
//

#include "game.h"

int rowConfig[ROW][COL]  = {
/* 0  */        {19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
/* 1  */        {1,8,1,8,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
/* 2  */        {1,1,2,1,3,1,1,1,3,1,2,1,1,0,0,0,0,0,0},
/* 3  */        {1,17,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
/* 4  */        {1,1,2,1,1,1,5,1,1,1,2,1,1,0,0,0,0,0,0},
/* 5  */        {1,4,1,3,1,3,1,4,1,0,0,0,0,0,0,0,0,0,0},
/* 6  */        {2,1,1,1,3,1,1,1,3,1,1,1,2,0,0,0,0,0,0},
/* 7  */        {1,2,1,1,1,7,1,1,1,2,1,0,0,0,0,0,0,0,0},
/* 8  */        {1,1,2,1,1,1,5,1,1,1,2,1,0,0,0,0,0,0,0},
/* 9  */        {1,1,2,3,1,3,1,3,2,1,1,0,0,0,0,0,0,0,0},
/* 10 */        {1,1,2,1,1,1,5,1,1,1,2,1,1,0,0,0,0,0,0},
/* 11 */        {1,4,1,7,1,4,1,0,0,0,0,0,0,0,0,0,0,0,0},
/* 12 */        {4,1,1,1,5,1,1,1,4,0,0,0,0,0,0,0,0,0,0},
/* 13 */        {1,8,1,8,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
/* 14 */        {1,1,2,1,3,1,1,1,3,1,2,1,1,0,0,0,0,0,0},
/* 15 */        {1,2,1,11,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
/* 16 */        {2,1,1,1,1,1,5,1,1,1,1,1,2,0,0,0,0,0,0},
/* 17 */        {1,4,1,3,1,3,1,4,1,0,0,0,0,0,0,0,0,0,0},
/* 18 */        {1,1,6,1,1,1,6,1,1,0,0,0,0,0,0,0,0,0,0},
/* 19 */        {1,17,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
/* 20 */        {19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
};

void setRow (int row[], int *newRow) {
    int i = 0;
    int flag = -1;
    for (int j = 0; j < COL; ++j) {
        if (row[j] == 0) {
            break;
        }
        else {
            int x = row[j];
            while (i != COL){
                if (x != 0) {
                    if (flag == -1) {
                        *(newRow+i) = 1;
                        x-=1;
                        i+=1;
                    } else {
                        *(newRow+i) = 0;
                        x-=1;
                        i+=1;
                    }
                } else {
                    flag *= -1;
                    break;
                }
            }
        }
    }
}

struct celda setBoard(struct celda** board) {
    int *newRow = malloc(19*sizeof(int));

    for (int k = 0; k < ROW; ++k) {
        setRow(rowConfig[k],newRow);
        for (int i = 0; i < COL; ++i) {
            board[k][i].available = *(newRow+i);
        }
    }
}

struct celda setDots(struct celda** board) {
    for (int i = 0; i < ROW; ++i) {
        for (int j = 0; j < COL; ++j) {
            if (!(board[i][j].available)) {
                if ((i == 9 && (j == 8 || j == 9 || j == 10))||(i == 11 && j == 9)){
                    board[i][j].dot = 1;
                } else {
                    board[i][j].dot = 0;
                }
            } else {
                board[i][j].dot = 0;
            }
        }
    }
}

struct state game_core(){

    struct celda** board = (struct celda**) malloc(ROW * sizeof(struct celda*));
    for (int i = 0; i < ROW; ++i) {
        *(board+i) = (struct celda*) malloc(COL * sizeof(struct celda));
    }
    setBoard(board);
    setDots(board);


    struct state actual_state;

    actual_state.board = board;

    return  actual_state;
}