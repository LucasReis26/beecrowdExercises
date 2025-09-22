#include <stdio.h>
#include "assets/cidade.h"

int main(){
	int qtdImoveis;
	int indCidade = 1;

	scanf("%d",&qtdImoveis);

	while(qtdImoveis != 0){
		Casa* casas = new_casa(qtdImoveis);
		scanInfos(casas,&qtdImoveis);
		ordenaPorConsumo(casas, qtdImoveis);
		float mediaPorPessoa = consumoCidade(casas, qtdImoveis);


		printf("Cidade# %d:\n",indCidade++);
		printaConsumo(casas, qtdImoveis);
		printf("Consumo medio: %.2f m3.\n",mediaPorPessoa);
		
		scanf("%d",&qtdImoveis);
		if(qtdImoveis != 0) printf("\n");
	}
}
