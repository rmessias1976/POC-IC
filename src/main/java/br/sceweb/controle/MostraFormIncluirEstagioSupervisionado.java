package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormIncluirEstagioSupervisionado implements IComando {


	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("erro", null);
		return "/visao/FormEstagioSupervisionadoIncluir.jsp";

	}

}
