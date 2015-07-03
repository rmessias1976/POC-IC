package br.sceweb.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EstagioSupervisionado {

	@Id
	private String RA;
	private String nomeAluno;
	private String dataInicio; 
	private String dataTermino;
	private String empresa;
	private String responsavel;
	private String curso;
	private String semestre;
	private String turno;
	private String horasCumpridas;
	private String tipoEstagio;
	
	
	public EstagioSupervisionado() {

	}


	public String getRA() {
		return RA;
	}


	public void setRA(String rA) {
		RA = rA;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public String getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}


	public String getDataTermino() {
		return dataTermino;
	}


	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getHorasCumpridas() {
		return horasCumpridas;
	}


	public void setHorasCumpridas(String horasCumpridas) {
		this.horasCumpridas = horasCumpridas;
	}


	public String getTipoEstagio() {
		return tipoEstagio;
	}


	public void setTipoEstagio(String tipoEstagio) {
		this.tipoEstagio = tipoEstagio;
	}
	
	

}
