package br.sceweb.servico;

import java.util.List;

import br.sceweb.dominio.Estagio;



public interface IEstagioDAO {
	/**
	 * 
	 * @return - retorna um list com todas os Estagios
	 */
	public List<Estagio> findAll();
		
	public void merge(Estagio estagio);
	/**
	 * exclui uma Estagio da base de dados
	 * @param estagio
	 */
	public void remove(Estagio estagio);
	
	public String cadastra(Estagio e);
	public int exclui(String cnpj);
	public Estagio consulta(Estagio e);
	public List<Estagio> consulta(String ra);
	int update(Estagio estagio);
}
