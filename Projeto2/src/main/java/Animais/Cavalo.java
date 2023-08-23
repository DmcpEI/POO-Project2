/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animais;


import Genomas.Equus;
import com.mycompany.jumanji.Zoo;

/*
Classe do animal Cavalo
 */
public class Cavalo extends Animal implements Equus{
    
    private static double atratividadeBase = 500; //Atratividade base do animal
    private static final String GENOMA = "Equus"; //Genoma do animal
    private static final int ESPERANCAVIDA = 30; //Esperança de vida média do animal
    private static final int APETITEREPRODUTIVO = 20; //Apetite reprodutivo do animal
    
    public Cavalo(String nome, boolean adiciona){ //Recebe dois argumentos "nome" é o nome artistico do animal e "adiciona" e se é ou não para adicionar o animal ao zoo
        
        super(nome,atratividadeBase,GENOMA,ESPERANCAVIDA,APETITEREPRODUTIVO);
        
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

    public static void setAtratividadeBase(double atratividadeBase) {
        Cavalo.atratividadeBase = atratividadeBase;
    }
    
    @Override
    public String toString() {
        return "Cavalo (" +super.toString()+" AtratividadeBase: "+atratividadeBase+" Genoma:"+GENOMA+" EsperançaDeVida:"+ESPERANCAVIDA+" ApetiteReprodutivo:"+APETITEREPRODUTIVO+")";
    }
    
    /*
    Método para simplificar o duplicamento da atratividade base por causa do ano chinês
    */
    public static void incrementaAtratividadeBase(){
        atratividadeBase=atratividadeBase*2;
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo da comida de um Cavalo durante um ano
    */
    @Override
    public void comerAnual(Zoo zoo){
        zoo.adicionarSaldo(-200);
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo dos cuidadores de um Cavalo durante um ano
    */
    @Override
    public void cuidarAnual(Zoo zoo){
        zoo.adicionarSaldo(-130);
    }
}
