package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public abstract class Comando {
	public BibliotecaFachada fachada;
	
	public Comando (BibliotecaFachada fachada) {
		this.fachada = fachada;
	}
	
	public abstract void executar(String[] args);
}
