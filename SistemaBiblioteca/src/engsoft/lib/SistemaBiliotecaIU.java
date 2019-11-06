package engsoft.lib;

import java.util.Scanner;

import engsoft.lib.cmd.EmprestimoCmd;
import engsoft.lib.cmd.SairCmd;
import engsoft.lib.sys.BibliotecaFachada;

public class SistemaBiliotecaIU {

	public static void main(String[] args) {
		Scanner s = null;
		
		BibliotecaFachada facade = new BibliotecaFachada();
		
		SairCmd saiCmd = new SairCmd();
		EmprestimoCmd empCmd = new EmprestimoCmd(facade);
		
		try {
			s = new Scanner(System.in);
			
			while (s.hasNext()) {
				String cmd = s.next();
				String[] arg = s.nextLine().split(" ");

				switch(cmd) {
					case "sai":
						saiCmd.executar(arg);
					case "emp":
						empCmd.executar(arg);
				}
			}
		} finally {
			s.close();
		}
	}

}
