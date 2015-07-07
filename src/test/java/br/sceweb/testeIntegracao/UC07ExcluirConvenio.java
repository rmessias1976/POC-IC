package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.ConvenioRepositorio;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.HibernateConvenioDAO;
import br.sceweb.servico.IConvenioDAO;

public class UC07ExcluirConvenio {
    static IConvenioDAO convenioDAO;
    static ConvenioRepositorio convenioRepositorio;
    static Convenio convenio;
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

	/**************************************************************************
	 * teste na camada de servico
	 **************************************************************************/	
	@Ignore("not ready yet")
	@Test
	public void CT01UC07ExcluirConveio_com_sucesso() {
		assertEquals(1,convenioDAO.exclui("33851384000105"));
	}
	/**************************************************************************
	 * teste na camada de dominio
	 **************************************************************************/
	@Ignore("not ready yet")
	@Test
	public void CT02UC07ExcluirConveio_com_sucesso() {
		convenioDAO.cadastra(convenio);
		assertEquals(1,convenioRepositorio.exclui("33851384000105"));
	}
	@AfterClass
		public static void tearDownAfterClass() throws Exception {
	}
}
