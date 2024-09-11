package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

public class BilheteEletronico {
    private Passageiro passageiro;
    private Viagem viagem;
    private Parada embarque;
    private Parada desembarque;
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraChegada;
    private int poltrona;
    private final UUID id;

    //Método construtor
    public BilheteEletronico(Passageiro passageiro, Viagem viagem, int indiceEmbarque, int indiceDesembarque, int poltrona) {
        setPassageiro(passageiro);
        setViagem(viagem);
        setDadosViagem(indiceEmbarque, indiceDesembarque);
        setPoltrona(poltrona);
        this.id = UUID.randomUUID();
    }

    //Método de exibição de dados
    public String exibirDados() {
        return "Passageiro: " + passageiro.getNome()
                + "\nCPF: " + passageiro.getCpf()
                + "\nEmbarque: " + embarque.getEnderecoFormatado()
                + "\nDesembarque: " + desembarque.getEnderecoFormatado()
                + "\nData de saída prevista: " + viagem.getDataHoraSaidaPrevista()
                + "\nData de chegada prevista: " + viagem.getDataHoraChegadaPrevista()
                + "\nPoltrona: " + poltrona
                + "\nID: " + id;
    }

    //Getters
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public Parada getEmbarque() {
        return embarque;
    }

    public Parada getDesembarque() {
        return desembarque;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public LocalDateTime getDataHoraChegada() {
        return dataHoraChegada;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public UUID getID() {
        return id;
    }

    //Setters
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public void setDadosViagem(int indiceEmbarque, int indiceDesembarque) {
        if(indiceEmbarque < indiceDesembarque) {
            for(int i = 0; i < this.viagem.getParadas().size(); i++) {
                if(i == indiceEmbarque) {
                    this.embarque = this.viagem.getParadas().get(i);
                    this.dataHoraSaida = this.viagem.getDataHoraSaidaPrevista().get(i);
                }
                if(i == indiceDesembarque) {
                    this.desembarque = this.viagem.getParadas().get(i);
                    this.dataHoraChegada = this.viagem.getDataHoraChegadaPrevista().get(i);
                }
            }
        }
    }

    public void setPoltrona(int poltrona) {
        if(poltrona <= viagem.getOnibus().getCapacidade()) {
            this.poltrona = poltrona;
        }
    }

}
