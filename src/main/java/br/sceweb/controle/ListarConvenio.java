package br.sceweb.controle;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.Fachada;

public class ListarConvenio implements IComando {
	Fachada fachada = new Fachada();
	
	public ListarConvenio(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "";
		Convenio convenio = new Convenio();
		ArrayList <Convenio> convenios = fachada.listaConvenio();
		
		if (! convenios.isEmpty()){
		    convenio = convenios.get(0);
		    
		    request.setAttribute("cnpj", convenio.getCnpj());
		    request.setAttribute("nomeDaEmpresa", convenio.getNomeDaEmpresa());
		    request.setAttribute("dataInicio", convenio.getDataInicio());
		    request.setAttribute("dataTermino", convenio.getDataTermino());
		    request.setAttribute("msg", "");
		    url = "/visao/FormRelatorioConvenioResultado.jsp";
		}
		else{
			request.setAttribute("msg", "Não há convenios cadastrados");
			url = "/visao/FormRelatorioConvenio.jsp";
		}
		return url;
	}

}
