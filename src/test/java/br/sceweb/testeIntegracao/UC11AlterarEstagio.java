package br.sceweb.testeIntegracao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import br.sceweb.dominio.Estagio;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioDAO;

public class UC11AlterarEstagio {

	private IEstagioDAO daoEstagio;
	private Estagio estagio;

	@Before
	public void setUp() throws Exception {
		daoEstagio = DAOFactory.getDAOFactory(1).getEstagioDAO();
		estagio = new Estagio();
		estagio.setRa("123456789");
		estagio.setNome("Alexandre");
		estagio.setDtInicio("01/01/2000");
		estagio.setDtTermino("02/02/2001");
		estagio.setEmpresa("FATEC");
		estagio.setResponsavel("Pablo");
		estagio.setCurso("ADS");
		daoEstagio.cadastra(estagio);
	}

	@Ignore("not ready yet")
	@Test
	public void CT01UC11FBCadastrar_Estagio_com_sucesso() {

		Estagio estagio = new Estagio();
		estagio.setRa("123456789");
		estagio.setNome("Gabriel");

		assertEquals("Estágio alterado com sucesso", 1,
				daoEstagio.update(estagio));
	}

	@Ignore("not ready yet")
	@Test
	public void CT02UC11FBCadastrar_Estagio_com_sucesso_verifica_estado_do_objeto() {

		Estagio estagioTemp = daoEstagio.consulta(estagio);
		
		assertEquals("Estágio cadastrado e recuperado com sucesso", estagio, estagioTemp);
	}	
	
	@Ignore("not ready yet")
	@Test
	public void CT03UC11FA01AlterarEstagio() {

		Estagio estagio = new Estagio();
		estagio.setRa("12345678910");
		estagio.setNome("Gabriel");

		assertEquals("Estágio não alterado com sucesso", 0,
				daoEstagio.update(estagio));
	}

	@After
	public void algumaCoisa() {
		daoEstagio.exclui(estagio.getRa());
	}
}
