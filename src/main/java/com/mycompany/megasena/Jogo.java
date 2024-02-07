package com.mycompany.megasena;
import java.util.Arrays;

public class Jogo {
    private int[] sortedNumbers;
    private int quantityNumbers;
    private Gui gameInterface;

    public Jogo(){
        quantityNumbers = 6;
        sortedNumbers = SorteadorNumeros.sortNumbers(quantityNumbers);
        this.gameInterface = new Gui(this);
        startIterationsFindNumbers();
    }

    @Override
    public String toString(){
        return "Jogo: " + Arrays.toString(sortedNumbers);
    }
    
    public int [] getSortedNumbers(){
        return sortedNumbers;
    }
    
    public int getQuantityNumbers(){
        return quantityNumbers;
    }

    public int numberOfHits(int[] bet){
        int numberOfHits = 0;

        for(int i = 0; i < quantityNumbers; i++){
            if(SorteadorNumeros.arrayContainNumber(sortedNumbers, bet[i])){
                numberOfHits ++;
            }
        }
        return numberOfHits;
    }
    
    public void startIterationsFindNumbers(){
        System.out.println("Começando iteracoes!");
        Aposta aposta;
        while(true){
            aposta = new Aposta(quantityNumbers);
            gameInterface.updateAll(aposta.getBet(), numberOfHits(aposta.getBet()));
            if(numberOfHits(aposta.getBet()) == quantityNumbers) break;
        }
        System.out.println("Números encontrados!");
    }
   
}
