<%@page import="br.sceweb.dominio.EstagioSupervisionado"%>
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
<title>Alterar Estágio Supervisionado</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function alterar() {
		document.FormEstagioSupervisionadoAlterar.acao.value = "AlterarEstagioSupervisionado";
		document.FormEstagioSupervisionadoAlterar.submit();
	}
	
	function voltar() {
		history.go(-1)
	}
	
	function consultar() {
		document.FormEstagioSupervisionadoConsultar.acao.value = "ConsultarEstagioSupervisionado";
		document.FormEstagioSupervisionadoConsultar.submit();
	}
	
	
	<% EstagioSupervisionado estagio = (EstagioSupervisionado)session.getAttribute("ESTAGIO"); 
	
	if(estagio == null)
		{
			estagio.setNomeAluno("");
			estagio.setDataInicio("");
			estagio.setDataTermino("");
			estagio.setEmpresa("");
			estagio.setResponsavel("");
			estagio.setCurso("");
			estagio.setSemestre("");
			estagio.setTurno("");
			estagio.setHorasCumpridas("");
			estagio.setTipoEstagio("");	
			
			
		}
	%>
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal"> 
		<div id="titulo">
			<h3>Alteração de Estágio Supervisionado</h3>
		</div>
		<hr>
		<div id="formulario2">


			<form name="formEstagioSupervisionadoIncluir" action="/sce-web-ref/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> R.A.:</label></td>
						<td><input id="campo" size="70" type="text" name="txtRaAluno"
							value=""></td>
					</tr>
					<tr>
						<td><label> Nome Completo:</label></td>	
						<td><input id="campo" size="15" type="text" name="txtNomeCompleto"
							value="<%=estagio.getNomeAluno()%>"></td>
					</tr>
					<tr>
						<td><label> Data de Início:</label></td>
						<td><input id="campo" size="70" type="text" name="txtDataInicio"
							value="<%=estagio.getDataInicio()%>"></td>
					</tr>
					<tr>
						<td><label> Data de Término:</label></td>
						<td><input id="campo" size="50" type="text" name="txtDataTermino"
							value="<%=estagio.getDataTermino()%>"></td>
					</tr>
					<tr>
						<td><label> Empresa:</label></td>
						<td><input id="campo" size="10" type="text" name="txtEmpresa"
							value="<%=estagio.getEmpresa()%>"></td>
					</tr>
					<tr>
						<td><label> Responsável:</label></td>
						<td><input id="campo" size="50" type="text" name="txtResponsavel"
							value="<%=estagio.getResponsavel()%>"></td>
					</tr>
					<tr>
						<td><label> Curso:</label></td>
						<td><input id="campo" size="10" type="text" name="txtCurso"
							value="<%=estagio.getCurso()%>"></td>
					</tr>
					<tr>
						<td><label> Semestre:</label></td>
						<td><input id="campo" size="50" type="text" name="txtSemestre"
							value="<%=estagio.getSemestre()%>"></td>
					</tr>
					<tr>
						<td><label> Turno:</label></td>
						<td><input id="campo" size="30" type="text" name="txtTurno"
							value="<%=estagio.getTurno()%>"></td>
					</tr>
					<tr>
						<td><label> Horas Cumpridas:</label></td>
						<td><input id="campo" size="30" type="text" name="txtHorasCumpridas"
							value="<%=estagio.getHorasCumpridas()%>"></td>
					</tr>
					<tr>
						<td><label> Tipo de Estágio:</label></td>
						<td><input id="campo" size="30" type="text" name="txtTipoEstagio"
							value=""></td>
					</tr>
					
					<tr>
						<td colspan=2 id="botoes" align="center">
						<!--  <input id="botao" type=button name=btnConsultar onclick=consultar() value=Consultar>-->
						<a href="../ServletAlterarEstagioSupervisionado?ra=<%=String.valueOf(estagio.getRA())%>&cmd=Consultar" >Consultar </a>
						<!-- <input id="botao" type=button name=btnIncluir onclick=alterar() value=Alterar>-->
						<a href="../ServletAlterarEstagioSupervisionado?ra=<%=String.valueOf(estagio.getRA())%>&cmd=Alterar" >Consultar </a>
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