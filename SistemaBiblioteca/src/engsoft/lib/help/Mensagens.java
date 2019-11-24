package engsoft.lib.help;

public abstract class Mensagens {
	public static final String SEM_EMPRESTIMOS_ABERTOS = "Não há empréstimo em aberto desse livro para o usuário requisitado!";
	public static final String OBS_CRIADO = "Professor registrado como observador com sucesso!";
	public static final String LIVRO_INDISPONIVEL = "Esse livro está indisponível no momento!";
	public static final String EXEMPLAR_EMPRESTADO = "Esse exemplar já está emprestado!";
	public static final String EMPRESTIMO_SUCESSO = "Empréstimo de %s realizado com sucesso para %s!";
	public static final String USUARIO_DEVEDOR = "Esse usuário está devendo um empréstimo!";
	public static final String EMPRESTIMO_EXISTENTE = "Esse usuário já possui um empréstimo desse livro em curso!";
	public static final String MAXIMO_EMPRESTIMOS = "Esse usuário possui a quantidade máxima de empréstimo!";
	public static final String QNT_RESERVAS_LIVRO_NAO_RESERVADO = 
			"O usuário não tem reserva para esse livro e a quantidade de reservas existentes do livro é\nmaior ou igual a de exemplares disponíveis.";
	public static final String QNT_RESERVAS_LIVRO_RESERVADO = 
			"O usuário tem reserva para esse livro e a quantidade de reservas existentes do livro é\nmenor a de exemplares disponíveis.";
	public static final String EXEMPLAR_JA_DEVOLVIDO = "Esse exemplar já foi devolvido!";
	public static final String EMPRESTIMO_JA_DEVOLVIDO = "Esse empréstimo já foi finalizado e o exemplar devolvido!";
	public static final String LIVRO_JA_DEVOLVIDO = "Livro já devolvido.";
	public static final String EMPRESTIMO_INEXISTENTE = "Nenhum empréstimo para esse livro encontrado!";
	public static final String DEVOLUCAO_SUCESSO = "Devolução realizada com sucesso!";
	public static final String RESERVAR_LIVRO_SUCESSO = "Reserva realizada com sucesso!";
}
