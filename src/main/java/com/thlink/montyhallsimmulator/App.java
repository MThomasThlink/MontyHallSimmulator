
package com.thlink.montyhallsimmulator;

public class App 
{
    public static void main (String[] args)
    {
        MH mh = new MH();
        int ctdVitoria = 0, maxJogos = 10000;
        mh.initialize(true);
        
        System.out.printf("           PR U1 AP U2: Score\n");
        for (int i = 0; i < maxJogos; i++)
        {
            GameResult gr =  mh.play();
            System.out.printf("Resultado: %2d %2d %2d %2d: %s.\n", gr.getPremio(), gr.getUsu1(), gr.getApres(), gr.getUsu2(), 
                                                                  (gr.isResult() ? "VENCE" : "PERDE"));
            if (gr.isResult())
                ctdVitoria++;
        }
        double ratio = ((double)ctdVitoria / (double)maxJogos) * 100;
        System.out.printf("Jogos: %d. Vitórias: %d. %5.3f%%.\n", maxJogos, ctdVitoria, ratio);
    }
}
