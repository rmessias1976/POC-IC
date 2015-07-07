package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.dominio.Fachada;
import br.sceweb.servico.DAOFactory;
import br.sceweb.servico.IEmpresaDAO;
import br.sceweb.servico.IEstagioSupervisionadoDAO;

public class UC13CadastrarEstagioSupervisionado {
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
		
	}

	@AfterClass
	//deletar dados cadastrados
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Ignore("not ready yet")
	@Test
	//incluir com sucesso
	public void UC01FBCT01CadastraEstagioSupervisionado_com_sucesso() {
		daoEstagioSupervisionado.exclui("122746");
		assertEquals("Cadastro realizado com sucesso",daoEstagioSupervisionado.cadastra(estagioSupervisionado));
		daoEstagioSupervisionado.exclui("122746");
		
	}

}
