package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.ConvenioRepositorio;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IConvenioDAO;

public class UC06ConsultarConvenio {
	 	static IConvenioDAO convenioDAO;
	    static ConvenioRepositorio convenioRepositorio;
	    static Convenio convenio;
	    Fachada fachada = new Fachada();
	    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenioDAO = DAOFactory.getDAOFactory(1).getConvenioDAO();
		convenio = new Convenio();
		convenio.setCnpj("33851384000105");
		convenio.setDataInicio("06/11/2014");
		convenio.setDataTermino("06/12/2015");
		convenio.setNomeDaEmpresa("primeira empresa de convenio 1");
		convenioDAO.cadastra(convenio);
		convenioRepositorio = new ConvenioRepositorio(1);
	}
	@Ignore("not ready yet")
	@Test
	public void CT01UC06ConsultarConvenio() {
		List<Convenio> convenios = convenioDAO.consulta("33851384000105");
		assertFalse(convenios.isEmpty());
	}
	@Ignore("not ready yet")
	@Test
	public void CT02UC06ConsultarConvenio() {
		List<Convenio> convenios = convenioRepositorio.consulta("33851384000105");
		assertFalse(convenios.isEmpty());
	}
	@Ignore("not ready yet")
	@Test
	public void CT03UC06ConsultarConvenio() {
		List<Convenio> convenios = fachada.consulta("33851384000105");
		assertFalse(convenios.isEmpty());
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}