package com.mycompany.megasena;
import java.util.Random;
import java.util.Arrays;

public class SorteadorNumeros {
    
    public static int[] sortNumbers(int quantityNumbers){
        int arraySortedNumbers[] = new int[quantityNumbers];
        Random random = new Random();

        for(int i = 0; i < arraySortedNumbers.length; i ++){ 
            int aux;

            do{aux = random.nextInt(60) + 1;}
            while(arrayContainNumber(arraySortedNumbers, aux));

            arraySortedNumbers[i] = aux;
        }

        Arrays.sort(arraySortedNumbers);
        return arraySortedNumbers;
    }

public static boolean arrayContainNumber(int[] arrayNumbers, int number){
    for(int i : arrayNumbers){
        if(i != 0 && i == number){
            return true;
        }
    }
    return false;
    }
}
