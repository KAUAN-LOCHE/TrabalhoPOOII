package modelo;
import modelo.enums.TipoParada;

import java.time.LocalTime;

/**
 * Classe que representa uma parada em área rural.
 * Estende a classe Parada e adiciona atributos específicos para paradas rurais.
 * 
 * @author [Enzo Racciatti]
 * @version 1.0
 * @since 2024-03-11
 */

public class ParadaRural extends Parada {

    /** Indica se o acesso à parada é pavimentado */
    private boolean acessoPavimentado;

    /** Distância em quilômetros até a cidade mais próxima */
    private double distanciaCidadeMaisProxima;

    /** Indica se a parada possui abrigo */
    private boolean temAbrigo;
    
    /**
     * Construtor da classe ParadaRural, sem especificação de horário
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
     * @param acessoPavimentado Indica se o acesso é pavimentado
     * @param distanciaCidadeMaisProxima Distância até a cidade mais próxima em km
     */
    public ParadaRural(String bairro, String cep, String cidade, 
                      String latitude, String longitude, String numero,
                      String pais, String referencia, String rua,
                      boolean acessoPavimentado, 
                      double distanciaCidadeMaisProxima) {
        super(bairro, cep, cidade, latitude, longitude, numero, 
              pais, referencia, rua);
        this.acessoPavimentado = acessoPavimentado;
        this.distanciaCidadeMaisProxima = distanciaCidadeMaisProxima;
        this.temAbrigo = false; // padrão
    }
    
    /**
     * Construtor da classe ParadaRural, com horário de funcionamento definido
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
     * @param acessoPavimentado Indica se o acesso é pavimentado
     * @param distanciaCidadeMaisProxima Distância até a cidade mais próxima em km
     */
    public ParadaRural(String bairro, String cep, String cidade, 
                      String latitude, String longitude, String numero,
                      String pais, String referencia, String rua,
                      LocalTime horarioAbertura, 
                      LocalTime horarioFechamento,
                      boolean acessoPavimentado, 
                      double distanciaCidadeMaisProxima) {
        super(bairro, cep, cidade, latitude, longitude, numero, 
              pais, referencia, rua, horarioAbertura, horarioFechamento);
        this.acessoPavimentado = acessoPavimentado;
        this.distanciaCidadeMaisProxima = distanciaCidadeMaisProxima;
        this.temAbrigo = false; // padrão
    }

    @Override
    public TipoParada getTipoParada() {
        return TipoParada.RURAL;
    }

    
    public String getInformacoesAcesso() {
        return String.format(
            "Distância até cidade mais próxima: %.2f km\n" +
            "Acesso por estrada pavimentada: %s",
            distanciaCidadeMaisProxima,
            acessoPavimentado ? "Sim" : "Não"
        );
    }
    
    // Getters e Setters
    public boolean isAcessoPavimentado() {
        return acessoPavimentado;
    }

    public void setAcessoPavimentado(boolean acessoPavimentado) {
        this.acessoPavimentado = acessoPavimentado;
    }

    public double getDistanciaCidadeMaisProxima() {
        return distanciaCidadeMaisProxima;
    }

    public void setDistanciaCidadeMaisProxima(double distanciaCidadeMaisProxima) {
        if (distanciaCidadeMaisProxima >= 0) {
            this.distanciaCidadeMaisProxima = distanciaCidadeMaisProxima;
        }
    } 

    public boolean temAbrigo() {
        return temAbrigo;
    }

    public void setTemAbrigo(boolean temAbrigo) {
        this.temAbrigo = temAbrigo;
    }

}