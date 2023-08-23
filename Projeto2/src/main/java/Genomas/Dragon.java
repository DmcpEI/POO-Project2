/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Dragão;
import Animais.Animal;

/*
Classe da característica genética Dragon
 */
public interface Dragon {
    
    public static double preco = 3000;
    
    /*
    Método que retorna um animal com genoma Dragon
    */
    public static Animal criaDragon (){
        return new Dragão(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
