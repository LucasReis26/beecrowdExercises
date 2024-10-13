package ex1261;

import java.util.Scanner;

class HayPoints
{
    private String word;
    private int value;

    public HayPoints()
    {
        this("",0);
    }
    public HayPoints(String word, int value)
    {
        this.word = word;
        this.value = value;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
    public String getWord()
    {
        return this.word;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return this.value;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int numPalavras, numDescricoes;
        numPalavras = sc.nextInt();
        numDescricoes = sc.nextInt();

        HayPoints[] x = new HayPoints[numPalavras];


        for(int i = 0; i < numPalavras; i++)
        {
            x[i] = new HayPoints();
            String word = sc.next();
            x[i].setWord(word);
            int value = sc.nextInt();
            x[i].setValue(value);
        }

        for(int i = 0; i < numDescricoes; i++)
        {
            String nextWord;
            int money = 0;
            nextWord = sc.next();
            while(!nextWord.equals("."))
            {
                for(int j = 0; j < numPalavras; j++)
                {
                    if(nextWord.equals(x[j].getWord()))
                        money += x[j].getValue();
                }
                nextWord = sc.next();
            }
            System.out.println(money);
            money = 0;
        }

        sc.close();

    }
}