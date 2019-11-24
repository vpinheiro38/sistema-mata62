package engsoft.lib.sys;

import java.util.List;

import engsoft.lib.help.Mensagens;

public class AlunoGraduacao implements ITipoUsuario {

	@Override
	public int getLimiteReserva() {
		return 3;
	}

	@Override
	public int getQntNotificacoes() {
		return 0;
	}

	@Override
	public boolean podeEmprestimo(Usuario usuario, Livro livro) {
		List<Emprestimo> emprestimos = usuario.getEmprestimos();
		for (Emprestimo emp : emprestimos) {
			if (emp.atrasado()) {
				System.out.println(Mensagens.USUARIO_DEVEDOR);
				return false;
			} else if (emp.getExemplar().getLivro() == livro) {
				System.out.println(Mensagens.EMPRESTIMO_EXISTENTE);
				return false;
			}
		}
		
		if (emprestimos.size() >= getLimiteEmprestimo()) {
			System.out.println(Mensagens.MAXIMO_EMPRESTIMOS);
			return false;
		}
		
		if (usuario.getReserva(livro) != null) {
			if (livro.getReservas().size() < livro.getExemplares().size()) {
				System.out.println(Mensagens.QNT_RESERVAS_LIVRO_RESERVADO);
				return false;
			}
		} else {			
			if (livro.getReservas().size() >= livro.getExemplares().size()) {
				System.out.println(Mensagens.QNT_RESERVAS_LIVRO_NAO_RESERVADO);
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int getLimiteEmprestimo() {
		return 3;
	}

	@Override
	public int getTempoLimiteEmprestimo() {
		return 3;
	}
        
    @Override
    public boolean podeReservar(Usuario usuario) {
        if (usuario.getReservas().size() == getLimiteReserva()) return false;
        else return true;
    }

}
