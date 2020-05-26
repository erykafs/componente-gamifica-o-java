package componente.gamificacao;

import java.io.Serializable;
import java.util.HashMap;

public class Usuario implements Serializable {
	private static final long serialVersionUID = -2833033561617910208L;
	
	private String _nome;
	private HashMap<String, Integer> _pontos;

	public Usuario(String nome) {
		_nome = nome;
		_pontos = new HashMap<>();
	}

	public String getNome() {
		return _nome;
	}

	public HashMap<String, Integer> getPontos() {
		return _pontos;
	}

	public void adicionarPontos(Pontos pontos) {
		if (pontos.getQuantidate() > 0) {
			if (_pontos.containsKey(pontos.getTipo()))
				_pontos.remove(pontos.getTipo());
			_pontos.put(pontos.getTipo(), pontos.getQuantidate());
		}
	}

	public int retornaPontosTipo(String tipo) {
		return _pontos.get(tipo);
	}
	
	public String todasPontuacoes() {
		String pontuacao = "";
		for (String chave: _pontos.keySet()) {
			pontuacao = pontuacao + chave + " = " + _pontos.get(chave) + " ";
		}
		return pontuacao;
	}
	
	public int tiposPontos() {
		return _pontos.size();
	}

}
