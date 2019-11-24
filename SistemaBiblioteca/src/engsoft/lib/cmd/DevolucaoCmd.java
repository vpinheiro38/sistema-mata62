package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class DevolucaoCmd extends Comando {

	public DevolucaoCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		this.fachada.realizarDevolucao(args[1], args[2]);
	}

}
