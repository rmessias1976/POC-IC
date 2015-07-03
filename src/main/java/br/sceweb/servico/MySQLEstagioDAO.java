package br.sceweb.servico;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.sceweb.dominio.Estagio;

public class MySQLEstagioDAO implements IEstagioDAO {

	private static final String excluiEstagio = "DELETE FROM estagio WHERE "
			+ "ra = ? ";
	String msg = "";

	@Override
	public List<Estagio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void merge(Estagio estagio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Estagio estagio) {
		// TODO Auto-generated method stub

	}

	@Override
	public String cadastra(Estagio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int exclui(String ra) {
		PreparedStatement stmt;
		int rc = 0;
		try {
			stmt = MySQLDAOFactory.criaConexao()
					.prepareStatement(excluiEstagio);
			stmt.setString(1, ra);
			rc = stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return rc;
	}

	@Override
	public Estagio consulta(Estagio e) {
		return null;
	}

	@Override
	public List<Estagio> consulta(String ra) {
		return null;
	}

	@Override
	public int update(Estagio estagio) {
		// TODO Auto-generated method stub
		return 0;
	}

}
