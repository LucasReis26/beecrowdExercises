import java.util.Scanner;

public class Main
{

	public static String[] separaString(String word, int wordCount)
	{
		char[] wordCharArray = word.toCharArray();

		
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);	

		int T = 0;

		int M = 0, N = 0;

		T = sc.nextInt();	

		for(int i = 0; i < T; i++)
		{
			M = sc.nextInt();
			N = sc.nextInt();

			String[] word = new String[M];
			String[] wordTranslated = new String[M];
			String[] music = new String[N];
			sc.nextLine();

			for(int p = 0, j = 0, l = 0; p < M * 2; p++)
			{
				if(p % 2 == 0)
				{
					word[j] = sc.nextLine();
					System.out.println("Palavra: "+word[j]);
					j++;
				}
				else
				{
					wordTranslated[l] = sc.nextLine();
					System.out.println("Tradução: "+wordTranslated[l]);
					l++;
				}
			}

			for(int j = 0; j < N; j++)		
			{
				music[j] = sc.nextLine();
			}

			int[] wordCount = new int[N];

			for(int p = 0; p < music.length; p++)
			{
				wordCount[p] = 1;
				//System.out.println(music[p]);
				for(int j = 0; j < music[p].length(); j++)
				{
					//System.out.println(music[p].charAt(j));
					if(music[p].charAt(j) == ' ')
					{	
						//System.out.println("Aqui");;
						wordCount[p]++;
					}
				}
				System.out.println("A "+ (p+1) +" linha tem "+wordCount[p]+" palavras");
			}

			for(int p = 0; p < N; p++)
			{
				if(wordCount[p] == 1)
				{
					for(int j = 0; j < M; j++)
					{
						if(music[p].equals(word[j]))
							System.out.println(wordTranslated[j]);
					}
				}
				else
				{
					String[] splittedLine = separaString(music[p]);
				}
			}

		}
	}
}
