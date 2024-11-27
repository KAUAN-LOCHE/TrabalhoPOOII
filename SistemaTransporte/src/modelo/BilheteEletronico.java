package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import modelo.enums.StatusViagem;
import modelo.interfaces.Veiculo;
import modelo.interfaces.ViagemObserver;

public class BilheteEletronico implements ViagemObserver {

    /**
     * Atributos da classe BilheteEletronico
     * 
     */
    private final UUID id;
    private final Passageiro passageiro;
    private final Viagem viagem;
    private final ParadaDecorator embarque;
    private final ParadaDecorator desembarque;
    private final int numAssento;
    private StatusViagem status;
    private LocalDateTime horarioEmbarque;
    private LocalDateTime horarioDesembarque;

    /**
     * Construtor da classe BilheteEletronico
     * @param passageiro
     * @param viagem
     * @param embarque
     * @param desembarque
     * @param numAssento
     * @param horarioEmbarque
    */
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
    /**
     * Atualiza o status da viagem
     */
    public void update() {
        this.status = StatusViagem.FINALIZADA;
        this.horarioDesembarque = LocalDateTime.now();
        this.viagem.getVeiculo().removePassageiro(this.passageiro);
    }

    /**
     * Retorna o passageiro
     * @return {@code Passageiro} passageiro
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Retorna a viagem
     * @return {@code Viagem} viagem
     */
    public Viagem getViagem() {
        return viagem;
    }

    /**
     * Retorna o local do embarque
     * @return {@code ParadaDecorator} embarque
     */
    public ParadaDecorator getEmbarque() {
        return embarque;
    }

    /**
     * Retorna o local do desembarque
     * @return {@code ParadaDecorator} desmbarque
     */
    public ParadaDecorator getDesembarque() {
        return desembarque;
    }

    /**
     * Retorna o número do assento do passageiro
     * @return {@code int} numAssento
     */
    public int getNumAssento() {
        return numAssento;
    }

    /**
     * Retorna o ID do bilhete eletrônico
     * @return {@code UUID} id
     */
    public UUID getID() {
        return id;
    }

    /**
     * Retorna o status da viagem
     * @return {@code StatusViagem} status
     */
    public StatusViagem getStatus() {
        return status;
    }

    /**
     * Retorna o horário do embarque
     * @return {@code LocalDateTime} horarioEmbarque
     */
    public LocalDateTime getHorarioEmbarque() {
        return horarioEmbarque;
    }

    /**
     * Retorna o horário do desembarque
     * @return {@code LocalDateTime} horarioDesembarque
     */
    public LocalDateTime getHorarioDesembarque() {
        return horarioDesembarque;
    }

    @Override
    /**
     * Representação textual da classe
     * @return {@code String} com informações do bilhete eletrônico
     */
    public String toString() {
        return "Bilhete Eletrônico\n" +
                "ID: " + id + "\n" +
                "Passageiro: " + passageiro + "\n" +
                "Viagem: " + viagem + "\n" +
                "Embarque: " + embarque + "\n" +
                "Desembarque: " + desembarque + "\n" +
                "Número do Assento: " + numAssento + "\n" +
                "Status: " + status + "\n" +
                "Horário de Embarque: " + horarioEmbarque + "\n" +
                "Horário de Desembarque: " + horarioDesembarque;
    }
}
