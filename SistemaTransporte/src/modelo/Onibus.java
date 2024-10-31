package modelo;


import java.util.ArrayList;

/**
 * Classe que representa um ônibus no sistema de transporte.
 * Cada ônibus possui uma rota, capacidade, número, quantidade de passageiros, um vetor de passageiros e um motorista.
 */

public class Onibus{
    /**
     * Atributos
     * rota: inteiro que representa a rota do ônibus
     * capacidade: inteiro que representa a capacidade do ônibus
     * numero: inteiro que representa o número do ônibus
     * quantidade: inteiro que representa a quantidade de passageiros no ônibus
     * passageiros: vetor de passageiros que representa os passageiros no ônibus
     * motorista: objeto da classe Motorista que representa o motorista do ônibus
     * 
     */
    private int rota, capacidade, numero, quantidade;
    private Passageiro passageiros[];
    private Motorista motorista;

    //Construtor
    public Onibus(){
    }


    /**
     * Construtor da classe Onibus
     * @param capacidade
     * @param motorista
     * @param numero
     * @param rota
     */
    
    public Onibus(int capacidade, Motorista motorista, int numero, int rota){
        this.numero = numero;
        this.rota = rota;
        this.numero = numero;
        this.capacidade = capacidade;
        passageiros = new Passageiro[capacidade];
        this.quantidade  = 0;
        this.motorista = motorista;
        inicializarPassageiros();
    }

    /**
     * Método que inicializa o vetor de passageiros do ônibus
     */
    public void inicializarPassageiros(){
        for(int i = 0; i < capacidade; i++){
            this.passageiros[i] = null;
        }
    }

    /**
     * Método que retorna o motorista do ônibus
     * @return motorista do ônibus
     */
    public Motorista getMotorista() {
        return motorista;
    }

    /**
     * Método que determina o motorista do ônibus
     * @param motorista
     */
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    /**
     * Método que retorna a capacidade do ônibus
     * @return
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Método que determina a capacidade do ônibus
     * @param capacidade
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    /**
     * Método que retorna a rota do ônibus
     * @return
     */
    public int getRota() {
        return rota;
    }

    /**
     * Método que determina a rota do ônibus
     * @param rota
     */
    public void setRota(int rota) {
        this.rota = rota;
    }
    
    /**
     * Método que retorna o número do ônibus
     * @return
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Método que retorna a quantidade de passageiros no ônibus
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }
    
    /**
     * Método que determina o número do ônibus
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Método que retorna o vetor de passageiros do ônibus
     * @return
     */
    public Passageiro[] getPassageiros(){
        return passageiros;
    }
    
    
    /**
     * Método que adiciona um passageiro ao ônibus pela primeira posição vaga
     * @param passageiro
     * @return
     */
    public boolean adicionarPassageiro(Passageiro passageiro){
        //Verifica se está cheio
        if(quantidade > capacidade) return false;
        
        for(int i = 0; i < capacidade; i++){
            if(passageiros[i] == null){
                passageiros[i] = passageiro;
                quantidade++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que adiciona um passageiro ao ônibus em uma posição específica
     * Utilização de polimorfismo
     * 
     * @param passageiro
     * @param posicao
     * @return
     */
    public boolean adicionarPassageiro(Passageiro passageiro, int posicao){
        //Verifica se está cheio
        if(quantidade > capacidade) return false;
        if(posicao < 1 || posicao > capacidade) return false;
        if(passageiros[posicao-1] == null){
           passageiros[posicao-1] = passageiro;
           quantidade++;
           return true;
        }
       
       return false;
    }
    
    
    /**
     * Método que busca um passageiro no ônibus pelo nome
     * 
     * @param nome
     * @return
     */
    public Passageiro buscarPassageiro(String nome){
        if(quantidade == 0) return null;
        
        for(int i = 0; i < capacidade; i++){
            if(passageiros[i] != null){
                if(passageiros[i].getNome().equals(nome)) return passageiros[i].clone();
            }
                
        }
        return null;
    }
    

    /**
     * Método que busca um passageiro no ônibus pela posição
     * Utilização de polimorfismo
     * @param posicao
     * @return
     */
    public Passageiro buscarPassageiro(int posicao){
        if(quantidade == 0) return null;
        if(posicao < 1 || posicao > capacidade) return null;

       return passageiros[posicao - 1].clone();
    }
    
    /**
     * Método que remove todos os passageiros do ônibus
     * @return
     */
    public boolean RemoverTodosPassageiro(){
        for(int i = 0; i < capacidade; i++){
            passageiros[i] = null;
        }
        return true;
    }
    
    /**
     * Método que remove um passageiro do ônibus pelo nome
     * @param nome
     * @return
     */
    public boolean RemoverPassageiro(String nome){
        for(int i = 0; i < capacidade; i++){
            if(passageiros[i] != null){
                if(this.passageiros[i].getNome().equals(nome)){
                    this.passageiros[i] = null;
                    quantidade--;
                    return true;
                }
            }   
        }
        return false;
    }

    /**
     * Método que remove um passageiro do ônibus pela posição
     * Utilização de polimorfismo
     * 
     * @param posicao
     * @return
     */
    public boolean RemoverPassageiro(int posicao){
        if(posicao < 1 || posicao > capacidade) return false;
        if(passageiros[posicao-1] != null){
            passageiros[posicao-1] = null;
            quantidade--;
            return true;
        }
        return false;
    }

}
