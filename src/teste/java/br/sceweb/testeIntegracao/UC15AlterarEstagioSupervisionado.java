package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioSupervisionadoDAO;

public class UC15AlterarEstagioSupervisionado {

	static IEstagioSupervisionadoDAO daoEstagioSupervisionado;
	static EstagioSupervisionado estagioSupervisionado;
	static Fachada fachada;
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoEstagioSupervisionado = DAOFactory.getDAOFactory(1).getEstagioSupervisionadoDAO();
		fachada = new Fachada();
		
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
