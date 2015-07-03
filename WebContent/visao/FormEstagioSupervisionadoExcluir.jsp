<%@page import="br.sceweb.dominio.EstagioSupervisionado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<title>Excluir Estágio Supervisionado</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function excluir() {
		document.formEstagioSupervisionadoExcluir.acao.value = "ExcluirEstagioSupervisionado";
		document.formEstagioSupervisionadoExcluir.submit();
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
			<h3>Controle de Estágio Supervisionado - Exclusão</h3>
		</div>
		<hr>
		<div id="formulario4" >
		<br>
		<br>

	
			<form name="formEstagioSupervisionadoExcluir" action="/sce-web-ref/ServletControle" method="post">
				<center>
				<table style=" border: 1px solid black;" >
					<thead>
						<tr>
							<th style=" border: 1px solid black;" >RA:</th>
							<th style=" border: 1px solid black;">Nome:</th>
							<th style=" border: 1px solid black;">Curso:</th>
							<th style=" border: 1px solid black;">Responsavel</th>
							<th style=" border: 1px solid black;">Excluir</th>
						</tr>
					</thead>
					<% List<EstagioSupervisionado> allEstagioSup = null;

					allEstagioSup = (ArrayList<EstagioSupervisionado>) session.getAttribute("LISTAESTAGIO");
					
					if (allEstagioSup == null)
					{
						allEstagioSup = new ArrayList<EstagioSupervisionado>();
					}
					for(EstagioSupervisionado estagio : allEstagioSup){
							%>
						<!--  <form action="../ServletExcluirEstagioSupervisionado" method="POST">-->
						<tr>
						<th style=" border: 1px solid black;">	<%=estagio.getRA() %> </th>    <%// session.setAttribute("RAESTAGIO", estagio.getRA()); %>
						<th style=" border: 1px solid black;">	<%=estagio.getNomeAluno() %> </th>
						<th style=" border: 1px solid black;">	<%=estagio.getCurso() %> </th>
						<th style=" border: 1px solid black;">	<%=estagio.getResponsavel()%> </th>
						<th style=" border: 1px solid black;">	 <a href="../ServletExcluirEstagioSupervisionado?ra=<%=String.valueOf(estagio.getRA())%>&cmd=excluir" >Excluir </a></th>
						<!-- <input id="botao" style=" width:100px ; height:20px" type="submit"  name=btnExcluir onclick=excluir() value=Excluir> --> 
						</tr>   <!--  </form>-->
					<%	}
					
					%>
				</table></center>
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