/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada as Parada;
import modelo.Passageiro;
import modelo.StatusViagem;
import modelo.Viagem;
import java.util.ArrayList;

/**
 *
 * @author kauan
 */
public class SistemaTransporte {
    private ArrayList<Onibus> onibus;
    private ArrayList<Motorista> motoristas;
    private ArrayList<Viagem> viagens;
    private ArrayList<Parada> paradas;
    
    public SistemaTransporte(){
        onibus = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
    }

    public ArrayList<Onibus> getOnibus() {
        return onibus;
    }

    public ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }
    
    //MÉTODO RELATIVOS À CLASSE ÔNIBUS ========================================================================================
    
    public Passageiro buscarPassageiroPosicao(int numeroOnibus, int posicao){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroPosicao(posicao);
            }
        }
        return null;
    }
    
    public boolean adicionarPassageiroPosicao(int numeroOnibus, Passageiro passageiro, int posicao){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).adicionarPassageiroPosicao(passageiro, posicao);
            }
        }
        return false;
    }
    public Passageiro buscarPassageiroNome(int numeroOnibus, String nome){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroNome(nome);
            }
        }
        return null;
    }
    
    public boolean adicionarPassageiro(int numeroOnibus, Passageiro passageiro){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).adicionarPassageiro(passageiro);
            }
        }
        return false;
    }
    
    public void exibirPassageiros(int numeroOnibus){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                onibus.get(i).exibirPassageiros();
            }
        }
    }
    
    public Passageiro[] getPassageiros(int numeroOnibus){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).getPassageiros();
            }
        }
        return null;
    }
    
    public void setNumero(int numeroOnibus, int numero) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                onibus.get(i).setNumero(numero);
            }
        }
    }
    
    public int getQuantidade(int numeroOnibus) {

        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).getQuantidade();
            }
        }
        return -1;
    }
    
    public int getNumero(int numeroOnibus) {
            
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).getNumero();
            }
        }
        return -1;
    }
    
    public int getRota(int numeroOnibus) {

        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).getRota();
            }
        }
        return -1;
    }
    
    public int getCapacidade(int numeroOnibus) {
        for(int i = 0; i < this.onibus.size(); i++){
        if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
            return onibus.get(i).getCapacidade();
        }
    }
    return -1;
    }
    
    public void setCapacidade(int numeroOnibus, int capacidade) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                onibus.get(i).setCapacidade(capacidade);
            }
        }
    }
    
    public void setMotorista(int numeroOnibus, Motorista motorista) {
         for(int i = 0; i < this.onibus.size(); i++){
        if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
            onibus.get(i).setMotorista(motorista);
        }
    }
         
    public Motorista getMotorista(int numeroOnibus){
         for(int i = 0; i < this.onibus.size(); i++){
        if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
            return onibus.get(i).getMotorista();
        }
    }
    return null;
    }
    
    public void inicializarPassageiros(int numeroOnibus){
         for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                onibus.get(i).inicializarPassageiros();
            }
        }
    }

    
    public boolean RemoverPassageiro(int numeroOnibus, String nome){
         for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).RemoverPassageiro(nome);
            }
        }
         return false;
    }
    
    public boolean RemoverTodosPassageiro(int numeroOnibus){
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).RemoverTodosPassageiro();
            }
        }
         return false;
    }
    
    //MÉTODOS DA CLASSE PASSAGEIROS ====================================================================================
            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================
    
    //MÉTODOS DA CLASSE VIAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PAGAMENTO PASSAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PARADA ====================================================================================
    
    // Definindo valores que serão utilizados na instanciação de objetos pertencentes à classe Parada
    
    String[] stopNames = ["Maplewood Grove", "Cedar Hill Estates", "Riverside Meadows", "Willow Creek Village", "Sunnyvale Heights", "Pinecrest Park", "Oakridge Hollow", "Silver Lake Shores", "Briarwood Commons", "Elm Street Junction"]
    Parada parada = new Parada();
    
    
    //MÉTODOS DA CLASSE HORARIONIBUS ====================================================================================
    
    //MÉTODOS DA CLASSE BILHETEELETRÔNICO ====================================================================================
}
