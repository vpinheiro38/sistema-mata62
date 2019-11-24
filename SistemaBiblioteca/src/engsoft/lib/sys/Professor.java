package engsoft.lib.sys;

import java.util.List;

import engsoft.lib.help.Mensagens;

public class Professor implements ITipoUsuario, IObserver {
	
	public int qntNotificacoes = 0;
	
	public int getLimiteEmprestimo() {
		return 7;
	}
	
	public int getTempoLimiteEmprestimo() {
		return -1;
	}

	@Override
	public int getQntNotificacoes() {
		return this.qntNotificacoes;
	}

	@Override
	public int getLimiteReserva() {
		return 3;
	}

	@Override
	public boolean podeEmprestimo(Usuario usuario, Livro livro) {
		List<Emprestimo> emprestimos = usuario.getEmprestimos();
		for (Emprestimo emp : emprestimos) {
			if (emp.atrasado()) {
				System.out.println(Mensagens.USUARIO_DEVEDOR);
				return false;
			}
		}
		return true;
	}
        
    @Override
    public boolean podeReservar(Usuario usuario) {
        return true;
    }

	@Override
	public void update() {
		this.qntNotificacoes++;
	}

    

}
