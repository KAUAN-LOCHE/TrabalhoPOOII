package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

import modelo.enums.StatusViagem;

public class Viagem {
    private final UUID id;
    private final Onibus onibus;
    private int indiceParada = 0;
    private ArrayList<Parada> paradas;
    private ArrayList<LocalDateTime> dataHoraSaidaPrevista;
    private ArrayList<LocalDateTime> dataHoraChegadaPrevista;
    private ArrayList<LocalDateTime> dataHoraSaida;
    private ArrayList<LocalDateTime> dataHoraChegada;
    private ArrayList<StatusViagem> status;

    public Viagem(Onibus onibus, ArrayList<Parada> paradas, ArrayList<LocalDateTime> dataHoraSaidaPrevista,
            ArrayList<LocalDateTime> dataHoraChegadaPrevista) {
        this.id = UUID.randomUUID();
        this.onibus = onibus;
        this.paradas = paradas;
        this.dataHoraSaidaPrevista = dataHoraSaidaPrevista;
        this.dataHoraChegadaPrevista = dataHoraChegadaPrevista;
        
        for (int i = 0; i < paradas.size(); i++) {
            this.status.add(StatusViagem.AGUARDANDO);
        }
    }

    /**
     * Adiciona uma parada à lista de paradas da viagem
     * @param parada Parada a ser adicionada
     */
    public void adicionarParada(Parada parada) {
        this.paradas.add(parada);
        this.dataHoraSaida.add(LocalDateTime.now());
        this.dataHoraChegada.add(LocalDateTime.now());
        this.status.add(StatusViagem.AGUARDANDO);
    }

    /**
     * Remove uma parada da lista de paradas da viagem
     * @param parada Parada a ser removida
     */
    public void cancelarParada(Parada parada) {
        if (!this.paradas.contains(parada)) {
            throw new IllegalArgumentException("Não é possível remover uma parada que não está na lista de paradas da viagem");
        }

        this.status.add(this.indiceParada, StatusViagem.CANCELADA);
        this.indiceParada++;

    }

    /**
     * Inicia a viagem
     */
    public void iniciarViagem() {
        this.dataHoraSaida.add(this.indiceParada, LocalDateTime.now());
        this.status.add(this.indiceParada, StatusViagem.EM_ANDAMENTO);
    }

    /**
     * Finaliza a viagem
     */
    public void finalizarViagem() {
        this.dataHoraChegada.add(this.indiceParada, LocalDateTime.now());
        this.status.add(this.indiceParada, StatusViagem.FINALIZADA);
        this.indiceParada++;
    }

    /**
     * Adia a viagem em {@code x} horas e {@code y} minutos
     * @param horas a serem adicionadas à data de saída e chegada prevista
     * @param minutos a serem adicionados à data de saída e chegada prevista
     */
    public void adiarViagem(long horas, long minutos) {
        if (horas <= 0 || minutos <= 0) {
            throw new IllegalArgumentException("Horas e minutos devem ser maiores que zero");
        }

        this.dataHoraSaidaPrevista.get(this.indiceParada).plus(horas, ChronoUnit.HOURS).plus(minutos, ChronoUnit.MINUTES);
        this.dataHoraChegadaPrevista.get(this.indiceParada).plus(horas, ChronoUnit.HOURS).plus(minutos, ChronoUnit.MINUTES);
    }

    /**
     * Adianta a viagem em {@code x} horas e {@code y} minutos
     * @param horas a serem reduzidas à data de saída e chegada prevista
     * @param minutos a serem reduzidas à data de saída e chegada prevista
     */
    public void adiantarViagem(long horas, long minutos) {
        if (horas <= 0 || minutos <= 0) {
            throw new IllegalArgumentException("Horas e minutos devem ser maiores que zero");
        }

        this.dataHoraSaidaPrevista.get(this.indiceParada).plus(horas, ChronoUnit.HOURS).plus(minutos, ChronoUnit.MINUTES);
        this.dataHoraChegadaPrevista.get(this.indiceParada).plus(horas, ChronoUnit.HOURS).plus(minutos, ChronoUnit.MINUTES);
    }

    /**
     * Retorna uma representação em {@link String} da viagem
     * @return Uma representação em {@link String} da viagem
     */
    public String toString() {
        return "Viagem: {\n\tid: " + id + ",\n\tonibus: " + onibus + ",\n\tparadas: " + paradas + ",\n\tdataHoraSaidaPrevista: "
                + dataHoraSaidaPrevista + ",\n\tdataHoraChegadaPrevista: " + dataHoraChegadaPrevista + ",\n\tdataHoraSaida: "
                + dataHoraSaida + ",\n\tdataHoraChegada: " + dataHoraChegada + ",\n\tstatus: " + status + "\n}";
    }

    // getters e setters
    public UUID getId() {
        return id;
    }
    
    public Onibus getOnibus() {
        return onibus;
    }
    
    public Parada getParadaAtual() {
        return this.paradas.get(this.indiceParada);
    }
    
    
    public ArrayList<Parada> getParadas() {
        return paradas;
    }
    
    public void setParadas(ArrayList<Parada> paradas) {
        this.paradas = paradas;
    }
    
    public ArrayList<LocalDateTime> getDataHoraSaidaPrevista() {
        return dataHoraSaidaPrevista;
    }
    
    public void setDataHoraSaidaPrevista(ArrayList<LocalDateTime> dataHoraSaidaPrevista) {
        this.dataHoraSaidaPrevista = dataHoraSaidaPrevista;
    }
    
    public ArrayList<LocalDateTime> getDataHoraChegadaPrevista() {
        return dataHoraChegadaPrevista;
    }
    
    public void setDataHoraChegadaPrevista(ArrayList<LocalDateTime> dataHoraChegadaPrevista) {
        this.dataHoraChegadaPrevista = dataHoraChegadaPrevista;
    }
    
    public ArrayList<LocalDateTime> getDataHoraSaida() {
        return dataHoraSaida;
    }
    
    public void setDataHoraSaida(ArrayList<LocalDateTime> dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }
    
    public ArrayList<LocalDateTime> getDataHoraChegada() {
        return dataHoraChegada;
    }
    
    public void setDataHoraChegada(ArrayList<LocalDateTime> dataHoraChegada) {
        this.dataHoraChegada = dataHoraChegada;
    }
    
    public ArrayList<StatusViagem> getStatus() {
        return status;
    }
    
    public void setStatus(ArrayList<StatusViagem> status) {
        this.status = status;
    }
}
