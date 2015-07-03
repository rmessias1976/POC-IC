package br.sceweb.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.sceweb.dominio.Usuario;
import br.sceweb.servico.HibernateUsuarioDAO;

/**
 * Servlet implementation class ServletListaUsuario
 */
@WebServlet("/ServletListaUsuario")
public class ServletListaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateUsuarioDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		dao = new HibernateUsuarioDAO();
		listaUsuarios= dao.findAll();
		
		HttpSession session =request.getSession();
		session.setAttribute("LISTAUSUARIO", listaUsuarios);
		
		response.sendRedirect("/visao/FormUsuarioExcluir.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
