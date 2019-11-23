package engsoft.lib.sys;

public interface IEmprestimoEstado {
	public boolean atrasado(Emprestimo emp);
	public String getStatus(Emprestimo emp);
  public boolean devolver(Emprestimo emprestimo);
}
