/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jumanji;

import Animais.Animal;
import Animais.Boi;
import Animais.Cabra;
import Animais.Cachorro;
import Animais.Cavalo;
import Animais.Cobra;
import Animais.Coelho;
import Animais.Crocodilo;
import Animais.Dragão;
import Animais.Galo;
import Animais.Gorila;
import Animais.Leão;
import Animais.Macaco;
import Animais.Panda;
import Animais.Porco;
import Animais.Rato;
import Animais.Tigre;
import Animais.UrsoPardo;
import Animais.UrsoPolar;
import Animais.Vaca;
import Exceções.AnimalIdAlreadyUsedF;
import Exceções.InsAlreadyExistsF;
import Exceções.InsNotFound;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/*
Classe principal
*/
public class Jumanji {

    public static void main(String[] args) throws IOException {
        
        System.out.println("\n---------------------Opções de Início---------------------");
        System.out.println("1. Carregar dados");
        System.out.println("2. Novo Zoo");
        
        int opcao;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Selecione uma opção: ");
        while(!scan.hasNextInt()){
            System.out.println("Para escolher uma opção tem de escrever um dos dois números inteiros apresentados no início de cada opção de início");
            System.out.print("Selecione uma opção: ");
            scan.next();
        }
        opcao = scan.nextInt(); //Utilizamos scanner para saber a opção que o utilizador escolheu 
        
        switch (opcao){
            case 1: //Se for para carregar zoo apartir dos ficheiros
                Zoo zoo = new Zoo(false);
                try{
                carregaZoo(zoo); //Carrega as informações do zoo apartir do ficheiro
                carregaAnimaisFI(zoo); //Carrega as informações dos animais fora das instalações apartir do ficheiro
                carregaInstalaçao(zoo); //Carrega as informações das instalações apartir do ficheiro
                carregarAnimaisI(zoo); //Carrega as informações dos animais dentro das instalações apartir do ficheiro
                zoo.menu(); //Inicializa o menu 
                }
                catch(IOException i){ //Se houver algum erro no carregamento
                    System.out.println("Erro no carregamento");
                }
                catch (AnimalIdAlreadyUsedF  | InsAlreadyExistsF | InsNotFound ex){
                    System.out.println(ex.getMessage());
                }
                break;

            case 2: //Se for para criar novo zoo
                zoo = new Zoo(true);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
    
    /*
    Método para carregar as informações do zoo
    */
    public static void carregaZoo (Zoo zoo) throws IOException {
        
        String nomeZoo; //Nome do zoo
        int anoZoo; //Ano do zoo
        
        String line;
        
        FileReader inStream = new FileReader("Zoo.txt");
        
        try (BufferedReader lerDados = new BufferedReader(inStream)) { //Usamos um buffer para ler linha a linha do ficheiro
            line = lerDados.readLine();
            while (line != null) {
                nomeZoo = lerDados.readLine();
                anoZoo = Integer.parseInt(lerDados.readLine().trim());  
                zoo.setNomeZoo(nomeZoo);
                zoo.setAnoZoo(anoZoo);
                line = lerDados.readLine();
            }
            lerDados.close();
        }
    }
    
    /*
    Método para carregar as informações dos animais fora da instalações no zoo e inserilos nesse ArrayList
    */
    public static void carregaAnimaisFI(Zoo zoo) throws IOException, AnimalIdAlreadyUsedF {
        
        Animal animal;
        
        int id; //Id do animal
        String nome; //Nome do animal
        int idade; //Idade do animal
       
        String line;
        
        FileReader inStream = new FileReader("AnimaisZoo.txt");
        
        try (BufferedReader lerDados = new BufferedReader(inStream)) { //Usamos um buffer para ler linha a linha do ficheiro
            line = lerDados.readLine();
            while (line != null) {
                switch (line) {
                    case "Leão:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Leão(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Boi:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Boi(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Cabra:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cabra(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Cachorro:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cachorro(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Cavalo:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cavalo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Coelho:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Coelho(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Cobra:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cobra(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Crocodilo:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Crocodilo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Dragão:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Dragão(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Galo:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Galo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Gorila:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Gorila(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Macaco:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Macaco(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Panda:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Panda(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Porco:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Porco(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Rato:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Rato(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Tigre:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Tigre(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "UrsoPardo:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new UrsoPardo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "UrsoPolar:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new UrsoPolar(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                    case "Vaca:":
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Vaca(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarFI(animal);
                        break;
                }
                line = lerDados.readLine();
            }
            lerDados.close();
        } 
    }
    
    /*
    Método para carregar as informações das instalações do zoo
    */
    public static void carregaInstalaçao(Zoo zoo)throws IOException,InsAlreadyExistsF{
        
        Instalação inst;
        
        int numeroInstalacao;
        int lotacao;
        
        String line;
        
        FileReader inStream = new FileReader("ZooInstalação.txt");
        
        try (BufferedReader lerDados = new BufferedReader(inStream)) { //Usamos um buffer para ler linha a linha do ficheiro
            line = lerDados.readLine();
            while (line != null) {
                numeroInstalacao = Integer.parseInt(lerDados.readLine().trim()); 
                
                for (Map.Entry instalacao : zoo.getZoo().entrySet()){

                    int key = (int)instalacao.getKey();
                    
                    if(numeroInstalacao == key){
                        throw new InsAlreadyExistsF();
                    }
                }
                
                
                
                lotacao = Integer.parseInt(lerDados.readLine().trim());
                inst = new Instalação(false);
                inst. setLotacao(lotacao);
                inst.setNumeroInstalacao(numeroInstalacao);
                if (Instalação.getInstalacoes()<numeroInstalacao){
                    Instalação.setInstalacoes(numeroInstalacao);
                }
                zoo.adicionarInstalacao(inst);
                
                line = lerDados.readLine();
            }
            lerDados.close();
        } 
    }
    
    /*
    Método para carregar as informações dos animais dentro da instalações do zoo e inserir-los na ArayList dessa instalação
    */
    public static void carregarAnimaisI(Zoo zoo) throws IOException,AnimalIdAlreadyUsedF,InsNotFound{
        
        int numeroI ;//Número da instalçao
        boolean existe;
        
        Animal animal;
        
        int id; //Id do animal
        String nome; //Nome do animal
        int idade; //Idade do animal
        
        String line;
        
        FileReader inStream = new FileReader("AnimaisZooI.txt");
        
        try (BufferedReader lerDados = new BufferedReader(inStream)) { //Usamos um buffer para ler linha a linha do ficheiro
            line = lerDados.readLine();
            while (line != null) {
                switch (line) {
                                        
                    case "Leão:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceção
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Leão(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Boi:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Boi(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Cabra:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cabra(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Cachorro:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cachorro(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Cavalo:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cavalo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Coelho:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Coelho(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Cobra:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Cobra(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Crocodilo:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Crocodilo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Dragão:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Dragão(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Galo:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Galo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Gorila:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Gorila(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Macaco:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Macaco(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Panda:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Panda(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Porco:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Porco(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Rato:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Rato(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Tigre:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Tigre(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "UrsoPardo:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new UrsoPardo(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "UrsoPolar:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new UrsoPolar(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                    case "Vaca:":
                        numeroI=Integer.parseInt(lerDados.readLine().trim());
                        
                        existe = false;
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            int key = (int)instalacao.getKey();
                            
                            if(numeroI == key){ //Se houver um número de instalação igual
                                existe = true;
                            }   
                        }
                        if(!existe){
                            throw new InsNotFound();
                        }
                        
                        id= Integer.parseInt(lerDados.readLine().trim());
                        
                        for(Animal a : zoo.getAnimaisFI()){ //Percorre a ArrayList dos animais fora das instalações do zoo
                            if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                            }
                        }
                        for (Map.Entry instalacao : zoo.getZoo().entrySet()){ //Percorre o HashMap das instalações do zoo

                            Instalação value = ((Instalação)instalacao.getValue());
                            
                            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                                if(a.getId() == id){ //Se houver um id igual ao do animal que estamos a ler
                                throw new AnimalIdAlreadyUsedF(); //Lança a exceçaõ
                                }
                            }
                        }
                        
                        nome = lerDados.readLine().trim();
                        idade = Integer.parseInt(lerDados.readLine().trim());                  
                        animal=new Vaca(null, false);
                        animal.setNome(nome);
                        animal.setId(id);
                        if (Animal.getAnimaisZoo()<id){ //Se o id do animal que estamos a ler é maior que o número de animais ja adicionados no zoo
                            Animal.setAnimaisZoo(id); //Igualamos o o número de animais ao id
                        }
                        animal.setIdade(idade);
                        zoo.adicionarAI(numeroI,animal);
                        break;
                }
                line = lerDados.readLine();
            }
            lerDados.close();
        }
    }
}
