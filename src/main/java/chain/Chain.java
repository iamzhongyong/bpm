package chain;

public abstract class Chain {

	Chain next;
	public void setNext(Chain chain){
		this.next = chain;
	}
	public abstract void execute();
}
