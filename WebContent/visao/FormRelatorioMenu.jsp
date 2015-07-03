<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Estagio</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function relatorioEmpresa() {
		document.formEmpresaMenu.acao.value = "MostraFormRelatorioEmpresa";
		document.formEmpresaMenu.submit();
	}
	function relusuario() {		
		document.formEmpresaMenu.acao.value = "MostraFormRelUsuario"; 
		document.formEmpresaMenu.submit();
	}
	function relelatorioEstagioSuper() {		
		document.formEmpresaMenu.acao.value = "MostraFormRelatorioEstagioSupervisionado"; 
		document.formEmpresaMenu.submit();
	}
	function relatorioVencimentoEstagio() {		
		document.formEmpresaMenu.acao.value = "MostraFormRelatorioVencimentoEstagio"; 
		document.formEmpresaMenu.submit();
	}
	function relatorioConvenio() {		
		document.formEmpresaMenu.acao.value = "MostraFormRelatorioConvenio"; 
		document.formEmpresaMenu.submit();
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
			<h3 align=center>Relatórios</h3>
		</div>
		<div id="menuSuperior">
		<form name="formEmpresaMenu" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabmenu">
					<tr>
						<td><input id="botao" type="button" name="btnRelatorioEmpresa" onclick="relatorioEmpresa()" value="Empresa"></td>
						<td><input id="botao" type="button" name="btnRelUsuario" onclick="relusuario()" value="Usuário"></td>
						<td><input id="botao" type="button" name="btnRelatorioEstagioSupervisionado" onclick="relelatorioEstagioSuper()" value="Estagio Supervisionado"></td>
						<td><input id="botao" type="button" name="btnRelatorioVencimentoEstagio" onclick="relatorioVencimentoEstagio()" value="Vencimento de Estágio"></td>
						<td><input id="botao" type="button" name="btnRelatorioConvenio" onclick="relatorioConvenio()" value="Convênio"></td>
						<td><input id="botao" type="button" name="btnVoltar" onclick="retornar()" value="Voltar"></td>
					<tr>
				</table>
				<input type="hidden" name="acao" value="">
		<input type="hidden" name="menu" value="empresas">	
		</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>