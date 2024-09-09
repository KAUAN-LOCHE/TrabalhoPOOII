package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

public class BilheteEletronico {
    private Passageiro passageiro;
    private Viagem viagem;
    private LocalDateTime dataHora;
    private int plataforma; //Não tenho ctz se plataforma e poltrona deveriam ser int
    private int poltrona;
    private final UUID id;

    public BilheteEletronico(Passageiro passageiro, Viagem viagem, LocalDateTime dataHora, int plataforma, int poltrona) {
        setPassageiro(passageiro);
        setViagem(viagem);
        setDataHora(dataHora);
        setPlataforma(plataforma);
        setPoltrona(poltrona);
        this.id = UUID.randomUUID();
    }

    public String dados() {
        return "Passageiro: " + passageiro.getNome()
                + "\nCPF: " + passageiro.getCpf()
                + "\nData de saída prevista: " + viagem.getDataHoraSaidaPrevista()
                + "\nData de chegada prevista: " + viagem.getDataHoraChegadaPrevista()
                + "\nPoltrona: " + poltrona
                + "\nID: " + id;
    }

    //gettters
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public UUID getID() {
        return id;
    }

    //setters
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

}
