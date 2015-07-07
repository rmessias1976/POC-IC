package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioDAO;

public class UC10ConsultarEstagio {
	static IEstagioDAO dao;
	static String ra = null;
	static Estagio estagio;
	static Fachada fachada = new Fachada();

	@Before
	public void setUp() throws Exception {
		dao = DAOFactory.getDAOFactory(1).getEstagioDAO();
		fachada = new Fachada();
		estagio = new Estagio();
		ra = "1222222";
		estagio.setResponsavel("Teste");
		estagio.setRa("1222222");
		estagio.setNome("Danilovkis");
		estagio.setEmpresa("Teste");
		estagio.setDtTermino("12/06/2014");
		estagio.setDtInicio("10/05/2014");
		estagio.setCurso("ADS");
		dao.cadastra(estagio);
	}

	@Test
	public void CT01UC10FBConsultaEstagioComSucesso() {
		assertEquals(1, fachada.consultaEstagios(ra).size());
	}

	@Test
	public void CT01UC10A1ConsultaRANaoCadastrado() {
		assertEquals(0, fachada.consultaEstagios("111111").size());
	}

	@Test
	public void CT01UC10A2ConsultaRAInvalido() {
		assertEquals(0, fachada.consultaEstagios("aaaaaaa").size());
	}

	@Test
	public void CT01UC10A3ConsultaRANulo() {
		assertEquals(0, fachada.consultaEstagios(null).size());
	}

	@Test
	public void CT01UC10A4ConsultaRABranco() {
		assert (fachada.consultaEstagios("").size() > 0);
	}

	@After
	public void tearDown() throws Exception {
		dao.remove(estagio);
	}

}
