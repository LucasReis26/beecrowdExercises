#ifndef CIDADE_H
#define CIDADE_H

#include <stdlib.h>
#include <stdio.h>

typedef struct Casa{
	int pessoas;
	int consumoCasa;
	int mediaConsumo;
}Casa;

Casa* new_casa(long long);
void scanInfos(Casa*, long long*, int*);
double consumoCidade(Casa*, long long);
void printaConsumo(int*);

#endif
