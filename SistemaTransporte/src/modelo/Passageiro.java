package modelo;

import modelo.enums.TipoAssento;

public class Passageiro extends UsuarioBase implements Cloneable{
    //atributos
    private int telefone;
    private TipoAssento tipoAssento;

    //método construtor
    public Passageiro(String nome, int idade, String cpf, String UUID, String senha, int telefone, TipoAssento tipoAssento) {
        super(nome, idade, cpf, UUID, senha);
        this.telefone = telefone;
        this.tipoAssento = tipoAssento;
    }
    
    //métodos getters e setters
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public int getTelefone(){
        return telefone;
    }

    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }

    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
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
