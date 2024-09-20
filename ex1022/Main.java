import java.util.Scanner;

public class Main
{
	public static int removeSinal(int num)
	{
		if(num < 0)
		{
			num *= -1;
		}
		
		return num;
	}

	public static int menorPositivo(int num1, int num2)
	{
		int n1 = removeSinal(num1);
		int n2 = removeSinal(num2);
		
		int resp = 0;

		if(n1 > n2)
		{
			resp = n2;
		}
		else if (n1 < n2)
		{
			resp = n1;
		}
		else
		{
			resp = n1;
		}

		return resp;
	}

	public static void soma(int num1, int den1, int num2, int den2)
	{
		int firstNum = ((num1 * den2)+(num2*den1));
		int firstDen = (den1 * den2);

		System.out.print(firstNum+"/"+firstDen);

		int tam = menorPositivo(firstNum, firstDen);

		int secondNum = firstNum;
		int secondDen = firstDen;

		for(int i = tam; i >= 2; i--)
		{
			if(secondNum % i == 0 && secondDen % i == 0)
			{
				secondNum /= i;
				secondDen /= i;
			}
		}

		System.out.println(" = "+secondNum+"/"+secondDen);

	}

	public static void subtrai(int num1, int den1, int num2, int den2)
	{
		int firstNum = ((num1 * den2)-(den1 * num2)); 
		int firstDen = (den1 * den2);

		System.out.print(firstNum+"/"+firstDen);

		int tam = menorPositivo(firstNum, firstDen);

		int secondNum = firstNum;
		int secondDen = firstDen;

		for(int i = tam; i >= 2; i--)
		{
			if(secondNum % i == 0 && secondDen % i == 0)
			{
				secondNum /= i;
				secondDen /= i;
			}
		}

		System.out.println(" = "+secondNum+"/"+secondDen);

	}

	public static void multi(int num1, int den1, int num2, int den2)
	{
		int firstNum = (num1*num2); 
		int firstDen = (den1 * den2);

		System.out.print(firstNum+"/"+firstDen);

		int tam = menorPositivo(firstNum, firstDen);

		int secondNum = firstNum;
		int secondDen = firstDen;

		for(int i = tam; i >= 2; i--)
		{
			if(secondNum % i == 0 && secondDen % i == 0)
			{
				secondNum /= i;
				secondDen /= i;
			}
		}

		System.out.println(" = "+secondNum+"/"+secondDen);

	}

	public static void divide(int num1, int den1, int num2, int den2)
	{
		int firstNum = (num1*den2); 
		int firstDen = (den1 * num2);

		System.out.print(firstNum+"/"+firstDen);

		int tam = menorPositivo(firstNum, firstDen);

		int secondNum = firstNum;
		int secondDen = firstDen;

		for(int i = tam; i >= 2; i--)
		{
			if(secondNum % i == 0 && secondDen % i == 0)
			{
				secondNum /= i;
				secondDen /= i;
			}
		}

		System.out.println(" = "+secondNum+"/"+secondDen);

	}

	public static void operacao (int[] num, int[] den, char[] op, int x)
	{
		for(int i = 0, j = 0; i < x; i++)
		{
			switch(op[i])
			{
				case '+':
					soma(num[j], den[j], num[j+1], den[j+1]);
					j += 2;
					break;
				case '-':
					subtrai(num[j], den[j], num[j+1], den[j+1]);
					j += 2;
					break;
				case '*':
					multi(num[j], den[j], num[j+1], den[j+1]);
					j += 2;
					break;
				case '/':
					divide(num[j], den[j], num[j+1], den[j+1]);
					j += 2;
					break;
			}
		}
	}

	public static void preencheVariaveis(int[] numeradores, int[] denominadores, char[] operacoes,int x, Scanner sc)
	{
		for(int i = 0, j = 0; i < x * 2; i++)
		{
			if(i % 2 == 0)
			{
				numeradores[i] = sc.nextInt();
				sc.next();
				denominadores[i] = sc.nextInt();
				operacoes[j] = sc.next().charAt(0);
				j++;
			}
			else
			{
				numeradores[i] = sc.nextInt();
				sc.next();
				denominadores[i] = sc.nextInt();
			}
		}
	}

	public static void main (String[] args)
	{
		//Instanciando o Scanner
		Scanner sc = new Scanner(System.in);

		//Lendo o número de testes
		int x = sc.nextInt();

		//Declarando arrays a serem utilizados
		int[] numeradores = new int[2*x];
		int[] denominadores = new int[2*x];
		char[] operacoes = new char[x];
		
		//Preenchendo as variáveis
		preencheVariaveis(numeradores,denominadores,operacoes,x,sc);

		//Realiza operação
		operacao(numeradores,denominadores,operacoes,x);

		//Fechando o Scanner;
		sc.close();
	}
}
