package componente.gamificacao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Repositorio {
	private String _nomeArquivo;

	public Repositorio(String nomeArquivo) {
		_nomeArquivo = nomeArquivo;
		inicializarArquivo();
	}

	private void inicializarArquivo() {
		File file = new File(_nomeArquivo);
		if (file.length() == 0) {
			salvarLista(new HashMap<String, Usuario>());
		}
	}

	public void salvarLista(Map<String, Usuario> usuarios) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_nomeArquivo)));
			out.writeObject(usuarios);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public Map<String, Usuario> buscarLista() {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(_nomeArquivo)));
			Object obj = in.readObject();
			in.close();
			return (Map<String, Usuario>) obj;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
