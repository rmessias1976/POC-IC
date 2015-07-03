package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.sceweb.dominio.Fachada;

public class IncluirEstagioSupervisionado implements IComando{
	Fachada fachada;
	public IncluirEstagioSupervisionado(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = "";
		request.setAttribute("erro", null);
		
		try {
			resultado = fachada.incluirEstagioSupervisionado(request.getParameter("txtRaAluno"), 
					                     request.getParameter("txtNomeCompleto"),
					                     request.getParameter("txtDataInicio"),
					                     request.getParameter("txtDataTermino"),
					                     request.getParameter("txtEmpresa"),
					                     request.getParameter("txtResponsavel"),
					                     request.getParameter("txtCurso"),
					                     request.getParameter("txtSemestre"),
					                     request.getParameter("txtTurno"),
					                     request.getParameter("txtHorasCumpridas"),
					                     request.getParameter("txtTipoEstagio"));
					                   
			request.setAttribute("msg", resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", resultado);
		}
		return "/visao/FormEstagioSupervisionadoIncluir.jsp";
	}

}
