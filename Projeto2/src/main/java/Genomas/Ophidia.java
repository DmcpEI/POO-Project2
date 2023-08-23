/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Cobra;
import Animais.Animal;

/*
Classe da característica genética Ophidia
 */
public interface Ophidia {
    
    public static double preco = 250;
    
    /*
    Método que retorna um animal com genoma Ophidia
    */
    public static Animal criaOphidia (){
        return new Cobra(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
