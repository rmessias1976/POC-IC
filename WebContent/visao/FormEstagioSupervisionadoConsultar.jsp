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
<title>Consultar Estágio Supervisionado</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function consultar() {
		document.formEstagioSupervisionadoConsultar.acao.value = "ConsultarEstagioSupervisionado";
		document.formEstagioSupervisionadoConsultar.submit();
	}
	
	function voltar() {
		history.go(-1)
	}
</script>
</head>
<body>
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Estágio Supervisionado - consulta</h3>
		</div>
		<hr>
		<div id="formulario2">


			<form name="formEstagioSupervisionadoConsultar" action="/sce-web-ref/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> R.A.:</label></td>
						<td><input id="campo" size="70" type="text" name="txtRaAluno"
							value=""></td>
					</tr>
					<tr>
						<td><label> Nome Completo:</label></td>	
						<td><input id="campo" size="15" type="text" name="txtNomeCompleto"
							value=""></td>
					</tr>
					<tr>
						<td><label> Empresa:</label></td>
						<td><input id="campo" size="10" type="text" name="txtEmpresa"
							value=""></td>
					</tr>
					<tr>
						<td><label> Responsável:</label></td>
						<td><input id="campo" size="50" type="text" name="txtResponsavel"
							value=""></td>
					</tr>
					<tr>
						<td><label> Curso:</label></td>
						<td><input id="campo" size="10" type="text" name="txtCurso"
							value=""></td>
					</tr>
					<tr>
						<td><label> Semestre:</label></td>
						<td><input id="campo" size="50" type="text" name="txtSemestre"
							value=""></td>
					</tr>
					<tr>
						<td><label> Horas Cumpridas:</label></td>
						<td><input id="campo" size="30" type="text" name="txtHorasCumpridas"
							value=""></td>
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnConsultar onclick=consultar() value=Consultar>
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
</body>
</html>