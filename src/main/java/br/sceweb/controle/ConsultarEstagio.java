package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;

public class ConsultarEstagio implements IComando {
	Fachada fachada = new Fachada();

	public ConsultarEstagio() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String url = "";
		Estagio estagio = new Estagio();
		ArrayList<Estagio> estagios = fachada.consultaEstagios(request
							.getParameter("txtRA"));
		
		url = "/visao/FormEstagioConsultar.jsp";
		if (!estagios.isEmpty()) {
			request.setAttribute("estagios", estagios);
			request.setAttribute("msg", "Estágio Localizado");
			
		} else {
			request.setAttribute("msg", "Estagio não localizado");
		}
		return url;
	}

}
