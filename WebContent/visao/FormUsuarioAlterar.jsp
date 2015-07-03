<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Usuarios - Alterar</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">

function alterar() {
	document.formAlterarUsuario.acao.value = "MostraFormAlterarUsuario";
	document.formAlterarUsuario.submit();
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
			<h3>Controle de Usuarios - Alterar</h3>
		</div>
		
		<div id="menuSuperior">
			<form name="formAlterarUsuario" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					
					<tr>
						<td><label> Nome:</label></td>
						<td><input id="campoUsuario" size="70" type="text" name="txtNomeUsuario"
							value="<% out.println(request.getAttribute("nome")); %>"></td>
					</tr>
				
					<tr>
						<td><label> User ID:</label></td>
						<td><input id="campoID" size="10" type="text" name="txtUserID"
							value="<% out.println(request.getAttribute("userID")); %>"></td>
					</tr>
					
					<tr>
						<td><label> Senha:</label></td>
						<td><input id="campoSenha" size="10" type="text" name="txtSenhaUsuario"
							value="<% out.println(request.getAttribute("senha")); %>"></td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input id="botao" type="button"	name="btnSalvar" onclick="alterar()" value="Salvar">
							<input id="botao" type="button"	name="btnVoltar" onclick="voltar()" value="Voltar">
						</td>
					</tr>
				
				</table>
				
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
				
				<label>
				<%
					String msg = (String) request.getAttribute("msg");
					
					if (msg == null) {
						msg = "";
					}
					
					out.println(msg); %></label>
			</form>
		</div>
	</div>
	
	<jsp:include page="Rodape.jsp" />
	
</body>
</html>
