package modelo.interfaces;

import java.util.ArrayList;

import modelo.Assento;
import modelo.Passageiro;
import modelo.enums.TipoAssento;
import modelo.Motorista;

public interface Veiculo {
    public Assento[] getAssentos();
    public ArrayList<Number> getPosicoesDisponiveis(TipoAssento tipo);
    public void adicionarPassageiro(Passageiro passageiro, int numAssento);
    public Assento buscaAssentoPassageiro(Passageiro passageiro);
    public Passageiro removePassageiro(Passageiro passageiro);
    public int getLotacao();
    public int getCapacidade();
    public int getNumero();
    public int getRota();
    public void setRota(int rota);
    public void setNumero(int numero);
    public Motorista getMotorista();
    public void setMotorista(Motorista motorista);
}
