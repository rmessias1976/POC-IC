package br.sceweb.controle;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Fachada;
import br.sceweb.dominio.Usuario;

public class MostraFormAlterarUsuario implements IComando {

	Fachada fachada;

	public MostraFormAlterarUsuario() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		ArrayList<Usuario> usuarios = fachada.consultaUsuario(request.getParameter("txtNomeUsuario"));

		if (request.getParameter("txtUserID") != null &&
			request.getParameter("txtNomeUsuario") != null &&
			request.getParameter("txtSenhaUsuario") != null &&
			!request.getParameter("txtUserID").equals("") &&
			!request.getParameter("txtNomeUsuario").equals("") &&
			!request.getParameter("txtSenhaUsuario").equals("")
		) {

			Usuario usuario = new Usuario();

			usuario.setUserID(request.getParameter("txtUserID"));
			usuario.setNome(request.getParameter("txtNomeUsuario"));
			usuario.setSenha(request.getParameter("txtSenhaUsuario"));

			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("userID", usuario.getUserID());
			request.setAttribute("senha", usuario.getSenha());
			request.setAttribute("msg", fachada.alterarUsuario(usuario));
			request.setAttribute("erro", null);

			url = "/visao/FormUsuarioAlterar.jsp";

		} else if (!usuarios.isEmpty()) {

			Usuario usuario = usuarios.get(0);

			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("userID", usuario.getUserID());
			request.setAttribute("senha", usuario.getSenha());
			request.setAttribute("msg", "");
			request.setAttribute("erro", null);

			url = "/visao/FormUsuarioAlterar.jsp";

		} else {

			request.setAttribute("msg", "Usuário não encontrado");
			url = "/visao/FormUsuarioConsultar.jsp";

		}

		return url;
	}

}
