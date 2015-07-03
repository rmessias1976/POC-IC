package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormRelatorioConvenio implements IComando {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
		return "/visao/FormRelatorioConvenio.jsp";
	}
}