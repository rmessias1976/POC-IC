package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Estagio;
import br.sceweb.servico.HibernateEstagioDAO;

public class AlterarEstagio implements IComando {

	private HibernateEstagioDAO estagioDAO;
	
	public AlterarEstagio() {
		estagioDAO = new HibernateEstagioDAO();
	}
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String resultado = "";
		request.setAttribute("erro", null);
		
		Estagio estagio = new Estagio();

		try {
			estagio.setRa(request.getParameter("txtRA"));
			estagio.setNome(request.getParameter("txtNome"));
			estagio.setDtInicio(request.getParameter("txtDataInicio"));
			estagio.setDtTermino(request.getParameter("txtDataTermino"));
			estagio.setEmpresa(request.getParameter("txtEmpresa"));
			estagio.setResponsavel(request.getParameter("txtResponsavel"));
			estagio.setCurso(request.getParameter("txtCurso"));
			estagioDAO.merge(estagio);
			
			resultado = "Estagio alterado com sucesso !!";
			
			request.setAttribute("msg", resultado);
		} catch (Exception e) {
			request.setAttribute("msg", resultado);
		}
		return "/visao/FormEstagioConsultar.jsp";
	}
}
