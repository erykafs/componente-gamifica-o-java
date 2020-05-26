package componente.gamificacao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Armazenamento {
	
	private Repositorio _repositorio;
	private Map<String, Usuario> _usuarios;
	private Usuario _usuarioAtual;
	
	public Armazenamento(Repositorio repositorio) {
		_repositorio = repositorio;
	}


	/**	Armazenar que um usuário recebeu uma quantidade de um tipo de ponto. 
	* Por exemplo: o usuário "guerra" recebeu "10" pontos do tipo "estrela"
	 * @throws IOException 
	*/
	public void armazenarPontos(Usuario usuario, Pontos pontos) throws IOException {
		_usuarioAtual = usuario;
		_usuarios = _repositorio.buscarLista();
		if (_usuarios == null) _usuarios = new HashMap<>();
		if (_usuarios.containsKey(usuario.getNome())) {
			_usuarioAtual = _usuarios.get(usuario.getNome());
			_usuarios.remove(usuario.getNome());
		}
		_usuarioAtual.adicionarPontos(pontos);
		_usuarios.put(_usuarioAtual.getNome(), _usuarioAtual);
		_repositorio.salvarLista(_usuarios);
	}
	
	/**	Recuperar quantos pontos de um tipo tem um usuário. 
	 * Por exemplo: retornar quantos pontos do tipo "estrela" tem o usuário "guerra"
	 */
	public int quantPontosTipo(String nome, String tipo) {
		if (_usuarios != null)
			if (_usuarios.containsKey(nome))
				return _usuarios.get(nome).retornaPontosTipo(tipo);
		return 0;
	}
	
	/**	Retornar todos os usuários que já receberam 
	 * algum tipo de ponto.
	 */
	public Set<String> usuariosComPontos() {
		_usuarios = _repositorio.buscarLista();
		if (_usuarios != null)
			return _usuarios.keySet();
		return null;
	}
	
	
	/**	Retornar todos os tipos de ponto que já foram 
	 * registrados para algum usuário.
	 */	
	public Map<String, Integer> pontosUsuario(String nomeUsuario) {
		_usuarios = _repositorio.buscarLista();
		if (_usuarios.containsKey(nomeUsuario))
			return _usuarios.get(nomeUsuario).getPontos();
		return null;
	}

}
