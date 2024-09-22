import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main
{
	public static void swapArray(int[] array, int n1, int n2)
	{
		int temp = array[n1];
		array[n1] = array[n2];
		array[n2] = temp;
	}

	public static void preencheArray(int[] x, int[] y, Scanner sc )
	{
		for(int i = 0; i < x.length; i++)
		{
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();

			if(i >= 1)
			{
				int j = i;

				while( j > 0 && (y[j]/x[j]) <= (y[j-1]/x[j-1]) )
				{
					swapArray(x,j,j-1);
					swapArray(y,j,j-1);
					j--;
				}
				
			}
		}
	}

	public static void imprimeResultado (int[] x, int[] y, int city)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.DOWN);

		float total = 0;
		int pessoas = 0;
		
		if(city != 1)
			System.out.println();

		System.out.println("Cidade# "+city+":");

		for(int i  = 0; i < x.length; i++)
		{
			total += y[i];
			pessoas += x[i];

			if(i != x.length-1)
			{
				int j = i;
				
				int k = x[j];

				while( j < x.length-1 && (y[j]/x[j]) == (y[j+1]/x[j+1]) )
				{
					total += y[j+1];
					pessoas += x[j+1];

					k += x[j+1];
						
					j++;
				}

				i = j;

				System.out.print(k+"-"+(y[i]/x[i])+" ");
			}
			else
				System.out.println(x[i]+"-"+(y[i]/x[i]));
		}

		System.out.println("Consumo medio: " + df.format(total/(float) pessoas) + " m3.");


	}

	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Variáveis necessárias para o exercício
		int n = sc.nextInt();
		int city = 1;

		while(n != 0)
		{
			int[] x = new int[n];
			int[] y = new int[n];

			preencheArray(x,y,sc);

			imprimeResultado(x,y,city);

			city++;

			n = sc.nextInt();
		}

		//Fechando o Scanner
		sc.close();
	}
}
