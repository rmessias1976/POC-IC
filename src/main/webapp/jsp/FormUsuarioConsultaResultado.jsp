<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" language="javascript">
	
	function consultar() {
		document.formUsuarioConsultar.acao.value = "AlterarUsuario";
		document.formUsuarioConsultar.submit();
	}
	
	function voltar() {
		history.go(-1)
		
	}
</script>
<title>Consulta Usuario</title>
</head>
<body>
<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Usuários - consulta</h3>
		</div>
		<hr>
		<div id="formulario2">

			<form name="formUsuarioConsultar" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
				
					<tr>
						<td><label> Nome:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeUsuario"
							value="<% out.println(request.getAttribute("nome")); %>" disabled="disabled">
						</td>
					</tr>
					
					<tr>
						<td><label> User ID:</label></td>
						<td><input id="campo" size="50" type="text" name="txtUserID"
							value="<% out.println(request.getAttribute("userID")); %>" disabled="disabled">
						</td>
					</tr>
					
					<tr>
						<td><label> Senha:</label></td>
						<td><input id="campo" size="50" type="password" name="txtSenhaUsuario"
							value="<% out.println(request.getAttribute("senha")); %>" disabled="disabled">
						</td>
					</tr>
					
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnIncluir onclick=incluir() value=Alterar>
						<input id="botao" type=reset name=btnLimpar onclick=limpar() value=Limpar>
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    </td>
					</tr>
				</table>
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
				
				<%	
				    request.setAttribute("nome", request.getAttribute("nome"));
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