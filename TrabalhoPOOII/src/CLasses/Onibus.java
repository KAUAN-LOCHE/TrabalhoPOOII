/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLasses;

import java.util.ArrayList;


/**
 *
 * @author kauan
 */
public class Onibus {
   // private String nome;
    int quantidade;
    private int rota, capacidade, numero;
    private Passageiro passageiros[];
    public Onibus(){
    }
    
    public Onibus(int capacidade, int numero, int rota){
        numero = numero;
        this.rota = rota;
        this.numero = this.numero;
        passageiros = new Passageiro[capacidade];
        this.quantidade = 0;
    }

    //Retorna capacidade
    public int getCapacidade() {
        return capacidade;
    }
    //Determina a capacidade
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    //Retorna a Rota
    public int getRota() {
        return rota;
    }

    //Determina a rota
    public void setRota(int rota) {
        this.rota = rota;
    }
    
    //Retorna  o numero
    public int getNumero() {
        return numero;
    }
    
    //Retorna a quantidade de passageiros cadastrados no Onibus

    public int getQuantidade() {
        return quantidade;
    }
    

    //Determina o numero
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //Adicionar passageiro no onibus
    public boolean AdicionarPassageiro(Passageiro passageiro){
        if(this.quantidade < this.capacidade){
            this.passageiros[quantidade] = passageiros;
            return true;
        }
        return false;
    }
    
    //Buscar passageiro no onibus
    
    
    //Retorna os passageiros do onibus
    public ArrayList<Passageiro> exibirOnibus(){
        ArrayList<Passageiro> passageiro = new ArrayList<>();
        
        for(int i = 0; i < quantidade; i++){
            passageiro.add(this.passageiros[i].clone();
        }
        
        return passageiro;
    }
    
  /*  @Override
    public Onibus clone(){
        Onibus onibus;
        try{
            onibus = (Onibus) super.clone();
        }
         catch (CloneNotSupportedException e){
             System.out.println("Erro");  
             return null;
         }
         return onibus;
}*
}
