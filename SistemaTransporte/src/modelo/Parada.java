package modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Parada {

	
	private UUID id;
	
	// Atributos referentes à localização	
	private String cidade;
	private String pais;
	private String latitude;
	private String longitude;	
	private String bairro;
	private String numero;
	private String cep;
	private String referencia;
	
	private boolean operacional;
	private boolean maoDupla;
	private String rua;
	
	// CONSTRUTOR
	public Parada(
			String bairro, 
			String cep, 
			String cidade, 
			String latitude, 
			String longitude, 
			boolean maoDupla, 
			String numero,
			String pais, 
			String referencia, 
			String rua) 
	{
		this.cidade = cidade;
		this.pais = pais;
		this.maoDupla = maoDupla;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.referencia = referencia;
		this.id = UUID.randomUUID();
		this.rua = rua;
		this.operacional = true; // Por enquanto todas as paradas criadas são operacionais
	}
	
	
	// MÉTODOS -----------------------------------------------------------------------------------------------------------------------------
	
	// Returns the stop's address
	public String getEnderecoFormatado() {
	    return rua + " " + numero + ", " + bairro + ", " + cep;
	}
	
	// Returns the stop's coordinates
	public String getCoordenadas() {
		return ("Latitude: " + this.latitude +
				"\nLongitude: " + this.longitude);
	}
	
	public boolean isOperational(){
		return this.operacional; // Some condition can be checked in the future for this method to be relevant
	}
	
	public String getBusTimes(ArrayList<Viagem> viagens){
		
		String information = "";
		
		// For each trip
		for(Viagem viagem:viagens) {
			
			// Save its relevant information
			ArrayList<LocalDateTime> arrivalTimes = viagem.getDataHoraChegada();
			ArrayList<LocalDateTime> departureTimes = viagem.getDataHoraSaida();
			Onibus onibus = viagem.getOnibus();
			ArrayList<StatusViagem> statusViagem = viagem.getStatus();
			
			// For each stop in that trip
			for(Parada parada: viagem.getParadas()) {
				
				// If the stop is this one 
				if(parada.getId() == this.id) {
						
					// Get the stop index
					int tripIndex = viagem.getParadas().indexOf(parada);
					
					//Add the relevant information to the output of this method
					information = information + 
									(
									
									"\nBus number: " + Integer.toString(onibus.getNumero()) +
									"\nStatus: " + statusViagem.get(tripIndex).name() +
									"\nArrival time: " + arrivalTimes.get(tripIndex) + 
									"\nDeparture time: " + departureTimes.get(tripIndex) + "\n\n"  
									
									);
					
				}
				
			}
			
		}
		
		return information;
	}
	
	// GETTERS AND SETTERS ==================================================================================================================================
	public String getCidade() {
        return this.cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public boolean getOperacional() {
    	return this.operacional;
    }
    
    public void setOperacional(boolean operacional) {
    	this.operacional= operacional;
    }

    public boolean getMaoDupla() {
        return this.maoDupla;
    }

    public void setMaoDupla(boolean maoDupla) {
        this.maoDupla = maoDupla;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public UUID getId() {
    	return this.id;
    }
	
	
}

