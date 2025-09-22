#ifndef CIDADE_H
#define CIDADE_H

#include <stdlib.h>
#include <stdio.h>

typedef struct Casa{
	int pessoas;
	int consumoCasa;
	int mediaConsumo;
}Casa;

Casa* new_casa(int);
void scanInfos(Casa*, int*);
void ordenaPorConsumo(Casa*, int);
float consumoCidade(Casa*, int);
void printaConsumo(Casa*, int);

#endif
