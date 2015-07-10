<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<title>Excluir Estagio</title>
<link rel="stylesheet" type="text/css"
	href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function excluir() {
		document.formEstagioExcluir.acao.value = "ExcluirEstagio";
		document.formEstagioExcluir.submit();
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
			<h3>Controle de Estagios - Exclusão</h3>
		</div>
		<hr>
		<div id="formularioEstagioExcluir">
			<%
				List<Estagio> listaEstagios = (ArrayList) request
						.getAttribute("listaEstagios");
			%>
			<form name="formEstagioExcluir" action="ServletControle2"
				method="post">
				<label> RA:</label> <select id="campoRA" name="raParaExclusao">
					<option>Selecione um RA</option>
					<%
						if (listaEstagios != null) {
							for (Estagio estagio : listaEstagios) {
					%>
					<option id="<%=estagio.getRa()%>" value="<%=estagio.getRa()%>">

						<%=estagio.getRa()%> -
						<%=estagio.getNome()%> -
						<%=estagio.getCurso()%>

					</option>
					<%
						}
						}
					%>
					<input type="button" id="btnExcluir" name="btnExcluir"
					value="Excluir Registro" onclick="excluir();" />
					<input type="hidden" name="acao" value="">
					<input type="hidden" name="menu" value="principal">
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