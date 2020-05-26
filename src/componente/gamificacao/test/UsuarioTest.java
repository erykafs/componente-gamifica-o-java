package componente.gamificacao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import componente.gamificacao.Pontos;
import componente.gamificacao.Usuario;

public class UsuarioTest {
	
	private Usuario usuario;
	private Pontos pontos1;
	private Pontos pontos2;
	private Pontos pontos3;
	
	@Before
	public void inicializar() {
		usuario = new Usuario("Gerra");
		pontos1 = new Pontos(Pontos.MOEDA, 6);
		pontos2 = new Pontos(Pontos.ESTRELA, 5);
	}
	
	
	@Test
	public void adicionarUmTipoPontos() {
		usuario.adicionarPontos(pontos1);
		assertEquals(usuario.tiposPontos(), 1);
		assertEquals(usuario.retornaPontosTipo(Pontos.MOEDA), 6);	
	}
	
	@Test
	public void adicionarDoisTipoPontos() {
		usuario.adicionarPontos(pontos1);
		usuario.adicionarPontos(pontos2);
		assertEquals(usuario.tiposPontos(), 2);
		assertEquals(usuario.retornaPontosTipo(Pontos.MOEDA), 6);
		assertEquals(usuario.retornaPontosTipo(Pontos.ESTRELA), 5);	
	}
	
	@Test
	public void adicionarTipoPontosRepetidos() {
		pontos3 = new Pontos(Pontos.MOEDA, 7);
		usuario.adicionarPontos(pontos1);
		usuario.adicionarPontos(pontos2);
		usuario.adicionarPontos(pontos3);
		assertEquals(usuario.tiposPontos(), 2);
		assertEquals(usuario.retornaPontosTipo(Pontos.MOEDA), 7);
		assertEquals(usuario.retornaPontosTipo(Pontos.ESTRELA), 5);	
	}
	
	@Test
	public void adicionarPontosZerados() {
		pontos3 = new Pontos(Pontos.COMENTARIO, 0);
		usuario.adicionarPontos(pontos1);
		usuario.adicionarPontos(pontos2);
		usuario.adicionarPontos(pontos3);
		assertEquals(usuario.tiposPontos(), 2);
	}
	
	@Test
	public void retornarPontos() {
		pontos3 = new Pontos(Pontos.MOEDA, 7);
		usuario.adicionarPontos(pontos1);
		usuario.adicionarPontos(pontos2);
		usuario.adicionarPontos(pontos3);
		assertEquals(usuario.todasPontuacoes(), "Estrela = 5 Moeda = 7 ");
	}

}
