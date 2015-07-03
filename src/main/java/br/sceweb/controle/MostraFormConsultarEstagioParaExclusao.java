package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;

public class MostraFormConsultarEstagioParaExclusao implements IComando {

	private Fachada fachada;
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
		fachada = new Fachada();
	
		
		List<Estagio> listaEstagiarios = fachada.findAllEstagios();
		request.setAttribute("erro", null);
		request.setAttribute("listaEstagios", listaEstagiarios);
		return "/visao/FormEstagioExcluir.jsp";
	}

}
