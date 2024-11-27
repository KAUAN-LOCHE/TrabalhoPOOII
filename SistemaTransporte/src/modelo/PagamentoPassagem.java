package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import modelo.enums.MetodoPagamento;
import modelo.interfaces.Veiculo;

public class PagamentoPassagem {
    private final UUID id;
    private Passageiro passageiro;
    private Onibus onibus;
    private double valorPassagem;
    private boolean pago;
    private LocalDateTime dataHoraPagamento;
    private MetodoPagamento metodoPagamento;

    /**
     * 
     * @param passageiro
     * @param valorPassagem
     * @param metodoPagamento
     * @param veiculo
     */
    public PagamentoPassagem(Passageiro passageiro, double valorPassagem, MetodoPagamento metodoPagamento, Veiculo veiculo) {
        this.id = UUID.randomUUID();
        this.passageiro = passageiro;
        this.valorPassagem = valorPassagem;
        this.metodoPagamento = metodoPagamento;
        this.pago = false;
        this.dataHoraPagamento = null; // O pagamento ainda não foi feito
        if (veiculo instanceof Onibus) {
            this.onibus = (Onibus) veiculo;
        } else {
            throw new IllegalArgumentException("Veículo inválido."); // Veículo inválido
        }
    }

    /**
     * Realiza o pagamento da passagem
     * @throws IllegalStateException se o pagamento já foi realizado
     */
    public void realizarPagamento() {
        if (pago) {
            throw new IllegalStateException("O pagamento já foi realizado."); // Pagamento já realizado
        }
        this.pago = true;
        this.dataHoraPagamento = LocalDateTime.now(); // Pagamento realizado com sucesso
    }

    /**
     * Verifica se a passagem foi paga
     * @return {@code true} se a passagem foi paga, {@code false} caso contrário
     */
    public boolean isPago() {
        return pago;
    }


    /**
     * Retorna o valor da passagem
     * @return {@code double} valorPassagem
     */
    public double getValorPassagem() {
        return valorPassagem;
    }

    /**
     * Define o valor da passagem
     * @param valorPassagem
     */
    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    /**
     * Retorna a data e hora do pagamento
     * @return {@code LocalDateTime} dataHoraPagamento
     */
    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    /**
     * Retorna o método de pagamento
     * @return {@code MetodoPagamento} metodoPagamento
     */
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

 
    /**
     * Retorna o id do pagamento
     * @return {@code UUID} id
     */
    public UUID getID(){
        return id;
    }

    /**
    * Define o método de pagamento
    * @param metodoPagamento
    */
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Representação textual do pagamento
     * @return {@code String} representação textual do pagamento
     */
    @Override
    public String toString() {
        return 
                "id: " + id +
                "\npassageiro: " + passageiro.getNome() +
                "\nonibus: " + onibus.getNumero() +
                "\nvalorPassagem: " + valorPassagem +
                "\npago: " + pago +
                "\ndataHoraPagamento: " + dataHoraPagamento +
                "\nmetodoPagamento: " + metodoPagamento;
    }
}
