
package br.sceweb.servico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.dominio.Usuario;

public class HibernateEstagioSupervisionadoDAO implements IEstagioSupervisionadoDAO {
	Logger logger = Logger.getLogger(HibernateEstagioSupervisionadoDAO.class);

	/*
	 * Metodo de consulta para relatorioEstagioSupervisionado 
	 * 08/11/2014 - Dennis
	 */
	@SuppressWarnings("null")
	@Override
	public List<EstagioSupervisionado> findAll() {
		Logger logger = Logger.getLogger("br.sceweb.dominio.estagiosupervisionado");
		logger.info("inicializando o procedimento");
		List<EstagioSupervisionado> lista = new ArrayList<EstagioSupervisionado>();
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT e from EstagioSupervisionado e");
			lista = query.getResultList();

		} catch (Throwable e) {
		}
		return lista;
	}

	@Override
	public void merge(EstagioSupervisionado estagioSupervisionado) {

		
	}

	@Override
	public void remove(EstagioSupervisionado estagioSupervisionado) {

		
	}
	

	@Override
	public String cadastra(EstagioSupervisionado e) {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento cadastra");
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			em.close();
			codigoRetorno = "Cadastro realizado com sucesso";
		} catch (PersistenceException exception) { // HibernateException
			codigoRetorno = "Erro no cadastro";
			logger.info("disparou um erro na transacao de persistencia do tipo PersistenceException = "
					+ exception.toString());
		}

		return codigoRetorno;
		
		
	}

	@Override
	public int exclui(String ra) {

		logger.info("inicializando o procedimento");
		int codigoRetorno = 0;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();


			String jpql = " DELETE FROM EstagioSupervisionado e WHERE e.RA = :RA";

			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("RA", ra);
			codigoRetorno = query.executeUpdate();
			logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query exclui RA ="+ ra + " e codigoRetorno =" + codigoRetorno + " excluido");
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			exception.printStackTrace();

		}

		return codigoRetorno;
		
	}
	
	@Override
	public EstagioSupervisionado consulta(EstagioSupervisionado es) {
		Logger logger = Logger.getLogger("br.sceweb.dominio.estagiosupervisionado");
		logger.info("inicializando o procedimento");
		EstagioSupervisionado estagio = new EstagioSupervisionado();
		estagio = null;
		

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			estagio = em.find(EstagioSupervisionado.class, es.getRA());
			em.getTransaction().commit();
		
		} catch (HibernateException exception) {
			exception.printStackTrace();
		
		}
		return estagio;
	}
	@Override
	public String alterar(String ra) {
		// TODO Auto-generated method stub
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			Query query = em.createQuery (" UPDATE EstagioSupervisionado e SET e.nomealuno,e.datainicio"
					+ ",e.datatermino,e.empresa,e.reponsavel,e.curso,e.semestre,e.turno,e.horascumpridas,e.tipoestagio WHERE e.ra = :ra");
			query.setParameter("ra", ra);
			query.executeUpdate();
			em.getTransaction().commit();
			codigoRetorno = "Alteração realizada com sucesso";
		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			//logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao na alteracao de estágio supervisionado="	+ exception.getMessage());
			codigoRetorno = "Erro na alteração";
		}
		return codigoRetorno;
	}
}
