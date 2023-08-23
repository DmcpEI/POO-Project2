/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import Animais.Animal;
import com.mycompany.jumanji.Zoo;

/*
Classe da ocorrência de morrer um animal
*/
public class Óbito extends Ocorrência {
    
    private Animal animal; //Animal que morreu
    
    public Óbito (Animal animal, Zoo zoo){ //Recebe o animal que morreu e o seu zoo
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
        return super.toString()+" Morreu um "+animal.getClass()+" chamado "+animal.getNome()+" que tinha o id "+animal.getId();
    }
}
