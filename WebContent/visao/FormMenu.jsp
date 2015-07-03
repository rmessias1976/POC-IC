<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Estagio</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function empresa() {
		document.formMenu.acao.value = "MostraFormMenuEmpresa";
		document.formMenu.submit();
	}
	function estagio() {
		document.formMenu.acao.value = "MostraFormMenuEstagio";
		document.formMenu.submit();
	}
	function usuario() {
		document.formMenu.acao.value = "MostraFormMenuUsuario";
		document.formMenu.submit();
	}
	function convenio() {
		document.formMenu.acao.value = "MostraFormMenuConvenio";
		document.formMenu.submit();
	}		
	function relatorio() {
			document.formMenu.acao.value = "MostraFormMenuRelatorio";
			document.formMenu.submit();
		}
		
	function upload() {
		document.formMenu.acao.value = "MostraUpload";
		document.formMenu.submit();
	}
	function estagioSupervisionado() {
		document.formMenu.acao.value = "MostraFormMenuEstagioSupervisionado";
		document.formMenu.submit();
	}
	function backup() {
		document.formMenu.acao.value = "MostraFormBackup";
		document.formMenu.submit();
	}
	function sair() {
		//window.close();
		history.go(-1);
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3 align=center>Menu Principal</h3>
		</div>
		<div id="menuSuperior">
		<form name="formMenu" action="/sce-web-ref2/ServletControle" method="post">
		<table id="tabmenu">
		<tr>
		<td>
		<input id="botao" type="button"	name="btnUsuario" onclick="usuario()" value="Usuários">
		</td>
		<td>
		<input id="botao" type="button"	name="btnEmpresa" onclick="empresa()" value="Empresas">
		</td>
		<td>
		<input id="botao" type="button"	name="btnEstagio" onclick="estagio()" value="Estagio">
		</td>
		<td>
		<input id="botao" type="button"	name="btnRelatorio" onclick="relatorio()" value="Relatórios">
		</td>
		<td>
		<input id="botao" type="button"	name="btnConvenio" onclick="convenio()" value="Convenio">
		</td>
		</tr>
		<tr>
		<td>
		<input id="botao" type="button"	name="btnEstagioSupervisionado" onclick="estagioSupervisionado()" value="Estagio Supervisionado">
		</td>
		<td>
		<input id="botao" type="button"	name="btnUpload" onclick="upload()" value="Upload">
		</td>
		<td> 
		<input id="botao" type="button"	name="btnBackup" onclick="backup()" value="Backup">
		</td>
		<td>
		<input id="botao" type="button"	name="btnSair" onclick="sair()" value="Sair">
		</td>
		
		<tr>
	
		</table>
		<input type="hidden" name="acao" value="">
		<input type="hidden" name="menu" value="principal">	
		</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>