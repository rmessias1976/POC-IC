package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;

public class ConsultarEstagioResultado implements IComando{
	Fachada fachada = new Fachada();

	public ConsultarEstagioResultado() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String url = "";
		Estagio estagio = new Estagio();
		ArrayList<Estagio> estagios = fachada.consultaEstagios(request
							.getParameter("ra"));

		url = "/visao/FormEstagioAlterar.jsp";
		if (!estagios.isEmpty()) {		
			estagio = estagios.get(0);
			request.setAttribute("estagio", estagio);	
		} 
		return url;
	}
}
