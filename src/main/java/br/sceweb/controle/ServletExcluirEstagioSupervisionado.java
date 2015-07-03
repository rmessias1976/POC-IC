package br.sceweb.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.sceweb.servico.HibernateEstagioSupervisionadoDAO;

/**
 * Servlet implementation class ServletExcluirEstagioSupervisionado
 */
@WebServlet("/ServletExcluirEstagioSupervisionado")
public class ServletExcluirEstagioSupervisionado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateEstagioSupervisionadoDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirEstagioSupervisionado() {
        super();
        // TODO Auto-generated constructor stub
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
			String ra = request.getParameter("ra");
			this.excluir(ra);
		}
		
		response.sendRedirect("./ServletListaEstagioSupervisionado");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*dao = new HibernateEstagioSupervisionadoDAO();
		HttpSession session = request.getSession();
		String ra = (String) session.getAttribute("RAESTAGIO");
		dao.exclui(ra);
		
		response.sendRedirect("/controle/ServletListaEstagioSupervisionado");*/ 
		//\main\java\br\sceweb\controle\ServletListaEstagioSupervisionado.java
	}
	
	public void excluir(String ra)
	{
		dao = new HibernateEstagioSupervisionadoDAO();
		dao.exclui(ra);
	}

}
