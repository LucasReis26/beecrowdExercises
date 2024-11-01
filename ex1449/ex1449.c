#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct Dicio{
    char port[1000];
    char japa[1000];
    char line[1000];
    
}Dicio;
void LerDicio(){

}
int main(){
    int trechos;
    int pares;
    int linhas;
    scanf("%d", &trechos);
    while(trechos != 0){
        scanf("%d", &pares);
        scanf("%d", &linhas);
        int contador[linhas];
        int contjunt = 0;
        //alocando os pares de palavras no struct
        Dicio *palavrasP = (Dicio*) malloc(pares*sizeof(Dicio));
        for(int i = 0; i < pares; i++){
            scanf(" %[^\n]", palavrasP[i].japa);
            scanf(" %[^\n]", palavrasP[i].port);
        }
        //alocando as linhas a serem traduzidas 
        Dicio *palavrasL = (Dicio*) malloc(linhas*sizeof(Dicio));
        for(int i = 0; i < linhas; i++){
            scanf(" %[^\n]", palavrasL[i].line);
        }

        //printf("--Saída--\n");
        //colocando a tradução em um vetor de char
        /* for(int i = 0; i < pares; i++){
            printf("%s\n", palavrasP[i].japa);
            printf("%s\n", palavrasP[i].port);
        } 

        for(int i = 0; i < linhas; i++){
            printf("%s\n", palavrasL[i].line);
        } */

        for(int i = 0; i < linhas; i++){
            contador[i] = 1;
            for(int j = 0; j < strlen(palavrasL[i].line); j++){
                if(palavrasL[i].line[j] == ' '){
                    contador[i]+=1;
                }
            }
        }

        for(int i = 0; i < linhas; i++){
            contjunt+=contador[i];
        }

        //palavrasL = vetor de struct, cada struct guarda uma linha
        
        //palavrasM = vetor de struct, cada struct guarda uma palavra

        Dicio *palavrasM = (Dicio*) malloc(contjunt*sizeof(Dicio));
        for(int i = 0, k = 0, y = 0; i < linhas; i++){
            for(int j = 0; j <= strlen(palavrasL[i].line); j++){
               if(palavrasL[i].line[j] == ' ' || j == strlen(palavrasL[i].line)){
                palavrasM[k].line[y] = '\0';
		k++;
               	y = 0; 
               } else {
                palavrasM[k].line[y] = palavrasL[i].line[j];
		y++;
               }
            }
        }

	/*for(int i = 0; i < contjunt; i++)
	{
		printf("%s\n",palavrasM[i].line);
	}*/

	for(int i = 0, p = 0; i < linhas; i++)
	{
		for(int j = 0; j < contador[i]; j++)
		{
			int achou = 0;

			for(int k = 0; k < pares; k++)
			{
				if(strcmp(palavrasM[p].line,palavrasP[k].japa) == 0)
				{
					printf("%s",palavrasP[k].port);
					k = pares;
					achou = 1;
				}
			}

			if(achou == 0)
			{
				printf("%s",palavrasM[p].line);
			}
			if(j < contador[i] - 1)
			{
				printf(" ");
			}
			if(j == contador[i] - 1)
			{
				printf("\n");
			}
			p++;
		}
	}
		if(trechos != 1)
		{
			printf("\n");
		}

        trechos--;
    }
    return 0;
}
