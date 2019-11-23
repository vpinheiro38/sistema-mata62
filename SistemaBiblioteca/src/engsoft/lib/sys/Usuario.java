package engsoft.lib.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import engsoft.lib.help.Help;
import engsoft.lib.help.Mensagens;

public class Usuario {
	
	private String codigo;
	private String nome;
	
	private List<Reserva> reservas;
	private List<Emprestimo> emprestimos;
	
	private ITipoUsuario tipoUsuario;
	
	public Usuario(ITipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public boolean criarEmprestimo(ExemplarLivro exemplar) {
		boolean podeEmprestar = this.tipoUsuario.podeEmprestimo(this, exemplar.getLivro());
		
		if (podeEmprestar) {
			Date dataEmprestimo = Help.getHoje();
			Date dataDevolucao = Help.criarData(this.tipoUsuario.getTempoLimiteEmprestimo());
			
			Emprestimo emp = new Emprestimo(dataEmprestimo, dataDevolucao);
			if (exemplar.emprestar(emp)) {
				emprestimos.add(emp);
				removeReserva(exemplar.getLivro());
			} else {
				return false;
			}
		}
		
		return podeEmprestar;
	}
  
	public List<Emprestimo> getEmprestimosLivro(Livro livro) {
	    List<Emprestimo> emprestimosLivro = new ArrayList<Emprestimo>();
	    for (Emprestimo emprestimo : emprestimos) {
	        String codLivro = emprestimo.getCodigoLivro();
	        if (codLivro.equals(livro.getCodigo())) {
	            emprestimosLivro.add(emprestimo);
	        }
	    }
	
	    return emprestimosLivro;
	}
	
	public boolean devolverLivro(Livro livro) {
	    List<Emprestimo> emprestimosLivro = this.getEmprestimosLivro(livro);
	
	    for (Emprestimo emprestimo: emprestimosLivro) {
	        if (emprestimo.getCodigoLivro().equals(livro.getCodigo())) {
	            boolean resp = emprestimo.devolver();
	
	            if (resp)
	            	return true;
	            else {
	                System.out.println(Mensagens.LIVRO_JA_DEVOLVIDO);
	                return false;
	            }
	        }
	    }
	
	    System.out.println(Mensagens.EMPRESTIMO_INEXISTENTE);
	
	    return false;
	}
	
	public boolean removeReserva(Livro livro) {
		for (Reserva res : reservas) {
			if (res.getLivro() == livro) {
				reservas.remove(res);
				return true;
			}
		}
		return false;
	}
	
	public ITipoUsuario getTipoUsuario() {
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
	
	public Reserva getReserva(Livro livro) {
		for (Reserva res : reservas) {
			if (res.getLivro() == livro) {
				return res;
			}
		}
		
		return null;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimo) {
		this.emprestimos = emprestimo;
	}
}
