/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Cachorro;
import Animais.Animal;

/*
Classe da característica genética Canis
 */
public interface Canis {
    
    public static double preco = 150;
    
    /*
    Método que retorna um animal com genoma Canis
    */
    public static Animal criaCanis (){
        return new Cachorro(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
