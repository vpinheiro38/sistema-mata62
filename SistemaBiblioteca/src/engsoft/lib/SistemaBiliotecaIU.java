package engsoft.lib;

import java.util.Scanner;

import engsoft.lib.cmd.ConsultarLivroCmd;
import engsoft.lib.cmd.ConsultarProfCmd;
import engsoft.lib.cmd.ConsultarUsuarioCmd;
import engsoft.lib.cmd.DevolucaoCmd;
import engsoft.lib.cmd.EmprestimoCmd;
import engsoft.lib.cmd.ObservarCmd;
import engsoft.lib.cmd.ReservarCmd;
import engsoft.lib.cmd.SairCmd;
import engsoft.lib.sys.BibliotecaFachada;

public class SistemaBiliotecaIU {

	public static void main(String[] args) {
		Scanner s = null;
		
		BibliotecaFachada facade = new BibliotecaFachada();
		
		ConsultarLivroCmd livCmd = new ConsultarLivroCmd(facade);
		ConsultarProfCmd ntfCmd = new ConsultarProfCmd(facade);
		ConsultarUsuarioCmd usuCmd = new ConsultarUsuarioCmd(facade);
		DevolucaoCmd devCmd = new DevolucaoCmd(facade);
		EmprestimoCmd empCmd = new EmprestimoCmd(facade);
		ObservarCmd obsCmd = new ObservarCmd(facade);
		ReservarCmd resCmd = new ReservarCmd(facade);
		SairCmd saiCmd = new SairCmd(facade);
		
		try {
			s = new Scanner(System.in);
			
			while (s.hasNext()) {
				String cmd = s.next();
				String[] arg = s.nextLine().split(" ");

				switch(cmd) {
					case "liv":
						livCmd.executar(arg);
					case "ntf":
						ntfCmd.executar(arg);
					case "usu":
						usuCmd.executar(arg);
					case "dev":
						devCmd.executar(arg);
					case "emp":
						empCmd.executar(arg);
					case "obs":
						obsCmd.executar(arg);
					case "res":
						resCmd.executar(arg);
					case "sai":
						saiCmd.executar(arg);
				}
			}
		} finally {
			s.close();
		}
	}

}
