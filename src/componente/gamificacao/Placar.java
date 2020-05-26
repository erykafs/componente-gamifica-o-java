package componente.gamificacao;

import java.util.List;
import java.util.Map;

public abstract class Placar {
	
	public Armazenamento armazenamento;
	
	public abstract void registrarPontosUsuario(String nomeUsuario, String tipo, int quantidade);
	
	public abstract Map<String, Integer> retornarPontosUsuario(String nomeUsuario);
		
	public abstract List<String> retornarRanckingPontos(String tipo);

}
