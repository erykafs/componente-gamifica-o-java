package componente.gamificacao.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import componente.gamificacao.Armazenamento;
import componente.gamificacao.Placar;
import componente.gamificacao.Pontos;
import componente.gamificacao.Repositorio;
import componente.gamificacao.Usuario;

public class PlacarMock extends Placar {

	public PlacarMock(Repositorio repositorio) {
		armazenamento = new Armazenamento(repositorio);
	}

	@Override
	public void registrarPontosUsuario(String nomeUsuario, String tipo, int quantidade) {
		try {
			armazenamento.armazenarPontos(new Usuario(nomeUsuario), new Pontos(tipo, quantidade));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Override
	public Map<String, Integer> retornarPontosUsuario(String nomeUsuario) {
		return armazenamento.pontosUsuario(nomeUsuario);
	}

	@Override
	public List<String> retornarRanckingPontos(String tipo) {
		Map<String, Integer> ranking = new HashMap<String, Integer>();
		Set<String> u = armazenamento.usuariosComPontos();
		for (String nomeUsuario: u) {
			int pontos = armazenamento.quantPontosTipo(nomeUsuario, tipo);
			if (pontos > 0)
				ranking.put(nomeUsuario, pontos);
		}
		return ordenarRancking(ranking);
	}

	private List<String> ordenarRancking(Map<String, Integer> ranking) {
		List<String> dados = new ArrayList<>();
		for (String chave : ranking.keySet()) dados.add(ranking.get(chave) + "=" + chave);
		Collections.sort(dados);
		Collections.reverse(dados);
		return dados;
	}
}
