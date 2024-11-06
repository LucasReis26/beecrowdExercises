package ex1382Java;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class Main{
	public static void main (String[] args){
		
		//Declarando variáveis
		Scanner sc = new Scanner(System.in);
		Integer instancias = sc.nextInt();
		
		for(int i = 0; i < instancias; i++){

			Integer qttNums = sc.nextInt();
			Integer[] array = new Integer[qttNums];

			for(int j = 0; j < qttNums; j++){
				array[j] = sc.nextInt();
			}

			System.out.println(ordenaArray(array));

		}
	}

	public static Integer ordenaArray(Integer[] array){

		Integer count = 0;

		for(int i = 0; i < array.length - 1; i++){
			Integer menor = i;

			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[menor])
					menor = j;
			}
			if(i != menor){
				Integer tmp = array[menor];
				array[menor] = array[i];
				array[i] = tmp;
				count++;
			}
		}

		return count;
	}
}
