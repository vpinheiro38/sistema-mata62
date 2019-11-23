package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class ReservarCmd extends Comando {

	public ReservarCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		this.fachada.realizarReserva(args[0], args[1]);
	}

}
