package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Estagio;
import br.sceweb.dominio.Fachada;

public class ConsultarVencimentoEstagio implements IComando{
		Fachada fachada = new Fachada();

		public ConsultarVencimentoEstagio() {
			fachada = new Fachada();
		}

		@Override
		public String executa(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			String url = "";
			Estagio estagio = new Estagio();
			ArrayList<Estagio> estagios = fachada.consultaEstagios(request
								.getParameter("txtRA"));
			
			url = "/visao/FormRelatorioVencimentoEstagio.jsp";
			if (!estagios.isEmpty()) {
				estagio = estagios.get(0);
				request.setAttribute("estagio", estagio);
				//request.setAttribute("msg", "Estágio Encontrado");
				
			} else {
				request.setAttribute("msg", "Estágio não encontrado");
			}
			return url;
		}

	}
