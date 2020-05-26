package componente.gamificacao;

public class Pontos {

	public static final String MOEDA = "Moeda";
	public static final String ESTRELA = "Estrela";
	public static final String TOPICO = "Topico";
	public static final String COMENTARIO = "Comentario";
	public static final String CURTIDA = "Curtida";
	
	private int _quantidade;
	private String _tipo;

	public Pontos(String tipo, int quantidade) {
		_tipo = tipo;
		_quantidade = quantidade;
	}
	
	public String getTipo() {
		return _tipo;
	}

	public int getQuantidate() {
		return _quantidade;
	}
}
