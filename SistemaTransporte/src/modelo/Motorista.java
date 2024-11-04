package modelo;

public class Motorista extends UsuarioBase{

    //atributos
    private String cnh; 
    private int experiencia; 
    private String empresa;  
    private String linhaOnibus;

    //construtor
    public Motorista(String nome, int idade, String cpf, String UUID, String senha, String cnh, int experiencia, String empresa, String linhaOnibus) {
        super(nome, idade, cpf, UUID, senha);
        this.cnh = cnh;
        this.experiencia = experiencia;
        this.empresa = empresa;
        this.linhaOnibus = linhaOnibus;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLinhaOnibus() {
        return linhaOnibus;
    }

    public void setLinhaOnibus(String linhaOnibus) {
        this.linhaOnibus = linhaOnibus;
    }

    //exibir informacoes
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("CNH: " + cnh);
        System.out.println("Experiência de: " + experiencia + " anos dirigindo");
        System.out.println("Empresa: " + empresa);
        System.out.println("Faz a linha: " + linhaOnibus);
    }
}