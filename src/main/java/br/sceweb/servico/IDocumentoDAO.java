package br.sceweb.servico;

import br.sceweb.dominio.Estagio;

public interface IDocumentoDAO {
	public Estagio consultaRA(String ra);
}
