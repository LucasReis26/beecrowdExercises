import java.util.Scanner;

class Pilha
{
		
		private static final int MAX = 1000;
		private int menor = Integer.MAX_VALUE;
		private int top;
		private int[] x = new int[MAX];
	
	
		
		public Pilha()
		{
			top = -1;
		}

		public boolean PUSH (int num)
		{
			if(top >= MAX - 1)
			{
				return false;
			}
			else
			{
				x[++top] = num;
				if(num < menor)
					menor = num;
				return true;
			}
		}

		public boolean MIN ()
		{
			if (top < 0)
			{
				System.out.println("EMPTY");

				return false;
			}
			else
			{

				System.out.println(menor);

				return true;
			}
		}

		public int POP ()
		{
			if (top < 0)
			{
				System.out.println("EMPTY");

				return 0;
			}
			else
			{
				int num = x[top--];

				if(num == menor)
				{
					menor = x[0];

					for(int i = 1; i <= top; i++)
					{
						if(x[i] < menor)
						menor = x[i];
					}
				}

				return num;
			}
		}
}

public class Main
{
	public static void avalia (String expr, Pilha x,Scanner sc)
	{
		int num = 0;
		switch(expr)
		{
			case "PUSH":
				num = sc.nextInt();
				x.PUSH(num);
				break;
			case "MIN":
				x.MIN();
				break;
			case "POP":
				x.POP();
				break;
		}


	}

	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Declaração de variáveis
		int X = sc.nextInt();

		String expressao;

		Pilha pilha = new Pilha();

		for(int i = 0; i < X; i++)
		{
			expressao = sc.next();

			avalia(expressao,pilha,sc);
		}
		

		//Fechando o Scanner
		sc.close();
	}
}
