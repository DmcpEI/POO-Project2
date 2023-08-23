/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import Animais.Animal;
import com.mycompany.jumanji.Instalação;
import com.mycompany.jumanji.Zoo;

/*
Classe da ocorrência de colocar um animal numa instalação
*/
public class Colocação extends Ocorrência{
    
    private Animal animal; //Animal instalado
    private Instalação instalacao; //Instalação onde foi instalado
    
    public Colocação (Animal animal, Instalação instalacao, Zoo zoo){ //Recebe o animal instalado, a tal instalação e o seu zoo
        super(zoo);
        this.animal = animal;
        this.instalacao = instalacao;
    }

    public Animal getAnimal() {
        return animal;
    }
    
    public Instalação getInstalacao() {
        return instalacao;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void setInstalacao(Instalação instalacao) {
        this.instalacao = instalacao;
    }
    
    @Override
    public String toString(){
        return super.toString()+" Foi colocado na instalação de número "+instalacao.getNumeroInstalacao()+" o "+animal.getClass()+" de id "+animal.getId();
    }
}
