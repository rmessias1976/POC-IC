<%@ page import="br.sceweb.dominio.Estagio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
label {
	font: normal 12px courier !important;
}
</style>
<title>Alterar Estagio</title>
<link rel="stylesheet" type="text/css"
	href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function alterar() {
		document.formEstagioAlterar.acao.value = "AlterarEstagio";
		document.formEstagioAlterar.submit();
	}

	function voltar() {
		history.go(-1)
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Estagios - Alterar</h3>
		</div>
		<hr>
		<div id="formularioEstagioAlterar">

			<form name="formEstagioAlterar" action="/sce-web-ref2/ServletControle"
				method="post">
				<%
					Estagio estagio = (Estagio) request.getAttribute("estagio");
				%>
				<table id="tabcampos">
					<tr>
						<td><label> RA:</label></td>
						<td><input id="campoRA" size="10" type="text" name="txtRA"
							value="<%=estagio.getRa()%>"/></td>
					</tr>
					<tr>
						<td><label> Nome Completo:</label></td>
						<td><input id="campoNome" size="70" type="text"
							name="txtNome" value="<%=estagio.getNome()%>"/></td>
					</tr>
					<tr>
						<td><label> Data de Início:</label></td>
						<td><input id="campoDataInicio" size="10" type="text"
							name="txtDataInicio" value="<%=estagio.getDtInicio()%>"/></td>
					</tr>
					<tr>
						<td><label> Data de Término:</label></td>
						<td><input id="campoDataTermino" size="10" type="text"
							name="txtDataTermino" value="<%=estagio.getDtTermino()%>"></td>
					</tr>
					<tr>
						<td><label> Empresa:</label></td>
						<td><input id="campoEmpresa" size="70" type="text"
							name="txtEmpresa" value="<%=estagio.getEmpresa()%>"></td>
					</tr>
					<tr>
						<td><label> Responsável pelo Estágio:</label></td>
						<td><input id="campoResponsavel" size="70" type="text"
							name="txtResponsavel" value="<%=estagio.getResponsavel()%>"></td>
					</tr>
					<tr>
						<td><label> Curso:</label></td>
						<td><input id="campoCurso" size="70" type="text"
							name="txtCurso" value="<%=estagio.getCurso()%>"></td>
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center"><input
							id="botaoAlterar" type=button name=btnAlterar onclick=alterar()
							value=Alterar> <input
							id="botaoVoltar" type=button name=btnVoltar onclick=voltar()
							value=Voltar></td>
					</tr>
				</table>
				<input type="hidden" name="acao" value=""> <input
					type="hidden" name="menu" value="principal">
				<%
					String msg = (String) request.getAttribute("msg");
					if (msg == null)
						msg = "";
				%>
				<label><%=msg%></label>
			</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>