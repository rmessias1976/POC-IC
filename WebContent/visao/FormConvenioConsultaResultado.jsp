<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" language="javascript">
	function alterar(){		
		document.formConvenioConsultar.acao.value = "AlterarConvenio";
		document.formConvenioConsultar.submit();
	}
	
	function limpar() {
		
	}
	
	function voltar() {
		history.go(-1)
		
	}
</script>
<title>Consultar Convenio</title>
</head>
<body>
<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Convenios - consulta</h3>
		</div>
		<hr>
		<div id="formulario2">

			<form name="formConvenioConsultar" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
				<tr>
						<td><label> Nome:</label></td>
						<td><input id="campo" size="90" type="text" name="txtNomeDaEmpresa"
							value="<% out.println(request.getAttribute("nomeDaEmpresa")); %>" disabled="disabled">
						</td>
					</tr>
					<tr>
						<td><label> CNPJ:</label></td>
						<td><input id="campo" size="15" type="text" name="txtCNPJ"
							value="<% out.println(request.getAttribute("cnpj")); %>" disabled="disabled">
						</td>
					</tr>
					<tr>
						<td><label> Data inicio:</label></td>
						<td><input id="campo" size="15" type="text" name="txtDataInicio"
							value="<% out.println(request.getAttribute("dataInicio")); %>">
						</td>
					</tr>
					<tr>
						<td><label> Data termino:</label></td>
						<td><input id="campo" size="15" type="text" name="txtDataTerminio"
							value="<% out.println(request.getAttribute("dataTermino")); %>" >
						</td>
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnAlterar onclick=alterar() value=Alterar>
						<input id="botao" type=reset name=btnLimpar onclick=limpar() value=Limpar>
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    </td>
					</tr>
				</table>
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
				
				<%	
				    request.setAttribute("cnpj", request.getAttribute("cnpj"));
				    String msg = (String) request.getAttribute("msg"); 
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