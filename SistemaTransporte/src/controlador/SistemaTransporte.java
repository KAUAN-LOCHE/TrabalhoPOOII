package controlador;

import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada;
import modelo.ParadaDecorator;
import modelo.Passageiro;
import modelo.Viagem;
import modelo.ViagemOnibus;
import modelo.enums.TipoAssento;
import modelo.interfaces.Veiculo;
import modelo.Motorista;
import modelo.Assento;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;


import modelo.Motorista;
/**
 * A classe SistemaTransporte gerencia a frota de ônibus, motoristas, viagens, paradas e bilhetes eletrônicos.
 * Ela permite a manipulação de dados como a adição e remoção de ônibus, configuração de motoristas, rotas e 
 * manipulação de passageiros nos ônibus.
 */
public class SistemaTransporte {
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Motorista> motoristas;
    private ArrayList<Viagem> viagens;
    private ArrayList<BilheteEletronico> bilhetesEletronicos;
    private static SistemaTransporte instance;

    private SistemaTransporte() {
        veiculos = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
        bilhetesEletronicos = new ArrayList<>();
    }

    public static SistemaTransporte getInstance() {
        if (instance == null) {
            instance = new SistemaTransporte();
        }
        return instance;
    }

    /**
     * Retorna a lista de ônibus registrados no sistema.
     * @return Lista de ônibus.
     */
    public ArrayList<Onibus> getOnibus() {
        ArrayList<Onibus> onibus = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Onibus) {
                onibus.add((Onibus) v);
            }
        }
        return onibus;
    }

    /**
     * Retorna a lista de motoristas cadastrados no sistema.
     * @return Lista de motoristas.
     */
    public ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }

    /**
     * Retorna a lista de viagens cadastradas no sistema.
     * @return Lista de viagens.
     */
    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    // MÉTODOS RELATIVOS À CLASSE PASSAGEIRO
    // ========================================================================================

    /**
     * Cria um novo passageiro.
     * @param nome
     * @param idade
     * @param cpf
     * @param senha
     * @param endereco
     * @param telefone
     * @param tipoAssento
     * @return {@link Passageiro} criado.
     */
    public Passageiro createPassageiro(String nome, int idade, String cpf, String senha, String endereco,
            String telefone, TipoAssento tipoAssento) {
        Passageiro passageiro = new Passageiro(nome, idade, cpf, senha, telefone, tipoAssento);
        return passageiro;
    }

    /**
     * Define se um passageiro está em viagem ou não.
     * @param numVeiculo
     * @param cpf
     * @param emViagem
     */
    public void setEmViagem(int numVeiculo, String cpf, boolean emViagem) {
        Assento[] assentos = getAssentos(numVeiculo);
        for (Assento a : assentos) {
            if (a.getPassageiro() != null && a.getPassageiro().getCpf().equals(cpf)) {
                a.getPassageiro().setEmViagem(emViagem);
                return;
            }
        }
    }






    // MÉTODO RELATIVOS À CLASSE ÔNIBUS
    // ========================================================================================

    /**
     * Cria um novo ônibus.
     * @param capacidade
     * @param qdeAssentosPlusSize
     * @param qdeAssentosCadeirante
     * @param qdeAssentosIdoso
     * @param motorista
     * @param numero
     * @param rota
     * @return {@link Onibus} criado.
     */
    public Onibus createOnibus(int capacidade, int qdeAssentosPlusSize, int qdeAssentosCadeirante, int qdeAssentosIdoso,
            Motorista motorista, int numero, int rota) {
        Onibus onibus = new Onibus(capacidade, qdeAssentosPlusSize, qdeAssentosCadeirante, qdeAssentosIdoso, motorista,
                numero, rota);
        this.veiculos.add(onibus);
        return onibus;
    }

    /**
     * Define o número de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo
     * @param numero
     */
    public void setNumero(int numVeiculo, int numero) {
        for (int i = 0; i < this.veiculos.size(); i++) {
            if (this.veiculos.get(i) != null && this.veiculos.get(i).getNumero() == numVeiculo) {
                veiculos.get(i).setNumero(numero);
            }
        }
    }

    /**
     * Retorna a quantidade de passageiros em um ônibus específico pelo seu número de identificação.
     * @param numVeiculo
     * @return
     */
    public int getQuantidade(int numVeiculo) {

        for (int i = 0; i < this.veiculos.size(); i++) {
            if (this.veiculos.get(i) != null && this.veiculos.get(i).getNumero() == numVeiculo) {
                return veiculos.get(i).getLotacao();
            }
        }
        return -1;
    }


    /**
     * Retorna o número de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo
     * @return {@code int} número do ônibus, ou -1 se o ônibus não for encontrado.
     */

    public int getNumero(int numVeiculo) {

        for (int i = 0; i < this.veiculos.size(); i++) {
            if (this.veiculos.get(i) != null && this.veiculos.get(i).getNumero() == numVeiculo) {
                return veiculos.get(i).getNumero();
            }
        }
        return -1;
    }

    /**
     * Função que retorna a capacidade de um ônibus específico pelo seu número de identificação.
     * 
     * @param numVeiculo Número do ônibus.
     * @return {@code int} capacidade do ônibus, ou -1 se o ônibus não for encontrado. 
     */
    public int getCapacidade(int numVeiculo) {
        for (int i = 0; i < this.veiculos.size(); i++) {
            if (this.veiculos.get(i) != null && this.veiculos.get(i).getNumero() == numVeiculo) {
                return veiculos.get(i).getCapacidade();
            }
        }
        return -1;
    }

    /**
     * Define o motorista de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo Número do ônibus.
     * @param motorista Motorista a ser atribuído ao ônibus.
     */
    public void setMotorista(int numVeiculo, Motorista motorista) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                o.setMotorista(motorista);
                return;
            }
        }
    }

    /**
     * Retorna o motorista de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo Número do ônibus.
     * @return Motorista do ônibus, ou null se o ônibus não for encontrado.
     */
    public Motorista getMotorista(int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.getMotorista();
            }
        }
        return null;
    }

    /**
     * Define a rota de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo Número do ônibus.
     * @param rota Número da rota a ser atribuída ao ônibus.
     */
    public void setRota(int numVeiculo, int rota) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                o.setRota(rota);
                return;
            }
        }
    }

    /**
     * Retorna a rota de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo Número do ônibus.
     * @return Rota do ônibus, ou -1 se o ônibus não for encontrado.
     */
    public int getRota(int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.getRota();
            }
        }
        return -1;
    }

    /**
     * Retorna a lotação atual de um ônibus específico pelo seu número de identificação.
     * @param numVeiculo Número do ônibus.
     */
    public int getLotacao(int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.getLotacao();
            }
        }
        return -1;
    }

    /**
     * Adiciona um novo ônibus ao sistema.
     * @param veiculos Novo objeto de ônibus a ser adicionado.
     */
    public void adicionarOnibus(Onibus onibus) {
        this.veiculos.add(onibus);
    }

    /**
     * Remove um ônibus do sistema pelo número do ônibus.
     * @param numVeiculo Número do ônibus a ser removido.
     */
    public void removerOnibus(int numVeiculo) {
        this.veiculos.removeIf(o -> o.getNumero() == numVeiculo);
    }

    /**
     * Adiciona um passageiro ao ônibus especificado pelo número.
     * @param numVeiculo Número do ônibus onde o passageiro será adicionado.
     * @param passageiro Passageiro a ser adicionado.
     * @throws IllegalArgumentException Se o ônibus estiver cheio ou não houver assento adequado.
     */
    public void adicionarPassageiro(int numVeiculo, Passageiro passageiro, int assento) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                o.adicionarPassageiro(passageiro, assento);
                return;
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Busca o assento de um passageiro pelo CPF no ônibus especificado pelo número.
     * @param numVeiculo Número do ônibus onde será feita a busca.
     * @param cpf CPF do passageiro.
     * @return Assento do passageiro encontrado.
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado.
     */
    public Assento buscaAssentoPassageiro(Passageiro passageiro, int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.buscaAssentoPassageiro(passageiro);
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Remove um passageiro do ônibus especificado pelo número.
     * @param numVeiculo Número do ônibus onde o passageiro será removido.
     * @param cpf CPF do passageiro a ser removido.
     * @return Passageiro removido.
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado.
     */
    public Passageiro removerPassageiro(int numVeiculo, Passageiro passageiro) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.removePassageiro(passageiro);
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Retorna a lista de assentos de um ônibus pelo número.
     * @param numVeiculo Número do ônibus.
     * @return Array de assentos do ônibus, ou null se o ônibus não for encontrado.
     */
    public Assento[] getAssentos(int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o.getAssentos();
            }
        }
        return null;
    }

    /**
     * Retorna um ônibus pelo número.
     * @param numVeiculo
     * @return {@link Onibus} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Veiculo GetOnibus(int numVeiculo) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numVeiculo) {
                return o;
            }
        }
        return null;
    }


//MÉTODOS DA CLASSE ASSENTO ====================================================================================

    /**
     * Retorna um passageiro de um ônibus pelo número do ônibus e número do assento.
     * @param numVeiculo
     * @param numAssento
     * @return {@link Passageiro} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Passageiro getPassageiro(int numVeiculo, int numAssento) {
       Veiculo veiculos = GetOnibus(numVeiculo);
        return veiculos.getAssentos()[numAssento].getPassageiro();
    }

    /**
     * Retorna um passageiro de um ônibus pelo CPF.
     * @param numVeiculo
     * @param cpf
     * @return {@link Passageiro} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Passageiro getPassageiro(int numVeiculo, String cpf) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        for (Assento a : veiculos.getAssentos()) {
            if (a.getPassageiro() != null && a.getPassageiro().getCpf().equals(cpf)) {
                return a.getPassageiro();
            }
        }
        return null;
    }

    /**
     * Retorna um passageiro de um ônibus pelo nome e CPF.
     * @param numVeiculo
     * @param nome
     * @param cpf
     * @return {@link Passageiro} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Passageiro getPassageiro(int numVeiculo, String nome, String cpf) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        for (Assento a : veiculos.getAssentos()) {
            if (a.getPassageiro() != null && a.getPassageiro().getCpf().equals(cpf) && a.getPassageiro().getNome().equals(nome)) {
                return a.getPassageiro();
            }
        }
        
        return null;
    }

    /**
     * Define um passageiro para um assento de um ônibus.
     * @param numVeiculo
     * @param numAssento
     * @param passageiro
     */
    public void setPassageiro(int numVeiculo, int numAssento, Passageiro passageiro) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        veiculos.getAssentos()[numAssento].setPassageiro(passageiro);
    }

    /**
     * Verifica se um assento de um ônibus está ocupado.
     * @param numVeiculo
     * @param numAssento
     * @return {@code true} se o assento estiver ocupado, {@code false} caso contrário
     */
    public boolean estaOcupado(int numVeiculo, int numAssento) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        return veiculos.getAssentos()[numAssento].estaOcupado();
    }

    /**
     * Remove um passageiro de um assento de um ônibus.
     * @param numVeiculo
     * @param numAssento
     */
    public void removePassageiro(int numVeiculo, int numAssento) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        veiculos.getAssentos()[numAssento].removePassageiro();
    }

    /**
     * Retorna o tipo de assento de um passageiro de um ônibus.
     * @param numVeiculo
     * @param numAssento
     * @return {@link TipoAssento} do passageiro, ou {@code null} caso o assento esteja vazio.
     */
    public TipoAssento getTipoAssento(int numVeiculo, int numAssento) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        return veiculos.getAssentos()[numAssento].getTipo();
    }

    /**
     * Retorna o tipo de assento de um passageiro de um ônibus pelo CPF.
     * @param numVeiculo
     * @param cpf
     * @return {@link TipoAssento} do passageiro, ou {@code null} caso o assento esteja vazio.
     */

    public TipoAssento getTipoAssento(int numVeiculo, String cpf) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        for (Assento a : veiculos.getAssentos()) {
            if (a.getPassageiro() != null && a.getPassageiro().getCpf().equals(cpf)) {
                return a.getTipo();
            }
        }
        return null;
    }

    /**
     * Retorna informações de um assento de um ônibus.
     * @param numVeiculo
     * @param numAssento
     * @return {@code String} com informações do assento.
     */

    public String getAssentoInfo(int numVeiculo, int numAssento) {
        Veiculo veiculos = GetOnibus(numVeiculo);
        return veiculos.getAssentos()[numAssento].toString(); 
    }

    /**
     * Retorna informações de um assento de um ônibus pelo CPF.
     * @param numVeiculo
     * @param cpf
     * @return {@code String} com informações do assento.
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado.
     */
    public String getAssentoInfo(int numVeiculo, String cpf){
        Veiculo veiculos = GetOnibus(numVeiculo);
        for (Assento a : veiculos.getAssentos()) {
            if (a.getPassageiro() != null && a.getPassageiro().getCpf().equals(cpf)) {
                return a.toString();
            }
        }
        throw new IllegalArgumentException("Passageiro não encontrado.");
    }

            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================

    /**
     * Cria um novo motorista.
     * @param nome
     * @param idade
     * @param cpf
     * @param senha
     * @param cnh
     * @param experiencia
     * @param empresa
     * @param linhaOnibus
     * @return {@link Motorista} criado.
     */
    public Motorista createMotorista(String nome, int idade, String cpf, String senha, String cnh, int experiencia,
            String empresa, String linhaOnibus) {
        Motorista motorista = new Motorista(nome, idade, cpf, senha, cnh, experiencia, empresa, linhaOnibus);
        this.motoristas.add(motorista);
        return motorista;
    }

    /**
     * Retorna o nome da empresa de um motorista pelo CPF.
     * @param cpf
     * @return {@code String} com o nome da empresa, ou {@code null} caso o motorista não seja encontrado.
     */
    public String getEmpresa(String cpf) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                return motoristas.get(i).getEmpresa();
            }
        }
        return null;
    }

    /**
     * Retorna a linha de ônibus de um motorista pelo CPF.
     * @param cpf
     * @return {@code String} com a linha de ônibus, ou {@code null} caso o motorista não seja encontrado.
     */
    public String getLinhaOnibus(String cpf) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                return motoristas.get(i).getLinhaOnibus();
            }
        }
        return null;
    }

    /**
     * Retorna a experiência de um motorista pelo CPF.
     * @param cpf
     * @return {@code int} com a experiência, ou -1 caso o motorista não seja encontrado.
     */
    public int getExperiencia(String cpf) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                return motoristas.get(i).getExperiencia();
            }
        }
        return -1;
    }

    /**
     * Retorna a CNH de um motorista pelo CPF.
     * @param cpf
     * @return {@code String} com a CNH, ou {@code null} caso o motorista não seja encontrado.
     */
    public String getCnh(String cpf) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                return motoristas.get(i).getCnh();
            }
        }
        return null;
    }

    /**
     * Retorna o nome de um motorista pelo CPF.
     * @param cpf
     * @return {@code String} com o nome, ou {@code null} caso o motorista não seja encontrado.
     */
    public void setEmpresa(String cpf, String empresa) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setEmpresa(empresa);
            }
        }
    }

    /**
     * Define a linha de ônibus de um motorista pelo CPF.
     * @param cpf
     * @param linhaOnibus
     */
    public void setLinhaOnibus(String cpf, String linhaOnibus) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setLinhaOnibus(linhaOnibus);
            }
        }
    }

    /**
     * Define a experiência de um motorista pelo CPF.
     * @param cpf
     * @param experiencia
     */
    public void setExperiencia(String cpf, int experiencia) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setExperiencia(experiencia);
            }
        }
    }

    /**
     * Define a CNH de um motorista pelo CPF.
     * @param cpf
     * @param cnh
     */
    public void setCnh(String cpf, String cnh) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setCnh(cnh);
            }
        }
    }

    /**
     * Define o nome de um motorista pelo CPF.
     * @param cpf
     * @param nome
     */
    public void setNome(String cpf, String nome) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setNome(nome);
            }
        }
    }

    /**
     * Define a idade de um motorista pelo CPF.
     * @param cpf
     * @param idade
     */
    public void setIdade(String cpf, int idade) {
        for (int i = 0; i < this.motoristas.size(); i++) {
            if (this.motoristas.get(i) != null && this.motoristas.get(i).getCpf().equals(cpf)) {
                motoristas.get(i).setIdade(idade);
            }
        }
    }

    // MÉTODOS DA CLASSE VIAGEM ÔNIBUS
    // ====================================================================================

    /**
     * Cria uma nova viagem de ônibus.
     * @param veiculos
     * @param paradas
     * @return {@link Viagem} criada.
     */
    public Viagem createViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        Viagem viagem = new ViagemOnibus(onibus, paradas);
        this.viagens.add(viagem);
        return viagem;
    }

    /**
     * Retorna a lista de viagens de ônibus.
     * @return {@link ArrayList} de {@link Viagem}.
     */
    public ArrayList<Viagem> getAllViagensOnibusByDestino(ParadaDecorator destino, TipoAssento tipoAssento) {
        ArrayList<Viagem> viagensDisponiveis = new ArrayList<Viagem>();

        this.viagens.forEach(viagem -> {
            if (viagem.getParadas().contains(destino) && temAssentoDisponivel(viagem.getVeiculo(), tipoAssento)) {
                viagensDisponiveis.add(viagem);
            }
        });

        if (viagensDisponiveis.isEmpty()) {
            throw new IllegalArgumentException("Não há viagens disponíveis para o destino selecionado");
        }

        return viagensDisponiveis;
    }

    /**
     * Retorna se um Veículo tem assento disponível.
     * @param veiculo
     * @param tipoAssento
     * @return {@code true} se houver assento disponível, {@code false} caso contrário.
     */
    public boolean temAssentoDisponivel(Veiculo veiculo, TipoAssento tipoAssento) {
        for (int i = 0; i < veiculo.getAssentos().length; i++) {
            if (veiculo.getAssentos()[i].getTipo() == tipoAssento
                    && veiculo.getAssentos()[i].getPassageiro() == null) {
                return true;
            }
        }
        return false;
    }

   

    // MÉTODOS DA CLASSE PARADA
    // ====================================================================================
    /**
     * Cria uma nova parada.
     * @param endereco
     * @return {@link Parada} criada.
     */
    public Parada createParada(String endereco) {
        Parada parada = new Parada(endereco);
        return parada;
    }

    /**
     * Cria um novo decorador de parada.
     * @param parada
     * @param horarioPrevisto
     * @return {@link ParadaDecorator} criado.
     */
    public ParadaDecorator createParadaDecorator(Parada parada, LocalDateTime horarioPrevisto) {
        ParadaDecorator paradaDecorator = new ParadaDecorator(parada, horarioPrevisto);
        return paradaDecorator;
    }

    

    // MÉTODOS DA CLASSE BILHETEELETRÔNICO
    // ====================================================================================

    /**
     * Cria um novo bilhete eletrônico.
     * @param passageiro
     * @param viagem
     * @param embarque
     * @param desembarque
     * @param assento
     * @param horarioEmbarque
     * @return {@link BilheteEletronico} criado.
     */
    public BilheteEletronico createBilhete(Passageiro passageiro, Viagem viagem, ParadaDecorator embarque,
            ParadaDecorator desembarque, int assento, LocalDateTime horarioEmbarque) {
        BilheteEletronico bilheteEletronico = new BilheteEletronico(passageiro, viagem, embarque, desembarque, assento, horarioEmbarque);
        this.bilhetesEletronicos.add(bilheteEletronico);
        return bilheteEletronico;
    }

    /**
     * Retorna um Passageiro de um Bilhete Eletrônico pelo ID.
     * @param id
     * @return {@link Passageiro} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Passageiro getPassageiro(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
        return null;

    }

    /**
     * Retorna uma Viagem de um Bilhete Eletrônico pelo ID.
     * @param id
     * @return {@link Viagem} encontrada, ou {@code null} caso não seja encontrada.
     */
    public Viagem getViagem(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
        return null;
    }

    /**
     * Retorna a Poltrona de um Bilhete Eletrônico pelo ID.
     * @param id
     * @return {@link Parada} encontrada, ou {@code null} caso não seja encontrada.
     */

    public int getPoltrona(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getNumAssento();
            }
        }
        return -1;
    }

}
