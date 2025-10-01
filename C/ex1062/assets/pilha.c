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

	int indexVerificador = 0;

	int tamTrem = tamanho(entrada);

	int organizando = 1;

	while(organizando){
		int vagao = 0;
		int liEntrada = 0;
		int testeiEstacao = 0;

		if(tamanho(entrada)){ 
			vagao = pop(entrada);
			// printf("%d %d\n",vagao,arranjo[indexVerificador]);
			liEntrada = 1;
		}

		if(liEntrada && vagao == arranjo[indexVerificador]){
			// printf("Mandei pra saída\n");
			push(saida,vagao);
			indexVerificador++;
			vagao = 0;
		}else{

			// if(tamanho(estacao)) printf("Estacao> %d %d\n",estacao->topo->prox->elemento, arranjo[indexVerificador]);

			if(tamanho(estacao) && estacao->topo->prox->elemento == arranjo[indexVerificador]){
				// printf("Mandei pra saída\n");
				int valorEntrada = vagao;
				vagao = pop(estacao);
				push(saida,vagao);
				indexVerificador++;
				if(liEntrada) {
					// printf("Mandei %d para estacao\n",valorEntrada);
					push(estacao,valorEntrada);
					vagao = 0;
				}
			}else if(liEntrada){
				// printf("Mandei para estacao\n");
				push(estacao,vagao);
				vagao = 0;
				testeiEstacao = 1;
			}else{
				organizando = 0;
			}

		}

		liEntrada = 0;
		testeiEstacao = 0;
	}

	if(indexVerificador == tamTrem) resp = 1;

	return resp;
}
