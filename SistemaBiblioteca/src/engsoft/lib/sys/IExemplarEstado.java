package engsoft.lib.sys;

public interface IExemplarEstado {
    public boolean disponivel();
    public boolean devolver(ExemplarLivro exemplar);
    public boolean emprestar(Emprestimo emprestimo);
    public String getStatus();
    public Emprestimo getEmprestimo(ExemplarLivro exemplar);
}
