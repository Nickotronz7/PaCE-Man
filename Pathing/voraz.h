//
// Created by nautilus on 21/11/18.
//

#ifndef PACE_MAN_CHASE_H
#define PACE_MAN_CHASE_H


#include <stdbool.h>
void cycle ();
void behavior (int ghostNumber);
double* checkSurrounding (int ghostNumber);
void sorteador(int comportamiento, int ghostNumber);
void moveGhost (int direction, int ghostNumber);
double gridValue (double initialx, double initialy, double destinationx, double destinationy);
bool higher (double value1, double value2);
bool lower (double value1, double value2);


#endif //PACE_MAN_CHASE_H
