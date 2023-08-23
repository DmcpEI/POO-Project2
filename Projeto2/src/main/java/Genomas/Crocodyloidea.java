/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Crocodilo;
import Animais.Animal;

/*
Classe da característica genética Crocodyloidea
 */
public interface Crocodyloidea {
    
    public static double preco = 425;
    
    /*
    Método que retorna um animal com genoma Crocodyloidea
    */
    public static Animal criaCrocodyloidea (){
        return new Crocodilo(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
