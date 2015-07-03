package br.sceweb.dominio;


import java.util.ArrayList;
import java.util.List;

import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IUsuarioDAO;

public class UsuarioRepositorio {
	private IUsuarioDAO daoUsuario;
/**
 * O metodo construtor recebe como parametro o SGBD selecionado
 * @param fabrica - MYSQL = 2 HIBERNATE = 1
 */
	public UsuarioRepositorio(int fabrica) {
		this.daoUsuario = DAOFactory.getDAOFactory(fabrica).getUsuarioDAO();
	}
	public boolean login(String nome, String senha) {
			return daoUsuario.login(nome, senha);
	}
	public String save (Usuario usuario){
		return daoUsuario.cadastra(usuario);
	}
	public ArrayList<Usuario> consulta(String nome){
		return (ArrayList<Usuario>) daoUsuario.consulta(nome);
	}
	public String altera(Usuario u) {
		return daoUsuario.altera(u);
	}
	public List<Usuario> findAll(){
		return daoUsuario.findAll();
	}
	public ArrayList<Usuario> lista(){
		return (ArrayList<Usuario>) daoUsuario.lista();
	}
	
}
