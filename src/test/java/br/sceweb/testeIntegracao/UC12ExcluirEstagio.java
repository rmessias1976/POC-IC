package br.sceweb.testeIntegracao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.EstagioRepositorio;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioDAO;

public class UC12ExcluirEstagio {
	IEstagioDAO estagioDAO;
	EstagioRepositorio estagioRepositorio;
	Estagio estagio;

	@Before
	public  void setUpBefore() throws Exception {
		estagioDAO = DAOFactory.getDAOFactory(1).getEstagioDAO();
		estagio = new Estagio();
		
		estagio.setCurso("ADS");
		estagio.setDtInicio("22/03/2000");
		estagio.setDtTermino("22/03/2001");
		estagio.setEmpresa("iurinho");
		estagio.setRa("1220561");
		estagio.setResponsavel("john");
		estagio.setNome("fuckersAndSuckers");
		estagioDAO.cadastra(estagio);
		
		estagioRepositorio = new EstagioRepositorio(1);

	}

	/**************************************************************************
	 * teste na camada de servico
	 **************************************************************************/

	@Ignore("not ready yet")	 
	@Test
	public void CT01UC12FBExcluirConveio_com_sucesso_Camada_Servico() {
		assertEquals(1, estagioDAO.exclui("1220561"));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT02UC12FA1ExcluirConveio_ra_invalido_Camada_Servico() {
		assertEquals(0, estagioDAO.exclui("A00000B"));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT03UC12FA2ExcluirConveio_ra_null_Camada_Servico() {
		assertEquals(0, estagioDAO.exclui(null));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT04UC12FA2ExcluirConveio_ra_branco_Camada_Servico() {
		assertEquals(0, estagioDAO.exclui(""));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT05UC12FA2ExcluirConveio_ra_naoCadastrado_Camada_Servico() {
		assertEquals(0, estagioDAO.exclui("0000000"));
	}

	/**************************************************************************
	 * teste na camada de dominio
	 **************************************************************************/
	@Ignore("not ready yet")
	@Test
	public void CT06UC12FBExcluirConveio_com_sucesso_Camada_Dominio() {
		estagioDAO.cadastra(estagio);
		assertEquals(1, estagioRepositorio.exclui("1220561"));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT07UC12FAExcluirConveio_ra_invalido_Camada_Dominio() {
		assertEquals(0, estagioRepositorio.exclui("A00000B"));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT08UC12FA2ExcluirConveio_ra_null_Camada_Dominio() {
		assertEquals(0, estagioRepositorio.exclui(null));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT09UC12FAExcluirConveio_ra_branco_Camada_Dominio() {
		assertEquals(0, estagioRepositorio.exclui(""));
	}
	
	@Ignore("not ready yet")
	@Test
	public void CT10UC12FA2ExcluirConveio_ra_naoCadastrado_Camada_Dominio() {
		assertEquals(0, estagioRepositorio.exclui("0000000"));
	}

}
