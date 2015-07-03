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
import br.sceweb.dominio.Estagio;

public class HibernateEstagioDAO implements IEstagioDAO {
	Logger logger = Logger.getLogger(HibernateEstagioDAO.class);

	public String cadastra(Estagio e) {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento cadastra");
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("sceweb");
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
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();

			String jpql = " DELETE FROM Estagio e WHERE e.ra = :ra";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("ra", ra);
			codigoRetorno = query.executeUpdate();
			logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query exclui estagio ="
					+ ra + " e codigoRetorno =" + codigoRetorno + " excluido");
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			exception.printStackTrace();

		}

		return codigoRetorno;

	}

	public Estagio consulta(Estagio e) {
		Logger logger = Logger.getLogger("br.sceweb.dominio.estagio");
		logger.info("inicializando o procedimento");
		Estagio nova = null;

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			nova = em.find(Estagio.class, e.getRa());
			em.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		}
		return nova;
	}

	@Override
	public List<Estagio> findAll() {
		List<Estagio> lista = new ArrayList<Estagio>();
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT e from Estagio e");
			lista = query.getResultList();

		} catch (Throwable e) {
		}
		return lista;
	}

	@Override
	public void merge(Estagio estagio) {

		logger.info("inicializando o procedimento");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.merge(estagio);
		
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query altera RA =" + estagio.getRa()
				+ ", nome ="
				+ estagio.getNome());
				
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
	
	@Override
	public int update(Estagio estagio) {
		logger.info("inicializando o procedimento");
		int codigoRetorno = 0;
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("sceweb");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Query query = em.createQuery("UPDATE Estagio as e SET e.ra = :ra, e.nome = :nome, e.dtInicio = :dtInicio,"
				+ "e.dtTermino = :dtTermino, e.empresa = :empresa, e.responsavel = :responsavel, e.curso = :curso WHERE e.ra = :ra");
		query.setParameter("ra", estagio.getRa());
		query.setParameter("nome", estagio.getNome());
		query.setParameter("dtInicio", estagio.getDtInicio());
		query.setParameter("dtTermino", estagio.getDtTermino());
		query.setParameter("empresa", estagio.getEmpresa());
		query.setParameter("responsavel", estagio.getResponsavel());
		query.setParameter("curso", estagio.getCurso());
		
		codigoRetorno = query.executeUpdate();
		em.getTransaction().commit();

		em.close();
		factory.close();
		
		return codigoRetorno;
	}
	

	@Override
	public void remove(Estagio estagio) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Estagio> consulta(String ra) {

		List<Estagio> results = null;
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT e FROM Estagio e WHERE e.ra like :ra";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			query.setParameter("ra", "%"+ra+"%");
			results = query.getResultList();
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao no consulta="
					+ exception.getMessage());

		}
		return (ArrayList<Estagio>) results;
	}

}
