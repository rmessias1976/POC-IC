package br.sceweb.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MostraFormRelatorioEstagioSupervisionado implements IComando {

	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			

			return "/visao/FormRelatorioEstagioSupervisionado.jsp";
	}
}
