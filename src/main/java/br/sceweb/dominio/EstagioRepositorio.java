package br.sceweb.dominio;

import java.util.ArrayList;
import java.util.List;

import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioDAO;

/**
 * @author: edson
 * @version
 */
public class EstagioRepositorio {
	private IEstagioDAO daoEstagio;

	public EstagioRepositorio(int fabrica) {
		daoEstagio = DAOFactory.getDAOFactory(fabrica).getEstagioDAO();
	}

	/**
	 * Cadastra a empresa na base de dados
	 * 
	 * @param empresa
	 * @return boolean true cadastrado false nao cadastrado
	 */
	public String save(Estagio estagio) {
		return daoEstagio.cadastra(estagio);
	}

	public List<Estagio> findAll() {
		return daoEstagio.findAll();
	}

	public ArrayList<Estagio> consulta(String ra) {
		return (ArrayList<Estagio>) daoEstagio.consulta(ra);
	}

	public int exclui(String ra) {
		return daoEstagio.exclui(ra);
	}
}
