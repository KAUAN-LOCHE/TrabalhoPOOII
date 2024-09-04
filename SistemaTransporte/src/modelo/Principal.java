package modelo;

public class Principal {
    public static void main(String[] args) {
        //Onibus onibus = new Onibus(10, motorista, 1, 1);
        Passageiro passageiro = new Passageiro("Maria", 123456789, 123456789, "123456789");
        Motorista motorista = new Motorista("Pedro");
        Onibus onibus = new Onibus (45, motorista, 3,65 );
        
        onibus.exibirPassageiros();
        
        onibus.AdicionarPassageiro(passageiro);
    }
}
