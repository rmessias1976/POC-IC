<%@page import="br.sceweb.dominio.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir Usuário</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function excluir() {
		document.formUsuarioExcluir.acao.value = "ExcluirUsuario";
		document.formUsuarioExcluir.submit();
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
			<h1>Controle de Usuários - Exclusão</h3>
		</div>
		<hr>
		<div id="formulario4">

			<form name="formUsuarioExcluir" action="/sce-web-ref/ServletControle" method="post">
				<center>
				<table style=" border: 1px solid black;" >
					<thead>
						<tr>
							<th style=" border: 1px solid black;" >UserID:</th>
							<th style=" border: 1px solid black;">Nome:</th>
							<th style=" border: 1px solid black;">Senha:</th>
							<th style=" border: 1px solid black;">Excluir</th>
						</tr>
					</thead>
					<% List<Usuario> allUsuario = null;

					allUsuario = (ArrayList<Usuario>) session.getAttribute("LISTAUSUARIO");
					
					if (allUsuario == null)
					{
						allUsuario = new ArrayList<Usuario>();
					}
					for(Usuario usuario : allUsuario){
							%>
						<tr>
						<th style=" border: 1px solid black;">	<%=usuario.getUserID() %> </th>
						<th style=" border: 1px solid black;">	<%=usuario.getNome() %> </th>
						<th style=" border: 1px solid black;">	<%=usuario.getSenha() %> </th>
						<th style=" border: 1px solid black;">	<a href="/sce-web-ref/ServletExcluirUsuario?ra=<%=String.valueOf(usuario.getUserID())%>&cmd=excluir" >Excluir </a></th>
						</tr>
					<%	}	
					%>
				</table>
				</center>
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