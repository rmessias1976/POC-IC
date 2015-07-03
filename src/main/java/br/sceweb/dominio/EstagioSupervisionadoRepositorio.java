package br.sceweb.dominio;

import java.util.ArrayList;
import java.util.List;

import br.sceweb.servico.HibernateEstagioSupervisionadoDAO;
import br.sceweb.servico.IEstagioSupervisionadoDAO;

/**
 * @author: edson
 * @version
 */
public class EstagioSupervisionadoRepositorio {
	private IEstagioSupervisionadoDAO daoEstagioSupervisionado;

	public EstagioSupervisionadoRepositorio(int fabrica) {
		daoEstagioSupervisionado = new HibernateEstagioSupervisionadoDAO();
	}

	/**
	 * Cadastra o estagioSupervisionado supervisionado na base de dados
	 * 
	 * @param estagioSupervisionadoSupervisionado
	 * @return boolean true cadastrado false nao cadastrado
	 */
	
	public String save(EstagioSupervisionado estagioSupervisionado) {
		return daoEstagioSupervisionado.cadastra(estagioSupervisionado);
	}

	public List<EstagioSupervisionado> findAll() {
		return daoEstagioSupervisionado.findAll();
	}

	public ArrayList<EstagioSupervisionado> consulta(String ra) {
		//return (ArrayList<EstagioSupervisionado>) daoEstagioSupervisionado.consulta(ra);
		return new ArrayList<EstagioSupervisionado>();
	}

	public int exclui(String ra) {
		return daoEstagioSupervisionado.exclui(ra);
	}
}
