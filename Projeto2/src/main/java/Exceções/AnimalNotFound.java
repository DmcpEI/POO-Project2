/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceções;

/*
Classe quando utilizador instancia um animal que não existe
*/
public class AnimalNotFound extends Exception {
    
    public AnimalNotFound(){
        super("Não foi encontrado o animal ou não existe");
    }
}
