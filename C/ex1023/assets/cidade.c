#include "cidade.h"

Casa* new_casa(int x){
	Casa* resp = (Casa*)malloc(x*sizeof(Casa));
	resp->pessoas = 0;
	resp->consumoCasa = 0;
	resp->mediaConsumo = 0.0;
	return resp;
}

void scanInfos(Casa* casa, int* x){
	for(int i = 0; i < *x; i++){
		scanf("%d %d",&casa[i].pessoas,&casa[i].consumoCasa);

		casa[i].mediaConsumo = casa[i].consumoCasa / casa[i].pessoas;

		if(i > 0 && casa[i].mediaConsumo == casa[i-1].mediaConsumo){
			casa[i-1].pessoas += casa[i].pessoas;
			casa[i-1].consumoCasa += casa[i].consumoCasa;
			(*x)--;
			i--;
		}

	}
}

float consumoCidade(Casa* casa, int x){
	float resp;

	int totalConsumo = 0;
	int totalPessoas = 0;

	for(int i = 0; i < x; i++){
		totalConsumo += casa[i].consumoCasa;
		totalPessoas += casa[i].pessoas;
	}

	resp = (float) totalConsumo / (float) totalPessoas;

	int parte = (int) (resp * 100);
	resp =  parte / 100.0;

	return resp;
}

void ordenaPorConsumo(Casa* casas, int x){
	for(int i = 0; i < x - 1; i++){
		int menor = i;

		for(int j = i + 1; j < x; j++){
			if(casas[j].mediaConsumo < casas[menor].mediaConsumo) menor = j;
		}

		Casa aux = casas[i];
		casas[i] = casas[menor];
		casas[menor] = aux;
	}
}

void printaConsumo(Casa* casas, int x){
	for(int i = 0; i < x; i++){
		if(i >= x - 1)
			printf("%d-%d\n",casas[i].pessoas,casas[i].mediaConsumo);
		else
			printf("%d-%d ",casas[i].pessoas,casas[i].mediaConsumo);
	}
}
