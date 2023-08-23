/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Cabra;
import Animais.Animal;

/*
Classe da característica genética Capra
 */
public interface Capra {
    
    public static double preco = 225;
    
    /*
    Método que retorna um animal com genoma Capra
    */
    public static Animal criaCapra (){
        return new Cabra(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
