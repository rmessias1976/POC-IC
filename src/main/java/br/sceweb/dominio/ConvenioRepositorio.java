
package br.sceweb.dominio;

import java.util.ArrayList;
import java.util.List;

import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.HibernateEmpresaDAO;
import br.sceweb.servico.IConvenioDAO;


public class ConvenioRepositorio {
	private IConvenioDAO daoConvenio;
	
	public ConvenioRepositorio(int fabrica) {
		daoConvenio = DAOFactory.getDAOFactory(fabrica).getConvenioDAO();
	}
	
	 
	public String save (Convenio convenio){
		return daoConvenio.cadastra(convenio);
		
	}
	public List<Convenio> findAll(){
		return daoConvenio.findAll();
	}
	public ArrayList<Convenio> consulta(String cnpj){
		return (ArrayList<Convenio>) daoConvenio.consulta(cnpj);
	}
	public int exclui(String cnpj){
		return daoConvenio.exclui(cnpj);
	}
	
	public ArrayList<Convenio> listaConvenio(){
		return (ArrayList<Convenio>) daoConvenio.listaConvenio();
	}
}
