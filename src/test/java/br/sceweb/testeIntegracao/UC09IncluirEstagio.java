package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioDAO;

public class UC09IncluirEstagio {
	
	static IEstagioDAO daoEstagio;
	static Estagio estagio;
	static Fachada fachada;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fachada = new Fachada();
		daoEstagio = DAOFactory.getDAOFactory(1).getEstagioDAO();
		estagio = new Estagio();
		//89.424.232/0001-80
		estagio.setCurso("Administração");
		estagio.setDtInicio("20140105");
		estagio.setDtTermino("20140605");
		estagio.setEmpresa("Teleatlantic");
		estagio.setNome("Renato Geraldes Eraclide");
		estagio.setRa("1220731");
		estagio.setResponsavel("Edson Arantes do Nascimento");
	}

	//**********************************************************************************************************************************
	// * Testa servico
	// *********************************************************************************************************************************/

	/*
	 * CT09 - verifica o comportamento da camada de servico no cadastro de um estagio com sucesso.
	 */
	@Test
	public void UC09FBCT01CadastraEstagio_com_sucesso() {
		daoEstagio.exclui("1220731");
		assertEquals("Cadastro realizado com sucesso",daoEstagio.cadastra(estagio));
		daoEstagio.exclui("1220731");
		
	}
	
	/*
	 * CT09 - verifica o comportamento da camada de servico no cadastro de um
	 * estagio ja cadastrado
	 */
	@Test //(expected=javax.persistence.RollbackException.class)
	public void UC09A1CT02CadastraEstagio_ja_cadastrado() {
		daoEstagio.cadastra(estagio);
		assertEquals("Erro no cadastro",daoEstagio.cadastra(estagio));

		
	}
	
	//**********************************************************************************************************************************
	// * Testa dominio
	// **********************************************************************************************************************************/
	/*
	 * CT03 - verifica o comportamento da camada de dominio no cadastro de uma
	 * estagio com sucesso
	 */
	@Test
	public void UC09FBCT03CadastraEstagio_com_sucesso() {
		//48526171000185
		assertEquals("Cadastro realizado com sucesso", fachada.incluirEstagio("12207317", "Renato Geraldes Eraclide", "20140105", "20140605", "Teleatlantic", "Edson Arantes do Nascimento", "Administração"));
		daoEstagio.exclui("12207317");
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	
	

}
