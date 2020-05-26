package componente.gamificacao.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import componente.gamificacao.Armazenamento;
import componente.gamificacao.Pontos;
import componente.gamificacao.Repositorio;
import componente.gamificacao.Usuario;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	private Repositorio repositorio;
	private String arquivo = "repositorio";
	
	@Before
	public void inicializar() {
		repositorio = new Repositorio(arquivo);
		armazenamento = new Armazenamento(repositorio);
	}

	@Test
	public void armazenarPontosUsuario1() throws IOException {
		armazenamento.armazenarPontos(new Usuario("Gerra"), new Pontos(Pontos.MOEDA, 6));
		armazenamento.armazenarPontos(new Usuario("Gerra"), new Pontos(Pontos.ESTRELA, 5));
		assertEquals(armazenamento.quantPontosTipo("Gerra", Pontos.MOEDA), 6);
	}
	
	@Test
	public void armazenarPontosUsuario2() throws IOException {
		armazenamento.armazenarPontos(new Usuario("Ana"), new Pontos(Pontos.ESTRELA, 4));
		armazenamento.armazenarPontos(new Usuario("Ana"), new Pontos(Pontos.MOEDA, 4));
		assertEquals(armazenamento.quantPontosTipo("Gerra", Pontos.ESTRELA), 5);
		assertEquals(armazenamento.quantPontosTipo("Ana", Pontos.ESTRELA), 4);
	}
	
	@Test
	public void armazenarPontosUsuario3() throws IOException {
		armazenamento.armazenarPontos(new Usuario("João"), new Pontos(Pontos.ESTRELA, 3));
		armazenamento.armazenarPontos(new Usuario("João"), new Pontos(Pontos.MOEDA, 4));
		assertEquals(armazenamento.quantPontosTipo("Gerra", Pontos.ESTRELA), 5);
		assertEquals(armazenamento.quantPontosTipo("Ana", Pontos.ESTRELA), 4);
		assertEquals(armazenamento.quantPontosTipo("João", Pontos.ESTRELA), 3);
	}
	
	@Test
	public void recuperaUsuariosComPontos() throws IOException {
		assertEquals(armazenamento.usuariosComPontos().toString(), "[Gerra, Ana, João]");
	}
	
	@Test
	public void recuperaPontosUsuario() throws IOException {
		assertEquals(armazenamento.pontosUsuario("Ana").toString(), "{Estrela=4, Moeda=4}");
		assertEquals(armazenamento.pontosUsuario("Gerra").toString(), "{Estrela=5, Moeda=6}");
		assertEquals(armazenamento.pontosUsuario("João").toString(), "{Estrela=3, Moeda=4}");
		assertEquals(armazenamento.pontosUsuario("Maria"), null);
	}

}
