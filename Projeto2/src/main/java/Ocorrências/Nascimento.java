/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import Animais.Animal;
import com.mycompany.jumanji.Zoo;

/*
Classe da ocorrência de nascer um animal
*/
public class Nascimento extends Ocorrência {
    
    private Animal animal; //Animal que nasceu
    
    public Nascimento (Animal animal, Zoo zoo){ //Recebe o animal nascido e o seu zoo
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
        return super.toString()+" Nasceu um "+animal.getClass()+" chamado "+animal.getNome()+" que ficou com id "+animal.getId();
    }
}
