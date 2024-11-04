package modelo;

public abstract class UsuarioBase {

    private String nome;
    private int idade;
    private String cpf;
    private String UUID;
    private String senha;

    public UsuarioBase(String nome, int idade, String cpf, String UUID, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.UUID = UUID;
        this.senha = senha;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // metodo para exibir as informacoes do Usuario Base escondendo a senha
    public void exibirInfo() {
        System.out.println("UUID: "+ UUID);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("CPF: " + cpf);
    }
}
