package br.sceweb.controle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.sceweb.dominio.Fachada;

public class ExcluirConvenio implements IComando{
	
	Fachada fachada;
	String cnpjParaExclusao = "" ;//seta o cnpj para exclusao
	String nomeParaExclusao = "" ;//seta o nome para exclusao
	
	 Logger logger = Logger.getLogger(Fachada.class);
	public ExcluirConvenio() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		cnpjParaExclusao = (String) request.getParameter("txtCNPJ");
			
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do cnpj para exclusao comando excluir empresa="+ cnpjParaExclusao );		
		
		String msg="";
		int resultado = 0;
		resultado = fachada.excluirConvenio(cnpjParaExclusao.trim()); //retira os espacoes em branco

		if (resultado == 1)
			msg = "Registro excluido com sucesso";
			
		else
			msg = "Registro não excluido";
		request.setAttribute("msg", msg);
		
		return "/visao/FormConvenioExcluir.jsp";
	}

}
