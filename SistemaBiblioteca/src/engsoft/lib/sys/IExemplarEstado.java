package engsoft.lib.sys;

public interface IExemplarEstado {
	public boolean disponivel();
	public boolean emprestar(ExemplarLivro exemplar, Emprestimo emprestimo);
	public String getStatus();
}
