package CLasses;

public class Passageiro {
    //atributos
    private String nome;
    private int idade;
    private int telefone;
    private String cpf;

    //método construtor
    public Passageiro(String nome, int idade, int telefone, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    //métodos getters e setters dos atributos nome, idade, telefone e cpf do passageiro
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
    
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public int getTelefone(){
        return telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
