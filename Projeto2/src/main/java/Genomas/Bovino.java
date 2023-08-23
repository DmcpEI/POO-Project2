/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Boi;
import Animais.Vaca;
import Animais.Animal;
import java.util.Random;

/*
Classe da característica genética Bovino
 */
public interface Bovino {
    
    public static double preco = 275;
    
    /*
    Método que retorna um animal com genoma Bovino
    */
    public static Animal criaBovino (){
        
        Random rand = new Random();
        int a = rand.nextInt(2);
            
        if (a == 0){
            return new Boi(null, true);
        }
        else{
            return new Vaca(null, true);
        }
    }
    
    public static double getPreco() {
        return preco;
    }
}
