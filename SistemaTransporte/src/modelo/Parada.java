package modelo;
import java.util.UUID;
public class Parada {

	
	private UUID id;
	
	// Atributos referentes à localização	
	private final String endereco;
	
	private boolean ativo;
	
	/**
	 * Construtor da classe Parada
	 * @param endereco
	 */
	public Parada(
			String endereco) 
	{
		this.endereco = endereco;
		this.id = UUID.randomUUID();
		this.ativo = true; // Por enquanto todas as paradas criadas são operacionais
	}
	
	
	// MÉTODOS -----------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Retorna se a parada está ativa
	 * @return boolean
	 */
	public boolean isAtivo(){
		return this.ativo; // Some condition can be checked in the future for this method to be relevant
	}
	
	// GETTERS AND SETTERS ==================================================================================================================================
	/**
	 * Retorna se a parada está ativa
	 * @return {@code boolean} ativo
	 */
	public boolean getAtivo() {
    	return this.ativo;
    }
    
	/**
	 * Atribui um valor booleano para ativo
	 * @param operacional
	 */
    public void setAtivo(boolean operacional) {
    	this.ativo= operacional;
    }

	/**
	 * Retorna o ID da parada
	 * @return {@code UUID} id
	 */
    public UUID getId() {
    	return this.id;
    }
	
	/**
	 * Retorna o endereço da parada
	 * @return
	 */
	public String getEndereco() {
		return "Endereço: " + this.endereco;
	}
	
	
}

