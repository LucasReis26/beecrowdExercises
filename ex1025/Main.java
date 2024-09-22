import java.util.Scanner;

public class Main
{
	public static void swapArray(int[] array, int n1, int n2)
	{
		int temp = array[n1];
		array[n1] = array[n2];
		array[n2] = temp;
	}

	public static void preencheArray(int[] array, int[] array2, Scanner sc)
	{
		for(int i = 0; i < array.length; i++)
		{
			array[i] = sc.nextInt();

			if(i >= 1)
			{
				int j = i;

				while (j > 0 && array[j] < array[j-1])
				{
					swapArray(array, j, j-1);
					j--;
				}
			}
		}

		for(int i = 0; i < array2.length; i++)
		{
			array2[i] = sc.nextInt();
		}
	}

	public static void procuraArray(int[] array, int[] array2,  int[] count, Scanner sc)
	{
		System.out.println("CASE# "+count[0]+":");

		for(int i = 0; i < array2.length; i++)
		{
			int esquerda = 0;
			int direita = array.length - 1;
			int meio = 0;

			boolean found = false;
			int foundI = 0;

			while(esquerda <= direita)
			{
				meio = esquerda + ((direita - esquerda) / 2);

				if(array[meio] > array2[i])
					direita = meio - 1;
				else if (array[meio] < array2[i])
					esquerda = meio + 1;
				else if (array[meio] == array2[i])
				{
					foundI = meio + 1;
					found = true;
					direita = meio - 1;
				}
			}

			if(found == true)
			{
				System.out.println(array2[i]+" found at "+foundI);
			}
			else
			{
				System.out.println(array2[i]+" not found");
			}
		}

		count[0]++;
	}

	public static void main(String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Declarando variáveis que serão utilizadas no exercício
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] count = {1};

		while(n != 0 && q != 0)
		{
			int[] numArray = new int[n];
			int[] testes = new int[q];

			preencheArray(numArray, testes, sc);

			procuraArray(numArray, testes, count, sc);

			n = sc.nextInt();
			q = sc.nextInt();
		}


		//Fechando o Scanner
		sc.close();
	}
}
