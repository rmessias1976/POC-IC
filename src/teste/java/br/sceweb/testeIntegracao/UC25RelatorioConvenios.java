package br.sceweb.testeIntegracao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Convenio;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IConvenioDAO;

public class UC25RelatorioConvenios {

	static IConvenioDAO daoConvenio;
	static Convenio convenio;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenio = new Convenio();
		daoConvenio = DAOFactory.getDAOFactory(1).getConvenioDAO();
		convenio.setCnpj("44835901000179");
		convenio.setNomeDaEmpresa("Nike");
		convenio.setDataInicio("01/01/2014");
		convenio.setDataTermino("01/01/2015");
		daoConvenio.cadastra(convenio);

		convenio.setCnpj("05395432000162");
		convenio.setNomeDaEmpresa("Adidas");
		convenio.setDataInicio("01/01/2014");
		convenio.setDataTermino("01/01/2015");
		daoConvenio.cadastra(convenio);
		
		convenio.setCnpj("65687373000128");
		convenio.setNomeDaEmpresa("Umbro");
		convenio.setDataInicio("01/01/2014");
		convenio.setDataTermino("01/01/2015");
		daoConvenio.cadastra(convenio);
	}

	@Test
	public void CT01UC25RelatorioConvenio_com_sucesso() {
		assertFalse(daoConvenio.findAll().isEmpty());
	}
	@Test
	public void CT02UC25RelatorioConvenio_com_sucesso() {
		assertEquals(3,daoConvenio.findAll().size());
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}