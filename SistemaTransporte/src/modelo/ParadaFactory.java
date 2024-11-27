package modelo;

import modelo.enums.TipoParada;
import java.time.LocalTime;

/**
 * Factory para criação de diferentes tipos de parada.
 * Implementa o padrão Factory para encapsular a criação de objetos Parada.
 * 
 * @author [Enzo Racciatti]
 * @version 1.0
 * @since 2024-03-11
 */
public class ParadaFactory {
    
    /**
     * Cria uma nova parada com funcionamento 24 horas.
     * 
     * @param tipo O tipo da parada (URBANA ou RURAL)
     * @param bairro O bairro onde a parada está localizada
     * @param cep O CEP da localização
     * @param cidade A cidade onde a parada está localizada
     * @param latitude A latitude da localização
     * @param longitude A longitude da localização
     * @param numero O número do endereço
     * @param pais O país onde a parada está localizada
     * @param referencia O ponto de referência
     * @param rua A rua onde a parada está localizada
     * @param temCobertura (Parada Urbana) Indica se possui cobertura
     * @param temIluminacao (Parada Urbana) Indica se possui iluminação
     * @param temBanheiro (Parada Urbana) Indica se possui banheiro
     * @param acessoPavimentado (Parada Rural) Indica se possui acesso pavimentado
     * @param distanciaCidadeMaisProxima (Parada Rural) Distância até cidade mais próxima
     * @return Uma nova instância de Parada configurada para funcionamento 24h
     * @throws IllegalArgumentException se o tipo de parada for inválido
     */
    public static Parada criarParada24h(
            TipoParada tipo,
            String bairro,
            String cep,
            String cidade,
            String latitude,
            String longitude,
            String numero,
            String pais,
            String referencia,
            String rua,
            
            boolean temCobertura,
            boolean temIluminacao,
            boolean temBanheiro,
            boolean acessoPavimentado,
            double distanciaCidadeMaisProxima) {
        
        switch (tipo) {
            case URBANA:
                return new ParadaUrbana(
                    bairro, cep, cidade, 
                    latitude, longitude, numero,
                    pais, referencia, rua,
                    temCobertura, temIluminacao, temBanheiro
                );
                
            case RURAL:
                return new ParadaRural(
                    bairro, cep, cidade, 
                    latitude, longitude, numero,
                    pais, referencia, rua,
                    acessoPavimentado, distanciaCidadeMaisProxima
                );
                
            default:
                throw new IllegalArgumentException("Tipo de parada inválido: " + tipo);
        }
    }
    
    /**
     * Cria uma nova parada com horário de funcionamento específico.
     * 
     * @param tipo O tipo da parada (URBANA ou RURAL)
     * @param bairro O bairro onde a parada está localizada
     * @param cep O CEP da localização
     * @param cidade A cidade onde a parada está localizada
     * @param latitude A latitude da localização
     * @param longitude A longitude da localização
     * @param numero O número do endereço
     * @param pais O país onde a parada está localizada
     * @param referencia O ponto de referência
     * @param rua A rua onde a parada está localizada
     * @param horarioAbertura Horário de abertura da parada
     * @param horarioFechamento Horário de fechamento da parada
     * @param temCobertura (Parada Urbana) Indica se possui cobertura
     * @param temIluminacao (Parada Urbana) Indica se possui iluminação
     * @param temBanheiro (Parada Urbana) Indica se possui banheiro
     * @param acessoPavimentado (Parada Rural) Indica se possui acesso pavimentado
     * @param distanciaCidadeMaisProxima (Parada Rural) Distância até cidade mais próxima
     * @return Uma nova instância de Parada com horários específicos
     * @throws IllegalArgumentException se o tipo de parada for inválido
     */
    public static Parada criarParada(
            TipoParada tipo,
            String bairro, 
            String cep, 
            String cidade, 
            String latitude, 
            String longitude, 
            String numero,
            String pais, 
            String referencia, 
            String rua,
            LocalTime horarioAbertura, 
            LocalTime horarioFechamento,

            boolean temCobertura,
            boolean temIluminacao,
            boolean temBanheiro,
            boolean acessoPavimentado,
            double distanciaCidadeMaisProxima) {
        
        switch (tipo) {
            case URBANA:
                return new ParadaUrbana(
                    bairro, cep, cidade, 
                    latitude, longitude, numero,
                    pais, referencia, rua, horarioAbertura, horarioFechamento,
                    temCobertura, temIluminacao, temBanheiro
                );
                
            case RURAL:
                return new ParadaRural(
                    bairro, cep, cidade, 
                    latitude, longitude, numero,
                    pais, referencia, rua, horarioAbertura, horarioFechamento,
                    acessoPavimentado, distanciaCidadeMaisProxima
                );
                
            default:
                throw new IllegalArgumentException("Tipo de parada inválido: " + tipo);
        }
    }
}