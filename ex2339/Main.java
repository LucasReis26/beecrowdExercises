import java.io.IOException;
import java.util.Scanner;
 

public class Main 
{
 
    public static void main(String[] args) throws IOException 
    {
	//Inicializando o Scanner
	Scanner sc = new Scanner(System.in);

	//Declarando variáveis para o exercício
	
	int C, //Número de competidores
	    P, //Quantidade de folhas de papel compradas
	    F; //Quantidade de folhas que cada competidor deve ter

	//Recebendo as informações
	C = sc.nextInt();
	P = sc.nextInt();
	F = sc.nextInt();
	
	//Processando informações
	if ((C * F) <= P)
		System.out.println('S');
	else
		System.out.println('N');
	
	//Fechando o Scanner
	sc.close();

    }
 
}
