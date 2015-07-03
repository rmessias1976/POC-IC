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

import br.sceweb.dominio.Usuario;


public class HibernateUsuarioDAO implements IUsuarioDAO {
	Logger logger = Logger.getLogger(HibernateUsuarioDAO.class);
	@Override
	public boolean login(String userName, String password) {
		ArrayList<?> results = null;
		try {
			//stmt = MySQLDAOFactory.criaConexao().prepareStatement(login);
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT u FROM Usuario u WHERE u.userID = :userName and u.senha = :password";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			results = (ArrayList<?>) query.getResultList();
			em.getTransaction().commit();
			em.close();
			
		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao no consulta="	+ exception.getMessage());

		}
		return (!results.isEmpty()); //se nao esta vazio? achou
	}
	@Override
	public String cadastra(Usuario u) {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento cadastro Usuário");
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			codigoRetorno = "Cadastro de usuário realizado com sucesso";
		} catch (PersistenceException exception) { // HibernateException
			codigoRetorno = "Erro no cadastro";
			logger.info("disparou um erro na transacao de persistencia do tipo PersistenceException = "
					+ exception.toString());
		}

		return codigoRetorno;

	}
	@Override
	public ArrayList<Usuario> consulta(String nome) {
		List<Usuario> results = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT u FROM Usuario u WHERE u.nome = :nome";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			query.setParameter("nome", nome);
			results = query.getResultList();
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			// throw new Exception("ERRO..... " );
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao no consulta="	+ exception.getMessage());

		}
		return (ArrayList<Usuario>) results;
	}
	
	@Override
	public String altera(Usuario u) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento de alterar Usuário");
		String codigoRetorno = "";

		if (u.getNome().equals("") || u.getSenha().equals("") || u.getUserID().equals("")) {
			return "Valor dos campos não pode ficar vazio";
		}

		if (u.getNome().length() > 32) {
			return "Nome de usuário muito longo. Maximo 32 caracteres.";
		}

		if (u.getSenha().length() > 16) {
			return "Senha muito longa. Maximo 16 caracteres.";
		}

		if (u.getUserID().length() > 16) {
			return "ID de usuário muito longo. Maximo 16 caracteres.";
		}

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Usuario usuario = em.find(Usuario.class, u.getNome());

			// TODO: Não pode alterar a key do usuário. A key deveria ser a UserID, não o Nome.
			//usuario.setNome(u.getNome());

			usuario.setUserID(u.getUserID());
			usuario.setSenha(u.getSenha());

			em.getTransaction().commit();
			em.close();
			codigoRetorno = "Alteração de usuário realizada com sucesso";

		} catch (Exception e) { // HibernateException
			codigoRetorno = "Erro no cadastro";
			logger.info("disparou um erro na transacao de merge: " + e.toString());
		}

		return codigoRetorno;
	}
	
	public List<Usuario> findAll() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT e from Usuario e");
			lista = query.getResultList();

		} catch (Throwable e) {
		}
		return lista;
	}
	
	@Override
	public ArrayList<Usuario> lista() {

		List<Usuario> results = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();
			String hql = " SELECT e FROM Usuario";
			em.getTransaction().begin();
			Query query = em.createQuery(hql);
			results = query.getResultList();
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> excecao na listagem ="	+ exception.getMessage());
		}
		return (ArrayList<Usuario>) results;
	}
	@Override
	public int exclui(String userID) {
		logger.info("inicializando o procedimento");
		int codigoRetorno = 0;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
			EntityManager em = factory.createEntityManager();

			String jpql = " DELETE FROM Usuario u WHERE u.userID = :userID";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("userID", userID);
			codigoRetorno = query.executeUpdate();
			logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query exclui userID ="+ userID + " e codigoRetorno =" + codigoRetorno + " excluido");
			em.getTransaction().commit();

		} catch (HibernateException exception) {
			exception.printStackTrace();

		}
		return codigoRetorno;
	}
	

}
