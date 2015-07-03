package br.sceweb.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.Usuario;
import br.sceweb.dominio.UsuarioRepositorio;

public class MostraFormRelUsuario implements IComando {
	UsuarioRepositorio usuarioRepositorio;
	@Override
	/*public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/visao/FormRelUsuario.jsp";
	}*/
	
	public String executa(HttpServletRequest request, HttpServletResponse res) 	throws Exception {
		usuarioRepositorio = new UsuarioRepositorio(1);
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		request.setAttribute("usuarios", usuarios);
		return "/visao/FormConsultarTodosUsuarios.jsp";
	}
}