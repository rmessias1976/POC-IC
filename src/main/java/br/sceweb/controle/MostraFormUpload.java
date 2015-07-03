package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormUpload implements IComando {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		return "/visao/FormUpload.jsp";
	}

}
