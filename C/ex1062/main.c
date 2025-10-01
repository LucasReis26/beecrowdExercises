#include <stdio.h>
#include "assets/pilha.h"

int main(){

	int tamTrem;

	scanf("%d",&tamTrem);

	while(tamTrem != 0){

		Pilha *entrada = new_pilha();
		Pilha *estacao = new_pilha();
		Pilha *saida = new_pilha();

		int num;

		scanf("%d",&num);

		while(num != 0){

			int arranjo[tamTrem];

			preencheCrescente(entrada, tamTrem);

			arranjo[0] = num;

			for(int i = 1; i < tamTrem; i++){
				scanf("%d",&arranjo[i]);
			}

			int possibilidade = organizaVagoes(entrada,estacao,saida,arranjo);

			if(possibilidade)
				printf("Yes\n");
			else
				printf("No\n");

			scanf("%d",&num);
		}

		freePilha(entrada);
		freePilha(estacao);
		freePilha(saida);

		scanf("%d",&tamTrem);

		if(tamTrem != 0)
			printf("\n");
	}

	return 0;
}
