package ex1211Java;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main{

	public static void main (String[] args) throws IOException{
		
		//Declarando variáveis necessárias
		
		Scanner sc = new Scanner(System.in);
		FileWriter log = new FileWriter("log.txt");
		Integer qttTelNumbers = 0;

		//Iniciando Código

		log.write("--- Iniciando Exercício 1211 ---");
		do{
			//Variáveis necessárias
			String firstNumber = "";
			//Escaneando a quantidade de números do array
			qttTelNumbers = sc.nextInt();
			sc.nextLine();

			log.write("\n\n-- Criando array de  " + qttTelNumbers + " números --");	
			String[] telNumbers = new String[qttTelNumbers];

			//Preenchendo array com números e organizando;
			for(int i = 0; i < telNumbers.length; i++){
				telNumbers[i] = sc.nextLine();
				log.write("\n\n- Inserindo " + telNumbers[i] + " ao array de números na posição(" + i + ") -");

				//Captura o primeiro número de telefone para ordenação
				if(i == 0)
					firstNumber = telNumbers[i];

				if(i > 0){
					Integer j = i - 1;
					String tmp = telNumbers[i];
					while(j >= 0 && (telNumbers[j].compareTo(tmp) > 0 && tmp.compareTo(firstNumber) <= 0)){
						log.write("\n- "+ tmp + " < " + telNumbers[j] + " -");
						telNumbers[j + 1] = telNumbers[j];
						j--;
					}
					if(tmp != telNumbers[i]){
						log.write("\n- " + tmp + " <==> " + telNumbers[i] + " -");
						telNumbers[j+1] = tmp;
					}	
				}


			}
			System.out.println(contaSufixo(telNumbers));
		}while(sc.hasNextInt());

		//Fechando Scanner e FileWriter
		
		log.write("\n\n--- Fim ---");
		sc.close();
		log.close();
	}

	public static Integer contaSufixo(String[] array){
		//Variáveis a serem utilizadas
		String previousNumber = array[0];
		Integer equals = 0;
		Integer maxEquals = 0;

		for(int i = 1; i < array.length; i++){
			String atualNumber = array[i];

			for(int j = 0; j < atualNumber.length(); j++){
				if(atualNumber.charAt(j) == previousNumber.charAt(j)){
					equals++;
				}else{
					j = array[i].length();

					if(equals > maxEquals)
						maxEquals = equals;

					equals = 0;

					previousNumber = atualNumber;
				}
			}
		}
		return maxEquals;
	}
}
