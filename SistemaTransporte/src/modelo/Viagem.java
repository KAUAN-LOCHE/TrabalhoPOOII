package modelo;

import java.util.ArrayList;
import java.util.UUID;

import modelo.enums.StatusViagem;
import modelo.interfaces.Veiculo;

public abstract class Viagem  {
    protected final UUID id;
    //////////////////////////////// VERIFICAR
    protected Veiculo veiculo;
    protected ArrayList<ParadaDecorator> paradas;
    protected StatusViagem status;

    /**
     * Construtor da classe Viagem
     * @param veiculo
     * @param paradas
     */
    public Viagem(Veiculo veiculo, ArrayList<ParadaDecorator> paradas) {
        this.id = UUID.randomUUID();
        this.veiculo = veiculo;
        this.paradas = paradas;
        this.status = StatusViagem.NAO_INICIADA;
    }

    /**
     * Adiciona uma parada ao final da lista de paradas
     * @param parada
     * @param indice
     */
    public void adicionarParada(ParadaDecorator parada, int indice) {
        this.paradas.add(indice, parada);
    }

    /**
     * Adiciona uma parada ao final da lista de paradas
     * @param id
     * @return {@code ParadaDecorator} parada
     */
    public ParadaDecorator getParadaById(UUID id) {
        ParadaDecorator result = this.paradas.stream().filter(parada -> parada.getParadaId().equals(id)).findFirst()
                .orElse(null);

        if (result == null) {
            throw new IllegalArgumentException("Parada não encontrada");
        }

        return result;
    }

    /**
     * Inicia a viagem
     * @param parada
     */
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

    /**
     * Retorna o veículo da viagem
     * @return
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }


    /**
     * Retorna a lista de paradas da viagem
     * @return
     */
    public ArrayList<ParadaDecorator> getParadas() {
        return paradas;
    }

    /**
     * Determina a lista de paradas da viagem
     * @param paradas
     */
    public void setParadas(ArrayList<ParadaDecorator> paradas) {
        this.paradas = paradas;
    }

    /**
     * Retorna o status da viagem
     * @return
     */
    public StatusViagem getStatus() {
        return status;
    }

    /**
     * Determina o status da viagem
     * @param status
     */
    public void setStatus(StatusViagem status) {
        this.status = status;
    }

    /**
     * Determina o veículo da viagem
     * @param veiculo
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Remove uma parada da lista de paradas
     * @param endereco
     */
    public void removerParada(String endereco) {
        for (ParadaDecorator p : paradas) {
            if (p.getParada().getEndereco().equals(endereco)) {
                paradas.remove(p);
                return;
            }
        }

        throw new IllegalArgumentException("Parada não encontrada");
    }

    /**
     * Remove uma parada da lista de paradas
     */
    public void removerParada(Parada parada) {
        for (ParadaDecorator p : paradas) {
            if (p.getParada().equals(parada)) {
                paradas.remove(p);
                return;
            }
        }

        throw new IllegalArgumentException("Parada não encontrada");
    }

    public String toString() {
        String veiculo = this.veiculo == null ? "null" : String.valueOf(this.veiculo.getNumero());
        return "id: " + id + "\nstatus: " + status + "\nveiculo: " + veiculo;
    }

}
