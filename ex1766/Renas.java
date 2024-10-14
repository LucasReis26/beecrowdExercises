package ex1766;

public class Renas
{
	private String name;
	private int peso;
	private int idade;
	private float altura;

	public Renas()
	{
		this("",0,0,0);
	}

	public Renas(String name, int peso, int idade, float altura)
	{
		this.name = name;
		this.peso = peso;
		this.idade = idade;
		this.altura = altura;
	}

	public String getName()
	{
		return this.name;	
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getPeso()
	{
		return this.peso;
	}
	public void setPeso(int peso)
	{
		this.peso = peso;
	}
	public int getIdade()
	{
		return this.idade;
	}
	public void setIdade(int idade)
	{
		this.idade = idade;
	}
	public float getAltura()
	{
		return this.altura;
	}
	public void setAltura(float altura)
	{
		this.altura = altura;
	}
}
