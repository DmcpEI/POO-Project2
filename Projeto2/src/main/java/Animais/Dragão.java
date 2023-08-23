/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animais;


import Genomas.Dragon;
import Mutações.Dragonismo;
import com.mycompany.jumanji.Zoo;

import java.util.Objects;

/*
Classe do animal Dragão
*/
public class Dragão extends Animal implements Dragonismo, Dragon{
    
    private static double atratividadeBase = 5000; //Atratividade base do animal
    private static final String GENOMA = "Dragon"; //Genoma do animal
    private static final int ESPERANCAVIDA = 100; //Esperança de vida média do animal
    private static final int APETITEREPRODUTIVO = 1; //Apetite reprodutivo do animal
    
    private final boolean DRAGONISMO; //Booleano que define se o dragão tem dragonismo, que é uma mutação uníca dos dragões
    
    public Dragão(String nome, boolean adiciona){ //Recebe dois argumentos "nome" é o nome artistico do animal e "adiciona" e se é ou não para adicionar o animal ao zoo
        
        super(nome,atratividadeBase,GENOMA,ESPERANCAVIDA,APETITEREPRODUTIVO);
        
        DRAGONISMO = temDragonismo();
        
        if (DRAGONISMO){
            super.setBonus(super.getBonus()+atratividadeBase);
        }
        
        if(adiciona){//Se for para adicionar o numero de animais do zoo aumenta, é dado um "id" ao animal
            Animal.setAnimaisZoo(Animal.getAnimaisZoo()+1);
            super.setId(Animal.getAnimaisZoo());
        }
        
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static String getGENOMA() {
        return GENOMA;
    }

    public static int getESPERANCAVIDA() {
        return ESPERANCAVIDA;
    }

    public static int getAPETITEREPRODUTIVO() {
        return APETITEREPRODUTIVO;
    }

    public boolean isDRAGONISMO() {
        return DRAGONISMO;
    }
    
    public static void setAtratividadeBase(double atratividadeBase) {
        Dragão.atratividadeBase = atratividadeBase;
    }
    
    /*
    Método vindo da interface Dragonismo que retorna "true" se o número que é calculado usando o hash for menor que 20 e "false" se não, 
    Assim tencnicamente temos uma probabilidade de o animal ter dragonismo
    */
    @Override
    public boolean temDragonismo (Object...obj){
        int prob = (Math.abs(Objects.hash(obj))%100);
        return prob < 20;
    }

    
    @Override
    public String toString() {
        return "Dragão (" +super.toString()+" Dragonismo:"+DRAGONISMO+" AtratividadeBase:"+atratividadeBase+" Genoma:"+GENOMA+" EsperançaDeVida:"+ESPERANCAVIDA+" ApetiteReprodutivo:"+APETITEREPRODUTIVO+")";
    }
    
    /*
    Método para simplificar o duplicamento da atratividade base por causa do ano chinês
    */
    public static void incrementaAtratividadeBase(){
        atratividadeBase=atratividadeBase*2;
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo da comida de um Dragão durante um ano
    */
    @Override
    public void comerAnual(Zoo zoo){
        zoo.adicionarSaldo(-1000);
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo dos cuidadores de um Dragão durante um ano
    */
    @Override
    public void cuidarAnual(Zoo zoo){
        zoo.adicionarSaldo(-2000);
    }
}
