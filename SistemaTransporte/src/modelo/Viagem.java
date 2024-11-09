package modelo;

import java.util.ArrayList;
import java.util.UUID;

import modelo.enums.StatusViagem;
import modelo.interfaces.Veiculo;

public abstract class Viagem  {
    private final UUID id;
    private final Veiculo veiculo;
    private ArrayList<ParadaDecorator> paradas;
    private StatusViagem status;

    public Viagem(Veiculo veiculo, ArrayList<ParadaDecorator> paradas) {
        this.id = UUID.randomUUID();
        this.veiculo = veiculo;
        this.paradas = paradas;
        this.status = StatusViagem.NAO_INICIADA;
    }

    /**
     * Adiciona uma parada à lista de paradas da viagem
     * 
     * @param parada ParadaDecorator a ser adicionada
     */
    public void adicionarParada(ParadaDecorator parada, int indice) {
        this.paradas.add(indice, parada);
    }

    public ParadaDecorator getParadaById(UUID id) {
        ParadaDecorator result = this.paradas.stream().filter(parada -> parada.getParadaId().equals(id)).findFirst()
                .orElse(null);

        if (result == null) {
            throw new IllegalArgumentException("Parada não encontrada");
        }

        return result;
    }

    public void visitarParada(Parada parada) {
        for (ParadaDecorator p : paradas) {
            if (p.getParadaId().equals(parada.getId())) {
                p.visitar();
                return;
            }
        }

        throw new IllegalArgumentException("Parada não encontrada");
    }

    // getters e setters
    public UUID getId() {
        return id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public ArrayList<ParadaDecorator> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<ParadaDecorator> paradas) {
        this.paradas = paradas;
    }

    public StatusViagem getStatus() {
        return status;
    }

    /**
     * Inicia a viagem
     */
    public void setStatus(StatusViagem status) {
        this.status = status;
    }

}
