package br.sceweb.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	String nome;
	String userID;
	String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
