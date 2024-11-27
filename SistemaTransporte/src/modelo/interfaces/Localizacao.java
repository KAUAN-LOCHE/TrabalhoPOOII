package modelo.interfaces;

import java.util.UUID;
/**
 * Interface para a classe abstrata Parada.
 */

public interface  Localizacao {
    public UUID getId();
    public String getLatitude();
    public String getLongitude();
    public String getCoordenadas();
    public String getEndereco();
}