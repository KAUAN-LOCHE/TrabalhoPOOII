package modelo.interfaces;

import java.util.ArrayList;

import modelo.Assento;
import modelo.Passageiro;
import modelo.enums.TipoAssento;

public interface Veiculo {
    public Assento[] getAssentos();
    public ArrayList<Number> getPosicoesDisponiveis(TipoAssento tipo);
    public void adicionarPassageiro(Passageiro passageiro, int numAssento);
    public Assento buscaAssentoPassageiro(Passageiro passageiro);
    public Passageiro removePassageiro(Passageiro passageiro);
}
