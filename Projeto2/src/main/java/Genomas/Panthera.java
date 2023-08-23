/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Genomas;

import Animais.Leão;
import Animais.Tigre;
import Animais.Animal;
import java.util.Random;

/*
Classe da característica genética Panthera
 */
public interface Panthera {
    
    public static double preco = 560;
    
    /*
    Método que retorna um animal com genoma Panthera
    */
    public static Animal criaPanthera (){
        
        Random rand = new Random();
        int a = rand.nextInt(2);
            
        if (a == 0){
            return new Leão(null, true);
        }
        else{
            return new Tigre(null, true);
        }
    }
    
    public static double getPreco() {
        return preco;
    }
    
}
