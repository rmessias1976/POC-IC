package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.sceweb.dominio.Usuario;
import br.sceweb.dominio.Fachada;

public class ConsultarUsuario implements IComando{
	Fachada fachada;
	public ConsultarUsuario(){
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "";
		Usuario usuario = new Usuario();
		ArrayList <Usuario> usuarios = fachada.consultaUsuario(request.getParameter("txtNomeUsuario"));
		
		if (! usuarios.isEmpty()){
		    usuario = usuarios.get(0);
		    
		    request.setAttribute("userID", usuario.getUserID());
		    request.setAttribute("senha", usuario.getSenha());
		    request.setAttribute("nome", usuario.getNome());
		   
		    request.setAttribute("msg", "");
		    url = "/visao/FormUsuarioConsultaResultado.jsp";
		}
		else{
			request.setAttribute("msg", "Usuário não localizado");
			url = "/visao/FormUsuarioConsultar.jsp";
		}
		return url;
	}

}
