/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animais;


import Genomas.Ophidia;
import com.mycompany.jumanji.Zoo;

/*
Classe do animal Cobra
 */
public class Cobra extends Animal implements Ophidia{
    
    private static double atratividadeBase = 400; //Atratividade base do animal
    private static final String GENOMA = "Ophidia"; //Genoma do animal
    private static final int ESPERANCAVIDA = 25; //Esperança de vida média do animal
    private static final int APETITEREPRODUTIVO = 50; //Apetite reprodutivo do animal
    
    public Cobra(String nome, boolean adiciona){ //Recebe dois argumentos "nome" é o nome artistico do animal e "adiciona" e se é ou não para adicionar o animal ao zoo
        
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
        Cobra.atratividadeBase = atratividadeBase;
    }
    
    @Override
    public String toString() {
        return "Cobra (" +super.toString()+" AtratividadeBase: "+atratividadeBase+" Genoma:"+GENOMA+" EsperançaDeVida:"+ESPERANCAVIDA+" ApetiteReprodutivo:"+APETITEREPRODUTIVO+")";
    }
    
    /*
    Método para simplificar o duplicamento da atratividade base por causa do ano chinês
    */
    public static void incrementaAtratividadeBase(){
        atratividadeBase=atratividadeBase*2;
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo da comida de uma Cobra durante um ano
    */
    @Override
    public void comerAnual(Zoo zoo){
        zoo.adicionarSaldo(-50);
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo dos cuidadores de uma Cobra durante um ano
    */
    @Override
    public void cuidarAnual(Zoo zoo){
        zoo.adicionarSaldo(-50);
    }
}
