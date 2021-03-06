package br.sceweb.testeIntegracao;
import org.junit.Rule;

import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEmpresaDAO;

public class UC01CadastrarEmpresa {
	
	static IEmpresaDAO daoEmpresa;
	static Empresa empresa;
	static Fachada fachada;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fachada = new Fachada();
		daoEmpresa = DAOFactory.getDAOFactory(1).getEmpresaDAO();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("12121212");
		empresa.setResponsavel("jose silva");
		empresa.setTelefoneResponsavel("121212");
		empresa.setSetor("contabilidade");
		empresa.setEmail("jsilva@gmail.com");
		
	}
	//**********************************************************************************************************************************
	// * Testa servico
	// *********************************************************************************************************************************/

	/*
	 * CT01 - verifica o comportamento da camada de servico no cadastro de uma empresa com sucesso
	 */
	@Ignore("not ready yet")
	@Test
	public void CT01UC01FBCadastraEmpresa_com_sucesso() {
		daoEmpresa.exclui("89424232000180");
		assertEquals("Cadastro realizado com sucesso",daoEmpresa.cadastra(empresa));
		daoEmpresa.exclui("89424232000180");
		
	}
	/*
	 * CT02 - verifica o comportamento da camada de servico no cadastro de uma
	 * empresa ja cadastrada
	 */
	@Test //(expected=javax.persistence.RollbackException.class)
	public void CT02UC01A1CadastraEmpresa_ja_cadastrada() {
		daoEmpresa.cadastra(empresa);
		assertEquals("Erro no cadastro",daoEmpresa.cadastra(empresa));
		
		
	}
	/*
	 * CT03 - verifica o comportamento da camada de servico no cadastro de uma
	 * empresa com cnpj invalido
	 */
	
	@Test 
	public void CT03UC01A2CadastraEmpresa_com_cnpj_invalido() {
		try{
			empresa.setCnpj("894242320001806");
			fail("deveria gerar erro");
		}
		catch (IllegalArgumentException e){
			assertEquals("CNPJ inv�lido!", e.getMessage());
		}

	}
	//**********************************************************************************************************************************
	// * Testa dominio
	// **********************************************************************************************************************************/
	/*
	 * CT03 - verifica o comportamento da camada de dominio no cadastro de uma
	 * empresa com sucesso
	 */
	@Ignore("not ready yet")
	@Test
	public void UC01FBCT03CadastraEmpresa_com_sucesso() {
		//48526171000185
		assertEquals("Cadastro realizado com sucesso", fachada.incluirEmpresa("empresa x", "48526171000185", "empresa x", "rua taquari", "12121212", "jose silva", "1212", "contabilidade","jsilva@gmail.com"));
		daoEmpresa.exclui("48526171000185");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
