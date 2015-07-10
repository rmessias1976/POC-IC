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
<title>Incluir Usuário</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function incluir() {
		document.formUsuarioIncluir.acao.value = "IncluirUsuario";
		document.formUsuarioIncluir.submit();
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
			<h3>Controle de Usuários - Inclusão</h3>
		</div>
		<hr>
		<div id="formulario2">

			<form name="formUsuarioIncluir" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> Nome:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeDoUsuario"
							value=""></td>
					</tr>			
					<tr>
						<td><label> Id do usuário:</label></td>
						<td><input id="campo" size="50" type="text" name="txtUserId"
							value=""></td>
					</tr>
					<tr>
						<td><label> Senha:</label></td>
						<td><input id="campo" size="10" type="text" name="txtSenha"
							value=""></td>
					</tr>
					
										
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnIncluir onclick=incluir() value=Incluir>
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