import java.util.Scanner;

public class Main
{
	public static void imprime (int[] array1, int[] array2)
	{
		for(int i = 0; i < array1.length; i++)
			System.out.println(array1[i]);
		for(int i = 0; i < array2.length; i++)
			System.out.println(array2[i]);
	}

	public static void swap(int[] array, int n1, int n2)
	{
		int temp = array[n1];
		array[n1] = array[n2];
		array[n2] = temp;
	}

	public static void ordenaCrescente (int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int j = i;

			while(j > 0 && array[j] < array[j - 1])
			{
				swap(array, j, j-1);
				j--;
			}
		}
	}

	public static void ordenaDecrescente (int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int j = i;

			while(j > 0 && array[j] > array[j-1])
			{
				swap(array, j, j-1);
				j--;
			}
		}
	}

	public static void separaArray (int[] array, int pares, int impares)
	{
		int[] arrayPar = new int[pares],
		      arrayImpar = new int[impares];

		int iPar = 0,
			iImpar = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] % 2 == 0)
			{
				arrayPar[iPar] = array[i];
				iPar++;
			}
			else
			{
				arrayImpar[iImpar] = array[i];
				iImpar++;
			}
		}

		ordenaCrescente(arrayPar);
		ordenaDecrescente(arrayImpar);
		imprime(arrayPar, arrayImpar);


	}

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(),
		    countPar = 0,
			countImpar = 0;

		int[] array = new int[x];

		for(int i = 0; i < x; i++)
		{
			array[i] = sc.nextInt();
			if (array[i] % 2 == 0)
				countPar++;
			else
				countImpar++;
		}

		separaArray(array, countPar, countImpar);

		sc.close();
	}
}
