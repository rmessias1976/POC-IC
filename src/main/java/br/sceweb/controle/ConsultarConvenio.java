package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Fachada;

public class ConsultarConvenio implements IComando{
	Fachada fachada;
	Logger logger = Logger.getLogger(ConsultarConvenio.class);
	public ConsultarConvenio(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "";
		Convenio convenio = new Convenio();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>chamou consultar convenio para o cnpj = " + request.getParameter("txtCNPJ"));
		ArrayList<Convenio> convenios = fachada.consulta(request.getParameter("txtCNPJ"));		
		if (! convenios.isEmpty()){ // se nao esta vazio
		    convenio = convenios.get(0);
		    request.setAttribute("cnpj", convenio.getCnpj());
		    request.setAttribute("nomeDaEmpresa", convenio.getNomeDaEmpresa());
		    request.setAttribute("dataInicio", convenio.getDataInicio());
		    request.setAttribute("dataTermino", convenio.getDataTermino());
		   
		    request.setAttribute("msg", "");
		    url = "/visao/FormConvenioConsultaResultado.jsp";
		}
		else{
			request.setAttribute("msg", "Empresa não localizada");
			url = "/visao/FormConsultaConvenio.jsp";
		}
		return url;
	}

}
