package modelo;

import modelo.enums.TipoAssento;

public class Passageiro extends UsuarioBase implements Cloneable{

    private String telefone;
    private TipoAssento tipoAssento;
    private boolean emViagem;

    /**
     * Construtor da classe Passageiro
     * @param nome
     * @param idade
     * @param cpf
     * @param senha
     * @param tipoAssento comum, plus_size, cadeirante ou idoso
     */
    public Passageiro(String nome, int idade, String cpf, String senha, String telefone, TipoAssento tipoAssento) {
        super(nome, idade, cpf, senha);
        this.telefone = telefone;
        this.tipoAssento = tipoAssento;
        this.emViagem = false;
    }

    /**
     * Determina se o Passageiro está em viagem
     * @param emViagem
     */
    public void setEmViagem(boolean emViagem) {
        this.emViagem = emViagem;
    }

    /**
     * Retorna se o Passageiro está em viagem
     * @return {@code boolean} emViagem
     */
    public boolean getEmViagem() {
        return this.emViagem;
    }
    
    /**
     * Determina o telefone do Passageiro
     * @param telefone
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    /**
     * Retorna o telefone do Passageiro
     * @return {@code String} telefone
     */
    public String getTelefone(){
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
