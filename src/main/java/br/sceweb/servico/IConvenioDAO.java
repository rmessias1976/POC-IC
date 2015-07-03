package br.sceweb.servico;

import java.util.List;

import br.sceweb.dominio.Convenio;

public interface IConvenioDAO {
	public List<Convenio> findAll();
	public int update(Convenio convenio);
	public void remove(Convenio convenio);
	public String cadastra(Convenio c);
	public int exclui(String cnpj);
	public Convenio consulta(Convenio c);
	public List<Convenio> consulta(String cnpj);
	public int altera(String cnpj);
	public List<Convenio> listaConvenio();
}