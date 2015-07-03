package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormParaAlterarEstagio implements IComando {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		req.setAttribute("erro", null);	
		return "/visao/FormEstagioAlterar.jsp";
	}

}
