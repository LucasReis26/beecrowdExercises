import java.util.Scanner;

public class Main
{
	//Função utilizada pra avaliar expressão
	public static boolean avaliaExpressao (String expr)
	{
		//Conta quantos abre e fecha parentesis existem na expressão
		int abrePar = 0,
		    fechaPar = 0;
		//Resposta que será retornada
		boolean resp = true,
		        error = false;
		//Converte a String pra um Array de Char
		char[] exprArray = expr.toCharArray();
		//Contabiliza os abre e fecha parentesis
		for(int i = 0; i < expr.length(); i++)
		{
			if (exprArray[i] == 40)
				abrePar++;
			//Não considera fecha parentesis sem parentesis aberto
			else if (exprArray[i] == 41)
			{
				if(abrePar > fechaPar)
					fechaPar++;
				else
					error = true;
			}
		}
		//Se tiver a mesma quantidade e sem erros verdade
		if (abrePar == fechaPar && error == false)
			resp = true;
		//Se não resposta falsa
		else
			resp = false;
		//Retorno da função
		return resp;
	}

	public static void main (String[] args)
	{
		//Inicializando o Scanner
		Scanner sc = new Scanner(System.in);

		//Declarando variáveis para o exercício
		String expressao;

		//Inicializando Processamento de Dados
		while(sc.hasNext())
		{
			expressao = sc.nextLine();

			//Printa a resposta na tela
			if (avaliaExpressao(expressao))
				System.out.println("correct");
			else
				System.out.println("incorrect");

		}

		//Fechando o Scanner
		sc.close();

	}
}
