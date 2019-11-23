package engsoft.lib.cmd;

import java.util.Calendar;

import engsoft.lib.sys.BibliotecaFachada;

public class SairCmd extends Comando {
	
	public SairCmd(BibliotecaFachada fachada) {
		super(fachada);
	}

	@Override
	public void executar(String[] args) {
		System.exit(0);
	}

}
