package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Fachada;

public class IncluirEstagio implements IComando{
	Fachada fachada;
	public IncluirEstagio(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = "";
		request.setAttribute("erro", null);
		
		try {
			resultado = fachada.incluirEstagio(request.getParameter("txtRA"), 
							                     request.getParameter("txtNome"),
							                     request.getParameter("txtDataInicio"),
							                     request.getParameter("txtDataTermino"),
							                     request.getParameter("txtEmpresa"),
							                     request.getParameter("txtResponsavel"),
							                     request.getParameter("txtCurso"));

			request.setAttribute("msg", resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", resultado);
		}
		return "/visao/FormEstagioIncluir.jsp";
	}

}
