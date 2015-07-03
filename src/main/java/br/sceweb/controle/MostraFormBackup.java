package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormBackup implements IComando {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("erro", null);
		return "/visao/FormBackup.jsp";
	}

}