/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Macaco;
import Animais.Gorila;
import Animais.Animal;
import java.util.Random;

/*
Classe da característica genética Primata
 */
public interface Primata {
    
    public static double preco = 450;
    
    /*
    Método que retorna um animal com genoma Primata
    */
    public static Animal criaPrimata (){
        
        Random rand = new Random();
        int a = rand.nextInt(2);
            
        if (a == 0){
            return new Macaco(null, true);
        }
        else{
            return new Gorila(null, true);
        }
    }
    
    public static double getPreco() {
        return preco;
    }
}
