package modelo;

import java.util.ArrayList;

public class ViagemOnibus extends Viagem {

    public ViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        super(onibus, paradas);

        this.paradas = paradas;
    }

    public ArrayList<ParadaDecorator> getParadas() {
        return this.paradas;
    }

    public void setParadas(ArrayList<ParadaDecorator> paradas) {
        this.paradas = paradas;
    }

    public void addParada(ParadaDecorator parada) {
        this.paradas.add(parada);
    }

    public void removeParada(ParadaDecorator parada) {
        this.paradas.remove(parada);
    }

    public String toString() {
        String veiculo = (this.veiculo != null) ? this.veiculo.toString() : "indefinido";
        return "id: " + id + "\nstatus: " + status + "\nveiculo: " + veiculo;
    }
}
