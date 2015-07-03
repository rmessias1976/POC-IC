package br.sceweb.servico;

import java.util.List;

import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Usuario;

public interface IUsuarioDAO {

	public boolean login(String userName, String password);
	public String cadastra(Usuario u);
	public List<Usuario> consulta(String nome);
	public String altera(Usuario u);
	public List<Usuario> lista();
	public List<Usuario> findAll();
	public int exclui(String userID);
	
}
