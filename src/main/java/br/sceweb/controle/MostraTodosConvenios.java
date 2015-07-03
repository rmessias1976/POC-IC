package br.sceweb.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Convenio;
import br.sceweb.dominio.ConvenioRepositorio;

public class MostraTodosConvenios implements IComando {
	ConvenioRepositorio convenioRepositorio;
/**
 * O comando mostratodosconvenios seleciona o sgbd desejado
 * HIBERNATE = 1
 * MYSQL=2
 */
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) 	throws Exception {
		convenioRepositorio = new ConvenioRepositorio(1);
		List<Convenio> convenios = convenioRepositorio.findAll();
		request.setAttribute("convenios", convenios);
		return "/visao/FormConvenioConsultarTodos.jsp";
	}

}
