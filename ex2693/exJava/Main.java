package exJava;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Aluno{
	private Integer id;	
	private String name;
	private Character region;
	private Integer cost;

	public Aluno() {
		this(0,"Sem Nome",' ',0);
	}

	public Aluno(Integer id, String name, Character region, Integer cost){
		this.id = id;
		this.name = name;
		this.region = region;
		this.cost = cost;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setRegion(Character region){
		this.region = region;
	}

	public Character getRegion(){
		return this.region;
	}

	public void setCost(Integer cost){
		this.cost = cost;
	}

	public Integer getCost(){
		return this.cost;
	}
}


public class Main{

	public static void main(String[] args) throws IOException{

		FileWriter log = new FileWriter("log.txt"); 
		Scanner sc = new Scanner(System.in);

		log.write("-- Iniciando Programa --");
		log.write("\n");

		Integer alunosPresentes = 0;

		while(sc.hasNext()){
			alunosPresentes = sc.nextInt();

			log.write("\n-- Iniciando Turma de Tamanho(" + alunosPresentes + ") --\n");

			Aluno[] array = new Aluno[alunosPresentes];

			for(int i = 0; i < alunosPresentes; i++){
				array[i] = new Aluno((i+1),sc.next(),sc.next().charAt(0),sc.nextInt());
				log.write("\n-- Aluno " + (i + 1) + " --");
				log.write("\nName: " + array[i].getName());
				log.write("\nRegion: " + array[i].getRegion());
				log.write("\nCost: " + array[i].getCost());
				log.write("\n");
			}

			ordenaAlunos(array,log);

			for(int i = 0; i < array.length; i++){
				System.out.println(array[i].getName());
			}
		}
		sc.close();
		log.close();
	}

	public static void ordenaAlunos(Aluno[] array, FileWriter log) throws IOException{
		log.write("\n-- Iniciando Comparações --");

		for(int i = 1; i < array.length; i++){
			Aluno tmp = array[i];
			Integer j = i - 1;
			
			while(j >= 0 && comparaAlunos(array[j],tmp,log) > 0){
				array[j + 1] = array[j];
				j--;
			}
			log.write("\nTrocando " + tmp.getName() + " com " + array[i].getName() + " ");	
			array[j + 1] = tmp;
		}
	}

	public static Integer comparaAlunos(Aluno n1, Aluno n2, FileWriter log) throws IOException{

		Integer resp = 0;

		log.write("\n-- Comparando " + n1.getName() + " com " + n2.getName() + " --");

		if(n1.getCost() != n2.getCost()){
			if(n1.getCost() < n2.getCost()){
				log.write("\n" + n1.getName() + n1.getId() + ".cost < " + n2.getName()+ n2.getId() + ".cost");
				resp = -1;
			}else if(n2.getCost() < n1.getCost()){
				log.write("\n" + n2.getName() + ".cost < " + n1.getName() + ".cost");
				resp = 1;
			}
		}else if(n1.getRegion() != n2.getRegion()){
			if(n1.getRegion() < n2.getRegion()){
				log.write("\n" + n1.getName() + ".region < " + n2.getName() + ".region");
				resp = -1;
			}else if(n2.getRegion() < n1.getRegion()){
				log.write("\n" + n2.getName() + ".region < " + n1.getName() + ".region");
				resp = 1;
			}
		}else{
			if(n1.getName().compareTo(n2.getName()) < 0){
				log.write("\n" + n1.getName() + ".name < " + n2.getName() + ".name");
				resp = -1;
			}else if(n2.getName().compareTo(n1.getName()) < 0){
				log.write("\n" + n2.getName() + ".name < " + n1.getName() + ".name");
				resp = 1;
			}
		}	

		log.write("\n");
		return resp;
	}
}
