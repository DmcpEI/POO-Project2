/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceções;

/*
Classe da exceção quando o animal a ser inserido do ficheiro tem o mesmo id que um já no zoo
 */
public class AnimalIdAlreadyUsedF extends Exception{
    
    public AnimalIdAlreadyUsedF(){
        super("Houve repetição de ids no animais presentes nos documentos de texto");
    }
}
