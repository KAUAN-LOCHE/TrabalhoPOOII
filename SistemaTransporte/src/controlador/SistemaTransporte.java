/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada;
import modelo.Passageiro;
import modelo.Viagem;
import modelo.enums.StatusViagem;
import modelo.HorarioOnibus;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;
import modelo.Motorista;
/**
 *
 * @author kauan
 */
public class SistemaTransporte {
    private ArrayList<Onibus> onibus;
    private ArrayList<Motorista> motoristas;
    private ArrayList<Viagem> viagens;
    private ArrayList<Parada> paradas;
    private ArrayList<BilheteEletronico> bilhetesEletronicos;
    
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
                return onibus.get(i).getLotação();
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
    
    
    public int getCapacidade(int numeroOnibus) {
        for(int i = 0; i < this.onibus.size(); i++){
        if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
            return onibus.get(i).getCapacidade();
        }
    }
    return -1;
    }
    
    public void setMotorista(int numeroOnibus, Motorista motorista) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                onibus.get(i).setMotorista(motorista);
            }
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
            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================
    
    //MÉTODOS DA CLASSE VIAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PAGAMENTO PASSAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PARADA ====================================================================================
    
    // Definindo valores que serão utilizados na instanciação de objetos pertencentes à classe Parada
   
    //MÉTODOS DA CLASSE HORARIONIBUS ====================================================================================
    
    //MÉTODOS DA CLASSE BILHETEELETRÔNICO ====================================================================================

    public String exibirDados(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return this.bilhetesEletronicos.get(i).exibirDados();
            }
        }
        return null;
    }

    public Passageiro getPassageiro(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
        return null;

    }

    public Viagem getViagem(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
        return null;
    }

    public Parada getEmbarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
        return null;
    }

    public Parada getDesembarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
        return null;
    }


    public LocalDateTime getDataHoraChegada(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getDataHoraChegada();
            }
        }
        return null;
    }

    public int getPoltrona(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPoltrona();
            }
        }
        return -1;
    }

    public UUID getID(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getID();
            }
        }
        return null;
    }

    public void setPassageiro(UUID id, Passageiro passageiro) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setPassageiro(passageiro);
            }
        }
    }
    
    public void setViagem(UUID id, Viagem viagem) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setViagem(viagem);
            }
        }
    }

    public void setDadosViagem(UUID id, int indiceEmbarque, int indiceDesembarque) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setDadosViagem(indiceEmbarque, indiceDesembarque);
            }
        }
    }

    public void setPoltrona(UUID id, int poltrona) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setPoltrona(poltrona);
            }
        }
    }

}
