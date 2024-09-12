import java.util.Scanner;

public class Main
{	
	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);
		//Declarando variáveis
		int numLados;
		
		//Escaneia variável
		numLados = sc.nextInt();

		//Se o número de lados for igual a 3 = 1 triangulo
		if(numLados == 3)
		{
			System.out.println("1");
		}
		//Se o número de lados for igual a 4 = 2 triangulos encostando um lado
		else if(numLados == 4)
		{
			System.out.println("2");
		}
		//Se for maior que 4, acrescenta um ou mais triangulo dentro dos triangulos encostadospara aumentar em 1 lado
		else if(numLados > 4)
		{
			System.out.printf("%d\n",(numLados - 4) + 2);
		}
		//Se menor que 3, entrada inválida
		else
		{
			System.out.println("Entrada inválida");
		}
				
	}
}
