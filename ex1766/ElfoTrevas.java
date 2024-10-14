package ex1766;

import java.util.Locale;
import ex1766.Renas;
import java.util.Scanner;

public class ElfoTrevas
{
	public static void swap (Renas[] array, int n1, int n2)
	{
		Renas temp = array[n1];
		array[n1] = array[n2];
		array[n2] = temp;
	}

	public static void selecionaRenas(Renas[] renas,int renasTreno)
	{
		//System.out.println("Estou organizando renas");
		for(int i = 0; i < renas.length - 1; i++)
		{
			int renaIdeal = i;

			for(int j = i + 1; j < renas.length; j++)
			{
				if(renas[renaIdeal].getPeso() < renas[j].getPeso())
					renaIdeal = j;	
			}

			swap(renas,i,renaIdeal);
		}

		boolean reorder = false;
		for(int i = 1; i < renas.length && reorder == false; i++)
		{
			int count = 1;
			int avaliaPeso = renas[0].getPeso();

			if(renas[i].getPeso() == avaliaPeso)
				count++;
			else
			{
				//System.out.println("Trocando o peso");
				avaliaPeso = renas[i].getPeso();
				count = 1;
			}

			if(count == 2)
				reorder = true;
		}

		if(reorder == false)
			return;

		//System.out.println("Muitas renas com o mesmo peso, reorganizando");

		for(int i = 0; i < renasTreno - 1; i++)
		{
			int renaIdeal = i;

			for(int j = i + 1; j < renasTreno; j++)
			{
				if(renas[renaIdeal].getIdade() > renas[j].getIdade())
					renaIdeal = j;	
			}

			swap(renas,i,renaIdeal);
		}
		
		reorder = false;

		for(int i = 1; i < renasTreno && reorder == false; i++)
		{
			int count = 1;
			int avaliaIdade = renas[0].getIdade();

			if(renas[i].getIdade() == avaliaIdade)
				count++;
			else
			{
				avaliaIdade = renas[i].getIdade();
				count = 1;
			}

			if(count == 2)
				reorder = true;
		}

		if(reorder == false)
			return;
		
		reorder = false;

		//System.out.println("Muitas renas com a mesma idade, reorganizando");

		for(int i = 0; i < renasTreno - 1; i++)
		{
			int renaIdeal = i;

			for(int j = i + 1; j < renasTreno; j++)
			{
				if(renas[renaIdeal].getAltura() > renas[j].getAltura())
					renaIdeal = j;	
			}

			swap(renas,i,renaIdeal);
		}

		for(int i = 1; i < renasTreno && reorder == false; i++)
		{
			int count = 1;
			float avaliaAltura = renas[0].getAltura();

			if(renas[i].getAltura() == avaliaAltura)
				count++;
			else
			{
				avaliaAltura = renas[i].getAltura();
				count = 1;
			}

			if(count == 2)
				reorder = true;
		}

		if(reorder == false)
			return;
		
		reorder = false;

		//System.out.println("Muitas renas com a mesma altura, reorganizando");

		for(int i = 0; i < renasTreno - 1; i++)
		{
			int renaIdeal = i;

			for(int j = i + 1; j < renasTreno; j++)
			{
				if(renas[renaIdeal].getName().compareTo(renas[j].getName()) > 0)
					renaIdeal = j;	
			}

			swap(renas,i,renaIdeal);
		}

	}
	public static void imprime(Renas[] array,int tam)
	{
		for(int i = 0; i < tam; i++)
		{
			System.out.println((i + 1) +" - "+ array[i].getName());
		}
	}

	public static void main(String[] args)
	{
		int numTestes;
		int numRenas;
		int renasTreno;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		numTestes = sc.nextInt();
		numRenas = sc.nextInt();

		renasTreno = sc.nextInt();

		for(int i = 0; i < numTestes; i++)
		{
			System.out.println("CENARIO {" + (i+1) + "}");
			Renas[] renas = new Renas[numRenas];

			for(int j = 0; j < numRenas; j++)
			{
				renas[j] = new Renas();
				
				String name = sc.next();
				renas[j].setName(name);

				int peso = sc.nextInt();
				renas[j].setPeso(peso);

				int idade = sc.nextInt();
				renas[j].setIdade(idade);
				
				float altura = sc.nextFloat();
				renas[j].setAltura(altura);	
			}

			selecionaRenas(renas,renasTreno);
			imprime(renas,renasTreno);

			if(sc.hasNextInt())
			{
				numRenas = sc.nextInt();
				renasTreno = sc.nextInt();
			}
		}

		sc.close();

	}

}
