<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de Usuários</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function sair() {
		//window.close();
		history.go(-1)
	}
	function consultarTodos() {
		document.formRelUsuario.acao.value = "MostraTodosUsuarios";
		document.formRelUsuario.submit();
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Relatório de Usuários</h3>
		</div>	
		
		<div id="titulo">
			<h3>Filtros</h3>
		</div>
		
		<div id="formulario2">

			<form name="formRelatorioUsuario" action="/sce-web-ref/ServletControle" method="post">
				<table id="tabcampos">
				
										
					<tr>
						<td><label> Nome do Usuário:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeUsuario"
							value=""></td>
							
							
					</tr>
												
					
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type="button"	name="btnConsultarTodos" onclick="consultarTodos()" value="Todos">						
					    <input id="botao" type=button name=btnVoltar onclick=sair() value=Voltar>
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