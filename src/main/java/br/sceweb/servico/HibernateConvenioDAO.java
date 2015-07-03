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

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Empresa;

public class HibernateConvenioDAO implements IConvenioDAO {
	Logger logger = Logger.getLogger(HibernateConvenioDAO.class);

	public String cadastra(Convenio c) {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento cadastra");
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
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

	public int exclui(String cnpj) {

		logger.info("inicializando o procedimento");
		int codigoRetorno = 0;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();

			String jpql = " DELETE FROM Convenio c WHERE c.cnpj = :cnpj";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("cnpj", cnpj);
			codigoRetorno = query.executeUpdate();
			logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query exclui cnpj ="+ cnpj + " c codigoRetorno =" + codigoRetorno + " excluido");
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			exception.printStackTrace();

		}

		return codigoRetorno;

	}

	public Convenio consulta(Convenio c) {
		
		logger.info("inicializando o procedimento");
		Convenio nova = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			nova = em.find(Convenio.class, c.getCnpj());
			em.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		}
		return nova;
	}

	@Override
	public List<Convenio> findAll() {
		List<Convenio> lista = new ArrayList<Convenio>();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT c from Convenio c");
			lista = query.getResultList();

		} catch (Throwable e) {
		}
		return lista;
	}

	@Override
	public int update(Convenio e) {
		logger.info("inicializando o procedimento");
		int codigoRetorno = 0;
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("sceweb");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Query query = em.createQuery("UPDATE Convenio as c SET c.dataTermino = :datatermino, c.dataInicio = :datainicio WHERE c.cnpj = :cnpj");
		query.setParameter("datatermino", e.getDataTermino());
		query.setParameter("datainicio", e.getDataInicio());
		query.setParameter("cnpj", e.getCnpj());
		
		codigoRetorno = query.executeUpdate();
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query altera cnpj ="+ e.getCnpj() + ", data inicio =" + e.getDataInicio() + "e data termino =" + e.getDataTermino() + " alterado");
		em.getTransaction().commit();

		em.close();
		factory.close();
		
		return codigoRetorno;			

	}

	@Override
	public void remove(Convenio convenio) {
	}

	@Override
	public ArrayList<Convenio> consulta(String cnpj) {

		List<Convenio> results = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT c FROM Convenio c WHERE c.cnpj = :cnpj";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			query.setParameter("cnpj", cnpj);
			results = query.getResultList();
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao no consulta="	+ exception.getMessage());

		}
		return (ArrayList<Convenio>) results;
	}

	@Override
	public int altera(String cnpj) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			Query query = em.createQuery (" UPDATE Convenio c SET c.dataInicio WHERE c.cnpj = :cnpj");
			query.setParameter("cnpj", cnpj);
			query.executeUpdate ();
			em.getTransaction().commit();
		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao na alteracao de convenio="	+ exception.getMessage());

		}
		return 0;
	}
	
	@Override
	public ArrayList<Convenio> listaConvenio() {

		List<Convenio> results = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT c FROM Convenio";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			results = query.getResultList();
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao na listagem ="	+ exception.getMessage());
		}
		return (ArrayList<Convenio>) results;
	}

}
