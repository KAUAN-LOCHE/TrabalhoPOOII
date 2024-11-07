package modelo;

import modelo.enums.TipoAssento;

public class Passageiro extends UsuarioBase implements Cloneable{

    private int telefone;
    private TipoAssento tipoAssento;

    /**
     * Construtor da classe Passageiro
     * @param nome
     * @param idade
     * @param cpf
     * @param senha
     * @param tipoAssento comum, plus_size, cadeirante ou idoso
     */
    public Passageiro(String nome, int idade, String cpf, String senha, int telefone, TipoAssento tipoAssento) {
        super(nome, idade, cpf, senha);
        this.telefone = telefone;
        this.tipoAssento = tipoAssento;
    }
    
    /**
     * Determina o telefone do Passageiro
     * @param telefone
     */
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    /**
     * Retorna o telefone do Passageiro
     * @return {@code int} telefone
     */
    public int getTelefone(){
        return telefone;
    }

    /**
     * Retorna o Tipo de Assento do Passageiro
     * @return {@code tipoAssento} do Passageiro
     */
    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }

    /**
     * Determina o Tipo de Assento do Passageiro
     * @param tipoAssento
     */
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }
    
    /**
     * Imprime os dados do Passageiro
     */
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Telefone: " + telefone);
        System.out.println("Tipo de Assento: " + tipoAssento);
    }

    /**
     * Clona e retorna um Passageiro
     * @return {@code Passageiro}
     */
    @Override
    public Passageiro clone(){
        Passageiro passageiro;
        try{
            passageiro = (Passageiro) super.clone();
        }
         catch (CloneNotSupportedException e){
             System.out.println("Erro");  
             return null;
         }
         return passageiro;
    }
}
