package br.sceweb.servico;

public class HibernateDAOFactory extends DAOFactory{
	@Override
	public IEmpresaDAO getEmpresaDAO() {
		return new HibernateEmpresaDAO();
	}

	@Override
	public IUsuarioDAO getUsuarioDAO() {
		return new HibernateUsuarioDAO();
	}
	
	@Override
	public IConvenioDAO getConvenioDAO() {
		return new HibernateConvenioDAO();
	}

	@Override
	public IEstagioDAO getEstagioDAO() {
		return new HibernateEstagioDAO();
	}

	@Override
	public IEstagioSupervisionadoDAO getEstagioSupervisionadoDAO() {
		return new HibernateEstagioSupervisionadoDAO();
	}
}