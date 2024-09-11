/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    //Construtor vazio
    public HorarioOnibus() {
    }
    
    //Construtor cheio
    public HorarioOnibus(ArrayList<Onibus> onibus, ArrayList<Parada> parada, ArrayList<LocalTime> horarios) {
        this.onibus = onibus;
        this.parada = parada;
        this.horarios = horarios;
    }
    
    //Métodos de utilização da classe
    public void adicionarHorario(Onibus o, Parada p, LocalTime h) {
        if (o == null || p == null || h == null) {
            throw new IllegalArgumentException("Ônibus, Parada ou Horário inválidos!");
        }
        this.onibus.add(o);
        this.parada.add(p);
        this.horarios.add(h);
    }
    
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
      
       public List<LocalTime> buscarHorariosPorOnibus(Onibus o) {
        List<LocalTime> horariosOnibus = new ArrayList<>();
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).equals(o)) {
                horariosOnibus.add(horarios.get(i));
            }
        }
        return horariosOnibus;
    }
       
    public List<Onibus> buscarOnibusPorParada(Parada p) {
        List<Onibus> onibusNaParada = new ArrayList<>();
        for (int i = 0; i < parada.size(); i++) {
            if (parada.get(i).equals(p)) {
                onibusNaParada.add(onibus.get(i));
            }
        }
        return onibusNaParada;
    }
    
    public void atualizarHorario(Onibus o, Parada p, LocalTime novoHorario) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).equals(o) && parada.get(i).equals(p)) {
                horarios.set(i, novoHorario);
                break;
            }
        }
    }
    
    public void listarHorarios() {
        for (int i = 0; i < onibus.size(); i++) {
            System.out.println("Ônibus: " + onibus.get(i).getNumero()+ //nao colocaram getter na classe, nao vou mexer por enqt pra nao prejudicar a classe do outro
                               " | Parada: " + parada.get(i).getId()+ //nao colocaram getter na classe, nao vou mexer por enqt pra nao prejudicar a classe do outro
                               " | Horário: " + horarios.get(i).toString());
        }
    }
    
    //Getters e Setters
    public ArrayList<Onibus> getOnibus() {
        return onibus;
    }

    public void setOnibus(ArrayList<Onibus> onibus) {
        this.onibus = onibus;
    }

    public ArrayList<Parada> getParada() {
        return parada;
    }

    public void setParada(ArrayList<Parada> parada) {
        this.parada = parada;
    }

    public ArrayList<LocalTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<LocalTime> horarios) {
        this.horarios = horarios;
    }
}
