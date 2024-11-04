package modelo;

public class Passageiro extends UsuarioBase implements Cloneable{
    //atributos
    private int telefone;

    //método construtor
    public Passageiro(String nome, int idade, String cpf, String UUID, String senha, int telefone) {
        super(nome, idade, cpf, UUID, senha);
        this.telefone = telefone;
    }
    
    //métodos getters e setters
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public int getTelefone(){
        return telefone;
    }
    
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Telefone: " + telefone);
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
