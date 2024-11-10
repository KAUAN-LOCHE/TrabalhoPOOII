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

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;

import modelo.Motorista;
/**
 * A classe SistemaTransporte gerencia a frota de ônibus, motoristas, viagens, paradas e bilhetes eletrônicos.
 * Ela permite a manipulação de dados como a adição e remoção de ônibus, configuração de motoristas, rotas e 
 * manipulação de passageiros nos ônibus.
 */
public class SistemaTransporte {
    private ArrayList<Onibus> onibus;
    private ArrayList<Motorista> motoristas;
    private ArrayList<Viagem> viagens;
    private ArrayList<BilheteEletronico> bilhetesEletronicos;

    public SistemaTransporte() {
        onibus = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
        bilhetesEletronicos = new ArrayList<>();
    }

    /**
     * Retorna a lista de ônibus registrados no sistema.
     * @return Lista de ônibus.
     */
    public ArrayList<Onibus> getOnibus() {
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

    public Passageiro createPassageiro(String nome, int idade, String cpf, String senha, String endereco,
            String telefone, TipoAssento tipoAssento) {
        Passageiro passageiro = new Passageiro(nome, idade, cpf, senha, telefone, tipoAssento);
        return passageiro;
    }

    // MÉTODO RELATIVOS À CLASSE ÔNIBUS
    // ========================================================================================

    public Onibus createOnibus(int capacidade, int qdeAssentosPlusSize, int qdeAssentosCadeirante, int qdeAssentosIdoso,
            Motorista motorista, int numero, int rota) {
        Onibus onibus = new Onibus(capacidade, qdeAssentosPlusSize, qdeAssentosCadeirante, qdeAssentosIdoso, motorista,
                numero, rota);
        this.onibus.add(onibus);
        return onibus;
    }

    public void setNumero(int numeroOnibus, int numero) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                onibus.get(i).setNumero(numero);
            }
        }
    }

    public int getQuantidade(int numeroOnibus) {

        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getLotação();
            }
        }
        return -1;
    }

    public int getNumero(int numeroOnibus) {

        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getNumero();
            }
        }
        return -1;
    }

    public int getCapacidade(int numeroOnibus) {
        for (int i = 0; i < this.onibus.size(); i++) {
            if (this.onibus.get(i) != null && this.onibus.get(i).getNumero() == numeroOnibus) {
                return onibus.get(i).getCapacidade();
            }
        }
        return -1;
    }

    /**
     * Define o motorista de um ônibus específico pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @param motorista Motorista a ser atribuído ao ônibus.
     */
    public void setMotorista(int numeroOnibus, Motorista motorista) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                o.setMotorista(motorista);
                return;
            }
        }
    }

    /**
     * Retorna o motorista de um ônibus específico pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @return Motorista do ônibus, ou null se o ônibus não for encontrado.
     */
    public Motorista getMotorista(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getMotorista();
            }
        }
        return null;
    }

    /**
     * Define a rota de um ônibus específico pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @param rota Número da rota a ser atribuída ao ônibus.
     */
    public void setRota(int numeroOnibus, int rota) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                o.setRota(rota);
                return;
            }
        }
    }

    /**
     * Retorna a rota de um ônibus específico pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @return Rota do ônibus, ou -1 se o ônibus não for encontrado.
     */
    public int getRota(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getRota();
            }
        }
        return -1;
    }

    /**
     * Retorna a lotação atual de um ônibus específico pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     */
    public int getLotacao(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getLotacao();
            }
        }
        return -1;
    }

    /**
     * Adiciona um novo ônibus ao sistema.
     * @param onibus Novo objeto de ônibus a ser adicionado.
     */
    public void adicionarOnibus(Onibus onibus) {
        this.onibus.add(onibus);
    }

    /**
     * Remove um ônibus do sistema pelo número do ônibus.
     * @param numeroOnibus Número do ônibus a ser removido.
     */
    public void removerOnibus(int numeroOnibus) {
        this.onibus.removeIf(o -> o.getNumero() == numeroOnibus);
    }

    /**
     * Adiciona um passageiro ao ônibus especificado pelo número.
     * @param numeroOnibus Número do ônibus onde o passageiro será adicionado.
     * @param passageiro Passageiro a ser adicionado.
     * @throws IllegalArgumentException Se o ônibus estiver cheio ou não houver assento adequado.
     */
    public void adicionarPassageiro(int numeroOnibus, Passageiro passageiro) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                o.adicionarPassageiro(passageiro);
                return;
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Busca o assento de um passageiro pelo CPF no ônibus especificado pelo número.
     * @param numeroOnibus Número do ônibus onde será feita a busca.
     * @param cpf CPF do passageiro.
     * @return Assento do passageiro encontrado.
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado.
     */
    public Assento buscaAssentoPassageiro(int numeroOnibus, String cpf) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.buscaAssentoPassageiro(cpf);
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Remove um passageiro do ônibus especificado pelo número.
     * @param numeroOnibus Número do ônibus onde o passageiro será removido.
     * @param cpf CPF do passageiro a ser removido.
     * @return Passageiro removido.
     * @throws IllegalArgumentException Caso o passageiro não seja encontrado.
     */
    public Passageiro removerPassageiro(int numeroOnibus, String cpf) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.removePassageiro(cpf);
            }
        }
        throw new IllegalArgumentException("Ônibus não encontrado.");
    }

    /**
     * Retorna a lista de assentos de um ônibus pelo número.
     * @param numeroOnibus Número do ônibus.
     * @return Array de assentos do ônibus, ou null se o ônibus não for encontrado.
     */
    public Assento[] getAssentos(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getAssentos();
            }
        }
        return null;
    }




            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================
    




    
    //MÉTODOS DA CLASSE VIAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PAGAMENTO PASSAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PARADA ====================================================================================
    
    // Definindo valores que serão utilizados na instanciação de objetos pertencentes à classe Parada
   
    //MÉTODOS DA CLASSE HORARIONIBUS ====================================================================================
    
    //MÉTODOS DA CLASSE BILHETEELETRÔNICO ====================================================================================


    // MÉTODOS DA CLASSE MOTORISTA
    // ====================================================================================

    public Motorista createMotorista(String nome, int idade, String cpf, String senha, String cnh, int experiencia,
            String empresa, String linhaOnibus) {
        Motorista motorista = new Motorista(nome, idade, cpf, senha, cnh, experiencia, empresa, linhaOnibus);
        this.motoristas.add(motorista);
        return motorista;
    }

    // MÉTODOS DA CLASSE VIAGEM
    // ====================================================================================

    // MÉTODOS DA CLASSE VIAGEM ÔNIBUS
    // ====================================================================================

    public Viagem createViagemOnibus(Onibus onibus, ArrayList<ParadaDecorator> paradas) {
        Viagem viagem = new ViagemOnibus(onibus, paradas);
        this.viagens.add(viagem);
        return viagem;
    }

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

    public boolean temAssentoDisponivel(Veiculo veiculo, TipoAssento tipoAssento) {
        for (int i = 0; i < veiculo.getAssentos().length; i++) {
            if (veiculo.getAssentos()[i].getTipo() == tipoAssento
                    && veiculo.getAssentos()[i].getPassageiro() == null) {
                return true;
            }
        }
        return false;
    }

    // MÉTODOS DA CLASSE PAGAMENTO PASSAGEM
    // ====================================================================================

    // MÉTODOS DA CLASSE PARADA
    // ====================================================================================
    public Parada createParada(String endereco) {
        Parada parada = new Parada(endereco);
        return parada;
    }

    public ParadaDecorator createParadaDecorator(Parada parada, LocalDateTime horarioPrevisto) {
        ParadaDecorator paradaDecorator = new ParadaDecorator(parada, horarioPrevisto);
        return paradaDecorator;
    }

    // Definindo valores que serão utilizados na instanciação de objetos
    // pertencentes à classe Parada

    // MÉTODOS DA CLASSE HORARIONIBUS
    // ====================================================================================

    // MÉTODOS DA CLASSE BILHETEELETRÔNICO
    // ====================================================================================

    public BilheteEletronico createBilhete(Passageiro passageiro, Viagem viagem, ParadaDecorator embarque,
            ParadaDecorator desembarque, int assento, LocalDateTime horarioEmbarque) {
        BilheteEletronico bilheteEletronico = new BilheteEletronico(passageiro, viagem, embarque, desembarque, assento, horarioEmbarque);
        this.bilhetesEletronicos.add(bilheteEletronico);
        return bilheteEletronico;
    }

    public Passageiro getPassageiro(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
        return null;

    }

    public Viagem getViagem(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
        return null;
    }

    public int getPoltrona(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getNumAssento();
            }
        }
        return -1;
    }

    public UUID getID(UUID id) {
        for (int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if (this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getID();
            }
        }
        return null;
    }

}
