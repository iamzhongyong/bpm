package chain;

public class MainChain {

	public static void main(String[] args) {
		Chain a = new AChain();
		Chain b = new BChain();
		Chain c = new CChain();
		a.setNext(b);
		b.setNext(c);
		a.execute();
	}
}
