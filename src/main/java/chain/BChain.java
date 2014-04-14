package chain;

public class BChain extends Chain {

	@Override
	public void execute() {
		System.out.println("BChain");
		next.execute();
	}

	
}
