/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceções;

/*
Classe da exceção quando utilizador instancia uma instalação que não existe
 */
public class InsNotFound extends Exception {
    
    public InsNotFound(){
        super("Não foi encontrada a instalação correspondente ao número ou essa não existe");
    }
}
