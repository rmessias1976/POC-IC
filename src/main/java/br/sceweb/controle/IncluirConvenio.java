package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Fachada;

public class IncluirConvenio implements IComando{
	Fachada fachada;
	Logger logger = Logger.getLogger(IncluirConvenio.class);
	public IncluirConvenio(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = "";
		request.setAttribute("erro", null);
		Empresa empresa = new Empresa();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>chamou o cmd incluir convenio para o cnpj = " + request.getParameter("txtCNPJ"));
		ArrayList<Empresa> empresas = fachada.consultaCNPJ(request.getParameter("txtCNPJ"));	
		
		try {
			if (! empresas.isEmpty()){
				empresa = empresas.get(0);
			      resultado = fachada.incluirConvenio(request.getParameter("txtCNPJ"), 
			    		  				 empresa.getNomeDaEmpresa(), 
			    		                 request.getParameter("txtDataInicio"),
					                     request.getParameter("txtDataTermino"));
			      request.setAttribute("msg", resultado);
			} else{
				resultado = "Empresa invalida";
				request.setAttribute("msg", resultado);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", resultado);
		}
		return "/visao/FormConvenioIncluir.jsp";
	}

}
