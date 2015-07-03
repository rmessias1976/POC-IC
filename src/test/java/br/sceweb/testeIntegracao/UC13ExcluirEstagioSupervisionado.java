package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.servico.HibernateEstagioSupervisionadoDAO;

public class UC13ExcluirEstagioSupervisionado {


	/**
	 * CTFB01ExcluirEstagioSupervisionado_Sucesso
	 * Objetivo: Verificar se o sistema Exclui o registro de estagio supervisionado
	 * pre-condicao: deve haver estagio supervisionado para ser excluido
	 */
	
	private static EstagioSupervisionado s;
	
	@BeforeClass
	public static void setuupBefore(){
		s = new EstagioSupervisionado();
		s.setRA("1234");
		HibernateEstagioSupervisionadoDAO dao = new HibernateEstagioSupervisionadoDAO();
		dao.cadastra(s);
	}
	
	
	@Test
	public void CTFB01ExcluirEstagioSupervisionado_Sucesso(){
		HibernateEstagioSupervisionadoDAO dao = new HibernateEstagioSupervisionadoDAO();
		dao.exclui("1234");
		EstagioSupervisionado retorno = dao.consulta(s);
		assertTrue(retorno == null);
	}
}
