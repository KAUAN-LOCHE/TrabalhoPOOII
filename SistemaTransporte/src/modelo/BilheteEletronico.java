package modelo;

import java.time.LocalDateTime;

public class BilheteEletronico {
    private Passageiro passageiro;
    private Viagem viagem;
    private LocalDateTime dataHora;
    private int plataforma; //Não tenho ctz se plataforma e poltrona deveriam ser int
    private int poltrona;
    //private String id;

    public BilheteEletronico(Passageiro passageiro, Viagem viagem, LocalDateTime dataHora, int plataforma, int poltrona) {
        setPassageiro(passageiro);
        setViagem(viagem);
        setDataHora(dataHora);
        setPlataforma(plataforma);
        setPoltrona(poltrona);
    }

    //gettters
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public viagem getViagem() {
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
