package br.sceweb.dominio;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CopyOfFachada {
	Usuario usuario;
	Empresa empresa;
	Convenio convenio;
	EmpresaRepositorio empresaRepositorio;
	UsuarioRepositorio usuarioRepositorio;
	ConvenioRepositorio convenioRepositorio;
	EstagioRepositorio estagioRepositorio;
	Estagio estagio;
	EstagioSupervisionadoRepositorio estagioSupervisionadoRepositorio;
	EstagioSupervisionado estagioSupervisionado;

	Logger logger = Logger.getLogger(CopyOfFachada.class);

	/**
	 * O metodo construtor instancia o repositorio de acordo com sgbd desejado
	 * HIBERNATE = 1 MYSQL=2
	 */
	public CopyOfFachada() {
		empresaRepositorio = new EmpresaRepositorio(1);
		usuarioRepositorio = new UsuarioRepositorio(1);
		convenioRepositorio = new ConvenioRepositorio(1);
		estagioRepositorio = new EstagioRepositorio(1);
		estagioSupervisionadoRepositorio = new EstagioSupervisionadoRepositorio(1);
	}

	public boolean login(String userName, String password) {
		String url = "";
		return usuarioRepositorio.login(userName, password);

	}

	public String incluirEmpresa(String nomeDaEmpresa, String cnpj,
			String nomeFantasia, String endereco, String telefone,
			String responsavel, String telefoneResponsavel, String setor,
			String email) {

		empresa = new Empresa();
		String codigoRetorno = "";
		try {
			empresa.setNomeDaEmpresa(nomeDaEmpresa);
			empresa.setCnpj(cnpj);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setEndereco(endereco);
			empresa.setTelefone(telefone);
			empresa.setResponsavel(responsavel);
			empresa.setTelefoneResponsavel(telefoneResponsavel);
			empresa.setSetor(setor);
			empresa.setEmail(email);
		} catch (Exception e) {

			codigoRetorno = e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = empresaRepositorio.save(empresa);
		return codigoRetorno;

	}

	public ArrayList<Empresa> consultaCNPJ(String cnpj) {

		return empresaRepositorio.consulta(cnpj);
	}

	public int excluirEmpresa(String cnpj) {
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do cnpj para exclusao ="
				+ cnpj);
		return empresaRepositorio.exclui(cnpj);

	}

	public List<Empresa> listaTodas() {
		return (List<Empresa>) empresaRepositorio.findAll();
	}

	public ArrayList<Empresa> lista() {

		return empresaRepositorio.lista();
	}

	// Inicio do Fachada Convenio

	public String incluirConvenio(String cnpj, String nomeDaEmpresa,
			String dataInicio, String dataTermino) {

		convenio = new Convenio();
		String codigoRetorno = "";
		try {
			convenio.setCnpj(cnpj);
			convenio.setNomeDaEmpresa(nomeDaEmpresa);
			convenio.setDataInicio(dataInicio);
			convenio.setDataTermino(dataTermino);

		} catch (Exception e) {

			codigoRetorno = e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = convenioRepositorio.save(convenio);
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>incluir convenio chamado resultado ="
				+ codigoRetorno);
		return codigoRetorno;

	}

	public ArrayList<Convenio> consulta(String cnpj) {

		return convenioRepositorio.consulta(cnpj);
	}

	public int excluirConvenio(String cnpj) {
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do cnpj para exclusao ="
				+ cnpj);
		return convenioRepositorio.exclui(cnpj);

	}

	public int excluirEstagio(String ra) {
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do ra para exclusao ="
				+ ra);
		return estagioRepositorio.exclui(ra);

	}

	public List<Convenio> findAll() {
		return (List<Convenio>) convenioRepositorio.findAll();
	}

	public List<Estagio> findAllEstagios() {
		return (List<Estagio>) estagioRepositorio.findAll();
	}

	public ArrayList<Estagio> consultaEstagios(String ra) {
		return estagioRepositorio.consulta(ra);
	}

	// Inicio Fachada Estagio

	public String incluirEstagio(String ra, String nome, String dataInicio,
			String dataTermino, String empresa, String responsavel, String curso) {

		estagio = new Estagio();
		String codigoRetorno = "";
		try {
			estagio.setRa(ra);
			estagio.setNome(nome);
			estagio.setDtInicio(dataInicio);
			estagio.setDtTermino(dataTermino);
			estagio.setEmpresa(empresa);
			estagio.setResponsavel(responsavel);
			estagio.setCurso(curso);
		} catch (Exception e) {

			codigoRetorno = e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = estagioRepositorio.save(estagio);
		return codigoRetorno;

	}

	// Inicio do Fachada Usuário

	public String incluirUsuario(String nome, String userID, String senha) {

		usuario = new Usuario();
		String codigoRetorno = "";
		try {
			usuario.setNome(nome);
			usuario.setUserID(userID);
			usuario.setSenha(senha);

		} catch (Exception e) {

			codigoRetorno = e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = usuarioRepositorio.save(usuario);
		return codigoRetorno;

	}

	public ArrayList<Usuario> consultaUsuario(String nome) {
		return usuarioRepositorio.consulta(nome);
	}

	
	
	
	
	/*
	 * Inicio do Fachada Estagio Supervisionado
	 */
	
	public String incluirEstagioSupervisionado(String ra, String nomeAluno,
			String dataInicio, String dataTermino, String empresa,
			String responsavel, String curso, String semestre, 
			String turno, String horasCumpridas, String tipoEstagio) {
		
	

		estagioSupervisionado = new EstagioSupervisionado();
		String codigoRetorno = "";
		try {
			estagioSupervisionado.setRA(ra);
			estagioSupervisionado.setNomeAluno(nomeAluno);
			estagioSupervisionado.setDataInicio(dataInicio);
			estagioSupervisionado.setDataTermino(dataTermino);
			estagioSupervisionado.setEmpresa(empresa);
			estagioSupervisionado.setResponsavel(responsavel);
			estagioSupervisionado.setCurso(curso);
			estagioSupervisionado.setSemestre(semestre);
			estagioSupervisionado.setTurno(turno);
			estagioSupervisionado.setHorasCumpridas(horasCumpridas);
			estagioSupervisionado.setTipoEstagio(tipoEstagio);
		} catch (Exception e) {

			codigoRetorno = e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = estagioSupervisionadoRepositorio.save(estagioSupervisionado);
		return codigoRetorno;

	}

}