package engsoft.lib.sys;

public interface IExemplarEstado {
	public boolean disponivel();
	public boolean devolver(ExemplarLivro exemplar);
	public boolean emprestar(ExemplarLivro exemplar, Emprestimo emprestimo);
	public String getStatus();
}
