import java.util.Scanner;

public class Main
{
	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Declarando variáveis necessárias
		int count1 = 0;
		int count2 = 0;
		int found = 0;
		int traducoes = sc.nextInt();
		String enter = sc.nextLine();
		int criancas;
		String saida;
		
		String[] linguas = new String[traducoes];
		String[] linguasTraduzidas = new String[traducoes];

		//Captura as linguas junto com os índices;
		for(int i = 0; i < traducoes*2; i++)
		{
			if (i % 2 == 0)
			{
				linguas[count1] = sc.nextLine();
				count1++;
			}
			else
			{
				linguasTraduzidas[count2] = sc.nextLine();
				count2++;
			}
		}
		
		//Captura a quantidade de crianças para as cartas
		criancas = sc.nextInt();
		enter = sc.nextLine();

		//Imprime na tela o nome da criança e feliz natal na lingua que ela fala
		for(int i = 0; i < criancas*2; i++)
		{
			if (i % 2 == 0)
			{
				saida = sc.nextLine();
				System.out.println(saida);
			}
			else
			{
				saida = sc.nextLine();
				for(int j = 0; j < count1; j++)
				{
					if (linguas[j].equals(saida))
					{
						found = j;
						j = count1;
					}
				}
				saida = linguasTraduzidas[found];
				System.out.println(saida);
				System.out.println();
			}
		}
		//Fechando o Scanner
		sc.close();
	}
}
