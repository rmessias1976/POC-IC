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

import br.sceweb.dominio.EstagioSupervisionado;
import br.sceweb.servico.HibernateEstagioSupervisionadoDAO;

/**
 * Servlet implementation class AlterarEstagioSupervisionado
 */
@WebServlet("/AlterarEstagioSupervisionado")
public class ServletAlterarEstagioSupervisionado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateEstagioSupervisionadoDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarEstagioSupervisionado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String cmd = "";
		
		cmd = request.getParameter("cmd");
		
		if("CONSULTAR".equalsIgnoreCase(cmd))
		{
		
		EstagioSupervisionado Estagio = new EstagioSupervisionado();
		dao = new HibernateEstagioSupervisionadoDAO();
		//listaEstagios= dao.findAll();
		
		HttpSession session =request.getSession();
		session.setAttribute("ESTAGIO", Estagio);
		
		response.sendRedirect("/visao/FormEstagioSupervisionadoAlterar.jsp");
		}
		else if("ALTERAR".equalsIgnoreCase(cmd))
		{
			EstagioSupervisionado e = new EstagioSupervisionado();
			
			String ra = request.getParameter("txtRaAluno");
			e.setRA(ra);
			
			e.setNomeAluno(request.getParameter("txtNomeCompleto"));
			e.setDataInicio(request.getParameter("txtDataInicio"));
			e.setDataTermino(request.getParameter("txtDataTermino"));
			e.setEmpresa(request.getParameter("txtEmpresa"));
			e.setResponsavel(request.getParameter("txtResponsavel"));;
			e.setCurso(request.getParameter("txtCurso"));
			e.setSemestre(request.getParameter("txtSemestre"));
			e.setTurno(request.getParameter("txtTurno"));
			e.setHorasCumpridas(request.getParameter("txtHorasCumpridas"));
			e.setTipoEstagio(request.getParameter("txtTipoEstagio"));
			
			dao.alterar(ra);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
