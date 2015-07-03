package br.sceweb.servico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import org.hibernate.JDBCException;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Empresa;

public class MySQLConvenioDAO implements IConvenioDAO{
	private static final String cadastraConvenio = "INSERT INTO convenio "
			+ "(codigo, , dataInicio, dataTermino, nomeDaEmpresa) VALUES (?,?, ?, ? ) ";
	private static final String excluiConvenio = "DELETE FROM convenio WHERE "
			+ "cnpj = ? ";
	private static final String consultaConvenio= "SELECT *  FROM convenio WHERE "
			+ "cnpj = ? ";
	private static final String consultaNome = "SELECT *  FROM convenio WHERE "
			+ "nomeDaEmpresa LIKE ? ";
	private static final String alterarDados = "UPDATE convenio SET nome = ? "
			+ ", dataInicio = ?, dataTermino=? WHERE cnpj = ? ";
	private static final String listar = "SELECT *  FROM convenio";
	String msg = "";

	@Override
	public List<Convenio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Convenio convenio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove(Convenio convenio) {
		PreparedStatement stmt;
		int rc = 0;
		try {
			stmt = MySQLDAOFactory.criaConexao().prepareStatement(excluiConvenio);
			stmt.setString(1, convenio.getCnpj());
			rc = stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
	}

	@Override
	public String cadastra(Convenio c) {
		PreparedStatement stmt;
		int rc = 0;
		try {
			stmt = MySQLDAOFactory.criaConexao().prepareStatement(cadastraConvenio);
			stmt.setInt(1, 1);
			stmt.setString(2, c.getCnpj());
			stmt.setString(3, c.getNomeDaEmpresa());
			stmt.setString(4, c.getDataInicio());
			stmt.setString(5, c.getDataTermino());

			rc = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException ex) {
			msg = ex.getMessage();
			System.out.println("metodo cadastra mysqlconveniodao =" + ex.getMessage());
		}
		return null;
	}

	@Override
	public int exclui(String cnpj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Convenio consulta(Convenio c) {
		ResultSet rs = null;
		PreparedStatement stmt;
		try {

			stmt = MySQLDAOFactory.criaConexao().prepareStatement(consultaNome);
			stmt.setString(1,c.getNomeDaEmpresa());

			rs = stmt.executeQuery();
			
			// stmt.close();
		} catch (SQLException ex) {
			msg = ex.getMessage();
		}
		return null;
	}

	@Override
	public List<Convenio> consulta(String cnpj) {
		ResultSet rs = null;
		PreparedStatement stmt;
		try {

			stmt = MySQLDAOFactory.criaConexao().prepareStatement(consultaConvenio);
			stmt.setString(1, cnpj);
			rs = stmt.executeQuery();
			// stmt.close();
		} catch (SQLException e) {
			
			msg = e.getMessage();
			System.out.println(msg);
		}
		return null;
	}

	@Override
	public int altera(String cnpj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Convenio> listaConvenio(){
		List<Convenio> listaConvenio = new ArrayList<Convenio>();
		ResultSet rs = null;
		PreparedStatement stmt;
		
		try {
			stmt = MySQLDAOFactory.criaConexao().prepareStatement(listar);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Convenio convenio = new Convenio();
				convenio.setCnpj(rs.getString("cnpj"));
				convenio.setNomeDaEmpresa(rs.getString("nomeDaEmpresa"));
				convenio.setDataInicio(rs.getString("dataInicio"));
				convenio.setDataTermino(rs.getString("dataTermino"));
				listaConvenio.add(convenio);
			}
		} catch (SQLException e) {
			msg = e.getMessage();
			System.out.println(msg);
		} catch (Exception e) {
			msg = e.getMessage();
			System.out.println(msg);
		}
		return listaConvenio;
	}

	public void RelatorioConvenio() throws JRException{
		ResultSet rs = null;
		PreparedStatement stmt;
		
		String sql = "select cnpj, nomeDaEmpresa, dataInicio, dataTermino from CONVENIO";

		try{
			   stmt = MySQLDAOFactory.criaConexao().prepareStatement(sql);
			   rs = stmt.executeQuery();

			   JRResultSetDataSource relResultado = new JRResultSetDataSource(rs);

			   JasperReport jr = JasperCompileManager.compileReport("RelatorioConvenio.jrxml");

			   JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<String, Object>(), relResultado);

			   JasperViewer jv = new JasperViewer(jp, false);

			   jv.setVisible(true);
			   rs.close();
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao chamar o relatório: " +ex);
		} catch(JDBCException e) {
			e.printStackTrace();
		}
	}
}