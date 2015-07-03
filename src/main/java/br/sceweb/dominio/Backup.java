package br.sceweb.dominio;

import java.util.Date;

public class Backup {
	
	String ServerName;
	String DataBase;
	Date Data;
	Date Hora;
	
	public String getServerName() {
		return ServerName;
	}
	public void setServerName(String serverName) {
		ServerName = serverName;
	}
	public String getDataBase() {
		return DataBase;
	}
	public void setDataBase(String dataBase) {
		DataBase = dataBase;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public Date getHora() {
		return Hora;
	}
	public void setHora(Date hora) {
		Hora = hora;
	}

}
