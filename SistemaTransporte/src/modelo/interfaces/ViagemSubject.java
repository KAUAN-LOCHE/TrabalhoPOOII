package modelo.interfaces;

public interface ViagemSubject {
    public void addObserver(ViagemObserver observer);
    public void removeObserver(ViagemObserver observer);
    public void notifyObservers();
}
