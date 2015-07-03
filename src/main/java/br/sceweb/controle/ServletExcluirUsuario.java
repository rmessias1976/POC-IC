package br.sceweb.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.servico.HibernateUsuarioDAO;

/**
 * Servlet implementation class ServletExcluirUsuario
 */
@WebServlet("/ServletExcluirUsuario")
public class ServletExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateUsuarioDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = "";
		
		cmd = request.getParameter("cmd");
		
		if("excluir".equalsIgnoreCase(cmd))
		{	
			//exclusão
			String userID = request.getParameter("userID");
			this.excluir(userID);
		}
		
		response.sendRedirect("./ServletListaUsuario");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	public void excluir(String userID){
		dao = new HibernateUsuarioDAO();
		dao.exclui(userID);
	}

}
