#include "procura.h"

void scanMarmores(int *marmores, int x){
	for(int i = 0; i < x; i++){
		scanf("%d",&marmores[i]);
	}
}

void consultaMarmores(int *marmores,int x, int y){
	for(int i = 0; i < y; i++){
		int num;
		scanf("%d",&num);
		int found = 0;

		for(int j = 0; j < x; j++){
			if(num == marmores[j]){
				found = 1;
				printf("%d found at %d\n",num,j+1);
				j = x;
			}else if(marmores[j] > num){
				j = x;
			}
		}
		if(!found){
			printf("%d not found\n",num);
		}
	}
}

void quicksort(int *marmores, int x){
	quicksortRec(marmores,0,x-1);
}

void quicksortRec(int *marmores, int esq, int dir){
	int i = esq;
	int j = dir;
	int pivo = marmores[(esq + dir)/2];
	while(i <= j){
		while(marmores[i] < pivo) i++;
		while(marmores[j] > pivo) j--;
		if(i <= j){
			int aux = marmores[i];
			marmores[i] = marmores[j];
			marmores[j] = aux;
			i++;
			j--;
		}
	}
	if(esq < j) quicksortRec(marmores,esq,j);
	if(i < dir) quicksortRec(marmores,i,dir);
}

