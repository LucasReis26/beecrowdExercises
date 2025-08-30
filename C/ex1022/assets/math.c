#include "math.h"

int* makeOp(int num1, int den1, char op, int num2, int den2){
	int *resp = (int *)malloc(2*sizeof(int));

	switch(op){
		case '+':
			resp[1] = den1 * den2;
			resp[0] = ((resp[1] / den1) * num1) + ((resp[1] / den2) * num2);
			break;
		case '-':
			resp[1] = den1 * den2;
			resp[0] = ((resp[1] / den1) * num1) - ((resp[1] / den2) * num2);
			break;
		case '*':
			resp[1] = den1 * den2;
			resp[0] = num1 * num2;
			break;
		case '/':
			resp[1] = den1 * num2;
			resp[0] = den2 * num1;
			break;
	}

	return resp;
}

int* simplify(int* fraction){

	int* response = (int*)malloc(2*sizeof(int));
	int numerador = fraction[0];
	int denominador = fraction[1];
	if(numerador < 0) numerador *= -1;
	if(denominador < 0) denominador *= -1;

	if(denominador > numerador){

		while(denominador % numerador != 0){
			int newNumerador = denominador % numerador;
			denominador = numerador;
			numerador = newNumerador;
		}

		response[0] = fraction[0] / numerador;
		response[1] = fraction[1] / numerador;

	}else if(numerador > denominador){

		while(numerador % denominador != 0){
			int newDenominador = numerador % denominador;
			numerador = denominador;
			denominador = newDenominador;
		}

		response[0] = fraction[0] / denominador;
		response[1] = fraction[1] / denominador;

	}else if(numerador == denominador){
		response[0] = 1;
		response[1] = 1;
	}

	return response;
}
