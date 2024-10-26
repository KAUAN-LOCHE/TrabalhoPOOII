/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kauan
 */
public class Motorista extends Pessoa{
 
    private String cnh; 
    private int experiencia; 
    private String empresa;  
    private String linhaOnibus;

    public Motorista(String nome, String cnh, int idade, int experiencia, String empresa, String linhaOnibus) {
        super(nome, idade);
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

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("CNH: " + cnh);
        System.out.println("Experiência de: " + experiencia + " anos dirigindo");
        System.out.println("Empresa: " + empresa);
        System.out.println("Faz a linha: " + linhaOnibus);
    }
}