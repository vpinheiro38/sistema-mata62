package engsoft.lib.sys;

import java.util.ArrayList;

public class Usuario {
	
	private String codigo;
	private String nome;
	
	private ArrayList<Reserva> reservas;
	private ArrayList<Emprestimo> emprestimos;
	
	private TipoUsuario tipoUsuario;
	
	public Usuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(ArrayList<Emprestimo> emprestimo) {
		this.emprestimos = emprestimo;
	}
	
	public List<Emprestimo> getEmprestimosLivro(Livro livro) {
		List<Emprestimo> emprestimosLivro = new ArrayList();

		for (Emprestimo emprestimo : emprestimos) {
			String codLivro = emprestimo.getCodigoLivro();

			if (codLivro.equals(livro.getCodigo())) {
				emprestimosLivro.add(emprestimo)
			}
		}
	}
}
