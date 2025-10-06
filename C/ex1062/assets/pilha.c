#include "pilha.h"

Pilha* new_pilha(){
	Pilha *resp = (Pilha*)malloc(sizeof(Pilha));
	resp->topo = new_celula(-1);
	return resp;
}

Celula* new_celula(int x){
	Celula *resp = (Celula*)malloc(sizeof(Celula));
	resp->elemento = x;
	resp->prox = NULL;
	return resp;
}

void push(Pilha *pilha, int x){
	Celula *tmp = new_celula(x);
	tmp->prox = pilha->topo->prox;
	pilha->topo->prox = tmp;
	tmp = NULL;
}

int pop(Pilha *pilha){
	int resp = -1;

	if(pilha->topo->prox == NULL)
		printf("Erro ao remover da Pilha!\n");
	else{
		resp = pilha->topo->prox->elemento;
		Celula *tmp = pilha->topo->prox;
		pilha->topo->prox = pilha->topo->prox->prox;
		tmp->prox = NULL;
		free(tmp);
	}

	return resp;
}

void preencheCrescente(Pilha *pilha, int x){
	for(int i = x; i >= 1; i--){
		push(pilha,i);
	}
}

void mostrar(Pilha *pilha){
	for(Celula *i = pilha->topo->prox; i != NULL; i = i->prox){
		printf("[ %d ]\n",i->elemento);
	}
}

void freePilha(Pilha *pilha){
	freePilhaRec(pilha->topo->prox);
	pilha->topo->prox = NULL;
	free(pilha->topo);
	free(pilha);
}

void freePilhaRec(Celula *i){
	if(i != NULL){
		freePilhaRec(i->prox);
		i->prox = NULL;
		free(i);
	}
}

int tamanho(Pilha* pilha){
	int resp = 0;

	for(Celula *i = pilha->topo->prox; i != NULL; i = i->prox) resp++;

	return resp;
}

int organizaVagoes(Pilha *entrada, Pilha *estacao, Pilha *saida, int *arranjo){
	int resp = 0;

	int organizando = 1;
	int tamTrem = tamanho(entrada);

	int indexV = 0;

	while(organizando){
		if(tamanho(entrada) && mostraTopo(entrada) == arranjo[indexV]){
			push(saida,pop(entrada));
			indexV++;
		}else{
			if(tamanho(estacao) && mostraTopo(estacao) == arranjo[indexV]){
				push(saida,pop(estacao));
				indexV++;
			}else{
				if(tamanho(entrada)) push(estacao,pop(entrada));
				else organizando = 0;
			}
		}
	}

	if(indexV == tamTrem) resp = 1;

	return resp;
}

int mostraTopo(Pilha *pilha){
	int resp;
	if(tamanho(pilha)) resp = pilha->topo->prox->elemento;
	else{
		resp = -1;
		printf("Erro ao mostrar topo\n");
	}
	return resp;
}
