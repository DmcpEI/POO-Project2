/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Genomas;

import Animais.Coelho;
import Animais.Animal;

/*
Classe da característica genética Oryctolagus
 */
public interface Oryctolagus {
    
    public static double preco = 150;
    
    /*
    Método que retorna um animal com genoma Oryctolagus
    */
    public static Animal criaOryctolagus (){
        return new Coelho(null,true);
    }
    
    public static double getPreco() {
        return preco;
    }
}
