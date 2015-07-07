package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.rules.ExpectedException;

import br.sceweb.dominio.Fachada;
import br.sceweb.dominio.Usuario;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IUsuarioDAO;

public class UC20AlterarUsuario {

	static IUsuarioDAO daoUsuario;
	static Usuario usuario;
	static Fachada fachada;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoUsuario = DAOFactory.getDAOFactory(1).getUsuarioDAO();
		fachada = new Fachada();
		usuario = new Usuario();
		usuario.setNome("John Doe");
		usuario.setSenha("foo");
		usuario.setUserID("bar");
		daoUsuario.cadastra(usuario);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoUsuario.exclui(usuario.getUserID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT01AlterarUsuarioValido() {
		usuario.setSenha("ct01");
		usuario.setUserID("ct01");
		assertEquals("Alteração de usuário realizada com sucesso", daoUsuario.altera(usuario));
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT02AlterarUsuarioNaoCadastrado() {
		Usuario u = new Usuario();
		u.setNome("ct02");
		u.setSenha("ct02");
		u.setUserID("ct02");
		assertEquals("Erro no cadastro", daoUsuario.altera(u));
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT03AlterarUsuarioComCamposEmBranco() {
		Usuario u = new Usuario();
		u.setNome("John Doe");
		u.setSenha("");
		u.setUserID("");
		assertEquals("Valor dos campos não pode ficar vazio", daoUsuario.altera(u));
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT04AlterarUsuarioComValoresAlemDoPermitido() {
		Usuario u = new Usuario();
		u.setNome("1234567890123456789012345678901234567890");
		u.setSenha("foo");
		u.setUserID("bar");
		assertEquals("Nome de usuário muito longo. Maximo 32 caracteres.", daoUsuario.altera(u));
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT05AlterarUsuarioComValoresAlemDoPermitido() {
		Usuario u = new Usuario();
		u.setNome("foo");
		u.setSenha("12345678901234567890");
		u.setUserID("bar");
		assertEquals("Senha muito longa. Maximo 16 caracteres.", daoUsuario.altera(u));
	}

	@Ignore("not ready yet")
	@Test
	public void UC20FBCT06AlterarUsuarioComValoresAlemDoPermitido() {
		Usuario u = new Usuario();
		u.setNome("foo");
		u.setSenha("bar");
		u.setUserID("12345678901234567890");
		assertEquals("ID de usuário muito longo. Maximo 16 caracteres.", daoUsuario.altera(u));
	}

}
