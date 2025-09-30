#include "procura.h"

void scanMarmores(int *marmores, int x){
	for(int i = 0; i < x; i++){
		int num;
		scanf("%d",&num);
		marmores[num]++;
	}
}

void consultaMarmores(int *marmores, int y){
	for(int i = 0; i < y; i++){
		int num;
		int found = 0;
		scanf("%d",&num);
		for(int j = 0, position = 0; j < 10000 && !found; j++){
			// printf("%d\n",j);
			if(marmores[j] > 0 && j != num){
				position += marmores[j];
			}else if(marmores[j] > 0 && j == num){
				printf("%d found at %d\n",num,position+1);
				found = 1;
			}
		}
		// printf("Sai do for\n");
		if(!found){
			printf("%d not found\n",num);
		}
	}
}
