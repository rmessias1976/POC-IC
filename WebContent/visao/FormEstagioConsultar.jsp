<%@ page import="br.sceweb.dominio.Estagio"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Estagio</title>
<script type="text/javascript" language="javascript">
	function consultar() {
		document.formConsultarEstagio.acao.value = "ConsultarEstagio";
		document.formConsultarEstagio.submit();
	}
	function consultarResultado(ra){
		document.formConsultarEstagio.ra.value = ra;
		document.formConsultarEstagio.acao.value = "ConsultarEstagioResultado";
		document.formConsultarEstagio.submit();
	}
	function voltar() {
		history.go(-1);
	}
</script>
</head>
<body>
	<%
		List<Estagio> estagios = (ArrayList<Estagio>) request.getAttribute("estagios");
	%>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Consultar Estagio</h3>
		</div>
		<hr>
		<div id="formulario">
			<form name="formConsultarEstagio" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> RA:</label></td>
						<td><input id="campo" size="7" type="text" name="txtRA" value=""></td>
						<td><input id="botao" type=submit name="command" onclick=consultar() value="Consultar"></td>
						<td><input id="botaoVoltar" type=button name=btnVoltar onclick=voltar() value=Voltar style="width: 98px; height: 35px"></td>
						<input type="hidden" name="acao" value="">
					</tr>
				</table>
				<input type="hidden" name="ra">
				<table id="tabResultados">
					<%if (null != estagios){ %>	
						<%for(Estagio estagio : estagios){ %>
						<tr>
							<td>RA: <%=estagio.getRa()%></td>
							<td>NOME: <%=estagio.getNome()%></td>
							<td>DATA INICIO: <%=estagio.getDtInicio()%></td>
							<td>DATA TERMINO: <%=estagio.getDtTermino()%></td>
							<td>EMPRESA: <%=estagio.getEmpresa()%></td>
							<td>RESPONSÁVEL: <%=estagio.getResponsavel()%></td>
							<td>CURSO: <%=estagio.getCurso()%></td>
							
							<td><td><input id="botao" type=submit name="command" onclick="consultarResultado(<%=estagio.getRa()%>)" value='Alterar'/></td>
						</tr>
					<%} }%>
				</table>
				<%	String msg = (String) request.getAttribute("msg"); 
					if(msg == null)
						msg="";
				%>
				<label style="color:red"><%=msg%></label>
			</form>
		</div>
	</div>
<jsp:include page="Rodape.jsp" />
</body>
</html>