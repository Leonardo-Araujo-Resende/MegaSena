package com.mycompany.megasena;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Gui {

    JFrame frame;

    JPanel gamePanel;
    
    JLabel title;
    
    JLabel sortedNumbers;
    
    JLabel randomNumbers;
    
    JLabel attemps;
    int qntAttemps;
    
    JLabel betterAttemp;
    int betterNumberOfHits;
    
    JLabel frequencyOfEachHitLabel;
    int[] frequencyOfEachHit;
    
    long startTimeOfExecution;

    
    public Gui(Jogo jogo){ 
        qntAttemps = 0;
        betterNumberOfHits = 0;
        frequencyOfEachHit = new int[jogo.getQuantityNumbers()+1];
        
        System.out.println("Criando interface...");
        frame = new JFrame("Mega Sena");
        frame.setSize(600,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        frame.add(gamePanel);
        
        title = new JLabel("Mega Sena");
        title.setBounds(10,0,600,80);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 128));
        gamePanel.add(title);
        
        this.sortedNumbers = new JLabel(jogo.toString());
        this.sortedNumbers.setBounds(10, 50, 600, 80);
        gamePanel.add(this.sortedNumbers);
        
        randomNumbers = new JLabel("Tentativa: ");
        randomNumbers.setBounds(10,70,600,80);
        gamePanel.add(randomNumbers);
        
        betterAttemp = new JLabel("Melhor Tentativa: ");
        betterAttemp.setBounds(10,90,600,80);
        gamePanel.add(betterAttemp);
        
        attemps = new JLabel("Qnt Tentativas: ");
        attemps.setBounds(10,110,600,80);
        gamePanel.add(attemps);
        
        frequencyOfEachHitLabel = new JLabel("Frequencia de acertos: ");
        frequencyOfEachHitLabel.setBounds(10,130,600,80);
        gamePanel.add(frequencyOfEachHitLabel);
        
        startTimeOfExecution = System.nanoTime();
        frame.setVisible(true);
        System.out.println("Interface do jogo criada!");
    }

    
    public void updateRandomNumbers(int[] randomNumbers){
        this.randomNumbers.setText("Tentando: " + Arrays.toString(randomNumbers));
    }
    
    private void uptdateQuantityAttemps(){
        qntAttemps++;
        this.attemps.setText("Qnt Tentativas: " + qntAttemps);
    }
    
    private void uptdateBetterAttemps(int[] attempt, int numberOfHits){
        if(numberOfHits >= this.betterNumberOfHits){
            this.betterNumberOfHits = numberOfHits;
            this.betterAttemp.setText("Melhor Tentativa: " + Arrays.toString(attempt) + "("+numberOfHits+")");
        }
    }
    
    private void updateFrequencyOfhits(int numberOfHits){
        frequencyOfEachHit[numberOfHits]++;
        frequencyOfEachHitLabel.setText("Frequencia de acertos: " + Arrays.toString(frequencyOfEachHit));
    }
    
    private void updateTimeOfExecution(){
        long tempoDeExecucaoEmMicrossegundos = System.nanoTime() - startTimeOfExecution;
        double tempoDeExecucaoEmSegundos = tempoDeExecucaoEmMicrossegundos / 1000000000;
        String tempoDeExecucaoString = String.format("%.0f", tempoDeExecucaoEmSegundos);
        title.setText("MEGA SENA  Tempo: " + tempoDeExecucaoString);
    }
    
    public void updateAll(int[] attempt, int numberOfHits){
        updateFrequencyOfhits(numberOfHits);
        updateRandomNumbers(attempt);
        uptdateQuantityAttemps();
        uptdateBetterAttemps(attempt, numberOfHits);
        updateTimeOfExecution();
    }
}
