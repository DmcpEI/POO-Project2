/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Rato;
import Animais.Animal;

/*
Classe da característica genética Roedor
 */
public interface Roedor {
    
    public static double preco = 20;
    
    /*
    Método que retorna um animal com genoma Roedor
    */
    public static Animal criaRoedor (){
        return new Rato(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
