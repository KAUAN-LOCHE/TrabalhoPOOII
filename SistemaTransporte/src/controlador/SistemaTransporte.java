package controlador;

import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.PagamentoPassagem;
import modelo.Parada;
import modelo.ParadaDecorator;
import modelo.Passageiro;
import modelo.Viagem;
import modelo.ViagemOnibus;
import modelo.enums.MetodoPagamento;
import modelo.enums.TipoAssento;
import modelo.interfaces.Veiculo;
import modelo.Motorista;
import modelo.Assento;
import modelo.UsuarioBase;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.time.LocalTime;


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
    private ArrayList<Parada> paradas;
    private ArrayList<ParadaDecorator> decParadas;
    private static SistemaTransporte instance;
    private ArrayList<Passageiro> passageiros;
    private ArrayList<PagamentoPassagem> pagamentosPassagem;

    private SistemaTransporte() {
        veiculos = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
        bilhetesEletronicos = new ArrayList<>();
        passageiros = new ArrayList<>();
        paradas = new ArrayList<>();
        decParadas = new ArrayList<>();
        pagamentosPassagem = new ArrayList<>();
    }

    /**
     * Retorna a instância única da classe SistemaTransporte.
     * @return Instância única da classe.
     */
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

    /**
     * Retorna a lista de paradas cadastradas no sistema.
     * @return {@link ArrayList} de {@link ParadaDecorator}.
     */
    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    /**
     * Retorna a lista de bilhetes eletrônicos cadastrados no sistema.
     * @return {@link ArrayList} de {@link BilheteEletronico}.
     */
    public ArrayList<BilheteEletronico> getBilhetesEletronicos() {
        return bilhetesEletronicos;
    }

    /**
     * Retorna a lista de paradas cadastradas no sistema.
     * @return {@link ArrayList} de {@link Parada}.
     */
    public ArrayList<Parada> getParadas() {
        return paradas;
    }

    /**
     * Retorna a lista de paradas decoradas cadastradas no sistema.
     * @return {@link ArrayList} de {@link ParadaDecorator}.
     */
    public ArrayList<ParadaDecorator> getDecParadas() {
        if (decParadas == null) {
            decParadas = new ArrayList<>();
        }
        return decParadas;
    }

    /**
     * Retorna a lista de pagamentos de passagem cadastrados no sistema.
     * @return {@link ArrayList} de {@link PagamentosPassagem}.
     */
    public ArrayList<PagamentoPassagem> getPagamentosPassagem() {
        return pagamentosPassagem;
    }


    // MÉTODOS RELATIVOS À CLASSE PASSAGEIRO
    // ========================================================================================

    /**
     * Verifica se um passageiro está cadastrado no sistema.
     * @param senha
     * @param cpf
     * @param nome
     * @return
     */
    public int verificarPassageiro(String senha, String cpf, String nome) {
        if (this.passageiros == null) {
            return 0;
        }
        for (Passageiro p : this.passageiros) {
            if (p.getCpf().equals(cpf) && p.getSenha().equals(senha) && p.getNome().equals(nome)) {
                return 1;
            }
        }
        return 0;
    }

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
    public void addPassageiro(String nome, int idade, String cpf, String senha, String endereco,
        String telefone, TipoAssento tipoAssento) {
        Passageiro passageiro = new Passageiro(nome, idade, cpf, senha, telefone, tipoAssento);
        this.passageiros.add(passageiro);
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

    /**
     * 
     * @param cpf
     * @return
     */
    public Passageiro getPassageiroCPF(String cpf) {
        for (Passageiro p : this.passageiros) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

   /**
    * Retorna o número do assento de um passageiro em um ônibus.
    * @param numOnibus
    * @param cpf
    * @return
    */
    public int getNumAssento(int numOnibus, String cpf) {
        Veiculo veiculos = GetOnibus(numOnibus);
        if(veiculos == null){
            return -1;
        }
        for(int i = 0; i < veiculos.getAssentos().length; i++){
            if(veiculos.getAssentos()[i].getPassageiro() != null && veiculos.getAssentos()[i].getPassageiro().getCpf().equals(cpf)){
                return i + 1;
            }
        }
        return -1;
        
    }

    /**
     * Retorna o número do assento de um passageiro em um ônibus.
     * @param cpf
     * @return {@code int} número do assento, ou -1 se o passageiro não for encontrado.
     */
    public int procurarPassageiroTodosVeiculos(String cpf) {
        for (Veiculo o : this.veiculos) {
            for (int i = 0; i < o.getAssentos().length; i++) {
                if (o.getAssentos()[i].getPassageiro() != null && o.getAssentos()[i].getPassageiro().getCpf().equals(cpf)) {
                    return o.getNumero();
                }
            }
        }
        return -1;
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
    public void addOnibus(int capacidade, int qdeAssentosPlusSize, int qdeAssentosCadeirante, int qdeAssentosIdoso,
            Motorista motorista, int numero, int rota) {
        Onibus onibus = new Onibus(capacidade, qdeAssentosPlusSize, qdeAssentosCadeirante, qdeAssentosIdoso, motorista,
                numero, rota);
        this.veiculos.add(onibus);
        
    }
    /**
     * Retorna um ônibus pelo número.
     * @param numero
     * @return
     */
    public Onibus getOnibusNumero(int numero) {
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numero) {
                return (Onibus) o;
            }
        }
        return null;
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
    public void setMotoristaOnibus(int numVeiculo, Motorista motorista) {
        Onibus onibus = getOnibusNumero(numVeiculo);
        onibus.setMotorista(motorista);
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
        if (this.veiculos.isEmpty()) {
            throw new IllegalArgumentException("Ônibus não encontrado.");
        }
        this.veiculos.removeIf(o -> o.getNumero() == numVeiculo);

        //Remover Onibus de todas as viagens
        for (Viagem v : this.viagens) {
            if (v.getVeiculo() != null && v.getVeiculo().getNumero() == numVeiculo) {
                v.setVeiculo(null);
            }
        }
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
    public void removerPassageiro(int numOnibus, String cpf) {
        if (this.passageiros.isEmpty()) {
            throw new IllegalArgumentException("Passageiro não encontrado.");
        }
        for (Veiculo o : this.veiculos) {
            if (o.getNumero() == numOnibus) {
               for(int i = 0; i < o.getAssentos().length; i++){
                   if(o.getAssentos()[i].getPassageiro() != null && o.getAssentos()[i].getPassageiro().getCpf().equals(cpf)){
                       o.getAssentos()[i].removePassageiro();
                       return;
                   }
               }
            }
        }

        this.passageiros.removeIf(p -> p.getCpf().equals(cpf));

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
    public void addMotorista(String nome, int idade, String cpf, String senha, String cnh, int experiencia,
        String empresa, String linhaOnibus) {
        Motorista motorista = new Motorista(nome, idade, cpf, senha, cnh, experiencia, empresa, linhaOnibus);
        this.motoristas.add(motorista);
    }

    /**
     * Adiciona um motorista ao sistema.
     * @param motorista
     */
    public void removerMotorista(Motorista motorista) {
        if (motorista == null) {
            throw new IllegalArgumentException("Motorista não encontrado.");
        }
        this.motoristas.remove(motorista);
        //percorrer a lista de ônibus e remover o motorista de todos os ônibus que ele dirige
        for (Veiculo o : this.veiculos) {
            if (o.getMotorista() != null && o.getMotorista().getCpf().equals(motorista.getCpf())) {
                o.setMotorista(null);
            }
        }
    }

    /**
     * Retorna um motorista pelo CPF.
     * @param cpf
     * @return {@link Motorista} encontrado, ou {@code null} caso não seja encontrado.
     */
    public Motorista getMotoristaCPF(String cpf) {
        for (Motorista m : this.motoristas) {
            if (m.getCpf().equals(cpf)) {
                return m;
            }
        }
        return null;
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
     */
    public void addViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        Viagem viagem = new ViagemOnibus(onibus, paradas);
        this.viagens.add(viagem);
    }

    /**
     * Retorna uma viagem de ônibus pelo ID.
     * @param idViagem
     * @param paradas
     */
    public void setParadasViagem(String idViagem, ArrayList<ParadaDecorator> paradas) {
        Viagem viagem = getViagemId(idViagem);
        viagem.setParadas(paradas);
    }

    // public void addVeiculoViagem(String idViagem,String numOnibus){
    //     Veiculo veiculo = GetOnibus(Integer.parseInt(numOnibus));
    //     Viagem viagem = getViagemId(idViagem);
    //     viagem.setVeiculo(veiculo);
    // }

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
     * Retorna a lista de viagens de ônibus.
     * @param numVeiculo
     * @param cpf
     */
    public void addPassageiroOnibus(int numVeiculo, String cpf) {
        Passageiro passageiro = getPassageiroCPF(cpf);
        Veiculo veiculo = GetOnibus(numVeiculo);
        for (int i = 0; i < veiculo.getAssentos().length; i++) {
            if (veiculo.getAssentos()[i].getTipo() == passageiro.getTipoAssento()
                    && veiculo.getAssentos()[i].getPassageiro() == null) {
                veiculo.getAssentos()[i].setPassageiro(passageiro);
                return;
            }
        }
        throw new IllegalArgumentException("Não há assentos disponíveis para o tipo de assento selecionado.");
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
    public void addParada(String endereco) {
        Parada parada = new Parada(endereco);
        this.paradas.add(parada);
        
    }

    /**
     * Cria um novo decorador de parada.
     * @param endereco
     * @param horarioPrevisto
     * @return {@link ParadaDecorator} criado.
     */
    public void addParadaDecorator(String endereco, LocalDateTime horarioPrevisto) {
        Parada parada = getParadaEndereco(endereco);
        ParadaDecorator paradaDecorator = new ParadaDecorator(parada, horarioPrevisto);
        decParadas.add(paradaDecorator);
    }

    /**
     * Remove uma parada do sistema pelo endereço.
     * @param idViagem
     * @param endereco
     */
    public void removerParadaViagem(String idViagem, String endereco){
        Viagem viagem = getViagemId(idViagem);
        viagem.removerParada(endereco);
    }

    /**
     * Retorna uma parada pelo endereço.
     * @param endereco
     * @return {@link Parada} encontrada, ou {@code null} caso não seja encontrada.
     */
    public ParadaDecorator getParadaDecorator(String endereco) {
        for (ParadaDecorator p : this.decParadas) {
            if (p.getParada().getEndereco().equals(endereco)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Retorna uma parada pelo ID.
     * @param id
     * @return {@link Parada} encontrada, ou {@code null} caso não seja encontrada.
     */
    public ParadaDecorator getParadaDecoratorId(String id) {
        for (ParadaDecorator p : this.decParadas) {
            if (p.getId().toString().equals(id)) {
                return p;
            }
        }
        return null;
    }


    /**
     * Retorna uma parada pelo ID.
     * @param id
     * @return {@link Parada} encontrada, ou {@code null} caso não seja encontrada.
     */
    public Parada getParadaId(String id) {
        for (Parada p : this.paradas) {
            if (p.getId().toString().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Retorna uma parada pelo endereço.
     * @param endereco 
     * @return {@link Parada} encontrada, ou {@code null} caso não seja encontrada.
     */
    public Parada getParadaEndereco(String endereco) {
        for (Parada p : this.paradas) {
            if (p.getEndereco().equals(endereco)) {
                return p;
            }
        }
        return null;
    }


    // MÉTODOS DA CLASSE VIAGEM
    // =================================================

    /**
     * Retorna uma viagem pelo ID.
     * @param id 
     * @return {@link Viagem} encontrada, ou {@code null} caso não seja encontrada.
     */
    public Viagem getViagemId(String id) {
        for (Viagem v : this.viagens) {
            if (v.getId().toString().equals(id)) {
                return v;
            }
        }
        return null;
    }


    /**
     * Adiciona uma parada a uma viagem.
     * @param idViagem
     * @param parada
     */
    public void addParadaViagem(String idViagem, ParadaDecorator parada) {
        Viagem viagem = getViagemId(idViagem);
        //viagem.adicionarParada(parada);
    }

    /**
     * Define que um ônibus fará uma viagem.
     * @param idViagem
     * @param numOnibus
     */
    public void setOnibusViagem(String idViagem, int numOnibus) {
        Veiculo veiculo = GetOnibus(numOnibus);
        Viagem viagem = getViagemId(idViagem);
        if(viagem == null){
            throw new IllegalArgumentException("Viagem não encontrada.");
        }
        if (veiculo == null) {
            throw new IllegalArgumentException("Ônibus não encontrado.");
        }else{
            viagem.setVeiculo(veiculo);
        }
    }

    /**
     * Define o motorista de um ônibus em uma viagem.
     * @param idViagem
     */
    public void removerViagem(String idViagem) {
        Viagem viagem = getViagemId(idViagem);
        this.viagens.remove(viagem);
    }

    
    // MÉTODOS DA CLASSE BILHETEELETRÔNICO
    // ====================================================================================

    public String getBilheteEletronico(String cpfCliente){
        for (BilheteEletronico b : this.bilhetesEletronicos) {
            if (b.getPassageiro().getCpf().equals(cpfCliente)) {
                return b.getID().toString();
            }
        }
        return null;
    }

    /**
     * Adiciona um bilhete eletrônico ao sistema.
     * @param cpf
     * @param viagem
     * @param embarque
     * @param desembarque
     */
    public void addBilhete(String cpf, Viagem viagem, String embarque, String desembarque) {
        Passageiro passageiro = getPassageiroCPF(cpf);
        ParadaDecorator embarqueParada = getParadaDecoratorId(embarque);
        ParadaDecorator desembarqueParada = getParadaDecoratorId(desembarque);
        Onibus onibus = (Onibus) viagem.getVeiculo();
        onibus.adicionarPassageiro(passageiro);
        int assento = getNumAssento(onibus.getNumero(), passageiro.getCpf());
        
        if (assento == -1) {
            throw new IllegalArgumentException("Assento não encontrado.");
        }
        if (embarqueParada == null || desembarqueParada == null) {
            throw new IllegalArgumentException("Parada não encontrada.");
        }
        BilheteEletronico bilheteEletronico = new BilheteEletronico(passageiro, viagem, embarqueParada, desembarqueParada, assento, embarqueParada.getHorarioPrevisto());
        this.bilhetesEletronicos.add(bilheteEletronico);
    }

    /**
     * Retorna um bilhete eletrônico pelo ID.
     * @param id
     * @return {@link BilheteEletronico} encontrado, ou {@code null} caso não seja encontrado.
     */
    public BilheteEletronico getBilheteId(String id) {
        for (BilheteEletronico b : this.bilhetesEletronicos) {
            if (b.getID().toString().equals(id)) {
                return b;
            }
        }
        return null;
        
    }
    /**
     * Retorna um bilhete eletrônico pelo ID.
     * @param id
     * @return {@link BilheteEletronico} encontrado, ou {@code null} caso não seja encontrado.
     */
    public void removerBilhete(String id) {
        BilheteEletronico bilhete = getBilheteId(id);
        this.bilhetesEletronicos.remove(bilhete);
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

    // MÉTODOS DA CLASSE PAGAMENTOPASSAGEM
    // ====================================================================================
    /**
     * Adiciona um pagamento de passagem ao sistema.
     * @param cpf
     * @param valorPassagem
     * @param metodoPagamento
     */
    public void addPagamentoPassagem(String cpf, double valorPassagem, MetodoPagamento metodoPagamento, Viagem viagem) {
        Passageiro passageiro = getPassageiroCPF(cpf);
        PagamentoPassagem pagamentoPassagem = new PagamentoPassagem(passageiro, valorPassagem, metodoPagamento, viagem.getVeiculo());
        this.pagamentosPassagem.add(pagamentoPassagem);
    }

    /**
     * Retorna um pagamento de passagem pelo ID.
     * @param id
     * @return {@link PagamentoPassagem} encontrado, ou {@code null} caso não seja encontrado.
     */
    public PagamentoPassagem getPagamentoPassagemId(String id) {
        for (PagamentoPassagem p : this.pagamentosPassagem) {
            if (p.getID().toString().equals(id)) {
                return p;
            }
        }
        return null;
    }

}
