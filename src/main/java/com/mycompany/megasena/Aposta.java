package com.mycompany.megasena;
import java.util.Arrays;

public class Aposta {
        
    private int[] bet;

    public Aposta(int quantityNumbers){
        this.bet = SorteadorNumeros.sortNumbers(quantityNumbers);
    }

    public int[] getBet(){
        return bet;
    }

    @Override
    public String toString(){
        return "Aposta: " + Arrays.toString(bet);
    }
}
