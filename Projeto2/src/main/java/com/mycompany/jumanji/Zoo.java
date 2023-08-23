/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jumanji;

import Ocorrências.Ocorrência;
import Ocorrências.Fugiu;
import Ocorrências.Construção;
import Ocorrências.Adquirido;
import Ocorrências.Colocação;
import Ocorrências.Nascimento;
import Ocorrências.Óbito;
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
import Genomas.Bovino;
import Genomas.Canis;
import Genomas.Capra;
import Genomas.Crocodyloidea;
import Genomas.Dragon;
import Genomas.Equus;
import Genomas.Gallus;
import Genomas.Ophidia;
import Genomas.Oryctolagus;
import Genomas.Panthera;
import Genomas.Primata;
import Genomas.Roedor;
import Genomas.Suíno;
import Genomas.Urso;
import Exceções.InsNotFound;
import Exceções.AnimalNotFound;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
Classe do zoo
*/
public class Zoo {
    
    private String nomeZoo; //Nome do zoo
    private int anoZoo; //Ano presente
    
    private HashMap<Integer, Instalação> zoo; //HashMap onde as "keys" são os numeros das instalações e os "values" saõ as instalações
    private ArrayList<Animal> animaisFI; //Array de animais onde são armazenados os animais recem-criados e/ou fora das instalações
    private ArrayList<Animal> obituario; //Array da animais onde são armazenados os animais mortos
    private ArrayList<Ocorrência> historico; //Array de ocorrências onde são armazenadas todas as ocorrências no zoo
    
    private double saldo; //Saldo geral do zoo
    
    public Zoo(boolean receba){ //Recebe um argumento "receba" booleano que diz é ou não para o zoo receber o nome e o ano do utilizador
        
        zoo = new HashMap<>();
        animaisFI = new ArrayList<>();
        obituario = new ArrayList<>();
        historico = new ArrayList<>();
        saldo = 0;
        
        if (receba){ //Se for para receber o nome e o ano do zoo pelo o utilizador
            recebeNome(); //Pede ao utilizador o nome do zoo
            recebeAno(); //Pede ao utilizador o ano do zoo
            menu(); //Abre o menu do zoo
        }
        
    }

    public String getNomeZoo() {
        return nomeZoo;
    }

    public int getAnoZoo() {
        return anoZoo;
    }

    public HashMap<Integer, Instalação> getZoo() {
        return zoo;
    }

    public ArrayList<Animal> getAnimaisFI() {
        return animaisFI;
    }

    public ArrayList<Animal> getObituario() {
        return obituario;
    }

    public ArrayList<Ocorrência> getHistorico() {
        return historico;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setNomeZoo(String nomeZoo) {
        this.nomeZoo = nomeZoo;
    }

    public void setAnoZoo(int anoZoo) {
        this.anoZoo = anoZoo;
    }

    public void setZoo(HashMap<Integer, Instalação> zoo) {
        this.zoo = zoo;
    }

    public void setAnimaisFI(ArrayList<Animal> animaisFI) {
        this.animaisFI = animaisFI;
    }

    public void setObituario(ArrayList<Animal> obituario) {
        this.obituario = obituario;
    }

    public void setHistorico(ArrayList<Ocorrência> historico) {
        this.historico = historico;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /*
    Método que pede o nome do zoo ao utilizador
    */
    private void recebeNome (){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Nome do seu Zoo:");
        
        while(!scan.hasNext()){ //Verificar que o que o utilizador escreveu é uma string
            System.out.println("O nome do zoo tem de ser uma String!");
            System.out.print("Nome do seu Zoo:");
            scan.next();
        }
        nomeZoo = scan.next();
        
        while (!nomeZoo.matches("[a-zA-Z]+")){ //Verificar se essa string é uma string de letras
            System.out.println("O nome do zoo tem de ser uma String de só letras!");
            System.out.print("Nome do seu Zoo:");
            nomeZoo = scan.next();
        }
  
    }
    
    /*
    Método que pede o ano do zoo ao utilizador
    */
    private void recebeAno (){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Qual o ano de fundação:");

        while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
            System.out.println("O ano de fundalção tem de ser um número inteiro");
            System.out.print("Qual o ano de fundação:");
            scan.next();
        }
        anoZoo = scan.nextInt();

    }
    
    /*
    Método que adiciona um animal ao array dos animais criados/fora das instalações
    */
    public void adicionarFI (Animal animal){
        animaisFI.add(animal);
    }
    
    /*
    Método que remove um animal do array dos animais criados/fora das instalações
    */
    public void removerFI (int animal){
        animaisFI.remove(animal);
    }
    
    /*
    Método que adiciona uma animal ao array dos animais mortos
    */
    public void adicionarObitos (Animal animal){
        obituario.add(animal);
    }
    
    /*
    Método que adiciona uma instalação ao zoo/HashMap
    */
    public void adicionarInstalacao (Instalação instalacao){
        zoo.put(instalacao.getNumeroInstalacao(), instalacao);
    }
    
    /*
    Método que adiciona um animal a uma instalação utilizando o seu número
    */
    public void adicionarAI (int numeroInstalacao, Animal animal){
        zoo.get(numeroInstalacao).adicionaAnimal(this, animal);
    }
   
    /*
    Método que adiciona uma ocorrência ao histórico
    */
    public void adicionarOcorrencia (Ocorrência ocorrencia){
        historico.add(ocorrencia);
    }
    
    /*
    Método que adiciona ao saldo um número
    */
    public void adicionarSaldo (double saldo){
        this.saldo+=saldo;
    }
    
    /*
    Método que adiciona um ano ao zoo
    */
    public void aumentarAno(){
        anoZoo++;
    }
    
    /* 
    Método do menu do zoo
    */
    public void menu(){
        
        System.out.println("\n---------------------Menu Zoo "+nomeZoo+"---------------------");
        System.out.println("1. Adquirir animal aleatório");
        System.out.println("2. Adquirir animal com característica genética");
        System.out.println("3. Construir instalação");
        System.out.println("4. Colocar animal em instalação");
        System.out.println("5. Calendário chinês");
        System.out.println("6. Listar animais");
        System.out.println("7. Listar animais com dada característica genética");
        System.out.println("8. Listar animais com dada mutação");
        System.out.println("9. Listar instalações");
        System.out.println("10. Retrato de família animal");
        System.out.println("11. Obituário");
        System.out.println("12. Histórico");
        System.out.println("13. Período Contabilístico");
        System.out.println("14. Jumanji");
        System.out.println("15. Sair da aplicação");
    
        int opcao;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Selecione uma opção: ");
        while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
            System.out.println("Para escolher uma opção tem de escrever um dos números inteiros apresentados no inicio de cada opção");
            System.out.print("Selecione uma opção: ");
            scan.next();
        }
        opcao = scan.nextInt(); //Utilizamos scanner para saber a opção que o utilizador escolheu 
        
        switch (opcao) {
            case 1: 
                
                //Criamos 3 animais "parciais" randomizados, mas só um será escolhido pelo utilizador
                Animal animal1 = animalRandomizado();
                Animal animal2 = animalRandomizado();
                Animal animal3 = animalRandomizado();
                
                System.out.println("Escolha um animal a adiquirir!");
                System.out.println("1. "+animal1);
                System.out.println("2. "+animal2);
                System.out.println("3. "+animal3);
                
                System.out.print("Selecione uma opção: ");
                while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
                    System.out.println("Para escolher uma opção tem de escrever um três dos número inteiros apresentados no inicio de cada animal");
                    System.out.print("Selecione uma opção: ");
                    scan.next();
                }
                opcao = scan.nextInt(); //Utilizamos scanner para saber a opção que o utilizador escolheu 
                
                switch (opcao) {
                    case 1 :
                        constroiAnimalID(animal1, "adquirido"); //Construimos o animal que ainda não tem id nem esta adicionado ao zoo
                        comprarAnimal(animal1); //Tiramos ao saldo o custo desse animal
                        System.out.println("Foi criado um novo "+animal1.getClass()+" chamado "+animal1.getNome());
                        voltarMenu();
                        break;
                    case 2 :
                        constroiAnimalID(animal2, "adquirido"); //Construimos o animal que ainda não tem id nem esta adicionado ao zoo
                        comprarAnimal(animal2); //Tiramos ao saldo o custo desse animal
                        System.out.println("Foi criado um novo "+animal2.getClass()+" chamado "+animal2.getNome());
                        voltarMenu();
                        break;
                    case 3 :
                        constroiAnimalID(animal3, "adquirido"); //Construimos o animal que ainda não tem id
                        comprarAnimal(animal3); //Tiramos ao saldo o custo desse animal
                        System.out.println("Foi criado um novo "+animal3.getClass()+" chamado "+animal3.getNome()+"");
                        voltarMenu();
                        break;
                    default: //Se escolher uma opção inválida
                    System.out.println("Opção inválida.");
                    voltarMenu();
                }
                break;
            case 2 : 
                String genoma;
                System.out.print("Escreva o genoma que vai querer que o animal tenha: ");
                genoma = scan.next(); //Utilizamos scanner para saber o genoma que o utilizador escolheu 
                    
                Animal animalC = animalGenoma(genoma); //Cria animal randomizado, mas com genoma que o utilizador deu
                
                if(animalC == null){ //Se o animal for nulo (quer dizer que no o método "animalGenoma" não está presente o genoma dado pelo utilizador)
                    System.out.println("O genoma referido não existe!");
                }
                else{
                
                    constroiAnimal(animalC, "adquirido"); //Construimos o animal sendo que este ja tem id
                    comprarGenoma(genoma); //Tiramos ao saldo o custo de um animal desse genoma

                    System.out.println("Foi criado um novo "+animalC.getClass()+" chamado "+animalC.getNome()+"");
                }
                voltarMenu();
                break;
            case 3 :
                
                //Criamos 3 instalções "parciais" randomizadas, mas só uma ou nenhuma será escolhido pelo utilizador
                Instalação inst1 = new Instalação(false);
                Instalação inst2 = new Instalação(false);
                Instalação inst3 = new Instalação(false);
                
                System.out.println("Escolha um animal a adiquirir!");
                System.out.println("1. Primeiro Candidato: "+inst1);
                System.out.println("2. Segundo Candidato: "+inst2);
                System.out.println("3. Terceiro Candidato: "+inst3);
                System.out.println("0. Não escolher nenhuma");
                
                System.out.print("Selecione uma opção: ");
                while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
                    System.out.println("Para escolher uma opção tem de escrever um dos quatro números inteiros apresentados no inicio de cada instalação");
                    System.out.print("Selecione uma opção: ");
                    scan.next();
                }
                opcao = scan.nextInt(); //Utilizamos scanner para saber a opção que o utilizador escolheu 
                
                switch (opcao) {
                    case 0 : //Se escolher não construir nenhuma
                        System.out.println("Não foi construida nenhuma nova instalação");
                        voltarMenu();
                        break;
                    case 1 :
                        constroiInstalacao(inst1); //Construimos a instalação que ainda não tem id nem está no zoo
                        System.out.println("Foi escolhida e construida a instalação proposta pelo primeiro candidato");
                        voltarMenu();
                        break;
                    case 2 :
                        constroiInstalacao(inst2); //Construimos a instalação que ainda não tem id nem está no zoo
                        System.out.println("Foi escolhida e construida a instalação proposta pelo segundo candidato");
                        voltarMenu();
                        break;
                    case 3 :
                        constroiInstalacao(inst3); //Construimos a instalação que ainda não tem id nem está no zoo
                        System.out.println("Foi escolhida e construida a instalação proposta pelo terceiro candidato");
                        voltarMenu();
                        break;
                    default: //Se escolher uma opção inválida
                        System.out.println("Opção inválida.");
                        voltarMenu();
                }
                break;
            case 4 : 
                instalarAnimal(); //Colocamos um animal dos que temos no array dos criados numa instalação
                voltarMenu();
                break;
            case 5 : 
                anoChines(); //Verificamos o ano e aumentamos a atratividade base do animal desse ano no calendário chinês
                voltarMenu();
                break;
            case 6 : 
                listarAnimais(); //Listamos todos os animais fora e dentro das instalações
                voltarMenu();
                break;
            case 7 : 
                listarAnimaisG(); //Listamos todos os animais de um certo genoma fornecido pelo utilizador fora e dentro das instalações
                voltarMenu();
                break;
            case 8 : 
                listarAnimaisM(); //Listamos todos os animais com uma certa mutação fornecida pelo utilizador fora e dentro das instalações
                voltarMenu();
                break;
            case 9 : 
                listarInstalacoes(); //Listamos todas as instalações do zoo
                voltarMenu();
                break;
            case 10 : 
                retratoF(); //Imprimimos todo o zoo
                voltarMenu();
                break;
            case 11 : 
                System.out.println("Obituário :\n"+obituario); //Imprimimos o obituário
                voltarMenu();
                break;
            case 12 : 
                System.out.println("Histórico :\n"+historico); //Imprimimos o histórico
                voltarMenu();
                break;
            case 13 : 
                System.out.println("Período contabilistico do ano "+anoZoo);
                periodoContabilistico();
                voltarMenu();
                break;
            case 14 : 
                System.out.println("Devido a uma confusão no zoo foram perdidos de vista os animais!");
                jumanji();
                voltarMenu();
                break;
            case 15 : 
                System.out.println("Saiu da aplicação!");
                break;
            default : 
                System.out.println("Opção inválida!");
                voltarMenu();
                break;
        }
    }
    
    /*
    Método usado para voltar ao menu principal do zoo
    */
    public void voltarMenu(){
        
        System.out.println("Clique [0] para voltar ao menu");
        Scanner scan = new Scanner(System.in);
        int option;
        
        while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
            System.out.println("Para voltar tem de clicar no NÚMERO [0] do seu teclado");
            scan.next();
        }
        option = scan.nextInt();
        
        if(option == 0){ //Se utilizador escreu 0
            menu();
        }
        else{ //Se não executa o método denovo
            voltarMenu();
        }
        
    }
    
    /*
    Método usado para contruir um animal (neste caso completar um animal incompleto)
    Este método recebe um animal que ainda não tem nome nem esta no zoo (logo não tem id)
    */
    public void constroiAnimalID (Animal animal, String ocorrencia){
        
        Scanner scan = new Scanner(System.in);
        String nomeA;
        System.out.print("Digite o nome do animal: ");
        
        while(!scan.hasNext()){ //Verifica se o que o utilizador escreveu é uma string
            System.out.println("O nome do animal tem de ser uma String!");
            System.out.print("Digite o nome do animal: ");
            scan.next();
        }
        nomeA = scan.next(); //Utilizamos scanner para saber o nome artístico que o utilizador escolheu para o animal
        
        while (!nomeA.matches("[a-zA-Z]+")){ //Verifica se o que o utilizador escreveu é uma string de letras
            System.out.println("O nome do animal tem de ser uma String de só letras!");
            System.out.print("Digite o nome do animal: ");
            nomeA = scan.next();
        }
        
        Animal.incrementaAnimais(); //Aumenta o número de animais já criados no zoo
        animal.setId(Animal.getAnimaisZoo()); //Dá um id ao animal escolhido, dependendo do numero de animais já criados no zoo
        animal.setNome(nomeA); //Dá o nome artístico que o utilizador escolheu ao animal escolhido
        adicionarFI(animal); //Adiciona esse animal ao array dos animais fora das instalações
        criaOcorrencia(ocorrencia, animal,null); //Cria a ocorrência relacionada a este animal (se foi adquirido ou nasceu)
        
    }
    
    /*
    Método usado para contruir um animal (neste caso completar um animal incompleto)
    Este método recebe um animal que ainda não tem nome mas está no zoo (logo já tem id)
    */
    public void constroiAnimal (Animal animal,  String ocorrencia){
        
        Scanner scan = new Scanner(System.in);
        
        String nomeA;
        System.out.print("Digite o nome do animal: ");
        
        while(!scan.hasNext()){ //Verifica se o que o utilizador escreveu é uma string
            System.out.println("O nome do animal tem de ser uma String!");
            System.out.print("Digite o nome do animal: ");
            scan.next();
        }
        nomeA = scan.next(); //Utilizamos scanner para saber o nome artístico que o utilizador escolheu para o animal
        
        while (!nomeA.matches("[a-zA-Z]+")){ //Verifica se o que o utilizador escreveu é uma string de letras
            System.out.println("O nome do animal tem de ser uma String de só letras!");
            System.out.print("Digite o nome do animal: ");
            nomeA = scan.next();
        }
            
        animal.setNome(nomeA); //Dá o nome artístico que o utilizador escolheu ao animal escolhido
        adicionarFI(animal); //Adiciona esse animal ao array dos animais fora das instalações
        criaOcorrencia(ocorrencia, animal,null); //Cria a ocorrência relacionada a este animal (se foi adquirido ou nasceu)
        
    }
    
    /*
    Método usado para construir uma instalação (neste caso completar uma instalação incompleta)
    Este método recebe uma instalação que ainda não está no zoo (logo não tem número)
    */
    public void constroiInstalacao (Instalação instalacao){
        
        Instalação.incrementaInstalacoes(); //Aumenta o número de instalações já criadas no zoo
        instalacao.setNumeroInstalacao(Instalação.getInstalacoes()); //Dá um número á instalação, dependendo do número de instalações já criadas no zoo
        adicionarInstalacao(instalacao); //Adiciona a instalação ao HashMap do zoo
        adicionarSaldo(-(instalacao.getPrecoInstalacao())); //Retira ao saldo do zoo o preço de construção da instalação
        criaOcorrencia("construcao",null,instalacao); //Cria a ocorrência relacionada á instalação (que neste caso é a sua construção)
    }
    
    /*
    Método usado para instalar um animal numa instalação
    */
    public void instalarAnimal(){
        
        if(animaisFI.isEmpty()){ //Se não existir animais fora das instalações
            System.out.println("Não existem animais para ser instalados");
        }
        else if (zoo.isEmpty()){ //Se não houver instalações no zoo
            System.out.println("Não existem instalações para o animal ser instalado");
        }
        else{
            
            Scanner scan = new Scanner(System.in);

            for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo
                
                int key = (int)instalacao.getKey();
                Instalação value = ((Instalação)instalacao.getValue());
                
                System.out.println(key+" : "+value); //Imprime todas as instalações do zoo
                
            }
            
            int numero;
            System.out.print("Escreva o numero da instalação a adicionar o animal:");
                
            while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
                System.out.println("O número da instalação tem de ser inteiro!");
                System.out.print("Escreva o numero da instalação a adicionar o animal:");
                scan.next();
            }
            numero = scan.nextInt();
            
            try{
                
                boolean existe = false;
                for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo

                    int key = (int)instalacao.getKey();

                    if(numero == key){ //Se houver um número de instalação igual
                        existe = true;
                    }   
                }
                if(!existe){
                    throw new InsNotFound();
                }

                for(int i = 0; i<animaisFI.size(); i++){ //Percorre os animais fora das instalações
                    System.out.println(i+") "+animaisFI.get(i)); //Imprime os animais fora das instalações
                }

                int animal;
                System.out.print("Escoha o animal que quer adicionar:");

                while(!scan.hasNextInt()){ //Verifica se o que o utilizador escreveu é um número inteiro
                    System.out.println("Para escolher uma opção tem de escrever um dos número inteiros apresentados no inicio de cada animal");
                    System.out.print("Escoha o animal que quer adicionar:");
                    scan.next();
                }
                animal = scan.nextInt();

                if(animal<0 || animal>=animaisFI.size()){ //Verifica se o inteiro que o utilizador escreveu não corresponde a um animal na ArrayList dos animais fora das instalações
                    throw new AnimalNotFound();
                }

                adicionarAI(numero, animaisFI.get(animal)); //Adiciona o animal à ArrayList da instalação

                System.out.println(animaisFI.get(animal).getNome()+" o "+animaisFI.get(animal).getClass()+" foi adicionado à instalção de número "+numero);

                criaOcorrencia("colocacao",animaisFI.get(animal),zoo.get(numero)); //Cria a ocorrência relacionada a este animal e a essa instalação (que neste caso é a colocação do animal na instalação)

                removerFI(animal); //Remove o animal da ArrayList dos animal fora das instalações
            }
            catch (InsNotFound | AnimalNotFound ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /*
    Método usado para retirar ao saldo do zoo o valor para adquirir determinado animal
    Recebe um animal, verifica qual é e retira o devido valor ao saldo do zoo (que é a sua atratividade base a dividir por 2)
    */
    public void comprarAnimal(Animal animal){
        
        if(animal.getClass() == Boi.class){
            adicionarSaldo(-Boi.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Cabra.class){
            adicionarSaldo(-Cabra.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Cachorro.class){
            adicionarSaldo(-Cachorro.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Cavalo.class){
            adicionarSaldo(-Cavalo.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Cobra.class){
            adicionarSaldo(-Cobra.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Coelho.class){
            adicionarSaldo(-Coelho.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Crocodilo.class){
            adicionarSaldo(-Crocodilo.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == Dragão.class){
            adicionarSaldo(-Dragão.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Galo.class){
            adicionarSaldo(-Galo.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Gorila.class){
            adicionarSaldo(-Gorila.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == Leão.class){
            adicionarSaldo(-Leão.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == Macaco.class){
            adicionarSaldo(-Macaco.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Panda.class){
            adicionarSaldo(-Panda.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == Porco.class){
            adicionarSaldo(-Porco.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Rato.class){
            adicionarSaldo(-Rato.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == Tigre.class){
            adicionarSaldo(-Tigre.getAtratividadeBase()/2);
        }
        else if (animal.getClass() == UrsoPardo.class){
            adicionarSaldo(-UrsoPardo.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == UrsoPolar.class){
            adicionarSaldo(-UrsoPolar.getATRATIVIDADEBASE()/2);
        }
        else if (animal.getClass() == Vaca.class){
            adicionarSaldo(-Vaca.getATRATIVIDADEBASE()/2);
        }
    }
    
    /*
    Método usado para retirar ao saldo do zoo o valor para adquirir um animal de um certo genoma
    Recebe uma string que será o genoma do animal
    */
    public void comprarGenoma(String genoma){
        
        genoma = genoma.toLowerCase();
        
        switch (genoma) {
            case "bovino" -> adicionarSaldo(-Bovino.getPreco());
            case "canis" -> adicionarSaldo(-Canis.getPreco());
            case "capra" -> adicionarSaldo(-Capra.getPreco());
            case "crocodyloidea" -> adicionarSaldo(-Crocodyloidea.getPreco());
            case "dragon" -> adicionarSaldo(-Dragon.getPreco());
            case "equus" -> adicionarSaldo(-Equus.getPreco());
            case "gallus" -> adicionarSaldo(-Gallus.getPreco());
            case "ophidia" -> adicionarSaldo(-Ophidia.getPreco());
            case "oryctolagus" -> adicionarSaldo(-Oryctolagus.getPreco());
            case "panthera" -> adicionarSaldo(-Panthera.getPreco());
            case "primata" -> adicionarSaldo(-Primata.getPreco());
            case "roedor" -> adicionarSaldo(-Roedor.getPreco());
            case "suíno" -> adicionarSaldo(-Suíno.getPreco());
            case "urso" -> adicionarSaldo(-Urso.getPreco());
        }
    }
    
    /*
    Método usado para criar um animal qualquer sem nome e que ainda não está no zoo
    */
    public Animal animalRandomizado(){
        
        Random rand = new Random();
        int a = rand.nextInt(19); //Utiliza um random que vai de 0 a 18

        return switch (a) {
            case 0 -> new Boi(null, false);
            case 1 -> new Cabra(null, false);
            case 2 -> new Cachorro(null, false);
            case 3 -> new Cavalo(null, false);
            case 4 -> new Cobra(null, false);
            case 5 -> new Coelho(null, false);
            case 6 -> new Crocodilo(null, false);
            case 7 -> new Dragão(null, false);
            case 8 -> new Galo(null, false);
            case 9 -> new Gorila(null, false);
            case 10 -> new Leão(null, false);
            case 11 -> new Macaco(null, false);
            case 12 -> new Panda(null, false);
            case 13 -> new Porco(null, false);
            case 14 -> new Rato(null, false);
            case 15 -> new Tigre(null, false);
            case 16 -> new UrsoPardo(null, false);
            case 17 -> new UrsoPolar(null, false);
            default -> new Vaca(null, false);
        };
    }
    
    /*
    Método usado para criar um animal qualquer de um certo genoma
    Recebe uma string que será o genoma do animal e dependendo dessa chama o método estático ("cria...") da classe do genoma
    */
    public Animal animalGenoma (String genoma){
        
        genoma = genoma.toLowerCase();
        
        return switch (genoma) {
            case "bovino" -> Bovino.criaBovino();
            case "canis" -> Canis.criaCanis();
            case "capra" -> Capra.criaCapra();
            case "crocodyloidea" -> Crocodyloidea.criaCrocodyloidea();
            case "dragon" -> Dragon.criaDragon();
            case "equus" -> Equus.criaEquus();
            case "gallus" -> Gallus.criaGallus();
            case "ophidia" -> Ophidia.criaOphidia();
            case "oryctolagus" -> Oryctolagus.criaOryctolagus();
            case "panthera" -> Panthera.criaPanthera();
            case "primata" -> Primata.criaPrimata();
            case "roedor" -> Roedor.criaRoedor();
            case "suíno" -> Suíno.criaSuíno();
            default -> Urso.criaUrso();
        };
    }
    
    /*
    Método usado para duplicar a atratividade base de um animal no calêndário chinês dependendo do ano presente
    */
    public void anoChines(){
        int ano = anoZoo%12; //Usando o resto da divisão por 12 conseguimos saber qual animal é suposto duplicar
        switch (ano) {
            case 6 -> {
                Tigre.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Tigres duplicou");
            }
            case 7 -> {
                Coelho.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Coelhos duplicou");
            }
            case 8 -> {
                Dragão.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Dragões duplicou");
            }
            case 9 -> {
                Cobra.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base das Cobras duplicou");
            }
            case 10 -> {
                Cavalo.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Cavalos duplicou");
            }
            case 11 -> {
                Cabra.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base das Cabras duplicou");
            }
            case 0 -> {
                Macaco.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Macacos duplicou");
            }
            case 1 -> {
                Galo.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Galos duplicou");
            }
            case 2 -> {
                Cachorro.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Cachoros duplicou");
            }
            case 3 -> {
                Porco.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Porcos duplicou");
            }
            case 4 -> {
                Rato.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Ratos duplicou");
            }
            case 5 -> {
                Boi.incrementaAtratividadeBase();
                System.out.println("Como estamos no ano "+anoZoo+" a atratividade base dos Bois duplicou");
            } 
        }
    }
    
    /*
    Método que serve para listar todos os animais do zoo (dentro e fora das instalações)
    */
    public void listarAnimais(){
        
        if(animaisFI.isEmpty() && zoo.isEmpty()){ //Se não tem animais dentro nem fora das instalações
            System.out.println("Não existem animais no zoo");
        }
        else{
        
            System.out.println("Fora das instalações:");
            
            if(animaisFI.isEmpty()){ //Se não tem animais fora das instalações
                System.out.println("Não existem animais não instalados");
            }
            else{
                for (Animal a : animaisFI){ //Percorre a ArrayList dos animais fora das instalações
                    System.out.println(a);
                }
            }

            for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo

                int key = (int)instalacao.getKey();
                Instalação value = ((Instalação)instalacao.getValue());

                System.out.println("Dentro da instalação número "+key+":");
                
                if(value.getAnimais().isEmpty()){ //Se não tem animais dentro da instalação
                    System.out.println("Não existem animais dentro desta instalação");
                }
                else{
                    for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais dentro da instalação
                        System.out.println(a);
                    }
                }
            }
        }
    }
    
    /*
    Método que serve para listar todos os animais do zoo (dentro e fora das instalações) de um certo genoma
    */
    public void listarAnimaisG(){
        
        if(animaisFI.isEmpty() && zoo.isEmpty()){ //Se não tem animais dentro nem fora das instalações
            System.out.println("Não existem animais no zoo");
        }
        else{
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Quer listar os animais com qual genoma? Genoma: ");
            String genoma;

            while(!scan.hasNext()){ //Verifica se o que o utilizador escreveu é uma string
                System.out.println("O nome do genoma tem de ser uma String!");
                System.out.print("Genoma: ");
                scan.next();
            }
            genoma = scan.next();
            
            while (!genoma.matches("[a-zA-Z]+")){ //Verifica se o que o utilizador escreveu é uma string de letras
                System.out.println("O nome do genoma tem de ser uma String de só letras!");
                System.out.print("Genoma: ");
                genoma = scan.next();
            }
            
            genoma = genoma.toLowerCase();

            System.out.println("Fora das instalações:");
            
            if(animaisFI.isEmpty()){ //Se não tem animais fora das instalações
                System.out.println("Não existem animais fora das instalações");
            }
            else{
                
                boolean existe= false; //Booleano que serve para sber se existe pelo menos um animal do genoma fora das instalações

                for (Animal a : animaisFI){ //Percorre a ArrayList dos animais fora das instalações

                    switch (genoma) { //Verifica que genoma o utilizador escreveu
                        case "bovino" : 
                            if(a.getClass() == Vaca.class || a.getClass() == Boi.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "canis" : 
                            if(a.getClass() == Cachorro.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "capra" : 
                            if(a.getClass() == Cabra.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "crocodyloidea" : 
                            if(a.getClass() == Crocodilo.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "dragon" : 
                            if(a.getClass() == Dragão.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "equus" : 
                            if(a.getClass() == Cavalo.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "gallus" : 
                            if(a.getClass() == Galo.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "ophidia" : 
                            if(a.getClass() == Cobra.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "oryctolagus" : 
                            if(a.getClass() == Coelho.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "panthera" : 
                            if(a.getClass() == Leão.class || a.getClass() == Tigre.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "primata" : 
                            if(a.getClass() == Macaco.class || a.getClass() == Gorila.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "roedor" : 
                            if(a.getClass() == Rato.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "suíno" : 
                            if(a.getClass() == Porco.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                        case "urso" :
                            if(a.getClass() == Panda.class || a.getClass() == UrsoPardo.class || a.getClass() == UrsoPolar.class){ //Verifica se o animal é algum do genoma
                                System.out.println(a);
                                existe = true;
                            }
                            break;
                    } 
                }
                
                if(!existe){ //Se for false quer dizer que não existe um animal fora das instalações do genoma
                    System.out.println("Não existe nenhum animal com esse genoma fora das instalações");
                }
            }

            for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo

                int key = (int)instalacao.getKey();
                Instalação value = ((Instalação)instalacao.getValue());

                System.out.println("Dentro da instalação número "+key+":");
                
                if(value.getAnimais().isEmpty()){ //Se não tiver animais na ArrayList da instalação
                    System.out.println("Não existem animais dentro desta instalação");
                }
                else{
                    
                    boolean existe= false; //Booleano que serve para saber se existe pelo menos um animal do genoma dentro da instalação

                    for (Animal a : value.getAnimais()){ //Percorre a ArrayList da instalação

                        switch (genoma) {
                            case "bovino" : 
                                if(a.getClass() == Vaca.class || a.getClass() == Boi.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "canis" : 
                                if(a.getClass() == Cachorro.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "capra" : 
                                if(a.getClass() == Cabra.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "crocodyloidea" : 
                                if(a.getClass() == Crocodilo.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "dragon" : 
                                if(a.getClass() == Dragão.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "equus" : 
                                if(a.getClass() == Cavalo.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "gallus" : 
                                if(a.getClass() == Galo.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "ophidia" : 
                                if(a.getClass() == Cobra.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "oryctolagus" : 
                                if(a.getClass() == Coelho.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "panthera" : 
                                if(a.getClass() == Leão.class || a.getClass() == Tigre.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "primata" : 
                                if(a.getClass() == Macaco.class || a.getClass() == Gorila.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "roedor" : 
                                if(a.getClass() == Rato.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "suíno" : 
                                if(a.getClass() == Porco.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                            case "urso" :
                                if(a.getClass() == Panda.class || a.getClass() == UrsoPardo.class || a.getClass() == UrsoPolar.class){ //Verifica se o animal é algum do genoma
                                    System.out.println(a);
                                    existe = true;
                                }
                                break;
                        } 
                    }
                    
                    if(!existe){ //Se for false quer dizer que não existe um animal na instalação do genoma
                        System.out.println("Não existe nenhuma animal com esse genoma dentro desta instalação");
                    }
                }
            }
        }
    }
    
    /*
    Método que serve para listar todos os animais do zoo (dentro e fora das instalações) com uma certa mutação
    */
    public void listarAnimaisM(){
        
        if(animaisFI.isEmpty() && zoo.isEmpty()){ //Se não tem animais dentro nem fora das instalações
            System.out.println("Não existem animais no zoo");
        }
        else{
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Quer listar os animais com qual mutação? Mutação: ");
            String mutacao;
        
            while(!scan.hasNext()){ //Verifica se o que o utilizador escreveu é uma string
                System.out.println("O nome da mutação tem de ser uma String!");
                System.out.print("Mutação: ");
                scan.next();
            }
            mutacao = scan.next();
            
            while (!mutacao.matches("[a-zA-Z]+")){ //Verifica se o que o utilizador escreveu é uma string de letras
                System.out.println("O nome da mutação tem de ser uma String de só letras!");
                System.out.print("Mutação: ");
                mutacao = scan.next();
            }
            
            mutacao = mutacao.toLowerCase();
            
            //Se não existir a mutação dada pelo utiliador
            if (!mutacao.equals("heterocromia") && !mutacao.equals("albinismo") && !mutacao.equals("dragonismo")){
                System.out.println("Não existe essa mutação");
            }
            else{

                System.out.println("Fora das instalações:");
                
                if(animaisFI.isEmpty()){ //Se não tem animais fora das instalações
                    System.out.println("Não existem animais não instalados");
                }
                else{
                    
                    boolean existe = false; //Booleano usado para saber se existe pelo menos um animal fora das instalações com a mutação dada

                    for (Animal a : animaisFI){ //Percorre ArrayList dos animais fora das instalações

                        if(mutacao.equals("heterocromia") && a.isHETEROCROMIA()){ //Se a mutação é heterocromia e o animal a tem
                            System.out.println(a);
                            existe = true;
                        }
                        else if (mutacao.equals("albinismo") && a.isALBINISMO()){ //Se a mutação é albinismo e o animal a tem
                            System.out.println(a);
                            existe = true;
                        }
                        else if (mutacao.equals("dragonismo") && a.getClass()==Dragão.class){ //Se a mutação é dragonismo e o animal é um dragão
                            Dragão b = (Dragão) a;
                            if (b.isDRAGONISMO()){ //Se o dragão tem dragonismo
                                System.out.println(b);
                                existe = true;
                            }
                        }  
                    }
                    
                    if(!existe){ //Se for false quer dizer que não existe um animal fora das instalações com a mutação
                        System.out.println("Não existem animais com essa mutação fora das instalações");
                    }
                }

                for (Map.Entry instalacao : zoo.entrySet()){ //Percorre HashMap de instalações

                    int key = (int)instalacao.getKey();
                    Instalação value = ((Instalação)instalacao.getValue());

                    System.out.println("Dentro da instalação número "+key+":");

                    if(value.getAnimais().isEmpty()){ //Se não tiver animais na ArrayList da instalação
                        System.out.println("Não existem animais dentro desta instalação");
                    }
                    else{

                        boolean existe = false; //Booleano usado para saber se existe pelo menos um animal com a mutação na instalação

                        for (Animal a : value.getAnimais()){ //Percorre a ArrayList da instalação

                            if(mutacao.equals("heterocromia") && a.isHETEROCROMIA()){ //Se a mutação é heterocromia e o animal a tem
                            System.out.println(a);
                            existe = true;
                            }
                            else if (mutacao.equals("albinismo") && a.isALBINISMO()){ //Se a mutação é albinismo e o animal a tem
                                System.out.println(a);
                                existe = true;
                            }
                            else if (mutacao.equals("dragonismo") && a.getClass()==Dragão.class){ //Se a mutação é dragonismo e o animal é um dragão
                                Dragão b = (Dragão) a;
                                if (b.isDRAGONISMO()){ //Se o dragão tem dragonismo
                                    System.out.println(b);
                                    existe = true;
                                }
                            }  
                        }

                        if(!existe){ //Se for false quer dizer que não existe um animal na instalação com a mutação
                            System.out.println("Não existe nenhuma animal com essa mutação nesta instalação");
                        }
                    }
                }
            }
        }
    }
    
    /*
    Método usado para listar as instalações do zoo
    */
    public void listarInstalacoes(){

        if(zoo.isEmpty()){ //Se não existe instalações no zoo
            System.out.println("Não existem istalações no zoo");
        }
        else{
        
            for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações no zoo

                int key = (int)instalacao.getKey();
                Instalação value = ((Instalação)instalacao.getValue());

                System.out.println(key + " : " + value); //Imprime as instalações
            }
        }
    }
    
    /*
    Método usado para simplificar a criação das ocorrências do zoo
    Recebe uma string que corresponde a uma ocorrência, e se tiverem relacionados com esta, um animal e uma instalação
    */
    public void criaOcorrencia (String ocorrencia, Animal animal, Instalação instalacao){
        
        ocorrencia = ocorrencia.toLowerCase();
        
        switch (ocorrencia) {
            case "nascimento" -> adicionarOcorrencia(new Nascimento(animal,this));
            case "obito" -> adicionarOcorrencia(new Óbito(animal,this));
            case "adquirido" -> adicionarOcorrencia(new Adquirido(animal,this));
            case "construcao" -> adicionarOcorrencia(new Construção(instalacao,this));
            case "colocacao" -> adicionarOcorrencia(new Colocação(animal,instalacao,this));
            case "fugiu" -> adicionarOcorrencia(new Fugiu(animal,this));
            default -> System.out.println("Ocorreu um erro a criar a ocorrência");
        }
    }
    
    /*
    Método usado para verificar e criar um novo animal (recém-nascido) no zoo
    Só nasce um animal se já existir um do seu tipo instalado numa instalação no zoo
    */
    public void nascerAnimal(){
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações 

            int key = (int)instalacao.getKey();
            Instalação value = ((Instalação)instalacao.getValue());
            
            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                
                Random rand = new Random();
                int probNacer=rand.nextInt(100); //Inteiro random de 0 a 99
                
                //Verifica o tipo de animal
                //Verifica se o número randomizado é menor ou igual ao apetite reprodutivo desse
                if (a.getClass() == Tigre.class){                 
                    if(probNacer <= Tigre.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um tigre na instalação de número "+key);
                        Animal p =new Tigre(null, true); //Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass() == Leão.class){                    
                    if(probNacer<=Leão.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um leão na instalação de número "+key);
                        Animal p =new Leão(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Boi.class){                    
                    if(probNacer<=Boi.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um boi na instalação de número "+key);
                        Animal p =new Boi(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Cabra.class){                    
                    if(probNacer<=Cabra.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu uma cabra na instalação de número "+key);
                        Animal p =new Cabra(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Cachorro.class){                    
                    if(probNacer<=Cachorro.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um cachorro na instalação de número "+key);
                        Animal p =new Cachorro(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Cavalo.class){                    
                    if(probNacer<=Cavalo.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um cavalo na instalação de número "+key);
                        Animal p =new Cavalo(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                    
                }
                else if (a.getClass()==Cobra.class){                    
                    if(probNacer<=Cobra.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um cobra na instalação de número "+key);
                        Animal p =new Cobra(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Coelho.class){                    
                    if(probNacer<=Coelho.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um coelho na instalação de número "+key);
                        Animal p =new Coelho(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Crocodilo.class){                    
                    if(probNacer<=Crocodilo.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um crocodilo na instalação de número "+key);
                        Animal p =new Crocodilo(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Dragão.class){                    
                    if(probNacer<=Cavalo.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um dragão na instalação de número "+key);
                        Animal p =new Dragão(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Galo.class){                    
                    if(probNacer<=Galo.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um galo na instalação de número "+key);
                        Animal p =new Galo(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Gorila.class){                    
                    if(probNacer<=Gorila.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um gorila na instalação de número "+key);
                        Animal p =new Gorila(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Macaco.class){                    
                    if(probNacer<=Macaco.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um macaco na instalação de número "+key);
                        Animal p =new Macaco(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Panda.class){                    
                    if(probNacer<=Panda.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um panda na instalação de número "+key);
                        Animal p =new Panda(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Porco.class){                    
                    if(probNacer<=Porco.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um porco na instalação de número "+key);
                        Animal p =new Porco(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Rato.class){                    
                    if(probNacer<=Rato.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um rato na instalação de número "+key);
                        Animal p =new Rato(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==UrsoPolar.class){                    
                    if(probNacer<=UrsoPolar.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um urso polar na instalação de número "+key);
                        Animal p =new UrsoPolar(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==Vaca.class){                    
                    if(probNacer<=Vaca.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu uma vaca na instalação de número "+key);
                        Animal p =new Vaca(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
                else if (a.getClass()==UrsoPardo.class){                    
                    if(probNacer<=UrsoPardo.getAPETITEREPRODUTIVO()){
                        System.out.println("Nasceu um urso pardo na instalação de número "+key);
                        Animal p =new UrsoPardo(null, true);//Cria um novo animal já instalado no zoo (isto é , que ja tem id)
                        constroiAnimal(p,"nascimento"); //Constroi esse animal, sendo que já tem id, e cria a ocorrência
                        p.setIdade(0); //Muda a sua idade para 0
                    }
                }
            }
        }
    }
    
    /*
    Método usado para aumentar a idade dos animais no zoo
    */
    public void aumentarIdade(){
       
        for (Animal a : animaisFI){ //Percorre os animais fora das instalações
            a.incrementaIdade();
            a.incrementaBonus(-50);
        }
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HasMap da sinstalações no zoo

            Instalação value = ((Instalação)instalacao.getValue());
            
            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais na instalação
                a.incrementaIdade();
                a.incrementaBonus(-50);
            }
        }  
    }
    
    /*
    Método usado para verificar e "matar" os animais que já passaram da sua esperança de vida média
    */
    public void morrerAnimal(){
        
        for(int i = 0; i<animaisFI.size(); i++){ //Percorre a ArrayList dos animais fora do zoo
                
            //Verifica o tipo de animal
            //Verifica se a sua idade já passou da sua esperança média de vida
            if(animaisFI.get(i).getClass()==Tigre.class){                    
               if(Tigre.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o tigre chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                } 
            }
            else if (animaisFI.get(i).getClass()==Leão.class){                    
                if(Leão.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o leão chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Boi.class){
                if(Boi.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o boi chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Cabra.class){                    
                if(Cabra.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu a cabra chamada "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Cachorro.class){                    
                if(Cachorro.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o cachorro chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Cavalo.class){                    
               if(Cavalo.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o cavalo chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Cobra.class){                    
                if(Cobra.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu a cobra chamada "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Coelho.class){                    
                if(Coelho.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o coelho chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Crocodilo.class){                    
                if(Crocodilo.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o crocodilo chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Dragão.class){                    
                if(Dragão.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o dragão chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Galo.class){                    
                if(Galo.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o galo chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Gorila.class){                    
                if(Gorila.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o gorila chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Macaco.class){                    
               if(Macaco.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o macaco chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Panda.class){                    
               if(Panda.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o panda chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Porco.class){                    
                if(Porco.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o porco chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Rato.class){                    
                if(Rato.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o rato chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                } 
            }
            else if (animaisFI.get(i).getClass()==UrsoPolar.class){                    
                if(UrsoPolar.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o urso polar chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==Vaca.class){                    
                if(Vaca.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu a vaca chamada "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                }
            }
            else if (animaisFI.get(i).getClass()==UrsoPardo.class){                    
                if(UrsoPardo.getESPERANCAVIDA()<animaisFI.get(i).getIdade()){
                    System.out.println("Morreu o urso pardo chamado "+animaisFI.get(i).getNome()+" de id "+animaisFI.get(i).getId());
                    criaOcorrencia("obito", animaisFI.get(i),null); //Cria ocorrência de óbito
                    adicionarObitos(animaisFI.get(i)); //Adiciona o animal a ArrayList do obituário
                    removerFI(i); //Remove o animal da ArrayList dos animais fora do zoo
                } 
            }
        }
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo

            Instalação value = ((Instalação)instalacao.getValue());
  
            for (int i = 0; i<value.getAnimais().size();i++){ //Percorre a ArrayList dos animais na instalação
                
                //Verifica o tipo de animal
                //Verifica se a sua idade já passou da sua esperança média de vida
                if(value.getAnimais().get(i).getClass()==Tigre.class){                    
                   if(Tigre.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o tigre chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                   } 
                }
                else if (value.getAnimais().get(i).getClass()==Leão.class){                    
                    if(Leão.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o leão chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Boi.class){
                    if(Boi.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o boi chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Cabra.class){                    
                    if(Cabra.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu a cabra chamada "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Cachorro.class){                    
                    if(Cachorro.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o cachorro chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Cavalo.class){                    
                   if(Cavalo.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o cavalo chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Cobra.class){                    
                    if(Cobra.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu a cobra chamada "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Coelho.class){                    
                    if(Coelho.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o coelho chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Crocodilo.class){                    
                    if(Crocodilo.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o crocodilo chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Dragão.class){                    
                    if(Dragão.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o dragão chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Galo.class){                    
                    if(Galo.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o galo chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
                else if (value.getAnimais().get(i).getClass()==Gorila.class){                    
                    if(Gorila.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o gorila chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==Macaco.class){                    
                   if(Macaco.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o macaco chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==Panda.class){                    
                   if(Panda.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o panda chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==Porco.class){                    
                    if(Porco.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o porco chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==Rato.class){                    
                   if(Rato.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o rato chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==UrsoPolar.class){                    
                    if(UrsoPolar.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o urso polar chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==Vaca.class){                    
                    if(Vaca.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu a vaca chamada "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
               else if (value.getAnimais().get(i).getClass()==UrsoPardo.class){                    
                    if(UrsoPardo.getESPERANCAVIDA()<value.getAnimais().get(i).getIdade()){
                        System.out.println("Morreu o urso pardo chamado "+value.getAnimais().get(i).getNome()+" de id "+value.getAnimais().get(i).getId());
                        criaOcorrencia("obito", value.getAnimais().get(i),null); //Cria ocorrência de óbito
                        adicionarObitos(value.getAnimais().get(i)); //Adiciona o animal a ArrayList do obituário
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList dos animais na istalação
                    }
                }
            }
        }
    }
    
    /*
    Método usado para retirar ao saldo do zoo as despesas de cada animal fora das instalações do zoo
    Estes só dão despesa
    */
    public void animaisSaldo(){
        
        for (Animal a : animaisFI){ //Percorre a ArrayList dos animais fora das instalações
                
            //Verifica o tipo do animal
            if(a.getClass() == Boi.class){
                Boi b = (Boi) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Cabra.class){
                Cabra b = (Cabra) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Cachorro.class){
                Cachorro b = (Cachorro) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Cavalo.class){
                Cavalo b = (Cavalo) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Cobra.class){
                Cobra b = (Cobra) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Coelho.class){
                Coelho b = (Coelho) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Crocodilo.class){
                Crocodilo b = (Crocodilo) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Dragão.class){
                Dragão b = (Dragão) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Galo.class){
                Galo b = (Galo) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Gorila.class){
                Gorila b = (Gorila) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Leão.class){
                Leão b = (Leão) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Macaco.class){
                Macaco b = (Macaco) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Panda.class){
                Panda b = (Panda) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Porco.class){
                Porco b = (Porco) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Rato.class){
                Rato b = (Rato) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Tigre.class){
                Tigre b = (Tigre) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == UrsoPardo.class){
                UrsoPardo b = (UrsoPardo) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == UrsoPolar.class){
                UrsoPolar b = (UrsoPolar) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
            else if (a.getClass() == Vaca.class){
                Vaca b = (Vaca) a;
                b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
            }
        }
    }
    
    /*
    Método usado para retirar e adicionar ao saldo do zoo as despesas e os ganhos de cada animal dentro das instalações do zoo
    Estes dão despesas e ganhos
    */
    public void animaisISaldo (){
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HasMap das instalações do zoo
            
            Instalação value = ((Instalação)instalacao.getValue());
  
            for (Animal a : value.getAnimais()){ //Percorre a ArrayList dos animais da instalação
                
                //Verifica o tipo do animal
                if(a.getClass() == Boi.class){
                    Boi b = (Boi) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Cabra.class){
                    Cabra b = (Cabra) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Cachorro.class){
                    Cachorro b = (Cachorro) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Cavalo.class){
                    Cavalo b = (Cavalo) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Cobra.class){
                    Cobra b = (Cobra) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Coelho.class){
                    Coelho b = (Coelho) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Crocodilo.class){
                    Crocodilo b = (Crocodilo) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Dragão.class){
                    Dragão b = (Dragão) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Galo.class){
                    Galo b = (Galo) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Gorila.class){
                    Gorila b = (Gorila) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Leão.class){
                    Leão b = (Leão) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Macaco.class){
                    Macaco b = (Macaco) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Panda.class){
                    Panda b = (Panda) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Porco.class){
                    Porco b = (Porco) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Rato.class){
                    Rato b = (Rato) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Tigre.class){
                    Tigre b = (Tigre) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == UrsoPardo.class){
                    UrsoPardo b = (UrsoPardo) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == UrsoPolar.class){
                    UrsoPolar b = (UrsoPolar) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
                else if (a.getClass() == Vaca.class){
                    Vaca b = (Vaca) a;
                    b.comerAnual(this); //Retira o valor da comida ao saldo do zoo
                    b.cuidarAnual(this); //Retira o valor dos cuidados ao saldo do zoo
                    saldo+=Boi.getAtratividadeBase()+b.getBonus(); //Adiciona a sua atratividade base e seu bonus
                }
            }
        }
    }
    
    /*
    Método usado para retirar ao saldo do zoo as despesas das instalações do zoo
    Estas só dão despesas
    */
    public void instalacoesSaldo (){
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HashMap das instalações do zoo
            
            Instalação value = ((Instalação)instalacao.getValue());
            value.manutencaoInstalacaoAno(this); //Retira o valor da manutenção da instalação ao saldo do zoo
            
        }
    }
    
    /*
    Método usado para verificar se o zoo está em prejuizo, e se estiver invoca o método "jumangi" onde podem fugir animais
    */
    public void prejuizo(){

        if (saldo < 0){
            System.out.println("Saldo negativo, logo pode haver prejuisos");
            jumanji();
        }
        else{
            System.out.println("Saldo Positivo, logo não há prejuisos");
        }
    }
    
    /*
    Método usado para juntar e ordenar todos os métodos usados num período contabilistico
    */
    public void periodoContabilistico (){
        
        animaisSaldo(); //Retira ao saldo do zoo as despesas dos animais fora das instalações
        animaisISaldo(); //Retira e adiciona ao saldo so zoo as despesas e os ganhos dos animais dentro das instalações
        instalacoesSaldo(); //Retira ao saldo do zoo as despesas das instalaçoes do zoo
        aumentarIdade(); //Aumenta a idade de todos os animais do zoo
        aumentarAno(); //Aumenta o ano do zoo
        nascerAnimal(); //Cria animais que nascem
        morrerAnimal(); //Mata animais que morrem
        
        System.out.println("Passando do ano "+(anoZoo-1)+" para o ano "+anoZoo+" o saldo constabilístico resume-se em: "+saldo);
        
        prejuizo(); //Dependendo do saldo executa o método "jumangi"
    }

    /*
    Método usado para verificar a probabilidade do animal fugir e fazer ele fugir do zoo
    */
    public void jumanji(){
        
        for(int i = 0; i<animaisFI.size();i++){ //Percorre a ArrayList dos animais fora das instalações
            
            Random rand = new Random();
            int r = rand.nextInt(100); //Cria um inteiro randomizado de 0 a 99
                
            if(r > 30){ //Se esse random for maior que 30 (se foge do zoo)
                    
                if(r > 75){ //Se esse random for maior que 75 (foge do zoo e nunca volta)
                    System.out.println("O "+animaisFI.get(i).getClass()+" chamado "+animaisFI.get(i).getNome()+" fugiu do zoo");
                    criaOcorrencia("fugiu",animaisFI.get(i),null); //Cria a ocorrência do animal fugir do zoo
                    animaisFI.remove(animaisFI.get(i)); //Remove o animal da ArrayList dos animais fora das instalações
                }
                else{ //Se não (foge do zoo mas é apanhado)
                    System.out.println("O "+animaisFI.get(i).getClass()+" chamado "+animaisFI.get(i).getNome()+" fugiu do zoo mas por sorte foi apanhado.");
                    animaisFI.add(animaisFI.get(i)); //Adiciona o animal na ArrayList dos animais fora das instalações
                    animaisFI.remove(animaisFI.get(i)); //Retira o animal da ArrayList dos animais fora das instalações
                }
            }
        }
        
        for (Map.Entry instalacao : zoo.entrySet()){ //Percorre o HasMap das instalações do zoo
            
            int key = (int)instalacao.getKey();
            Instalação value = ((Instalação)instalacao.getValue());
  
            for (int i = 0; i<value.getAnimais().size();i++){ //Percorre a ArrayList dos animais na instalação
                
                Random rand = new Random();
                int r = rand.nextInt(100); //Cria um inteiro randomizado de 0 a 99
                
                if(r > 30){ //Se esse random for maior que 30 (se foge do zoo)
                    
                    if(r > 75){ //Se esse random for maior que 75 (foge do zoo e nunca volta)
                        System.out.println("O "+value.getAnimais().get(i).getClass()+" chamado "+value.getAnimais().get(i).getNome()+" fugiu da instalação número "+key);
                        criaOcorrencia("fugiu",animaisFI.get(i),null); //Cria a ocorrência do animal fugir do zoo
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList de animais da instalação
                        value.setAnimaisInstalados(value.getAnimaisInstalados()-1); //Diminui o número de animais na instalação
                    }
                    else{ //Se não (foge do zoo mas é apanhado)
                        System.out.println("O "+value.getAnimais().get(i).getClass()+" chamado "+value.getAnimais().get(i).getNome()+" fugiu da instalação número "+key+" mas por sorte foi apanhado.");
                        animaisFI.add(value.getAnimais().get(i)); //Adiciona o animal na ArrayList dos animais fora das instalações
                        value.getAnimais().remove(value.getAnimais().get(i)); //Remove o animal da ArrayList de animais da instalação
                        value.setAnimaisInstalados(value.getAnimaisInstalados()-1); //Diminui o número de animais na instalação
                    }  
                }
            }
        }
    }
    
    /*
    Método usado para juntar todo o zoo de modo a imprimir-lo todo
    */
    public void retratoF(){
        
        System.out.println("Retrato de família animal:");
        
        System.out.println("\nAnimais do zoo:");
        listarAnimais(); //Lista todos os animais do zoo
        System.out.println("Instalações do zoo:");
        listarInstalacoes(); //Lista todas as instalações do zoo
        System.out.println("Obituário :\n"+obituario);
        System.out.println("Histórico :\n"+historico);
                
    }
}
