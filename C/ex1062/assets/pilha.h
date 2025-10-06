#ifndef PILHA_H
#define PILHA_H

#include <stdlib.h>
#include <stdio.h>

typedef struct Celula{
	int elemento;
	struct Celula *prox;
}Celula;

Celula* new_celula(int);

typedef struct Pilha{
	Celula *topo;
}Pilha;

Pilha* new_pilha();
void push(Pilha*,int);
int pop(Pilha*);
void preencheCrescente(Pilha*,int);
void mostrar(Pilha*);
int mostraTopo(Pilha*);
int tamanho(Pilha*);
int organizaVagoes(Pilha*,Pilha*,Pilha*,int*);
void freePilhaRec(Celula*);
void freePilha(Pilha*);

#endif
