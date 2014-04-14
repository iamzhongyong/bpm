package chain;

public class AChain extends Chain {

	@Override
	public void execute() {
		System.out.println("AChain");
		next.execute();
	}  

	
}
