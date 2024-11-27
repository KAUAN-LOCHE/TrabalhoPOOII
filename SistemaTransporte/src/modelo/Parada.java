package modelo;

import modelo.interfaces.Localizacao;
import modelo.enums.TipoParada;
import modelo.enums.StatusViagem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Classe abstrata base para representar uma parada no sistema de transporte público.
 * Implementa a interface Localizacao e define atributos e comportamentos comuns
 * a todos os tipos de parada.
 *
 * @author [Enzo Racciatti]
 * @version 1.0
 * @since 2024-03-11
 */
public abstract class Parada implements Localizacao {
    
    /** Identificador único da parada */
    protected UUID id;

    // Atributos de endereço
    /** CEP da localização da parada */
    protected String cep;

    /** País onde a parada está localizada */
    protected String pais;

    /** Cidade onde a parada está localizada */
    protected String cidade;

    /** Bairro onde a parada está localizada */
    protected String bairro;

    /** Rua onde a parada está localizada */
    protected String rua;

    /** Número do endereço da parada */
    protected String numero;
    

    // Atributos de coordenadas
    /** Latitude da localização da parada */
    protected String latitude;

    /** Longitude da localização da parada */
    protected String longitude;


    /** Ponto de referência para localizar a parada */
    protected String referencia;

    /** Indica se a parada está operacional */
    protected boolean operacional;

    /** Horário de abertura da parada */
    protected LocalTime horarioAbertura;

    /** Horário de fechamento da parada */
    protected LocalTime horarioFechamento;

    /** Indica se a parada possui recursos de acessibilidade */
    protected boolean acessibilidade;


    
    /**
     * Construtor da classe Parada sem horário de funcionamento específico
     * 
     * @param bairro O bairro onde a parada está localizada
     * @param cep O CEP da localização
     * @param cidade A cidade onde a parada está localizada
     * @param latitude A latitude da localização
     * @param longitude A longitude da localização
     * @param numero O número do endereço
     * @param pais O país onde a parada está localizada
     * @param referencia O ponto de referência para localizar a parada
     * @param rua A rua onde a parada está localizada
     */ 
    protected Parada(String bairro, String cep, String cidade, String latitude, 
                    String longitude, String numero, String pais, 
                    String referencia, String rua) {
        this.id = UUID.randomUUID();
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numero = numero;
        this.pais = pais;
        this.referencia = referencia;
        this.rua = rua;
        this.operacional = true;
        this.horarioAbertura = LocalTime.of(0, 0); // Como o horário não foi especificado, a parada
        this.horarioFechamento = LocalTime.of(23, 59, 59); // é 24h por padrão
        
        // PENDENTE: Adicionar horário abertura e fechamento aqui e nas subclasses
    }
    
    /**
     * Construtor da classe Parada sem horário de funcionamento específico
     * 
     * @param bairro O bairro onde a parada está localizada
     * @param cep O CEP da localização
     * @param cidade A cidade onde a parada está localizada
     * @param latitude A latitude da localização
     * @param longitude A longitude da localização
     * @param numero O número do endereço
     * @param pais O país onde a parada está localizada
     * @param referencia O ponto de referência para localizar a parada
     * @param rua A rua onde a parada está localizada
     * @param horarioAbertura Horário de abertura da parada
     * @param horarioFechamento Horário de fechamento da parada
     */  
    
    protected Parada(String bairro, String cep, String cidade, String latitude, 
                    String longitude, String numero, String pais, 
                    String referencia, String rua, 
                    LocalTime horarioAbertura, 
                    LocalTime horarioFechamento) {
        this.id = UUID.randomUUID();
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numero = numero;
        this.pais = pais;
        this.referencia = referencia;
        this.rua = rua;
        this.operacional = true;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    
    // Métodos abstratos que as classes filhas devem implementar
    public abstract TipoParada getTipoParada();
    
    // Método concretos comum
    public String getEndereco() {
        return String.format("%s %s, %s, %s", rua, numero, bairro, cep);
    }

    // Verifica se a parada está operacional
    public boolean verificarDisponibilidade() {
        return (this.operacional && this.isActive()); 
    }

    // Checa se a parada está ativa baseada no horário
    private boolean isActive(){

        if(LocalTime.now().isAfter(horarioAbertura) && 
        		LocalTime.now().isBefore(horarioFechamento)) return true;

        return false;
    }
    
    // GETTERS
    
    public String getCoordenadas() {
        return String.format("Latitude: %s\nLongitude: %s", latitude, longitude);
    }
    public String getLongitude(){
        return this.longitude;
    }
    public String getLatitude(){
        return this.latitude;
    }

    public String getCidade() {
        return this.cidade;
    }
    
    public String getPais() {
        return this.pais;
    }
    public boolean getOperacional() {
        return this.operacional;
    }
    
    public String getBairro() {
        return this.bairro;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    
    public String getCep() {
        return this.cep;
    }
    
    
    public String getReferencia() {
        return this.referencia;
    }
    
    
    public String getRua() {
        return this.rua;
    }
    
    
    public boolean verificarAcessibilidade() {
        return acessibilidade;
    }

    public UUID getId() {
        return this.id;
    }
    
    public LocalTime getHorarioAbertura() {
        return horarioAbertura;
    }
    
    public LocalTime getHorarioFechamento() {
        return horarioFechamento;
    }
    
    // SETTERS
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
     
    }
    public void setOperacional(boolean operacional) {
        this.operacional= operacional;
    }
    public void setHorarioAbertura(LocalTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }
    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }
    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
}