//CLASSE DEVERIA TER SIDO FEITA PELO LUCAS, MAS ELE NÃO CUMPRIU COM SUA PARTE, O QUE ATRAPALHOU PARTE DA INTEGRAÇÃO. ASSIM, FOI DESENVOLVIDA POR KAUAN LOCHE

package modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import modelo.enums.MetodoPagamento;

public class PagamentoPassagem {
    private final UUID id;
    private Passageiro passageiro;
    private Onibus onibus;
    private double valorPassagem;
    private boolean pago;
    private LocalDateTime dataHoraPagamento;
    private MetodoPagamento metodoPagamento;

    //Atributos relacionados ao bilhete eletrônico
    private Viagem viagem;
    private ParadaDecorator embarque;
    private ParadaDecorator desembarque;
    private int numAssento;
    private LocalDateTime horarioEmbarque;

    // Construtor
    public PagamentoPassagem(Passageiro passageiro, Onibus onibus, double valorPassagem, MetodoPagamento metodoPagamento,
            Viagem viagem, ParadaDecorator embarque, ParadaDecorator desembarque, int numAssento, LocalDateTime horarioEmbarque) {
        this.id = UUID.randomUUID();
        this.passageiro = passageiro;
        this.onibus = onibus;
        this.valorPassagem = valorPassagem;
        this.metodoPagamento = metodoPagamento;
        this.pago = false;
        this.dataHoraPagamento = null; // O pagamento ainda não foi feito

        //Atributos relacionados ao bilhete eletrônico
        this.viagem = viagem;
        this.embarque = embarque;
        this.desembarque = desembarque;
        this.numAssento = numAssento;
        this.horarioEmbarque = horarioEmbarque;
    }

    // Realiza o pagamento da passagem
    public BilheteEletronico realizarPagamento() {
        if (!pago) {
            this.pago = true;
            this.dataHoraPagamento = LocalDateTime.now();
            BilheteEletronico bilhete = new BilheteEletronico(passageiro, viagem, embarque, desembarque, numAssento,
                horarioEmbarque);
            return bilhete; // Pagamento realizado com sucesso
        }
        return null; // Pagamento já realizado
    }

    // Retorna o status do pagamento
    public boolean isPago() {
        return pago;
    }

    // Retorna o valor da passagem
    public double getValorPassagem() {
        return valorPassagem;
    }

    // Define o valor da passagem
    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    // Retorna a data e hora do pagamento
    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    // Retorna o método de pagamento utilizado
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    // Define o método de pagamento
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Representação textual da classe
    @Override
    public String toString() {
        return "PagamentoPassagem: {" +
                "id=" + id +
                ", passageiro=" + passageiro.getNome() +
                ", onibus=" + onibus.getNumero() +
                ", valorPassagem=" + valorPassagem +
                ", pago=" + pago +
                ", dataHoraPagamento=" + dataHoraPagamento +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }
}
