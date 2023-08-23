/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animais;

import Mutações.Albinismo;
import Mutações.Heterocromia;
import com.mycompany.jumanji.Zoo;
import java.util.Objects;
import java.util.Random;

/*
Classe dos animais do zoo
*/
public abstract class Animal implements Albinismo, Heterocromia{
    
    private int id; //Id do animal
    private String nome; //Nome do animal
    private int idade; //Idade do animal
    private double bonus; //Bonus de atratividade do animal (pode ser negativo porque o animal perde este ao longo dos anos)
    
    private final boolean HETEROCROMIA; //Booleano que define se o animal tem heterocromia
    private final boolean ALBINISMO; //Booleano que define se o animal tem albinismo
    
    private static int animaisZoo; //Quantos animais foram inseridos no zoo desde o início

    /*Recebe 3 argumentos, 
    "nome" é o nome artístico do animal, 
    "atratividadeBase" é a atratividade base do animal em questão e 
    "esperancaVida" que é a esperança de vida também do animal em questão
    */
    public Animal(String nome, double atratividadeBase) { 
        
        this.nome = nome;
        idade = 0;
        bonus = 0;
        id = animaisZoo+1; //Diz que o id do animal é os animas já inseridos no zoo mais 1 (O seu id e animaisZoo vão realmente ser mudados no construtor das subclasses)
        
        HETEROCROMIA = temHeterocromia(nome,idade,bonus,id); //Calcula e verifica se o animal tem heterocromia utilizando as caraterísticas presentes
        ALBINISMO = temAlbinismo(nome,idade,bonus,id, HETEROCROMIA); //Calcula e verifica se o animal é albino utilizando as caraterísticas presentes
        
        incrementaBonus(atratividadeBase); //Incrementa ao bonus do animal a sua atratividade dependendo das mutações
        
    }                       
    
    /*Recebe 5 argumentos, 
    "nome" é o nome artístico do animal, 
    "atratividadeBase" é a atratividade base do animal em questão,
    "genoma" é a caraterística genética também do animal em questão,
    "esperancaVida" é a esperança de vida também do animal em questão e
    "apetiteReprodutivo" que é o apetite reprodutivo também do animal em questão
    */
    public Animal(String nome, double atratividadeBase, String genoma, int esperancaVida, int apetiteReprodutivo){
        
        Random rand = new Random();
        
        this.nome = nome;
        
        idade = (esperancaVida/3)+(rand.nextInt(3+3)-3); //Calcula a idade do animal dividindo a sua esperança de vida por 3 e adicionando a esse número outro que varia entre -3 e 3
        if(idade<0)idade=0; //Se o calculo da idade for menor que 0, a idade do animal fica a 0
        
        bonus = 0;
        id = animaisZoo+1; //Diz que o id do animal é os animas já inseridos no zoo mais 1 (O seu id e animaisZoo vão realmente ser mudados no construtor das subclasses)
        
        HETEROCROMIA=temHeterocromia(id, nome,idade,bonus,atratividadeBase, genoma, esperancaVida, apetiteReprodutivo); //Calcula e verifica se o animal tem heterocromia utilizando as caraterísticas presentes
        ALBINISMO=temAlbinismo(id, nome,idade,bonus,atratividadeBase, genoma, esperancaVida, apetiteReprodutivo, HETEROCROMIA); //Calcula e verifica se o animal é albino utilizando as caraterísticas presentes
        
        incrementaBonus(atratividadeBase); //Incrementa ao bonus do animal a sua atratividade dependendo das mutações
        
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getBonus() {
        return bonus;
    }

    public static int getAnimaisZoo() {
        return animaisZoo;
    }

    public boolean isHETEROCROMIA() {
        return HETEROCROMIA;
    }

    public boolean isALBINISMO() {
        return ALBINISMO;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public static void setAnimaisZoo(int animaisZoo) {
        Animal.animaisZoo = animaisZoo;
    }

    @Override
    public String toString() {
        
        return "Id= "+id+" Nome:"+nome+" Idade:"+idade+" Bonus:"+bonus+" Heterocromia:"+HETEROCROMIA+" Albinismo:"+ALBINISMO;
    }
    
    /*
    Método vindo da interface Heterocromia que retorna "true" se o número que é calculado usando o hash for menor que 5 e "false" se não, 
    Assim tencnicamente temos uma probabilidade de o animal ter heterocromia
    */
    @Override
    public boolean temHeterocromia (Object...obj){
        int prob = (Math.abs(Objects.hash(obj))%100);
        return prob < 5;
    }
    
    /*
    Método vindo da interface Albinismo que retorna "true" se o número que é calculado usando o hash for menor que 10 e "false" se não, 
    Assim tencnicamente temos uma probabilidade de o animal ter albinismo
    */
    @Override
    public boolean temAlbinismo (Object...obj){
        int prob = (Math.abs(Objects.hash(obj))%100);
        return prob < 10;
    }
    
    /*
    Método para simplificar a adição de um animal aumentando por um a variável de animais 
    */
    public static void incrementaAnimais(){
        animaisZoo++;
    }
    
    /*
    Método que verifica se o animal tem alguma mutação e ai incrementa ao bonús desse animal o valor da sua atratividade base
    Com isto, dependendo do número de mutações que tem o animal a sua atratividade em geral multiplica essas vezes
    */
    public void incrementaBonus (double atratividadeBase){
        if (HETEROCROMIA){
            bonus+=atratividadeBase;
        }
        if (ALBINISMO){
            bonus+=atratividadeBase;
        }
    }
    
    /*
    Método para simplificar o aumento da idade do animal
    */
    public void incrementaIdade(){
        idade++;
    }
    
    /*
    Método para retirar ao saldo do zoo o custo da comida do animal durante um ano
    */
    public abstract void comerAnual(Zoo zoo);
    
    /*
    Método para retirar ao saldo do zoo o custo dos cuidadores do animal durante um ano
    */
    public abstract void cuidarAnual(Zoo zoo);
}
