
package com.thlink.montyhallsimmulator;

import java.util.concurrent.ThreadLocalRandom;

public class MH 
{
    private static final int NUM_OPTIONS = 3;
    private boolean change, debug = false;

    private boolean[] game;
    
    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }
    
    public void initialize (boolean pChange)
    {
        setChange(pChange);
        game = new boolean[NUM_OPTIONS];
    }
    
    public GameResult play ()
    {
        GameResult gr = new GameResult();
        
        //0. 'Sortear o prêmio
        if (debug)
            System.out.println("Sortear Premio");
        gr.setPremio(rand());
        game[gr.getPremio()] = true;
        if (debug)
            System.out.println("Premio está em " + gr.getPremio());
        
        //1. 'Sortear a escolha do usuário
        if (debug)
            System.out.println("Escolha do usuário");
        gr.setUsu1(rand());
        game[gr.getUsu1()] = true;
        if (debug)
            System.out.println("Usuario escolheu " + gr.getUsu1());
        
        //2. Sortear a escolha do apresentador (não pode ser a mesma)
        int[] forbidden1 = { gr.getPremio(), gr.getUsu1() };
        if (debug)
            System.out.println("Escolha do apresentador");
        gr.setApres(randExceptThis(forbidden1));
        game[gr.getApres()] = true;
        if (debug)
            System.out.println("Apresentador mostrou " + gr.getApres());
        
        if (isChange())
        {
            if (debug)
                System.out.println("Mudar!");
            int[] forbidden = { gr.getApres(), gr.getUsu1() };
            gr.setUsu2(randExceptThis(forbidden));
            if (debug)
                System.out.println("Usuario escolhe de novo: " + gr.getUsu2());
            
            if (gr.getUsu2() == gr.getPremio())
            {
                if (debug)
                    System.out.println("Usuario acertou ao mudar!");
                gr.setResult(true);
                return gr;
            }
            else
            {
                if (debug)
                    System.out.println("Usuario errou ao mudar!");
                gr.setResult(false);
                return gr;
            }
        }
        else
        {
            if (debug)
                System.out.println("Nao mudar!!");
            if (gr.getUsu1() == gr.getPremio())
            {
                if (debug)
                    System.out.println("Usuario acertou ao não mudar!");
                gr.setResult(true);
                return gr;
            }
            else
            {
                if (debug)
                    System.out.println("Usuario errou ao não mudar!");
                gr.setResult(false);
                return gr;
            }
        }
    }
    
    private boolean areYouOnTheList (int choice, int[] pNums)
    {
        for (int i = 0; i < pNums.length; i++)
        {
            if (choice == pNums[i])
                return true;
        }
        return false;
    }
    
    private int randExceptThis (int[] pNums)
    {
        do
        {
            int randomNum = rand();
            if (!areYouOnTheList(randomNum, pNums))
            {
                //System.out.printf("Este serve: %d.\n", randomNum);
                return randomNum;
            }
            //System.out.printf("Não serve (%d). Pedir outro.\n", randomNum);
        } while(true);
    }
    
    private int rand ()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(0, NUM_OPTIONS);
        return randomNum;
    }
}
