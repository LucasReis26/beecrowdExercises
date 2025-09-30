#include <stdio.h>
#include "assets/procura.h"

int main(){
	int numCase = 1;
	int numMarmores,
		numConsultas;

	scanf("%d %d",&numMarmores, &numConsultas);

	while(numMarmores != 0 && numConsultas != 0){
		printf("CASE# %d:\n",numCase++);

		int marmores[numMarmores];

		scanMarmores(marmores,numMarmores);

		quicksort(marmores,numMarmores);

		consultaMarmores(marmores,numMarmores, numConsultas);

		scanf("%d %d",&numMarmores, &numConsultas);
	}
}
