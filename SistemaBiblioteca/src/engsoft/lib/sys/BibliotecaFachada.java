package engsoft.lib.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class BibliotecaFachada {
	
	private Map<String, Livro> livros;
	private Map<String, Usuario> usuarios;
	
	public BibliotecaFachada() {
		
	}
	
	public String realizarEmprestimo(String codUsuario, String codLivro) {
		
		
		String resposta = "";
		return resposta;
	}
	
	public String realizarDevolucao(String codUsuario, String codLivro) {
		String resposta = "";

		Usuario usuario = getUsuario(codUsuario);
		Livro livro = getLivro(codLivro);

		boolean resp = usuario.devolverLivro(livro)

		if (boo)

		return resposta;
	}
	
	public String realizarReserva(String codUsuario, String codLivro) {
		
		
		String resposta = "";
		return resposta;
	}
	
	public String consultarLivro(String codLivro) {

		
		String resposta = "";
		return resposta;		
	}
	
	public String consultarUsuario(String codUsuario) {
		Usuario usuario = getUsuario(codUsuario);
		ArrayList<Emprestimo> emprestimos = usuario.getEmprestimos();
		ArrayList<Reserva> reservas = usuario.getReservas();
	
		String resposta = "Consulta para o usu�rio " + usuario.getNome() + "\nEmpr�stimos: \n";
		
		for (Emprestimo emp : emprestimos) {
			String livro = emp.getTituloLivro();
			Date dataEmp = emp.getDataEmprestimo();			
			
			String status = emp.getStatus();
			String respEmp = "- Livro " + livro + " emprestado em " + dataEmp.toString() + ". Status: " + status + ". "; 
			if (status == "Devolvido") {
				respEmp += "Devolvido em " + emp.getDataDevolucao().toString() + ".";
			} else {
				respEmp += "Devolu��o prevista para" + emp.getDataDevolucao().toString() + ".";
			}
			
			resposta += respEmp + "\n";
		}
		
		resposta += "Reservas: ";
		
		for (Reserva res : reservas) {
			String livro = res.getTituloLivro();
			Date solicitacao = res.getDataReserva();
			
			String respRes = "- " + livro + " reservado em " + solicitacao + ".";
			resposta += respRes = "\n";
		}
		
		return resposta;
	}
	
	public String consultarProfessor(String codUsuario) {
		Usuario professor = getUsuario(codUsuario);
		int notificacoes = professor.getTipoUsuario().getQntNotificacoes();
		
		String resposta = "Esse professor foi notificado " + notificacoes + " vezes.";
		return resposta;
	}
	
	public void criarObservador(String codUsuario, String codLivro) {
		Livro livro = getLivro(codLivro);
		Usuario professor = getUsuario(codUsuario);
		
		livro.registerObserver((Observer) professor.getTipoUsuario());
	}

	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario getUsuario(String codigo) {
		return this.usuarios.get(codigo);
	}

	public Map<String, Livro> getLivros() {		
		return livros;
	}

	public void setLivros(Map<String, Livro> livros) {
		this.livros = livros;
	}
	
	public Livro getLivro(String codigo) {
		return this.livros.get(codigo);
	}
	
}
