package chain;

public class CChain extends Chain {

	@Override
	public void execute() {
		System.out.println("CChain");
		if(null != next){
			next.execute();

		}
	}

	
}
