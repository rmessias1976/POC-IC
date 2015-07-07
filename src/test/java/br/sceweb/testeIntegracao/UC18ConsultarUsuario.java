package br.sceweb.testeIntegracao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Fachada;
import br.sceweb.dominio.Usuario;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IUsuarioDAO;

public class UC18ConsultarUsuario {
	
	static Fachada fachada;
	static IUsuarioDAO daoUsuario;
	static Usuario usuario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fachada = new Fachada();
		daoUsuario = DAOFactory.getDAOFactory(1).getUsuarioDAO();
		usuario = new Usuario();
		usuario.setUserID("adm");
		usuario.setNome("Teste");
		usuario.setSenha("adm123");
		daoUsuario.cadastra(usuario);
	}

	@Ignore("not ready yet")
	@Test
	public void CT01UC18FBConsultaUsuario_com_sucesso() {
		assertFalse(daoUsuario.consulta("Teste").isEmpty());
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT02UC18FBConsultarUsuario_com_sucesso() {
		assertEquals(1, daoUsuario.consulta("Teste").size());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoUsuario.exclui("adm");
	}

}
