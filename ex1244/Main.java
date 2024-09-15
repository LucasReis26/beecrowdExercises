import java.util.Scanner;

public class Main
{
	//Procedimento para trocar duas posições no array
	public static void swap (String[] wordString, int maior, int menor)
	{
		String temp = wordString[maior];
		wordString[maior] = wordString[menor];
		wordString[menor] = temp;
	}

	//Função pra contar quantas palavras tem na string
	public static int wordCount(String word)
	{
		int N = 1;
		char[] charWord = word.toCharArray();

		for(int i = 0; i < word.length(); i++)
		{
			if(charWord[i] == 32)
			{
				N++;
			}
		}

		return N;
	}

	//Procedimento pra preencher um array de Strings vazio
	public static void preencheString(String word, String[] wordString,int numWords)
	{
		char[] charWord = word.toCharArray();
		int count = 0;

		for(int i = 0; i < numWords; i++)
		{
			wordString[i] = "";
		}

		for(int i = 0; i < word.length(); i++)
		{
			if(charWord[i] != 32)
			{
				wordString[count] += charWord[i];
			}
			else
			{
				count++;
			}
		}
	}
	//Procedimento pra ordenar o array de strings (ordenação por inserção)
	public static void ordenaString (String[] wordString,int numWords)
	{
		for(int i = 1; i < numWords; i++)
		{
			int j = i;

			while (j > 0 && wordString[j].length() > wordString[j-1].length())
			{
				swap(wordString,j,j-1);
				j -= 1;
			}
		}
	}

	//Procedimento pra imprimir as palavras na tela
	public static void imprime(String[] wordString,int numWords)
	{
		for(int i = 0; i < numWords; i++)
		{
			if(i != (numWords - 1))
				System.out.print(wordString[i] + " ");
			else
				System.out.println(wordString[i]);
		}
	}

	//função main
	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Declarando Variáveis
		int N = sc.nextInt();
		sc.nextLine(); //Limpando buffer

		//Processando informações
		for(int i = 0; i < N; i++)
		{
			String word = sc.nextLine();
			int numWords = wordCount(word);
			String[] wordString = new String[numWords];
			preencheString(word,wordString,numWords);
			ordenaString(wordString,numWords);
			imprime(wordString,numWords);
			
		}

		//Fechando o Scanner
		sc.close();
	}
}
