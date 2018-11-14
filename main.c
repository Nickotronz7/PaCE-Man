#include "Game/Headers/game.h"


void move_playe2r(struct state* game, char dir){

    switch (dir) {
        case 'u': {
            if ((*game).board[(*game).player1.col][(*game).player1.row-1].available) {
                (*game).player1.row -= 1;
            } else {
                printf("movimiento invalido\n");
            }
            break;
        }
        case 'd': {
            if ((*game).board[(*game).player1.col][(*game).player1.row+1].available) {
                (*game).player1.row += 1;
            } else {
                printf("movimiento invalido\n");
            }
            break;
        }
        case 'r': {
            if ((*game).board[(*game).player1.col+1][(*game).player1.row].available) {
                (*game).player1.col += 1;
            } else {
                printf("movimiento invalido\n");
            }
            break;
        }
        case 'l': {
            if ((*game).board[(*game).player1.col+1][(*game).player1.row].available) {
                (*game).player1.col -= 1;
            } else {
                printf("movimiento invalido\n");
            }
            break;
        }
        default:
            printf("no move done");
            break;
    }
}

int main() {

    struct state game = game_core();

    printf("player pos0: (%i, %i)\n", game.player1.row, game.player1.col);

    move_playe2r(&game,'d');

//    int row = game.player1.row;
//    int col = game.player1.col;
//
//    printf("dispo: %i  row: %i  col: %i\n",game.board[row][col].available,row,col);

    printf("player pos0: (%i, %i)\n", game.player1.row, game.player1.col);


//    for (int i = 0; i < ROW; ++i) {
//        for (int j = 0; j < COL; ++j) {
//            printf("%i,",game.board[i][j].available);
//        }
//        printf("\n");
//    }

    return 0;
}