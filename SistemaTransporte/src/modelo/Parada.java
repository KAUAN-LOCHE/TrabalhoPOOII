package modelo;
import java.util.UUID;
public class Parada {

	
	private UUID id;
	
	// Atributos referentes à localização	
	private final String endereco;
	
	private boolean ativo;
	
	// CONSTRUTOR
	public Parada(
			String endereco) 
	{
		this.endereco = endereco;
		this.id = UUID.randomUUID();
		this.ativo = true; // Por enquanto todas as paradas criadas são operacionais
	}
	
	
	// MÉTODOS -----------------------------------------------------------------------------------------------------------------------------
	
	
	public boolean isAtivo(){
		return this.ativo; // Some condition can be checked in the future for this method to be relevant
	}
	
	// GETTERS AND SETTERS ==================================================================================================================================
    public boolean getAtivo() {
    	return this.ativo;
    }
    
    public void setAtivo(boolean operacional) {
    	this.ativo= operacional;
    }

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

