#include <stdio.h>
#include <stdlib.h>

int main()
{
	int *ex = (int *)malloc(sizeof(int));
	char *cmd = (char *)malloc(255*sizeof(char));

	scanf("%d",ex);

	sprintf(cmd,"mkdir ex%d;",*ex);
	system(cmd);

	sprintf(cmd,"mkdir ex%d/verific;",*ex);
	system(cmd);

	sprintf(cmd,"vim ex%d/verific/pub.in;",*ex);
	system(cmd);

	sprintf(cmd,"vim ex%d/verific/pub.out",*ex);
	system(cmd);


	free(ex);
	free(cmd);
	return 0;
}
