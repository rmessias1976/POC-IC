package br.sceweb.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.EmpresaRepositorio;
import br.sceweb.dominio.Empresa;
import br.sceweb.dominio.Usuario;
import br.sceweb.dominio.UsuarioRepositorio;

public class MostraTodosUsuarios implements IComando {
	UsuarioRepositorio usuarioRepositorio;
/**
 * O comando mostratodosusuarios seleciona o sgbd desejado
 * HIBERNATE = 1
 * MYSQL=2
 */
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) 	throws Exception {
		usuarioRepositorio = new UsuarioRepositorio(1);
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		request.setAttribute("usuarios", usuarios);
		return "/visao/FormConsultarTodosUsuarios.jsp";
	}

}
