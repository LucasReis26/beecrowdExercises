import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int testes = sc.nextInt();
		sc.nextLine();

		while(sc.hasNext())
		{
			int maxEquals = 0;

			String firstNumber = sc.next();

			for(int i = 0; i < testes - 1; i++)
			{
				int equals = 0;

				String nextNumber = sc.next();

				for(int j = 0; j < nextNumber.length(); j++)
				{
					if(firstNumber.charAt(j) == nextNumber.charAt(j))
						equals++;
					else
						j = nextNumber.length();
				}

				if(equals > maxEquals && equals <= firstNumber.length())
					maxEquals = equals;
			}

			System.out.println(maxEquals);
	
			if(sc.hasNextInt())
			{
				testes = sc.nextInt();
				sc.nextLine();
			}
			
		}
	}
}
