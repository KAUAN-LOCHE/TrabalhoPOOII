package modelo;

public class Motorista extends UsuarioBase{

    private String cnh; 
    private int experiencia; 
    private String empresa;  
    private String linhaOnibus;

    /**
     * Construtor da classe Motorista
     * @param nome
     * @param idade
     * @param cpf
     * @param senha senha do motorista
     * @param cnh   carteira nacional de habilitacao
     * @param experiencia   tempo de experiencia do Motorista
     * @param empresa
     * @param linhaOnibus linha de onibus que o motorista conduz
     */
    public Motorista(String nome, int idade, String cpf, String senha, String cnh, int experiencia, String empresa, String linhaOnibus) {
        super(nome, idade, cpf, senha);
        this.cnh = cnh;
        this.experiencia = experiencia;
        this.empresa = empresa;
        this.linhaOnibus = linhaOnibus;
    }

    /**
     * Retorna a CNH do Motorista
     * @return {@code String} cnh
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * Determina a CNH do Motorista
     * @param telefone
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * Retorna o tempo de experiencia do Motorista
     * @return {@code int} experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Determina o tempo de experiencia do Motorista
     * @param experiencia
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Retorna a empresa que o Motorista trabalha
     * @return {@code String} empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Determina a empresa que o Motorista trabalha
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Retorna a linha de Onibus que o Motorista trabalha
     * @return {@code String} linhaOnibus
     */
    public String getLinhaOnibus() {
        return linhaOnibus;
    }

    /**
     * Determina a linha de Onibus que o Motorista trabalha
     * @param empresa
     */
    public void setLinhaOnibus(String linhaOnibus) {
        this.linhaOnibus = linhaOnibus;
    }

    /**
     * Imprime os dados do Motorista
     */
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("CNH: " + cnh);
        System.out.println("Experiência de: " + experiencia + " anos dirigindo");
        System.out.println("Empresa: " + empresa);
        System.out.println("Faz a linha: " + linhaOnibus);
    }

    @Override
    //ToString com os dados do motorista, como NOME, idade, cpf, cnh, experiencia, empresa e linha de onibus
    public String toString() {
        return "Motorista: " + nome +"\ncnh: " + cnh + "\nempresa: " + empresa + "\nexperiencia: " + experiencia + "\nlinhaOnibus: "
                + linhaOnibus + "\n\n\n";
    }
   
}