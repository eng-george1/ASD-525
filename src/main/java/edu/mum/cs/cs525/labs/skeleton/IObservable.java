package edu.mum.cs.cs525.labs.skeleton;

public interface IObservable {
    public void registerObserver(IObserver o);
    public void removeObserver(IObserver o);
    public void notifyAllObservers();
}
