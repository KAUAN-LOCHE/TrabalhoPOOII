package modelo;

import modelo.enums.TipoAssento;

public class Assento {
    private Passageiro passageiro;
    private final TipoAssento tipo;

    /**
     * Construtor de Assento
     * @param tipo {@link TipoAssento} do assento
     */
    public Assento(TipoAssento tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica se o assento está ocupado
     * @return {@code true} se o assento estiver ocupado, {@code false} caso contrário
     */
    public boolean estaOcupado() {
        return passageiro != null;
    }

    /**
     * Retorna o passageiro que está ocupando o assento
     * @return {@code null} se estiver vazio, {@link Passageiro} caso contrário
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Atribui um passageiro ao assento
     * @param passageiro {@link Passageiro} a ser atribuído ao assento
     * @throws IllegalStateException se o assento já estiver ocupado
     */
    public void setPassageiro(Passageiro passageiro) {
        if (estaOcupado()) {
            throw new IllegalStateException("Assento ocupado");
        }

        this.passageiro = passageiro;
    }

    /**
     * Retorna o tipo do assento
     * @return {@link TipoAssento}
     */
    public TipoAssento getTipo() {
        return tipo;
    }

    public String toString() {
        return "Assento{" +
                "passageiro=" + passageiro +
                ", tipo=" + tipo +
                '}';
    }
}
