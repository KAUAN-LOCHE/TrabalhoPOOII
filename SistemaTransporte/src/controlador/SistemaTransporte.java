package controlador;

import modelo.BilheteEletronico;
import modelo.Onibus;
import modelo.Parada;
import modelo.Passageiro;
import modelo.Viagem;
import modelo.enums.StatusViagem;
import modelo.HorarioOnibus;
import modelo.Motorista;
import modelo.*;
import java.util.UUID;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * A classe SistemaTransporte gerencia a frota de ônibus, motoristas, viagens, paradas e bilhetes eletrônicos.
 * Ela permite a manipulação de dados como a adição e remoção de ônibus, configuração de motoristas, rotas e 
 * manipulação de passageiros nos ônibus.
 */
public class SistemaTransporte {
    private ArrayList<Onibus> onibus;
    private ArrayList<Motorista> motoristas;
    private ArrayList<Viagem> viagens;
    private ArrayList<Parada> paradas;
    private ArrayList<BilheteEletronico> bilhetesEletronicos;

    /**
     * Construtor padrão da classe SistemaTransporte, inicializando as listas de ônibus, motoristas, e viagens.
     */
    public SistemaTransporte() {
        onibus = new ArrayList<>();
        motoristas = new ArrayList<>();
        viagens = new ArrayList<>();
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

    // MÉTODOS RELATIVOS À CLASSE ÔNIBUS ========================================================================================

    /**
     * Define o número de um ônibus específico pelo seu número de identificação atual.
     * @param numeroOnibus Número atual do ônibus.
     * @param numero Novo número a ser atribuído ao ônibus.
     */
    public void setNumero(int numeroOnibus, int numero) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                o.setNumero(numero);
                return;
            }
        }
    }

    /**
     * Retorna a lotação atual de um ônibus especificado pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @return Número de passageiros no ônibus, ou -1 se o ônibus não for encontrado.
     */
    public int getQuantidade(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getLotacao();
            }
        }
        return -1;
    }

    /**
     * Retorna o número de um ônibus específico pelo seu número de identificação atual.
     * @param numeroOnibus Número do ônibus.
     * @return Número do ônibus, ou -1 se o ônibus não for encontrado.
     */
    public int getNumero(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getNumero();
            }
        }
        return -1;
    }

    /**
     * Retorna a capacidade total de assentos de um ônibus especificado pelo seu número de identificação.
     * @param numeroOnibus Número do ônibus.
     * @return Capacidade do ônibus, ou -1 se o ônibus não for encontrado.
     */
    public int getCapacidade(int numeroOnibus) {
        for (Onibus o : this.onibus) {
            if (o.getNumero() == numeroOnibus) {
                return o.getCapacidade();
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
}



            
    //MÉTODOS DA CLASSE MOTORISTA ====================================================================================
    




    
    //MÉTODOS DA CLASSE VIAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PAGAMENTO PASSAGEM ====================================================================================
    
    //MÉTODOS DA CLASSE PARADA ====================================================================================
    
    // Definindo valores que serão utilizados na instanciação de objetos pertencentes à classe Parada
   
    //MÉTODOS DA CLASSE HORARIONIBUS ====================================================================================
    
    //MÉTODOS DA CLASSE BILHETEELETRÔNICO ====================================================================================

    public String exibirDados(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return this.bilhetesEletronicos.get(i).exibirDados();
            }
        }
        return null;
    }

    public Passageiro getPassageiro(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPassageiro();
            }
        }
        return null;

    }

    public Viagem getViagem(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getViagem();
            }
        }
        return null;
    }

    public Parada getEmbarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
        return null;
    }

    public Parada getDesembarque(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getEmbarque();
            }
        }
        return null;
    }


    public LocalDateTime getDataHoraChegada(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getDataHoraChegada();
            }
        }
        return null;
    }

    public int getPoltrona(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getPoltrona();
            }
        }
        return -1;
    }

    public UUID getID(UUID id) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                return bilhetesEletronicos.get(i).getID();
            }
        }
        return null;
    }

    public void setPassageiro(UUID id, Passageiro passageiro) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setPassageiro(passageiro);
            }
        }
    }
    
    public void setViagem(UUID id, Viagem viagem) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setViagem(viagem);
            }
        }
    }

    public void setDadosViagem(UUID id, int indiceEmbarque, int indiceDesembarque) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setDadosViagem(indiceEmbarque, indiceDesembarque);
            }
        }
    }

    public void setPoltrona(UUID id, int poltrona) {
        for(int i = 0; i < this.bilhetesEletronicos.size(); i++) {
            if(this.bilhetesEletronicos.get(i) != null && this.bilhetesEletronicos.get(i).getID().equals(id)) {
                bilhetesEletronicos.get(i).setPoltrona(poltrona);
            }
        }
    }

}
