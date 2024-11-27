package modelo;

import java.util.ArrayList;

public class ViagemOnibus extends Viagem {

    /** 
     * Construtor da classe ViagemOnibus
     * @param onibus
     * @param paradas
     */
    public ViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        super(onibus, paradas);

        this.paradas = paradas;
    }

    /**
     * Retorna as paradas da viagem
     * @return {@code ArrayList<ParadaDecorator>} paradas
     */
    public ArrayList<ParadaDecorator> getParadas() {
        return this.paradas;
    }

    /**
     * Determina as paradas da viagem
     * @param paradas
     */
    public void setParadas(ArrayList<ParadaDecorator> paradas) {
        this.paradas = paradas;
    }

    /**
     * Adiciona uma parada à lista de paradas
     * @param parada
     */
    public void addParada(ParadaDecorator parada) {
        this.paradas.add(parada);
    }

    /**
     * Remove uma parada da lista de paradas
     * @param parada
     */
    public void removeParada(ParadaDecorator parada) {
        this.paradas.remove(parada);
    }

    /**
     * Representação textual da viagem
     * @return {@code String} viagem
     */
    public String toString() {
        String veiculo = (this.veiculo != null) ? this.veiculo.toString() : "indefinido";
        return "id: " + id + "\nstatus: " + status + "\nveiculo: " + veiculo;
    }
}
