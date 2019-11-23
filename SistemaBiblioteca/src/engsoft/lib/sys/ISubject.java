package engsoft.lib.sys;

public interface ISubject {
	public boolean registerObserver(IObserver obs);
	public boolean removeObserver(IObserver obs);
	public void notifyObservers();
}
