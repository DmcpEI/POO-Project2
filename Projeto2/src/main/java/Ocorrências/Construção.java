/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ocorrências;

import com.mycompany.jumanji.Instalação;
import com.mycompany.jumanji.Zoo;

/*
Classe da ocorrência de construir uma instalação
*/
public class Construção extends Ocorrência {
    
    private Instalação instalacao; //Instalação construida
    
    public Construção (Instalação instalacao, Zoo zoo){ //Recebe a instalação construida e o seu zoo
        super(zoo);
        this.instalacao = instalacao;
    }

    public Instalação getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Instalação instalacao) {
        this.instalacao = instalacao;
    }
    
    @Override
    public String toString(){
        return super.toString()+" Foi construida uma instalação com lotação "+instalacao.getLotacao()+" que custou "+instalacao.getPrecoInstalacao()+" e ficou com o número "+instalacao.getNumeroInstalacao();
    }
}
