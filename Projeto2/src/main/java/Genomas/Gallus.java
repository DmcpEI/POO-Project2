/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Galo;
import Animais.Animal;

/*
Classe da característica genética Gallus
 */
public interface Gallus {
    
    public static double preco = 150;
    
    /*
    Método que retorna um animal com genoma Gallus
    */
    public static Animal criaGallus (){
        return new Galo(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
