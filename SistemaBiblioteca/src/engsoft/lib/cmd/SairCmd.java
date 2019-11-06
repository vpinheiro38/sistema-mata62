package engsoft.lib.cmd;

public class SairCmd implements Comando {
	
	@Override
	public void executar(String[] args) {
		System.exit(0);
	}

}
