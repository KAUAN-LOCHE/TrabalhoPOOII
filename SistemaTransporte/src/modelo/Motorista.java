/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kauan
 */
public class Motorista {
 
    private String nome;
    private String cnh; 
    private int idade;
    private int experiencia; 
    private String empresa;  
    private String linhaOnibus;

    public Motorista(String nome, String cnh, int idade, int experiencia, String empresa, String linhaOnibus) {
        this.nome = nome;
        this.cnh = cnh;
        this.idade = idade;
        this.experiencia = experiencia;
        this.empresa = empresa;
        this.linhaOnibus = linhaOnibus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    
    public void exibirInfo() {
        System.out.println("Nome do Motorista: " + nome);
        System.out.println("CNH: " + cnh);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Experiência de: " + experiencia + " anos dirigindo");
        System.out.println("Empresa: " + empresa);
        System.out.println("Faz a linha: " + linhaOnibus);
    }
}