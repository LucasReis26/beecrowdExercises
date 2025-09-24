#include <stdio.h>
#include "assets/cidade.h"

int main(){
	long long qtdImoveis;
	int indCidade = 1;

	scanf("%lld",&qtdImoveis);

	while(qtdImoveis != 0){
		Casa* casas = new_casa(qtdImoveis);
		int consumo[201];
		for(int i = 0; i < 201; i++) consumo[i] = 0;

		scanInfos(casas,&qtdImoveis,consumo);
		double mediaPorPessoa = consumoCidade(casas, qtdImoveis);


		printf("Cidade# %d:\n",indCidade++);
		printaConsumo(consumo);
		printf("Consumo medio: %.2f m3.\n",mediaPorPessoa);
		
		scanf("%lld",&qtdImoveis);
		if(qtdImoveis != 0) printf("\n");
	}
}
