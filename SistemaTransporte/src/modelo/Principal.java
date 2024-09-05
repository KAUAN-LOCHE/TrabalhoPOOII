package modelo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //Onibus onibus = new Onibus(10, motorista, 1, 1);
        Passageiro passageiro = new Passageiro("Maria", 123456789, 123456789, "123456789");
        Motorista motorista = new Motorista("Pedro");
        Onibus onibus = new Onibus(45, motorista, 3, 65 );
        
        //System.out.println(onibus.getCapacidade());
        onibus.exibirPassageiros();
        
       boolean i = onibus.adicionarPassageiro(passageiro);
        i = onibus.adicionarPassageiro(passageiro);
        passageiro = new Passageiro("João", 1234, 4321, "12434");
        i = onibus.adicionarPassageiroPosicao(passageiro, 45);
        
        ArrayList<Passageiro> Lista = new ArrayList<>();
        
      
    }
}
