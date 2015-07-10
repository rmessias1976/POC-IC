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
<title>Consultar Relatorio de Estagio Supervisionado</title>
<link rel="stylesheet" type="text/css"
	href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	function relatorio() {
	document.formEmpresaMenu.acao.value = "ConsultaRelatorioEstagioSupervisionado";
	document.formEmpresaMenu.submit();
	}
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
			<h3>Relatório de Estagio Supervisionado</h3>
		</div>
		<hr>
		<div id="formulario">
			<form name="formConsultaEstagioSupervisionadoTodos" action="/ServletLista" method="get" onload=relatorio()>
				<table id="tabcampos">

					<tr id="cabecalho">
						<td> R.A.      </td>
						<td> Nome Aluno       </td>
						<td> Data de Início   </td>
						<td> Data de Término	</td>
						<td> Empresa	</td>
						<td>Responsável	</td>
						<td>Curso	</td>
						<td>Semestre	</td>
						<td>Turno	</td>
						<td>Horas Cumpridas	</td>
						<td>Tipo de estágio	</td>
					</tr>
				<%
				ArrayList<EstagioSupervisionado> lista = (ArrayList<EstagioSupervisionado>) request.getAttribute("estagio");
					if ((lista!=null)&& (lista.size()>0)){
					   
						for (EstagioSupervisionado e : lista){	
							
								out.println("<TR>");
								out.println("<TD>" + e.getRA().trim()+ "</TD>");
								out.println("<TD>" + e.getNomeAluno() + "</TD>");
								out.println("<TD>" + e.getDataInicio() + "</TD>");
								out.println("<TD>" + e.getDataTermino() + "</TD>");
								out.println("<TD>" + e.getEmpresa() + "</TD>");
								out.println("<TD>" + e.getResponsavel() + "</TD>");
								out.println("<TD>" + e.getCurso() + "</TD>");
								out.println("<TD>" + e.getSemestre() + "</TD>");
								out.println("<TD>" + e.getTurno() + "</TD>");
								out.println("<TD>" + e.getHorasCumpridas() + "</TD>");
								out.println("<TD>" + e.getTipoEstagio() + "</TD>");
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