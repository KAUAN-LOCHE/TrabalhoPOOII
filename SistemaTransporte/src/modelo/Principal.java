package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import controlador.SistemaTransporte;
//CLASSE QUE SERVIRÁ PARA TESTES E IMPLEMENTAÇÕES FUTURAS
import modelo.enums.TipoAssento;

public class Principal {
    public static void main(String[] args) {
        SistemaTransporte sis = new SistemaTransporte();

        // Criação de um passageiro
        Passageiro passageiroComum = sis.createPassageiro("Marcos", 42, "123456789", "4321", "outro endereço", "123321",
                TipoAssento.COMUM);
        // Criação de um motorista
        Motorista motorista = sis.createMotorista("João", 30, "123456789", "1234", "123456", 5, "Empresa", "Linha");

        // Criação de um ônibus
        Onibus onibus = sis.createOnibus(7, 3, 1, 2, motorista, 1, 1);

        // Criação de uma parada
        Parada local1 = sis.createParada("endereco de teste1");
        Parada local2 = sis.createParada("endereco de teste2");
        Parada local3 = sis.createParada("endereco de teste3");

        // Criação de uma array de paradas com horários
        ParadaDecorator parada1 = sis.createParadaDecorator(local1, LocalDateTime.parse("2024-11-10T10:15:30"));
        ParadaDecorator parada2 = sis.createParadaDecorator(local2, LocalDateTime.parse("2024-11-10T10:35:30"));
        ParadaDecorator parada3 = sis.createParadaDecorator(local3, LocalDateTime.parse("2024-11-10T10:45:30"));

        ArrayList<ParadaDecorator> paradas = new ArrayList<ParadaDecorator>();
        paradas.add(parada1);
        paradas.add(parada2);
        paradas.add(parada3);

        // Criação de uma viagem
        sis.createViagemOnibus(onibus, paradas);

        /*
         * A criação da viagem do passageiro seguiria o seguinte fluxo:
         * - Passageiro (usuário) seleciona a parada de destino
         * - Abre tela de exibição das ViagensOnibus que tem essa parada no trajeto e de
         * onde elas saem
         * - Passageiro seleciona a viagem que ele quer
         * 
         * Tendo em vista que esse fluxo foi seguido, ocorreriam as seguintes chamadas
         */

        ParadaDecorator destinoSelecionado = parada2;

        var tipoAssentoPassageiro1 = passageiroComum.getTipoAssento();

        ArrayList<Viagem> viagensDisponiveis = sis.getAllViagensOnibusByDestino(destinoSelecionado, tipoAssentoPassageiro1);
        Viagem viagemSelecionada = viagensDisponiveis.get(0);
        ArrayList<Number> posicoesDisponiveis = viagemSelecionada.getVeiculo().getPosicoesDisponiveis(tipoAssentoPassageiro1);
        Number posicaoSelecionada = posicoesDisponiveis.get(0);
        ParadaDecorator embarqueSelecionado = viagemSelecionada.getParadas().get(0);

        // Gera um bilhete para a viagem
        sis.createBilhete(passageiroComum, viagemSelecionada, embarqueSelecionado, destinoSelecionado, posicaoSelecionada.intValue(), LocalDateTime.now());

        System.out.println("Viagem do passageiro criada com sucesso!");

        /*
         * Quando uma um veiculo passar por uma de suas paradas,
         * o método visitarParada da viagem em questão é invocado
         * e a parada em questão é passada por parâmentro, assim 
         * finalizando a viagem do passageiro e atualizando o 
         * bilhete eletrônico.
         */
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());
        viagemSelecionada.visitarParada(destinoSelecionado.parada);
        System.out.println("Onibus passou pela parada.");
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());

    }
}
