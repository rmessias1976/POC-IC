package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import br.sceweb.dominio.Empresa;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.HibernateEmpresaDAO;
import br.sceweb.servico.IEmpresaDAO;

public class UC23RelatorioEmpresa {
		static Empresa empresa ;
		static IEmpresaDAO hEDAO ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//setando os valores do ambiente de teste
		hEDAO = ( DAOFactory.getDAOFactory(1).getEmpresaDAO());
	    empresa = new Empresa();
		empresa.setCnpj("24973192000180");
		empresa.setDataInicio("11/01/2014");
		empresa.setDataFim("11/02/2014");
		empresa.setEndereco("R do Teste");
		empresa.setNomeDaEmpresa("Teste Empresa Ltda");
		empresa.setNomeFantasia("Testando Empresa");
		empresa.setResponsavel("Sr do Teste");
		empresa.setSetor("Comercial");
		empresa.setTelefone("99994444");
		empresa.setTelefoneResponsavel("45451313");
		hEDAO.cadastra(empresa);
		
		/*empresa.setCnpj("35017476000110");
		empresa.setDataInicio("11/01/2014");
		empresa.setDataFim("11/02/2014");
		empresa.setEndereco("R do Teste");
		empresa.setNomeDaEmpresa("Teste Empresa Ltda");
		empresa.setNomeFantasia("Testando Empresa");
		empresa.setResponsavel("Sr do Teste");
		empresa.setSetor("Comercial");
		empresa.setTelefone("99994444");
		empresa.setTelefoneResponsavel("45451313");
		hEDAO.cadastra(empresa);
		
		empresa.setCnpj("10445108000141");
		empresa.setDataInicio("11/01/2014");
		empresa.setDataFim("11/02/2014");
		empresa.setEndereco("R do Teste");
		empresa.setNomeDaEmpresa("Teste Empresa Ltda");
		empresa.setNomeFantasia("Testando Empresa");
		empresa.setResponsavel("Sr do Teste");
		empresa.setSetor("Comercial");
		empresa.setTelefone("99994444");
		empresa.setTelefoneResponsavel("45451313");
		hEDAO.cadastra(empresa);*/
		
				}
	
	// verifica o comportamento da camada de serviço no relatorios de empresa
	@Ignore("not ready yet")
	@Test
	public void CT01UC23FBRelatorioDeEmpresa_com_sucesso() {
		assert(hEDAO.lista().size() > 0);
		
	}
	
	@Ignore("not ready yet")
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}
