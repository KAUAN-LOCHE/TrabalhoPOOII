/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada;
import modelo.ParadaDecorator;
import modelo.Passageiro;
import modelo.Viagem;
import modelo.ViagemOnibus;
import modelo.enums.TipoAssento;
import modelo.interfaces.Veiculo;

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
    private ArrayList<BilheteEletronico> bilhetesEletronicos;

    public SistemaTransporte() {
        onibus = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
        bilhetesEletronicos = new ArrayList<>();
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

    // MÉTODOS RELATIVOS À CLASSE PASSAGEIRO
    // ========================================================================================

    public Passageiro createPassageiro(String nome, int idade, String cpf, String senha, String endereco,
            String telefone, TipoAssento tipoAssento) {
        Passageiro passageiro = new Passageiro(nome, idade, cpf, senha, telefone, tipoAssento);
        return passageiro;
    }

    // MÉTODO RELATIVOS À CLASSE ÔNIBUS
    // ========================================================================================

    public Onibus createOnibus(int capacidade, int qdeAssentosPlusSize, int qdeAssentosCadeirante, int qdeAssentosIdoso,
            Motorista motorista, int numero, int rota) {
        Onibus onibus = new Onibus(capacidade, qdeAssentosPlusSize, qdeAssentosCadeirante, qdeAssentosIdoso, motorista,
                numero, rota);
        this.onibus.add(onibus);
        return onibus;
    }

    public void setNumero(int numeroOnibus, int numero) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                onibus.get(i).setNumero(numero);
            }
        }
    }

    public int getQuantidade(int numeroOnibus) {

        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getLotação();
            }
        }
        return -1;
    }

    public int getNumero(int numeroOnibus) {

        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getNumero();
            }
        }
        return -1;
    }

    public int getCapacidade(int numeroOnibus) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getCapacidade();
            }
        }
        return -1;
    }

    public void setMotorista(int numeroOnibus, Motorista motorista) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                onibus.get(i).setMotorista(motorista);
            }
        }
    }

    public Motorista getMotorista(int numeroOnibus) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getMotorista();
            }
        }
        return null;
    }

    // MÉTODOS DA CLASSE MOTORISTA
    // ====================================================================================

    public Motorista createMotorista(String nome, int idade, String cpf, String senha, String cnh, int experiencia,
            String empresa, String linhaOnibus) {
        Motorista motorista = new Motorista(nome, idade, cpf, senha, cnh, experiencia, empresa, linhaOnibus);
        this.motoristas.add(motorista);
        return motorista;
    }

    // MÉTODOS DA CLASSE VIAGEM
    // ====================================================================================

    // MÉTODOS DA CLASSE VIAGEM ÔNIBUS
    // ====================================================================================

    public Viagem createViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        Viagem viagem = new ViagemOnibus(onibus, paradas);
        this.viagens.add(viagem);
        return viagem;
    }

    public ArrayList<Viagem> getAllViagensOnibusByDestino(ParadaDecorator destino, TipoAssento tipoAssento) {
        ArrayList<Viagem> viagensDisponiveis = new ArrayList<Viagem>();

        this.viagens.forEach(viagem -> {
            if (viagem.getParadas().contains(destino) && temAssentoDisponivel(viagem.getVeiculo(), tipoAssento)) {
                viagensDisponiveis.add(viagem);
            }
        });

        if (viagensDisponiveis.isEmpty()) {
            throw new IllegalArgumentException("Não há viagens disponíveis para o destino selecionado");
        }

        return viagensDisponiveis;
    }

    public boolean temAssentoDisponivel(Veiculo veiculo, TipoAssento tipoAssento) {
        for (int i = 0; i < veiculo.getAssentos().length; i++) {
            if (veiculo.getAssentos()[i].getTipo() == tipoAssento
                    && veiculo.getAssentos()[i].getPassageiro() == null) {
                return true;
            }
        }
        return false;
    }

    // MÉTODOS DA CLASSE PAGAMENTO PASSAGEM
    // ====================================================================================

    // MÉTODOS DA CLASSE PARADA
    // ====================================================================================
    public Parada createParada(String endereco) {
        Parada parada = new Parada(endereco);
        return parada;
    }

    public ParadaDecorator createParadaDecorator(Parada parada, LocalDateTime horarioPrevisto) {
        ParadaDecorator paradaDecorator = new ParadaDecorator(parada, horarioPrevisto);
        return paradaDecorator;
    }

    // Definindo valores que serão utilizados na instanciação de objetos
    // pertencentes à classe Parada

    // MÉTODOS DA CLASSE HORARIONIBUS
    // ====================================================================================

    // MÉTODOS DA CLASSE BILHETEELETRÔNICO
    // ====================================================================================

    public BilheteEletronico createBilhete(Passageiro passageiro, Viagem viagem, ParadaDecorator embarque,
            ParadaDecorator desembarque, int assento, LocalDateTime horarioEmbarque) {
        BilheteEletronico bilheteEletronico = new BilheteEletronico(passageiro, viagem, embarque, desembarque, assento, horarioEmbarque);
        this.bilhetesEletronicos.add(bilheteEletronico);
        return bilheteEletronico;
    }

    public Passageiro getPassageiro(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
        return null;

    }

    public Viagem getViagem(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
        return null;
    }

    public int getPoltrona(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getNumAssento();
            }
        }
        return -1;
    }

    public UUID getID(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getID();
            }
        }
        return null;
    }

}
