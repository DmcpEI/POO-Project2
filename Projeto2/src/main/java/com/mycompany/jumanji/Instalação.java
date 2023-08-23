/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jumanji;

import Animais.Animal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
Classe das instalações do zoo
*/
public class Instalação {
    
    private int numeroInstalacao; //Inteiro que cada instalação tem par serem distingidas, ou seja o seu id
    private int lotacao; //Tamanho da instalação (quantos animais pode ter, isto é, o tamanho do array)
    private int animaisInstalados; //Número de animais na instalação
    private double precoInstalacao; //Preço de construção da instalação
    private ArrayList<Animal> animais; //Array de animais da instalação (onde são guardados os animas que estão na instalação)
    
    private static int instalacoes; //Número de instalações adicionadas ao zoo, serve para criar seus numeros de instalação
    
    public Instalação(boolean constroi){ //O construtor recebe um boleano "constroi" que serve para saber se é ou não para adicionar a instalação ao zoo
      
        lotacao = geraLotacao(); //Gera uma lotação qualquer
        animais = new ArrayList<>(lotacao);
        animaisInstalados = 0;
        precoInstalacao = geraPreco(); //Gera um preço de construção para a instalação
        numeroInstalacao = instalacoes+1; //Diz que o numero da instalação é o número de instalações no zoo mais 1 (O seu numero e instalacoes vão realmente ser mudados se for para a construir)
        
        if(constroi){ //Se for para construir, aumenta o número de instalações no zoo e usa esse número como número da nova instalação
            instalacoes++;
            numeroInstalacao = instalacoes;
        }
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public int getNumeroInstalacao() {
        return numeroInstalacao;
    }

    public static int getInstalacoes() {
        return instalacoes;
    }

    public double getPrecoInstalacao() {
        return precoInstalacao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public int getAnimaisInstalados() {
        return animaisInstalados;
    }
    
    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public void setNumeroInstalacao(int numeroInstalacao) {
        this.numeroInstalacao = numeroInstalacao;
    }

    public static void setInstalacoes(int instalacoes) {
        Instalação.instalacoes = instalacoes;
    }

    public void setPrecoInstalacao(double precoInstalacao) {
        this.precoInstalacao = precoInstalacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public void setAnimaisInstalados(int animaisInstalados) {
        this.animaisInstalados = animaisInstalados;
    }

    @Override
    public String toString() {
        return "Instalação{ NúmeroDaInstalação="+numeroInstalacao+", Lotação="+lotacao+", Animais instalados="+animaisInstalados+", Preço="+precoInstalacao+", Animais="+animais+"}";
    }
    
    /*
    Método para simplificar a adição de uma instalação aumentando por um a variável de instalações 
    */
    public static void incrementaInstalacoes(){
        Instalação.setInstalacoes(Instalação.getInstalacoes()+1);
    }
    
    /*
    Método que usando um random retorna uma lotação para a instalação que vai de 1 a 10
    */
    private int geraLotacao (){
        
        Random rand = new Random();
        int a = rand.nextInt(10)+1;
        return a;
    }
    
    /*
    Método que usando um random e a lotação retorna um preço de construção para a instalação
    */
    private double geraPreco (){
        
        Random rand = new Random();
        double a = rand.nextInt(500)+250;
        return a*lotacao; //Random que vai de 250 a 749, vezes, a lotação da instalação que vai de 1 a 10
        
    }
    
    /*
    Método para adicionar um animal á instalação
    Verifica se a instalação está cheia e se estiver pede ao utilizador para escolher um animal para substituir pelo que quer inserir
    O animal substituído vai para o ArrayList dos animais fora do zoo e o a inserir é inserido na ArrayList da instalação
    */
    public void adicionaAnimal (Zoo zoo, Animal animal){
        
        if(animaisInstalados<lotacao){ //Se a instalação não estiver cheia
            animais.add(animal);
            animaisInstalados++;
        }
        else{ //Se estiver cheia
            System.out.println("Esta instalação está cheia, qual animal quer trocar?");
            
            for(int i = 0;i<animais.size();i++){
                System.out.println(i+") "+animais.get(i));
            }
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Animal:");
            
            while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
                System.out.println("Para escolher uma opção tem de escrever um dos números inteiros apresentados no inicio de cada animal");
                System.out.print("Animal:");
                scan.next();
            }
            int opcao = scan.nextInt();
                
            zoo.adicionarFI(animais.get(opcao)); //Adiciona o animal substituído ao ArrayList dos animais fora das instalações
            animais.remove(opcao); //Remove o animal substituído da instalação
            animais.add(animal); //Adiciona o animal a inserir á ArrayList da instalação
        }
    }
    
    /*
    Método para retirar ao saldo do zoo o custo da manutenção em geral da instalação
    Depende da lotação desta, pois numa instalação maior lógicamente será mais cara a manutenção
    */
    public void manutencaoInstalacaoAno(Zoo zoo){
        zoo.adicionarSaldo(-(lotacao*200));
    }
}
