<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import="br.sceweb.dominio.Convenio"
    import="br.sceweb.dominio.Fachada;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de Convênios</title>
</head>
<body>

	<%
	Fachada fachada = new Fachada();
	ArrayList<Convenio> convenios = (ArrayList<Convenio>) fachada.findAll();
	%>

	<jsp:include page="Cabecalho.jsp" />
	<div id="relatorio">

			<h3>Relatório de Convênios</h3>

		<hr>
		<div id="formulario">
			<form name="formConsultaConvenioTodos" onload=relatorio()>
				<table id="tabcampos">

					<tr id="cabecalho">
						<td> CNPJ      </td>
						<td> Empresa       </td>
						<td> Data de Início   </td>
						<td> Data de Término	</td>
					</tr>
				<%

					if ((convenios!=null)&& (convenios.size()>0)){

						for (Convenio c : convenios){	

								out.println("<TR>");
								out.println("<TD>" + c.getCnpj()+ "</TD>");
								out.println("<TD>" + c.getNomeDaEmpresa() + "</TD>");
								out.println("<TD>" + c.getDataInicio() + "</TD>");
								out.println("<TD>" + c.getDataTermino() + "</TD>");
								out.println("</TR>");
							}
						}
						else{
							out.println("<p><b>" +request.getAttribute("msg")+"!</b></p>");
						}
					%>
					<tr>
						<td colspan=6 id="botoes" align="center">
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    </td>
					</tr>
		
				</table>
			</form>
		</div>
	</div>
<jsp:include page="Rodape.jsp" />
</body>
</html>