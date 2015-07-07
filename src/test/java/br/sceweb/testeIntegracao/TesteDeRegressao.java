package br.sceweb.testeIntegracao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UC28Login.class, UC01CadastrarEmpresa.class,UC02ConsultarEmpresa.class,UC03ExcluirEmpresa.class,
	            UC06ConsultarConvenio.class, UC07ExcluirConvenio.class, UC09IncluirEstagio.class, UC10ConsultarEstagio.class, UC23RelatorioEmpresa.class})
public class TesteDeRegressao {

}
