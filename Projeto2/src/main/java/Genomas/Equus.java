/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Cavalo;
import Animais.Animal;

/*
Classe da característica genética Equus
 */
public interface Equus {
    
    public static double preco = 300;
    
    /*
    Método que retorna um animal com genoma Equus
    */
    public static Animal criaEquus (){
        return new Cavalo(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
