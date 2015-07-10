<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="br.sceweb.dominio.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
label {
	font: normal 12px courier !important;
}
</style>
<title>Consultar Todas Convenios</title>
<link rel="stylesheet" type="text/css"
	href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function voltar() {
		history.go(-1)
	}
</script>
</head>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="relatorio">
		<div id="titulo">
			<h3>Relatório de Convenios</h3>
		</div>
		<hr>
		<div id="formulario">
			<form name="formConvenioConsultaTodos"
				action="/sce-web-ref2/ServletControle" method="post">

				<table id="tabcampos">

					<tr id="cabecalho">
						<td>Codigo</td>
						<td>Nome Convenio</td>
						<td>Data de Inicio</td>
						<td>Data de Termino</td>
					</tr>
					<%
					ArrayList<Convenio> lista = (ArrayList<Convenio>) request.getAttribute("convenios");
					if ((lista!=null)&& (lista.size()>0)){
					    Convenio c = null;
						for (int i = 0; i < lista.size(); i++) {
							
							    c = (Convenio) lista.get(i);
								out.println("<TR>");
								out.println("<TD>" + c.getCnpj().trim()+ "</TD>");
								out.println("<TD>" + c.getNomeDaEmpresa() + "</TD>");
								out.println("<TD>" + c.getDataInicio() + "</TD>");
								out.println("<TD>" + c.getDataTermino() + "</TD>");
								out.println("</TR>");
							}
						
						}
						else{
							out.println("<TR><TD> <BR> </TD> <TD> <BR> </TD> <TD> <BR> </TD> <TD> <BR> </TD> </TR>");
							out.println("<TR><TD> <BR> </TD> <TD> <BR> </TD> <TD> <BR> </TD> <TD> <BR> </TD> </TR>");
						}
					%>
					<tr>
						<td colspan=6 id="botoes" align="center"><input id="botao"
							type=button name=btnVoltar onclick=voltar() value=Voltar>
						</td>
					</tr>



				</table>
			</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>