package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import modelo.interfaces.ViagemObserver;
import modelo.interfaces.ViagemSubject;

public class ParadaDecorator implements ViagemSubject{
    private final UUID id;
    private LocalDateTime horarioPrevisto;
    private LocalDateTime horario;
    private boolean visitada;
    private ArrayList<ViagemObserver> observers;
    protected Parada parada;
    
    /**
     * Construtor da classe ParadaDecorator
     * @param parada
     * @param horarioPrevisto
     */
    public ParadaDecorator(Parada parada, LocalDateTime horarioPrevisto) {
        this.id = UUID.randomUUID();
        this.parada = parada;
        this.horarioPrevisto = horarioPrevisto;
        this.visitada = false;
        this.observers = new ArrayList<>();
    }

    /**
     * Adiciona um observador
     */
    @Override
    public void addObserver(ViagemObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Remove um observador
     */
    @Override
    public void removeObserver(ViagemObserver observer) {
        this.removeObserver(observer);
    }

    /**
     * Notifica os observadores
     */
    @Override
    public void notifyObservers() {
        for (ViagemObserver o : observers) {
            o.update();
        }
    }

    /**
     * Retorna o ID da parada
     * @return {@code UUID} paradaId
     */
    public UUID getParadaId() {
        return parada.getId();
    }

    /**
     * Retorna o ID da parada
     * @return {@code UUID} id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Retorna o horário previsto da parada
     * @return {@code LocalDateTime} horarioPrevisto
     */
    public LocalDateTime getHorarioPrevisto() {
        return horarioPrevisto;
    }

    /**
     * Determina o horário previsto da parada
     * @param horarioPrevisto
     */
    public void setHorarioPrevisto(LocalDateTime horarioPrevisto) {
        this.horarioPrevisto = horarioPrevisto;
    }

    /**
     * Retorna o horário da parada
     * @return {@code LocalDateTime} horario
     */
    public LocalDateTime getHorario() {
        return horario;
    }

    /**
     * Determina o horário da parada
     * @param horario
     */
    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    /**
     * Retorna se a parada foi visitada
     * @return {@code boolean} visitada
     */
    public boolean isVisitada() {
        return visitada;
    }

    /**
     * Determina se a parada foi visitada
     * @param visitada
     */
    public void visitar() {
        this.visitada = true;
        this.notifyObservers();
    }

    /**
     * Retorna a parada
     * @return {@code Parada} parada
     */
    public Parada getParada() {
        return parada;
    }

    /**
     * Representação textual da parada
     * @return {@code String} representação textual
     */
    public String toString() {

        //String do endereço e id de paradas
        
        String endereco = (parada == null) ? "Endereço não informado" : parada.getEndereco();
        String id = (parada == null) ? "ID não informado" : parada.getId().toString();

        return "id: " + this.id + "\nhorarioPrevisto: " + horarioPrevisto + "\nhorario: " + horario
                + "\nvisitada: " + visitada + "\nEndereço: " + endereco + "\nID da Parada: " + id;
 


    }
}
