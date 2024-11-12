package modelo;

import java.util.UUID;

public abstract class UsuarioBase {

    protected String nome;
    protected int idade;
    protected String cpf;
    protected final UUID id;
    protected String senha;

    /**
     * Construtor da classe UsuarioBase
     * @param nome
     * @param idade
     * @param cpf
     * @param senha
     */
    public UsuarioBase(String nome, int idade, String cpf, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
        this.id = UUID.randomUUID();
    }

    /**
     * Retorna o nome do UsuarioBase
     * @return {@code String} nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Determina o nome do UsuarioBase
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a idade do UsuarioBase
     * @return {@code int} idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Determina a idade do UsuarioBase
     * @param nome
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna o CPF do UsuarioBase
     * @return {@code String} cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Determina o cpf do UsuarioBase
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o id do UsuarioBase
     * @return {@code UUID} id
     */
    public UUID getUUID() {
        return id;
    }

    /**
     * Retorna a senha do UsuarioBase
     * @return {@code String} senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Determina a senha do UsuarioBase
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Imprime os dados do UsuarioBase (menos a senha)
     */
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("CPF: " + cpf);
        System.out.println("id de usuario: " + id);
    }

    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade + " anos\nCPF: " + cpf + "\nid de usuario: " + id;
    }
}
