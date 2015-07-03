package br.sceweb.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;

public class ExcluirEstagio implements IComando {
	Fachada fachada;
	String raParaExclusao = "";// seta o ra para exclusao
	Logger logger = Logger.getLogger(Fachada.class);

	public ExcluirEstagio() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		raParaExclusao = (String) req.getParameter("raParaExclusao");
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do cnpj para exclusao comando excluir empresa="
				+ raParaExclusao);
		String msg = "";
		int resultado = 0;
		resultado = fachada.excluirEstagio(raParaExclusao.trim()); // retira os
																	// espacoes
																	// em branco

		if (resultado == 1)
			msg = "Registro excluido com sucesso";

		else
			msg = "Registro não excluido";
		req.setAttribute("msg", msg);

		List<Estagio> listaEstagiarios = fachada.findAllEstagios();
		req.setAttribute("erro", null);
		req.setAttribute("listaEstagios", listaEstagiarios);
		return "/visao/FormEstagioExcluir.jsp";
	}

}
