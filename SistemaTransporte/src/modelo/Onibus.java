package modelo;

import modelo.enums.TipoAssento;

public class Onibus {
    private final int capacidade;
    private int rota, numero, lotação;
    private Assento[] assentos;
    private Motorista motorista;

    /**
     * Construtor da classe Onibus
     * @param capacidade
     * @param qdeAssentosPlusSize quantidade de assentos dedicados a pessoas grávidas ou obesas
     * @param qdeAssentoCadeirante quantidade de assentos dedicados a cadeirantes ou deficientes físicos
     * @param qdeAssentosIdoso quantidade de assentos dedicados a idosos
     * @param motorista
     * @param numero
     * @param rota
     */
    public Onibus(int capacidade, int qdeAssentosPlusSize, int qdeAssentoCadeirante, int qdeAssentosIdoso,
            Motorista motorista, int numero, int rota) {
        this.numero = numero;
        this.rota = rota;
        this.capacidade = capacidade;
        this.assentos = new Assento[capacidade];
        this.lotação = 0;
        this.motorista = motorista;
        this.inicializarAssentos(qdeAssentosPlusSize, qdeAssentoCadeirante, qdeAssentosIdoso);
    }

    /**
     * Inicializa os assentos do ônibus de acordo com a quantidade de assentos especiais
     * @param qdeAssentosPlusSize
     * @param qdeAssentoCadeirante
     * @param qdeAssentosIdoso
     */
    public void inicializarAssentos(int qdeAssentosPlusSize, int qdeAssentoCadeirante, int qdeAssentosIdoso) {
        int posAssento = 0;

        for (; posAssento < qdeAssentoCadeirante; posAssento++) {
            this.assentos[posAssento + qdeAssentosPlusSize] = new Assento(TipoAssento.CADEIRANTE);
        }

        for (; posAssento < qdeAssentosIdoso; posAssento++) {
            this.assentos[posAssento + qdeAssentosPlusSize + qdeAssentoCadeirante] = new Assento(TipoAssento.IDOSO);
        }

        for (; posAssento < qdeAssentosPlusSize; posAssento++) {
            this.assentos[posAssento] = new Assento(TipoAssento.PLUS_SIZE);
        }

        for (; posAssento < this.capacidade; posAssento++) {
            this.assentos[posAssento] = new Assento(TipoAssento.COMUM);
        }
    }

    /**
     * @return {@code Motorista} do ônibus
     */
    public Motorista getMotorista() {
        return motorista;
    }

    /**
     * Determina o motorista do ônibus
     * @param motorista
     */
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    /**
     * Retorna a capacidade do ônibus
     * @return {@code int} capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Retorna a rota do ônibus
     * @return {@code int} rota
     */
    public int getRota() {
        return rota;
    }

    /**
     * Determina a rota do ônibus
     * @param rota
     */
    public void setRota(int rota) {
        this.rota = rota;
    }

    /**
     * Retorna o número do ônibus
     * @return {@code int} número
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna a lotação do ônibus
     * @return {@code int} lotação
     */
    public int getLotacao() {
        return lotação;
    }

    /**
     * Determina o número do ônibus
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Retorna os assentos do ônibus
     * @return {@code Assento[]} assentos
     */
    public Assento[] getAssentos() {
        return assentos;
    }

    /**
     * Adiciona um passageiro ao ônibus no primeiro assento disponível do tipo do passageiro
     * @param passageiro Passageiro a ser adicionado
     * @throws IllegalArgumentException Caso o ônibus esteja cheio
     * @throws IllegalArgumentException Caso não haja assentos disponíveis para o tipo do passageiro
     */
    public void adicionarPassageiro(Passageiro passageiro) {
        if (this.lotação >= this.capacidade) {
            throw new IllegalArgumentException("Onibus cheio");
        }

        for (int i = 0; i < this.capacidade; i++) {
            if (this.assentos[i] == null && this.assentos[i].getTipo() == passageiro.getTipoAssento()) {
                this.assentos[i].setPassageiro(passageiro);
                this.lotação++;
                break;
            }
        }

        throw new IllegalArgumentException("Não há assentos disponíveis para o tipo de assento do passageiro");
    }

    /**
     * Busca o assento de um passageiro pelo CPF
     * @param cpf CPF do passageiro
     * @return {@code Assento} do passageiro
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado
     */
    public Assento buscaAssentoPassageiro(String cpf) {
        for (int i = 0; i < this.capacidade; i++) {
            if (this.assentos[i] != null && this.assentos[i].getPassageiro().getCpf().equals(cpf)) {
                return this.assentos[i];
            }
        }

        throw new IllegalArgumentException("Passageiro não encontrado");
    }

    /**
     * Remove um passageiro do ônibus
     * @param cpf CPF do passageiro
     * @return {@code Passageiro} removido
     */
    public Passageiro removePassageiro(String cpf) {
        Assento assento = this.buscaAssentoPassageiro(cpf);

        Passageiro passageiro = assento.getPassageiro();
        
        assento.setPassageiro(null);
        this.lotação--;

        return passageiro;
    }

}
