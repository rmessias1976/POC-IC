package br.sceweb.testeIntegracao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEstagioSupervisionadoDAO;

public class UC26RelatorioEstagioSupervisionado {

	static IEstagioSupervisionadoDAO daoEstagioSupervisionado;
	static EstagioSupervisionado estagioSupervisionado;
	static Fachada fachada;
	@BeforeClass
	//preparar, instancia obj hibernate
	public static void setUpBeforeClass() throws Exception {
		
		fachada = new Fachada();
		
		daoEstagioSupervisionado = DAOFactory.getDAOFactory(1).getEstagioSupervisionadoDAO();
		estagioSupervisionado = new EstagioSupervisionado();
		estagioSupervisionado.setRA("122746");
		estagioSupervisionado.setNomeAluno("Carlos Silveira");
		estagioSupervisionado.setDataInicio("08/11/2014");
		estagioSupervisionado.setDataTermino("08/12/2014");
		estagioSupervisionado.setEmpresa("Microsoft");
		estagioSupervisionado.setResponsavel("Ivo Branquinho kkkk");
		estagioSupervisionado.setCurso("ADS");
		estagioSupervisionado.setSemestre("Quinto");
		estagioSupervisionado.setTurno("Noturno");
		estagioSupervisionado.setHorasCumpridas("30");
		estagioSupervisionado.setTipoEstagio("Supervisionado");
		
		daoEstagioSupervisionado.cadastra(estagioSupervisionado);

		//Aluno2
		estagioSupervisionado.setRA("122747");
		estagioSupervisionado.setNomeAluno("Branquinho");
		estagioSupervisionado.setDataInicio("08/11/2014");
		estagioSupervisionado.setDataTermino("08/12/2014");
		estagioSupervisionado.setEmpresa("Sony");
		estagioSupervisionado.setResponsavel("Ivo Branquinho kkkk");
		estagioSupervisionado.setCurso("ADS");
		estagioSupervisionado.setSemestre("Quinto");
		estagioSupervisionado.setTurno("Noturno");
		estagioSupervisionado.setHorasCumpridas("30");
		estagioSupervisionado.setTipoEstagio("Supervisionado");
		
		daoEstagioSupervisionado.cadastra(estagioSupervisionado);
		
		// Aluno3
		estagioSupervisionado.setRA("122748");
		estagioSupervisionado.setNomeAluno("Silveira");
		estagioSupervisionado.setDataInicio("08/11/2014");
		estagioSupervisionado.setDataTermino("08/12/2014");
		estagioSupervisionado.setEmpresa("Oracle");
		estagioSupervisionado.setResponsavel("Ivo Branquinho kkkk");
		estagioSupervisionado.setCurso("ADS");
		estagioSupervisionado.setSemestre("Quinto");
		estagioSupervisionado.setTurno("Noturno");
		estagioSupervisionado.setHorasCumpridas("30");
		estagioSupervisionado.setTipoEstagio("Supervisionado");
		
		daoEstagioSupervisionado.cadastra(estagioSupervisionado);
	}

	@Test
	public void CT01UC26RelatorioestSup_com_sucesso() {
		assertFalse(fachada.consultaRelatorioEstagioSupervisionado().isEmpty());
		
	}
	@Test
	public void CT02UC26RelatorioestSup_com_sucesso() {
		assertEquals(3, fachada.consultaRelatorioEstagioSupervisionado().size());
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoEstagioSupervisionado.exclui("122746");
		daoEstagioSupervisionado.exclui("122747");
		daoEstagioSupervisionado.exclui("122748");
	}
}
