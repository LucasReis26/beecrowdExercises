#include <stdio.h>
#include "assets/math.h"

int main(){
	int num1, num2, den1, den2, qtdOp;
	char op;

	scanf("%d",&qtdOp);

	for(int i = 0; i < qtdOp; i++){

		scanf("%d / %d %c %d / %d",&num1,&den1,&op,&num2,&den2);

		int* result = makeOp(num1,den1,op,num2,den2);
		int* simplifyResult = simplify(result);

		printf("%d/%d = %d/%d\n",result[0],result[1],simplifyResult[0],simplifyResult[1]);

		free(result);
	}
}
