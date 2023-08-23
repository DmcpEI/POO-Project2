/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Porco;
import Animais.Animal;

/*
Classe da característica genética Suíno
 */
public interface Suíno {
    
    public static double preco = 150;
    
    /*
    Método que retorna um animal com genoma Suíno
    */
    public static Animal criaSuíno (){
        return new Porco(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
