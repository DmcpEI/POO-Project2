/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceções;

/*
Classe da exceção quando instalações no ficheiro têm números iguais
 */
public class InsAlreadyExistsF extends Exception {
    
    public InsAlreadyExistsF(){
        super("Existem instalações no ficheiro que repetem o seu número");
    }
}
