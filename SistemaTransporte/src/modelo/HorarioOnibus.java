package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Junim
 */
public class HorarioOnibus {

    

    private ArrayList<Onibus> onibus;
    private ArrayList<Parada> parada;
    private ArrayList<LocalTime> horarios;
    
    /**
     * Construtor vazio
     */
    public HorarioOnibus() {
    }
    
    /**
     * Construtor da classe HorarioOnibus
     * @param onibus
     * @param parada
     * @param horarios
     */
    public HorarioOnibus(ArrayList<Onibus> onibus, ArrayList<Parada> parada, ArrayList<LocalTime> horarios) {
        this.onibus = onibus;
        this.parada = parada;
        this.horarios = horarios;
    }
    
    /**
     * Adiciona um horário de ônibus
     * @param o
     * @param p
     * @param h
     */
    public void adicionarHorario(Onibus o, Parada p, LocalTime h) {
        if (o == null || p == null || h == null) {
            throw new IllegalArgumentException("Ônibus, Parada ou Horário inválidos!");
        }
        this.onibus.add(o);
        this.parada.add(p);
        this.horarios.add(h);
    }
    
    /**
     * Remove um horário de ônibus
     * @param o
     * @param p
     */
    public void removerHorario(Onibus o, Parada p) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).equals(o) && parada.get(i).equals(p)) {
                onibus.remove(i);
                parada.remove(i);
                horarios.remove(i);
                break;
            }
        }
    }
      
    /**
     * Busca horários de ônibus por parada
     * @param o
     * @return {@code List<LocalTime>} horariosOnibus
     */
    public List<LocalTime> buscarHorariosPorOnibus(Onibus o) {
        List<LocalTime> horariosOnibus = new ArrayList<>();
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).equals(o)) {
                horariosOnibus.add(horarios.get(i));
            }
        }
        return horariosOnibus;
    }
       
    /**
     * Busca ônibus por parada
     * @param p
     * @return {@code List<Onibus>} onibusNaParada
     */
    public List<Onibus> buscarOnibusPorParada(Parada p) {
        List<Onibus> onibusNaParada = new ArrayList<>();
        for (int i = 0; i < parada.size(); i++) {
            if (parada.get(i).equals(p)) {
                onibusNaParada.add(onibus.get(i));
            }
        }
        return onibusNaParada;
    }
    
    /**
     * Atualiza horário de ônibus
     * @param o
     * @param p
     * @param novoHorario
     */
    public void atualizarHorario(Onibus o, Parada p, LocalTime novoHorario) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).equals(o) && parada.get(i).equals(p)) {
                horarios.set(i, novoHorario);
                break;
            }
        }
    }
    
    /**
     * Lista horários de ônibus
     */
    public void listarHorarios() {
        for (int i = 0; i < onibus.size(); i++) {
            System.out.println("Ônibus: " + onibus.get(i).getNumero()+ //nao colocaram getter na classe, nao vou mexer por enqt pra nao prejudicar a classe do outro
                               " | Parada: " + parada.get(i).getId()+ //nao colocaram getter na classe, nao vou mexer por enqt pra nao prejudicar a classe do outro
                               " | Horário: " + horarios.get(i).toString());
        }
    }
    
    /**
     * Retorna a lista de ônibus
     * @return {@code ArrayList<Onibus>} onibus
     */
    public ArrayList<Onibus> getOnibus() {
        return onibus;
    }

    /**
     * Define a lista de ônibus
     * @param onibus
     */
    public void setOnibus(ArrayList<Onibus> onibus) {
        this.onibus = onibus;
    }

    /**
     * Retorna a lista de paradas
     * @return {@code ArrayList<Parada>} parada
     */
    public ArrayList<Parada> getParada() {
        return parada;
    }

    /**
     * Define a lista de paradas
     * @param parada
     */
    public void setParada(ArrayList<Parada> parada) {
        this.parada = parada;
    }

    /**
     * Retorna a lista de horários
     * @return {@code ArrayList<LocalTime>} horarios
     */
    public ArrayList<LocalTime> getHorarios() {
        return horarios;
    }

    /**
     * Define a lista de horários
     * @param horarios
     */
    public void setHorarios(ArrayList<LocalTime> horarios) {
        this.horarios = horarios;
    }
}
