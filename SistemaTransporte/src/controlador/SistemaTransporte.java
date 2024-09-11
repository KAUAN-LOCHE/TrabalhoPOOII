/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada;
import modelo.Passageiro;
import modelo.StatusViagem;
import modelo.Viagem;
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
    
    public String getPassageiroNomePorPosicao(int numeroOnibus, int posicao) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroPosicao(posicao).getNome();
            }
        }
        return null;
    }
    
    public int getPassageiroTelefonePorNome(int numeroOnibus, String nome) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroNome(nome).getTelefone();
            }
        }
        return -1;
    }
    
    public int getPassageiroIdadePorNome(int numeroOnibus, String nome) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroNome(nome).getIdade();
            }
        }
        return -1;
    }
    
    public String getPassageiroCpfPorNome(int numeroOnibus, String nome) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                return onibus.get(i).buscarPassageiroNome(nome).getCpf();
            }
        }
        return null;
    }
    
    public void setPassageiroNomePorPosicao(int numeroOnibus, int posicao, String nome) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                this.onibus.get(i).buscarPassageiroPosicao(posicao).setNome(nome);
            }
        }
    }
    
    public void setPassageiroTelefonePorNome(int numeroOnibus, String nome, int telefone) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                this.onibus.get(i).buscarPassageiroNome(nome).setTelefone(telefone);
            }
        }
    }
    
    public void setPassageiroIdadePorNome(int numeroOnibus, String nome, int idade) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                this.onibus.get(i).buscarPassageiroNome(nome).setIdade(idade);
            }
        }
    }
    
    public void setPassageiroCpfPorNome(int numeroOnibus, String nome, String cpf) {
        for(int i = 0; i < this.onibus.size(); i++){
            if(this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus){
                this.onibus.get(i).buscarPassageiroNome(nome).setCpf(cpf);
            }
        }
    }
            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================
    
    //MÉTODOS DA CLASSE VIAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PAGAMENTO PASSAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PARADA ====================================================================================
    
    // Definindo valores que serão utilizados na instanciação de objetos pertencentes à classe Parada
    
    String[] stopNames = ["Maplewood Grove", "Cedar Hill Estates", "Riverside Meadows", "Willow Creek Village", "Sunnyvale Heights", "Pinecrest Park", "Oakridge Hollow", "Silver Lake Shores", "Briarwood Commons", "Elm Street Junction"]
    Parada parada = new Parada();
    
    
    //MÉTODOS DA CLASSE HORARIONIBUS ====================================================================================
    
    //MÉTODOS DA CLASSE BILHETEELETRÔNICO ====================================================================================

    public String exibirDados(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return this.bilhetesEletronicos.get(i).exibirDados();
            }
        }
    }

    public Passageiro getPassageiro(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
    }

    public Viagem getViagem(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
    }

    public Parada getEmbarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
    }

    public Parada getDesembarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
    }

    public LocalDateTime getDataHoraSaida(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getDataHoraSaida();
            }
        }
    }

    public LocalDateTime getDataHoraChegada(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getDataHoraChegada();
            }
        }
    }

    public int getPoltrona(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPoltrona();
            }
        }
    }

    public UUID getID(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getID();
            }
        }
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
