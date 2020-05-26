package componente.gamificacao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import componente.gamificacao.Pontos;
import componente.gamificacao.Repositorio;

public class PlacarMockTest {
	
	private PlacarMock placar;
	private Repositorio repositorio;
	private String arquivo = "repositorio";
	
	@Before
	public void inicializar() {
		repositorio = new Repositorio(arquivo);
		placar = new PlacarMock(repositorio);
	}
	
	@Test
	public void registrarPontos() {
		placar.registrarPontosUsuario("Maria", Pontos.MOEDA, 5);
		placar.registrarPontosUsuario("Maria", Pontos.ESTRELA, 5);
	}
	
	@Test
	public void retornarPontos() {
		assertEquals(placar.retornarPontosUsuario("Maria").toString(), "{Estrela=5, Moeda=5}");
	}
	
	@Test
	public void retornarRanking() {
		assertEquals(placar.retornarRanckingPontos(Pontos.ESTRELA).toString(), "[5=Maria, 5=Gerra, 4=Ana, 3=João]");
	}

}
