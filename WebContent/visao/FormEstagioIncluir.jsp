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
<title>Incluir Estagio</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function incluir() {
		document.formEstagioIncluir.acao.value = "IncluirEstagio";
		document.formEstagioIncluir.submit();
	}
	
	function voltar() {
		history.go(-2)
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Estagios - Inclus�o</h3>
		</div>
		<hr>
		<div id="formEstagioIncluir">

			<form name="formEstagioIncluir" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> RA:</label></td>
						<td><input id="campoRA" size="10" type="text" name="txtRA"
							value=""></td>
					</tr>
					<tr>
						<td><label> Nome Completo:</label></td>
						<td><input id="campoNome" size="70" type="text" name="txtNome"
							value=""></td>
					</tr>
					<tr>
						<td><label> Data de In�cio:</label></td>
						<td><input id="campoDataInicio" size="10" type="text" name="txtDataInicio"
							value=""></td>
					</tr>
					<tr>
						<td><label> Data de T�rmino:</label></td>
						<td><input id="campoDataTermino" size="10" type="text" name="txtDataTermino"
							value=""></td>
					</tr>
					<tr>
						<td><label> Empresa:</label></td>
						<td><input id="campoEmpresa" size="70" type="text" name="txtEmpresa"
							value=""></td>
					</tr>
					<tr>
						<td><label> Respons�vel pelo Est�gio:</label></td>
						<td><input id="campoResponsavel" size="70" type="text" name="txtResponsavel"
							value=""></td>
					</tr>
					<tr>
						<td><label> Curso:</label></td>
						<td><input id="campoCurso" size="70" type="text" name="txtCurso"
							value=""></td>
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botaoIncluir" type=button name=btnIncluir onclick=incluir() value=Incluir>
						
					    <input id="botaoVoltar" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    </td>
					</tr>
				</table>
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
				<%	String msg = (String) request.getAttribute("msg"); 
					if(msg == null)
						msg="";
				%>
				<label><%=msg%></label>
			</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>