/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.UrsoPardo;
import Animais.Panda;
import Animais.UrsoPolar;
import Animais.Animal;
import java.util.Random;

/*
Classe da característica genética Urso
 */
public interface Urso {
    
    public static double preco = 550;
    
    /*
    Método que retorna um animal com genoma Urso
    */
    public static Animal criaUrso (){
        
        Random rand = new Random();
        int a = rand.nextInt(3);
            
        return switch (a) {
            case 0 -> new Panda(null, true);
            case 1 -> new UrsoPardo(null, true);
            default -> new UrsoPolar(null, true);
        };
    }
    
    public static double getPreco() {
        return preco;
    }
}
