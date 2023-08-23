/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import Animais.Animal;
import com.mycompany.jumanji.Zoo;

/*
Classe da ocorrência de fugir um animal
*/
public class Fugiu extends Ocorrência {
    
    private Animal animal; //Animal que fugiu
    
    public Fugiu (Animal animal, Zoo zoo){ //Recebe o animal que fugiu e o seu zoo
        super(zoo);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString(){
        return super.toString()+" Fugiu um "+animal.getClass()+" chamado "+animal.getNome()+" de id "+animal.getId();
    }
}
