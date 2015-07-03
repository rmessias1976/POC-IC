<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backup</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	//function consultar() {
	//	document.formEmpresaConsultar.acao.value = "ConsultarEmpresa";
		//document.formEmpresaConsultar.submit();
	//}
	
	function voltar() {
		history.go(-1)
	}
</script>


</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Backup</h3>
		</div>
		<hr>
		<div id="formulario2">
			<form name="formBackup" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> ServerName:</label></td>
						<td><input id="campo" size="50" type="text" name="txtServerName"
							value=""></td>
					</tr>
					<tr>
						<td><label> Data Base:</label></td>
						<td><input id="campo" size="15" type="text" name="txtDataBase"
							value=""></td>
					</tr>
					<tr>
						<td><label> Data:</label></td>
						<td><input id="campo" size="15" type="text" name="txtData"
							value=""></td>
					</tr>
					<tr>
						<td><label> Hora:</label></td>
						<td><input id="campo" size="15" type="text" name="txtHora"
							value=""></td>
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnBackup value=Backup>
						<input id="botao" type=reset name=btnLimpar onclick=limpar() value=Limpar>
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
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