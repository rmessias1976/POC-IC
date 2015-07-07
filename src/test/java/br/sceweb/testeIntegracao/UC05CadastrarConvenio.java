package br.sceweb.testeIntegracao;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IConvenioDAO;

public class UC05CadastrarConvenio {
	
	static IConvenioDAO daoConvenio;
	static Convenio convenio;
	static Fachada fachada;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fachada = new Fachada();
		daoConvenio = DAOFactory.getDAOFactory(1).getConvenioDAO();
		convenio = new Convenio();
		//89.424.232/0001-80
		
		convenio.setCnpj("89424232000180");
		convenio.setNomeDaEmpresa("empresa x");		
		convenio.setDataInicio("11/11/2011");
		convenio.setDataTermino("11/11/2012");		
	}
	//**********************************************************************************************************************************
	// * Testa servico
	// *********************************************************************************************************************************/

	/*
	 * CT01 - verifica o comportamento da camada de servico no cadastro de um convenio com sucesso
	 */
	@Test
	public void CT01UC01FBCadastraConvenio_com_sucesso() {
		daoConvenio.exclui("89424232000180");
		assertEquals("Cadastro realizado com sucesso",daoConvenio.cadastra(convenio));
		daoConvenio.exclui("89424232000180");
		
	}
	/*
	 * CT02 - verifica o comportamento da camada de servico no cadastro de um
	 * convenio ja cadastrado
	 */
	@Test //(expected=javax.persistence.RollbackException.class)
	public void CT02UC01A1CadastraConvenio_ja_cadastrada() {
		daoConvenio.cadastra(convenio);
		assertEquals("Erro no cadastro",daoConvenio.cadastra(convenio));
		
		
	}
	/*
	 * CT03 - verifica o comportamento da camada de servico no cadastro de uma
	 * convenio com cnpj invalido
	 */
	
	@Test 
	public void CT03UC01A2CadastraConvenio_com_cnpj_invalido() throws Exception {
		try{
			convenio.setCnpj("894242320001806");
			fail("deveria gerar erro");
		}
		catch (IllegalArgumentException e){
			assertEquals("CNPJ inválido!", e.getMessage());
		}

	}
	//**********************************************************************************************************************************
	// * Testa dominio
	// **********************************************************************************************************************************/
	/*
	 * CT03 - verifica o comportamento da camada de dominio no cadastro de um
	 * convenio com sucesso
	 */
	@Test
	public void UC01FBCT03CadastraConvenio_com_sucesso() {
		//48526171000185
		assertEquals("Cadastro realizado com sucesso", fachada.incluirConvenio("48526171000185", "empresa x", "11/11/2011", "11/11/2012"));
		daoConvenio.exclui("48526171000185");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
