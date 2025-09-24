#include "cidade.h"

Casa* new_casa(long long x){
	Casa* resp = (Casa*)malloc(x*sizeof(Casa));
	for(long long i; i < x; i++){
		resp->pessoas = 0;
		resp->consumoCasa = 0;
		resp->mediaConsumo = 0;
	}
	return resp;
}

void scanInfos(Casa* casa, long long* x, int *consumo){
	for(int i = 0; i < *x; i++){
		scanf("%d %d",&casa[i].pessoas,&casa[i].consumoCasa);
		casa[i].mediaConsumo = casa[i].consumoCasa / casa[i].pessoas;
		consumo[casa[i].mediaConsumo] += casa[i].pessoas;
	}
}

double consumoCidade(Casa* casa, long long x){
	double resp;

	long long totalConsumo = 0;
	long long totalPessoas = 0;

	for(long long i = 0; i < x; i++){
		totalConsumo += casa[i].consumoCasa;
		totalPessoas += casa[i].pessoas;
	}

	resp = (double) totalConsumo / (double) totalPessoas;

	long long parte = (long long) (resp * 100);
	resp =  parte / 100.0;

	return resp;
}


void printaConsumo(int* consumo){
	int primeiro = 1;
	for(int i = 0; i < 201; i++){
		if(consumo[i] > 0){
			if(!primeiro) printf(" ");
			printf("%d-%d",consumo[i],i);
			primeiro = 0;
		} 
	}
	printf("\n");
}
