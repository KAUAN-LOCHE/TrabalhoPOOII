package modelo;
import modelo.enums.TipoParada;

import java.time.LocalTime;
/**
* Representa uma parada em área urbana com características específicas de infraestrutura.
* 
* Esta classe estende a classe Parada e adiciona características específicas
* de paradas urbanas, como cobertura, iluminação, banheiro e Wi-Fi.
* 
* @author [Enzo Racciatti]
* @version 1.0
* @since [03/11/24]
* @see Parada
*/
public class ParadaUrbana extends Parada {

	/**
     * Indica se a parada possui cobertura.
     */
    private boolean temCobertura;

    /**
     * Indica se a parada possui iluminação.
     */
    private boolean temIluminacao;

    /**
     * Indica se a parada possui banheiro.
     */
    private boolean temBanheiro;

    /**
     * Indica se a parada possui serviço de Wi-Fi.
     */
    private boolean temWifi;

    /**
     * Construtor para criar uma parada urbana sem especificação de horário.
     * 
     * @param bairro Nome do bairro onde a parada está localizada
     * @param cep Código de Endereçamento Postal da parada
     * @param cidade Cidade onde a parada está localizada
     * @param latitude Coordenada de latitude da parada
     * @param longitude Coordenada de longitude da parada
     * @param numero Número do endereço da parada
     * @param pais País onde a parada está localizada
     * @param referencia Pontos de referência próximos à parada
     * @param rua Nome da rua onde a parada está localizada
     * @param temCobertura Indica se a parada possui cobertura
     * @param temIluminacao Indica se a parada possui iluminação
     * @param temBanheiro Indica se a parada possui banheiro
     */
    public ParadaUrbana(String bairro, String cep, String cidade, 
                       String latitude, String longitude, String numero,
                       String pais, String referencia, String rua,
                       boolean temCobertura, boolean temIluminacao, 
                       boolean temBanheiro) {
        super(bairro, cep, cidade, latitude, longitude, numero, 
              pais, referencia, rua);
        this.temCobertura = temCobertura;
        this.temIluminacao = temIluminacao;
        this.temBanheiro = temBanheiro;
        this.temWifi = false; // padrão
    }
    
    /**
     * Construtor para criar uma parada urbana com especificação de horário.
     * 
     * @param bairro Nome do bairro onde a parada está localizada
     * @param cep Código de Endereçamento Postal da parada
     * @param cidade Cidade onde a parada está localizada
     * @param latitude Coordenada de latitude da parada
     * @param longitude Coordenada de longitude da parada
     * @param numero Número do endereço da parada
     * @param pais País onde a parada está localizada
     * @param referencia Pontos de referência próximos à parada
     * @param rua Nome da rua onde a parada está localizada
     * @param horarioAbertura Horário de abertura da parada
     * @param horarioFechamento Horário de fechamento da parada
     * @param temCobertura Indica se a parada possui cobertura
     * @param temIluminacao Indica se a parada possui iluminação
     * @param temBanheiro Indica se a parada possui banheiro
     */
    	public ParadaUrbana(String bairro, String cep, String cidade, 
                       String latitude, String longitude, String numero,
                       String pais, String referencia, String rua,
                       LocalTime horarioAbertura, 
                       LocalTime horarioFechamento,
                       boolean temCobertura, boolean temIluminacao, 
                       boolean temBanheiro) {
        super(bairro, cep, cidade, latitude, longitude, numero, 
              pais, referencia, rua, horarioAbertura, horarioFechamento);
        this.temCobertura = temCobertura;
        this.temIluminacao = temIluminacao;
        this.temBanheiro = temBanheiro;
        this.temWifi = false; // padrão
    }

    @Override
    public TipoParada getTipoParada() {
        return TipoParada.URBANA;
    }
    
     // Getters e Setters
     public boolean temCobertura() {
        return temCobertura;
    }
    
    public void setTemCobertura(boolean temCobertura) {
        this.temCobertura = temCobertura;
    }
    
    public boolean temIluminacao() {
        return temIluminacao;
    }
    
    public void setTemIluminacao(boolean temIluminacao) {
        this.temIluminacao = temIluminacao;
    }
    
    public boolean temBanheiro() {
        return temBanheiro;
    }
    
    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }
    
    public boolean temWifi() {
        return temWifi;
    }
    
    public void setTemWifi(boolean temWifi) {
        this.temWifi = temWifi;
    }

}
