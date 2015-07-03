package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Fachada;

import br.sceweb.dominio.EstagioSupervisionado;


public class ConsultaRelatorioEstagioSupervisionado implements IComando{
			Fachada fachada = new Fachada();

			public ConsultaRelatorioEstagioSupervisionado() {
				fachada = new Fachada();
			}

			@Override
			public String executa(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				String url = "";
				EstagioSupervisionado estagio = new EstagioSupervisionado();
				ArrayList<EstagioSupervisionado> estagios = (ArrayList<EstagioSupervisionado>) fachada.consultaRelatorioEstagioSupervisionado();
				
				url = "/visao/FormRelatorioEstagioSupervisionado.jsp";
				if (!estagios.isEmpty()) {
					request.setAttribute("estagio", estagios);
					request.setAttribute("msg", "Estágio Encontrado");
					
				} else {
					request.setAttribute("msg", "Estágio Supervisionado não encontrado");
				}
				return url;
			}
}
