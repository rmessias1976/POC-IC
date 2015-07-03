package br.sceweb.servico;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Usuario;

	public class MySQLUsuarioDAO implements IUsuarioDAO {
		private static final String login = "SELECT * FROM usuario WHERE userID = ? AND senha= ?";
		private static final String cadastraUsuario = "INSERT INTO usuario (userID, senha, nome) VALUES ( ?, ?,?) ";
		private static final String consultaNome = "SELECT * FROM usuario WHERE nome LIKE ?";
		private static final String listar = "SELECT *  FROM usuario";
		private static final String excluiUsuario = "DELETE FROM usuario WHERE userID = ?";
		String msg = "";
		@Override
		public boolean login(String userName, String password) {
			ResultSet rs = null;
			PreparedStatement stmt;
			try {
				
				stmt = MySQLDAOFactory.criaConexao().prepareStatement(login);
				stmt.setString(1, userName);
				stmt.setString(2, password);
				rs = stmt.executeQuery();

				if (rs.next()) {

					return true;
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("erro =>" + e.getMessage());
				//e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("erro =>" + e.getMessage());
				//e.printStackTrace();
			}
			return false;
		}
		
		public String cadastra(Usuario u) {
			PreparedStatement stmt;
			int rc = 0;
			try {
				stmt = MySQLDAOFactory.criaConexao().prepareStatement(cadastraUsuario);
				stmt.setString(1, u.getUserID());
				stmt.setString(2, u.getSenha());
				stmt.setString(3, u.getNome());
				

				rc = stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				msg = e.getMessage();
				System.out.println("metodo cadastra mysqlusuariodao =" + e.getMessage());
			}
			return null;
		}
		public String getMessage() {
			return msg;
		}

		@Override
		public List<Usuario> consulta(String nome) {
			ResultSet rs = null;
			PreparedStatement stmt;
			try {

				stmt = MySQLDAOFactory.criaConexao().prepareStatement(consultaNome);
				stmt.setString(1, nome);
				rs = stmt.executeQuery();
				// stmt.close();
			} catch (SQLException e) {
				
				msg = e.getMessage();
				System.out.println(msg);
			}
			return null;
		}

		@Override
		public String altera(Usuario u) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public List<Usuario> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public List<Usuario> lista(){
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			ResultSet rs = null;
			PreparedStatement stmt;
			
			try {
				stmt = MySQLDAOFactory.criaConexao().prepareStatement(listar);
				rs = stmt.executeQuery();
				
				while(rs.next()){
					Usuario usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					usuario.setUserID(rs.getString("userid"));
					listaUsuarios.add(usuario);
				}
			} catch (SQLException e) {
				msg = e.getMessage();
				System.out.println(msg);
			} catch (Exception e) {
				msg = e.getMessage();
				System.out.println(msg);
			}
			return listaUsuarios;
		}

		@Override
		public int exclui(String userID) {
			ResultSet rs = null;
			PreparedStatement stmt;
			try {
				stmt = MySQLDAOFactory.criaConexao().prepareStatement(excluiUsuario);
				stmt.setString(1, userID);
				rs = stmt.executeQuery();
				
			} catch (SQLException e) {
				msg = e.getMessage();
				System.out.println(msg);
			}
			return 0;
		}
	}


