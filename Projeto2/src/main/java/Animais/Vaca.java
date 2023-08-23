/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animais;


import Genomas.Bovino;
import com.mycompany.jumanji.Zoo;

/*
Classe do animal Vaca
*/
public class Vaca extends Animal implements Bovino {
    
    private static final double ATRATIVIDADEBASE = 250; //Atratividade base do animal
    private static final String GENOMA = "Bovino"; //Genoma do animal
    private static final int ESPERANCAVIDA = 20; //Esperança de vida média do animal
    private static final int APETITEREPRODUTIVO = 60; //Apetite reprodutivo do animal
    
    public Vaca(String nome, boolean adiciona){ //Recebe dois argumentos "nome" é o nome artistico do animal e "adiciona" e se é ou não para adicionar o animal ao zoo
        
        super(nome,ATRATIVIDADEBASE,GENOMA,ESPERANCAVIDA,APETITEREPRODUTIVO);
        
        if(adiciona){//Se for para adicionar o numero de animais do zoo aumenta, é dado um "id" ao animal
            Animal.setAnimaisZoo(Animal.getAnimaisZoo()+1);
            super.setId(Animal.getAnimaisZoo());
        }
    }

    public static double getATRATIVIDADEBASE() {
        return ATRATIVIDADEBASE;
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
    
    @Override
    public String toString() {
        return "Vaca (" +super.toString()+" AtratividadeBase: "+ATRATIVIDADEBASE+" Genoma:"+GENOMA+" EsperançaDeVida:"+ESPERANCAVIDA+" ApetiteReprodutivo:"+APETITEREPRODUTIVO+")";
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo da comida de um Vaca durante um ano
    */
    @Override
    public void comerAnual(Zoo zoo){
        zoo.adicionarSaldo(-80);
    }
    
    /*
    Método vindo da superclasse Animal para retirar ao saldo do zoo o custo dos cuidadores de um Vaca durante um ano
    */
    @Override
    public void cuidarAnual(Zoo zoo){
        zoo.adicionarSaldo(-100);
    }
}
