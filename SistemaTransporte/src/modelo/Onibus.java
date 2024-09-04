package modelo;


import java.util.ArrayList;

 
public class Onibus{
   // private String nome;
    private int rota, capacidade, numero, quantidade;
    private Passageiro passageiros[];
    private Motorista motorista;
    public Onibus(){
    }
    
    public Onibus(int capacidade, Motorista motorista, int numero, int rota){
        numero = numero;
        this.rota = rota;
        this.numero = this.numero;
        this.capacidade = capacidade;
        passageiros = new Passageiro[capacidade];
        this.quantidade  = 0;
        this.motorista = motorista;
        inicializarPassageiros();
    }

    //Inicialização do Vetor
    public void inicializarPassageiros(){
        for(int i = 0; i < capacidade; i++){
            this.passageiros[i] = null;
        }
    }

    //Retorna o motorista
    public Motorista getMotorista() {
        return motorista;
    }

    //Seta o motorista
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
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
    
    //Retorna os passageiros do onibus
    public Passageiro[] getPassageiros(){
        return passageiros;
    }
    
    //Exibir Passageiros
    public void exibirPassageiros(){
        System.out.println("\nLISTA DE PASSAGEIROS");
        System.out.println("\nMotorista: " + motorista );
        for(int i = 0; i < capacidade;i++){
            if(passageiros[i] == null) System.out.println("\t" + i+1 + ": " + "Espaço Vago");
            else System.out.println("\t" + i+1 + ": " + passageiros[i].getNome());
        }
    }
    
    //Adicionar passageiro no onibus na primeira posição disponível
    public boolean AdicionarPassageiro(Passageiro passageiro){
        //Verifica se está cheio
        if(quantidade > capacidade) return false;
        
        for(int i = 0; i < capacidade; i++){
            if(passageiros[i] != null){
                passageiros[i] = passageiro;
                quantidade++;
                return true;
            }
        }
        return false;
    }
    
    //Adicionar passageiro no onibus em determinada posicao vaga
    public boolean adicionarPassageiroPosicao(Passageiro passageiro, int posicao){
        //Verifica se está cheio
        if(quantidade > capacidade) return false;
        
       if(passageiros[posicao-1] == null){
           passageiros[posicao-1] = passageiro;
           quantidade++;
           return true;
       }
       
       return false;
    }
    
    
    //Buscar passageiro no onibus por nome
    public Passageiro buscarNome(String nome){
        if(quantidade == 0) return null;
        
        for(int i = 0; i < capacidade; i++){
            if(passageiros[i].getNome().equals(nome)) return passageiros[i].clone();
        }
        return null;
    }
    
    //Buscar passageiro no onibus por posicao
    public Passageiro buscarposicao(int posicao){
        if(quantidade == 0) return null;
        
       return passageiros[posicao - 1];
    }
    
    //Remove todos os passageiros
    public boolean RemoverTodosPassageiro(){
        for(int i = 0; i < capacidade; i++){
            passageiros[i] = null;
        }
        return true;
    }
    
    //Remove Passageiro que corresponde ao nome inserido
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
        
        
    
    
   public ArrayList<Passageiro> BuscarPassageiro(String nome){
       ArrayList<Passageiro> ListaPassageiros = new ArrayList<Passageiro>();
       for(int i = 0; i < capacidade; i++){
           if(this.passageiros[i] != null && this.passageiros[i].getNome().equals(nome)){
               ListaPassageiros.add(this.passageiros[i].clone());
           }
       }
       return ListaPassageiros;
   }
    
  
}
