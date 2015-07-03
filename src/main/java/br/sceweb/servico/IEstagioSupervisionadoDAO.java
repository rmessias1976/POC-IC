package br.sceweb.servico;

import java.util.List;

import br.sceweb.dominio.EstagioSupervisionado;



public interface IEstagioSupervisionadoDAO {
	/**
	 * 
	 * @return - retorna um list com todas os Estagios Supervisionados
	 */
	public List<EstagioSupervisionado> findAll();
		
	public void merge(EstagioSupervisionado estagioSupervisionado);
	/**
	 * exclui um estagio Supervisionado da base de dados
	 * @param empresa
	 */
	public void remove(EstagioSupervisionado estagioSupervisionado);
	
	public String cadastra(EstagioSupervisionado e);
	
	public int exclui(String ra);
	
	

	/**
	 * Cosultar estagio supervisionado a partir do RA do aluno
	 * 
	 * @param es
	 * @return
	 */
	public EstagioSupervisionado consulta(EstagioSupervisionado es);
	
	public String alterar(String ra);
	
}
