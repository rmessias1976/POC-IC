<%@ page import="br.sceweb.dominio.Estagio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Vencimento de Estagio</title>
<script type="text/javascript" language="javascript">

	function consultar() {
		document.formConsultarVencimentoEstagio.acao.value = "ConsultarVencimentoEstagio";
		document.formConsultarVencimentoEstagio.submit();
	}
	
	function consultarResultado(){
		document.formConsultarVencimentoEstagio.acao.value = "ConsultarEstagioResultado";
		document.formConsultarVencimentoEstagio.submit();
	}
	
	function voltar() {
		document.formConsultarVencimentoEstagio.acao.value = "MostraFormMenuRelatorio";
		document.formConsultarVencimentoEstagio.submit();
	}
	
</script>
</head>
<body>
	<%
		Estagio estagio = (Estagio) request.getAttribute("estagio");
	%>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">

			<h3>Consultar Vencimento de Estagio</h3>

		</div>
		<hr>
		<div id="formulario">
			<form name="formConsultarVencimentoEstagio" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">

					<tr>
	
						<td><label> RA:</label></td>
						<td><input id="campo" size="7" type="text" name="txtRA" value=""></td>
						<td><input id="botao" type=submit name="command" onclick=consultar() value="Consultar"></td>
						<td><input id="botaoVoltar" type=button name=btnVoltar onclick=voltar() value=Voltar style="width: 98px; height: 35px"></td>
						<input type="hidden" name="acao" value="">
					</tr>
				
				</table>
				<table id="tabResultados">
				
					<%if (null != estagio){ %>	
						
							<tr><td>Ra: <%=estagio.getRa()%></td></tr>
							<tr><td>Nome: <%=estagio.getNome()%></td></tr>
							<tr><td>Data Término: <%=estagio.getDtTermino()%></td></tr>
							<tr><td>Empresa: <%=estagio.getEmpresa()%></td></tr>
							<td><input type="hidden" name="ra" value="<%=estagio.getRa()%>">
					
					<%} %>
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