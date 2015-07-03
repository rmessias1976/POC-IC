package br.sceweb.servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import br.sceweb.dominio.Estagio;


public class HibernateDocumentoDAO implements IDocumentoDAO{

	@Override
	public Estagio consultaRA(String ra) {
		Logger logger = Logger.getLogger("br.sceweb.dominio.estagio");
		logger.info("inicializando o procedimento");
		Estagio nova = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			nova = em.find(Estagio.class, ra);
			em.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		}
		return nova;

	}
	
}
