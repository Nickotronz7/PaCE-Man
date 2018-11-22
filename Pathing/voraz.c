//
// Created by nautilus on 21/11/18.
//

#include "voraz.h"
#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#include "../Game/Headers/game.h"


/**
 * esto hay que moverlo a game.c para tener una cantidad de fantasmas dinamica.
 * ahorita esta hard coded
 */
void cycle ()
{
    for (int i = 0 ; i < 3; i++)
    {
        behavior(i);
    }
}

/**
 * revisa si los fantasmas tienen que correr o perseguir al jugador.
 */
void behavior(int ghostNumber)
{
    struct state* game;
    if (game->fantasmas->state == 0)
    {
        sorteador(0, ghostNumber);
    }
    else sorteador(1, ghostNumber);
}

/**
 * Dependiendo del comportamiento (0 = persigue, 0 != escapa),
 * manda hacia moveGhost la accion que debe de hacer, esto toma en cuenta
 * los valores mandados del metodo checkSurrounding, para perseguir, busca
 * el valor mayor en el arreglo y para escapar busca el menor.
 *
 * @param comportamiento (0 = persigue, !0 = escapa).
 */
void sorteador (int comportamiento, int ghostNumber)
{
    double *p;
    p = checkSurrounding(ghostNumber);

    int valor = 0;

    if (comportamiento == 1){
        for (int i=0; i<4; i++)
        {
            if (higher(*(p+i), *(p+(valor))))
            {
                valor = i;
            }
        }

    }else{
        for (int i=0; i<4; i++)
        {
            if (lower(*(p+i), *(p+(valor))))
            {
                valor = i;
            }
        }
    }

    moveGhost(valor, ghostNumber);
}

/**
 * Revisa las casillas alrededor del jugador (excluyendo las esquinas)
 * y le pone un valor a cada uno de ellos
 *
 * @return  un array de 4 datos [up, down, left, right] con sus respectivos
 *          valores de casetillas
 */
double* checkSurrounding (int ghostNumber)
{
    static double surrounding[4];
    struct state* game;
    int posx = game->fantasmas[ghostNumber].col;
    int posy = game->fantasmas[ghostNumber].row;

    for (int i = 0 ; i < 10 ; i++){
        switch(i)
        {
            case 0:
                if (game->board[posx][posy-1].available)
                {
                    surrounding[i] = gridValue(posx,posy-1,game->player1.col,game->player1.row);
                }else{
                    surrounding[i] = -1;
                }
                i++;
                break;
            case 1:
                if (game->board[posx][posy+1].available)
                {
                    surrounding[i] = gridValue(posx,posy+1,game->player1.col,game->player1.row);
                }else{
                    surrounding[i] = -1;
                }
                i++;
                break;
            case 2:
                if (game->board[posx-1][posy].available)
                {
                    surrounding[i] = gridValue(posx-1,posy,game->player1.col,game->player1.row);
                }else{
                    surrounding[i] = -1;
                }
                i++;
                break;
            case 3:
                if (game->board[posx+1][posy].available)
                {
                    surrounding[i] = gridValue(posx+1,posy,game->player1.col,game->player1.row);
                }else{
                    surrounding[i] = -1;
                }
                i++;
                break;

            default:
                printf("literal nunca deberia de llegar aqui");
        }
    };

    return surrounding;
}

/**
 * Calcula el valor de las casetillas
 *
 * @param initialx posicion actual en x
 * @param initialy posicion actual en y
 * @param destinationx posicion destino en x
 * @param destinationy posicion destino en y
 * @return hipotenusa del "delta x" y "delta y"
 */
double gridValue (double initialx, double initialy, double destinationx, double destinationy)
{
    double distancex = (destinationx - initialx)*(destinationx - initialx);
    double distancey = (destinationy - initialy)*(destinationy - initialy);
    double returnValue = sqrt(distancex + distancey);
    return returnValue;
}

/**
 * Actualiza la localizacion de los fantasmas en sus coordenas x, y
 * dependiendo de la direccion que tenga que mover (0 = up, 1 = down,
 * 2 = left, 3 = right)
 *
 * @param direction direccion a la que el fantasma se mueve.
 */
void moveGhost (int direction, int ghostNumber)
{
    struct state* game;

    switch (direction){
        case 0:
            game->fantasmas[ghostNumber].row = game->fantasmas[ghostNumber].row-1;
            break;
        case 1:
            game->fantasmas[ghostNumber].row = game->fantasmas[ghostNumber].row+1;
            break;
        case 2:
            game->fantasmas[ghostNumber].col = game->fantasmas[ghostNumber].col-1;
            break;
        case 3:
            game->fantasmas[ghostNumber].col = game->fantasmas[ghostNumber].col+1;
            break;
        default:
            printf("well this is a pickle");
    }

}

/**
 * @param value1 valor a comparar
 * @param value2 referencia a la cual se compara
 * @return booleano true si value1 es mayor o igual que value2
 */
bool higher (double value1, double value2)
{
    if (value1 >= value2)
    {
        return true;
    }else false;

}

/**
 * @param value1 valor a comparar
 * @param value2 referencia a la cual se compara
 * @return booleano true si value1 es menor que value2
 */
bool lower (double value1, double value2)
{
    if (value1 < value2)
    {
        return true;
    }else false;

}
