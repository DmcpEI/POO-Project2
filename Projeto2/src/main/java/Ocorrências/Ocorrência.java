/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import com.mycompany.jumanji.Zoo;

/*
Classe das ocorrências
*/
public class Ocorrência {
    
    private Zoo zoo; //Zoo onde aconteceu a ocorrência
    
    public Ocorrência(Zoo zoo){ //Recebe o seu zoo
        
        this.zoo = zoo;
        
    }

    public Zoo getZoo() {
        return zoo;
    }
    
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
    
    @Override
    public String toString(){
        return "\n No zoo "+zoo.getNomeZoo()+" no ano "+zoo.getAnoZoo()+":";
    }
}

