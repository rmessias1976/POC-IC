package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormConsultarUsuarioParaExclusao implements IComando {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) {
		request.setAttribute("erro", null);
		return "/visao/FormUsuarioExcluir.jsp";
	}

}
