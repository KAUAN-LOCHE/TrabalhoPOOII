package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import modelo.enums.StatusViagem;
import modelo.interfaces.Veiculo;
import modelo.interfaces.ViagemObserver;

public class BilheteEletronico implements ViagemObserver {
    private final UUID id;
    private final Passageiro passageiro;
    private final Viagem viagem;
    private final ParadaDecorator embarque;
    private final ParadaDecorator desembarque;
    private final int numAssento;
    private StatusViagem status;
    private LocalDateTime horarioEmbarque;
    private LocalDateTime horarioDesembarque;

    // Método construtor
    public BilheteEletronico(Passageiro passageiro, Viagem viagem, ParadaDecorator embarque,
            ParadaDecorator desembarque, int numAssento, LocalDateTime horarioEmbarque) {
        this.passageiro = passageiro;
        this.viagem = viagem;
        this.embarque = embarque;
        this.desembarque = desembarque;
        this.numAssento = numAssento;
        this.id = UUID.randomUUID();
        this.status = StatusViagem.EM_ANDAMENTO;
        this.horarioEmbarque = horarioEmbarque;

        Veiculo veiculo = viagem.getVeiculo();

        BilheteEletronicoValidator.validateBilheteEletronico(this, veiculo);
        veiculo.adicionarPassageiro(passageiro, numAssento);
        this.passageiro.setEmViagem(true);
        this.desembarque.addObserver(this);
    }

    @Override
    public void update() {
        this.status = StatusViagem.FINALIZADA;
        this.horarioDesembarque = LocalDateTime.now();
        this.viagem.getVeiculo().removePassageiro(this.passageiro);
    }

    // Getters
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public ParadaDecorator getEmbarque() {
        return embarque;
    }

    public ParadaDecorator getDesembarque() {
        return desembarque;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public UUID getID() {
        return id;
    }

    public StatusViagem getStatus() {
        return status;
    }

    public LocalDateTime getHorarioEmbarque() {
        return horarioEmbarque;
    }

    public LocalDateTime getHorarioDesembarque() {
        return horarioDesembarque;
    }
}
