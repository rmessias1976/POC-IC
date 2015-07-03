<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Convenio</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function incluir() {
		document.formConvenioMenu.acao.value = "MostraFormIncluirConvenio";
		document.formConvenioMenu.submit();
	}
	function alterar() {
		document.formConvenioMenu.acao.value = "MostraFormAlterarConvenio";
		document.formConvenioMenu.submit();
	}
	function excluir() {
		document.formConvenioMenu.acao.value = "MostraFormExcluirConvenio";
		document.formConvenioMenu.submit();
	}
	function consultar() {
		document.formConvenioMenu.acao.value = "MostraFormConsultarConvenio";
		document.formConvenioMenu.submit();
	}
	function consultarTodos() {
		document.formConvenioMenu.acao.value = "MostraTodosConvenios";
		document.formConvenioMenu.submit();
	}
	function retornar() {
		history.go(-1);
	}
</script>
</head>
<body>
<jsp:include page="Cabecalho.jsp" />
<div id="principal">
		<div id="titulo">
			<h3 align=center>Controle de Convenios</h3>
		</div>
		<div id="menuSuperior">
		<form name="formConvenioMenu" action="/sce-web-ref2/ServletControle" method="post">
		<table id="tabmenu">
		<tr>
		<td>
		<input id="botao" type="button"	name="btnIncluir" onclick="incluir()" value="Incluir">
		</td>
		<td>
		<input id="botao" type="button"	name="btnExcluir" onclick="excluir()" value="Excluir">
		</td>
		
		<td>
		<input id="botao" type="button"	name="btnConsultar" onclick="consultar()" value="Consultar/Alterar">
		</td>
		<td>
		<input id="botao" type="button"	name="btnConsultarTodos" onclick="consultarTodos()" value="Todos">
		</td>
		<td>
		<input id="botao" type="button"	name="btnVoltar" onclick="retornar()" value="Voltar">
		</td>
		<tr>
	
		</table>
		<input type="hidden" name="acao" value="">
		<input type="hidden" name="menu" value="convenios">	
		</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>