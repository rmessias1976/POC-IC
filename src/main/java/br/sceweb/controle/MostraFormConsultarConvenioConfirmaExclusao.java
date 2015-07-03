package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Fachada;

public class MostraFormConsultarConvenioConfirmaExclusao implements IComando {
	public Fachada fachada;
	String cnpjParaExclusao = "" ;//seta o cnpj para exclusao
	Logger logger = Logger.getLogger(MostraFormConsultarConvenioConfirmaExclusao.class);
	public MostraFormConsultarConvenioConfirmaExclusao(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "";
		Convenio convenio = new Convenio();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>chamou exclusao de convenio para o cnpj = " + request.getParameter("txtCNPJ"));
		ArrayList<Convenio> convenios = fachada.consulta(request.getParameter("txtCNPJ"));		

		if (!convenios.isEmpty()) {
			convenio = convenios.get(0);
			cnpjParaExclusao = convenio.getCnpj();			
			request.setAttribute("cnpj", convenio.getCnpj());
			request.setAttribute("nomeDaEmpresa", convenio.getNomeDaEmpresa());
			url = "/visao/FormConvenioExcluirConfirma.jsp";
		} else {
			request.setAttribute("msg", "Convenio não localizado");
			url = "/visao/FormConvenioExcluir.jsp";
		}
		return url;
	}

}
