package modelo;

public class Passageiro extends Pessoa implements Cloneable{
    //atributos
    private int telefone;
    private String cpf;

    //método construtor
    public Passageiro(String nome, int idade, int telefone, String cpf) {
        super(nome, idade);
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    //métodos getters e setters
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
    
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Telefone: " + telefone);
        System.out.println("CPF: " + cpf);
    }
    
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
