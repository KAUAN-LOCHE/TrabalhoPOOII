package modelo;

import modelo.interfaces.Veiculo;

public class BilheteEletronicoValidator {
    /**
     * Função para validar a criação de um bilhete eletrônico.
     * Essa função valida:
     * - Se {@code passageiro} existe
     * - Se {@code viagem} existe
     * - Se {@code embarque} existe
     * - Se {@code desembarque} existe
     * - Se o número do assento é válido
     * - Se o passageiro já está em uma viagem
     * - Se o assento está disponível
     *
     * @param bilheteEletronico O bilhete eletrônico a ser validado
     * @param veiculo O veículo associado ao bilhete eletrônico
     * @throws IllegalArgumentException se qualquer uma das validações falhar
     */
    public static void validateBilheteEletronico(BilheteEletronico bilheteEletronico, Veiculo veiculo) {
        if (bilheteEletronico.getPassageiro() == null) {
            throw new IllegalArgumentException("Passageiro não pode ser nulo");
        }

        if (bilheteEletronico.getViagem() == null) {
            throw new IllegalArgumentException("Viagem não pode ser nula");
        }

        if (bilheteEletronico.getEmbarque() == null) {
            throw new IllegalArgumentException("Parada de embarque não pode ser nula");
        }

        if (bilheteEletronico.getDesembarque() == null) {
            throw new IllegalArgumentException("Parada de desembarque não pode ser nula");
        }

        if (bilheteEletronico.getNumAssento() < 0) {
            throw new IllegalArgumentException("Número do assento não pode ser menor que 0");
        }

        if (bilheteEletronico.getPassageiro().getEmViagem()) {
            throw new IllegalArgumentException("O passageiro em questão já está em uma viagem");
        }

        if (veiculo.getAssentos()[bilheteEletronico.getNumAssento()].getPassageiro() != null) {
            throw new IllegalArgumentException("Assento indisponível");
        }
    }
}
