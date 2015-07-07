package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Usuario;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.HibernateUsuarioDAO;
import br.sceweb.servico.IUsuarioDAO;

public class UC27RelatorioUsuario {
		static Usuario usuario ;
		static IUsuarioDAO hEDAO ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//setando os valores do ambiente de teste
		hEDAO = ( DAOFactory.getDAOFactory(1).getUsuarioDAO());
		usuario = new Usuario();
		usuario.setNome("Jesus");
		usuario.setSenha("123");
		usuario.setUserID("Jesusnaminhavida");		
		hEDAO.cadastra(usuario);		
		
				}
	
	// verifica o comportamento da camada de serviço no relatorios de usuario
	@Ignore("not ready yet")
	@Test
	public void CT01UC27FBRelatoriodeUsuario_com_sucesso() {
		assert(hEDAO.lista().size() > 0);
		
	}	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}
