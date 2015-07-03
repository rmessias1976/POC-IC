package br.sceweb.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.sceweb.dominio.Fachada;

public class IncluirUsuario implements IComando{
	Fachada fachada;
	public IncluirUsuario(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = "";
		request.setAttribute("erro", null);
		
		try {
			resultado = fachada.incluirUsuario(request.getParameter("txtNomeDoUsuario"), 
					                     request.getParameter("txtUserId"),
					                     request.getParameter("txtSenha"));
			request.setAttribute("msg", resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", resultado);
		}
		return "/visao/FormUsuarioIncluir.jsp";
	}

}
