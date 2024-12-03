package ex1195Java;

import java.util.Scanner;

class No{
	private Integer elemento;
	private No esq;
	private No dir;

	public No(Integer elemento){
		this(elemento,null,null);
	}

	public No(Integer elemento, No esq, No dir){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}

	public void setElemento(Integer elemento){
		this.elemento = elemento;
	}
	public void setEsq(No esq){
		this.esq = esq;
	}
	public void setDir(No dir){
		this.dir = dir;
	}
	public Integer getElemento(){
		return this.elemento;
	}
	public No getEsq(){
		return this.esq;
	}
	public No getDir(){
		return this.dir;
	}
}

class Arvore{
	private No raiz;

	public Arvore(){
		this.raiz = null;
	}
	public void inserir(Integer x){
		this.raiz = inserir(x,raiz);
	}
	private No inserir(Integer x, No i){
		if(i == null){
			i = new No(x);
		}else if(x < i.getElemento()){
			i.setEsq(inserir(x,i.getEsq()));
		}else if(x > i.getElemento()){
			i.setDir(inserir(x,i.getDir()));
		}else{
			System.out.println("Erro!");
		}

		return i;
	}
	public void caminhaIn(){
		caminhaIn(this.raiz);
	}
	public void caminhaIn(No i){
		if(i != null){
			caminhaIn(i.getEsq());
			System.out.print(i.getElemento() + " ");
			caminhaIn(i.getDir());
		}	
	}
	public void caminhaPre(){
		caminhaPre(this.raiz);
	}
	public void caminhaPre(No i){
		if(i != null){
			System.out.print(i.getElemento() + " ");
			caminhaPre(i.getEsq());
			caminhaPre(i.getDir());
		}
	}
	public void caminhaPos(){
		caminhaPos(this.raiz);
	}
	public void caminhaPos(No i){
		if(i != null){
			caminhaPos(i.getEsq());
			caminhaPos(i.getDir());
			System.out.print(i.getElemento() + " ");
		}
	}
}

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Integer casosTeste = sc.nextInt();
		for(int i = 0; i < casosTeste; i++){
			Arvore arvore = new Arvore();
			Integer quantidadeElementos = sc.nextInt();
			for(int j = 0; j < quantidadeElementos; j++){
				arvore.inserir(sc.nextInt());
			}
			System.out.println("Case " + (i + 1) + ":");
			System.out.print("Pre.: ");
			arvore.caminhaPre();
			System.out.println();
			System.out.print("In..: ");
			arvore.caminhaIn();
			System.out.println();
			System.out.print("Post: ");
			arvore.caminhaPos();
			System.out.println();
			System.out.println();
		}
	}
}
