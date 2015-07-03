package br.sceweb.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Documento {
	@Id
	String identificador; //numero do ra + tipo do documento exemplo 1122_contrato, 1122_relatorio_estagio
	String versao;
	String ra;
	String cnpj;
	String dataDoUpload;
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getDataDoUpload() {
		return dataDoUpload;
	}
	public void setDataDoUpload(String dataDoUpload) {
		this.dataDoUpload = dataDoUpload;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
