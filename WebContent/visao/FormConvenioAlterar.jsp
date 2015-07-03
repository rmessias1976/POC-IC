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
<title>Alterar Convenio</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function ConsultarCNPJ(){
		document.formConvenioAlterar.acao.value = "ConsultarCNPJ";
		document.formConvenioAlterar.submit();
	}
	function ConsultarNome(){
		document.formConvenioAlterar.acao.value = "ConsultarNome";
		document.formConvenioAlterar.submit();
	}
	function alterar() {
		document.formConvenioAlterar.acao.value = "Alterar";
		document.formConvenioAlterar.submit();
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
			<h3>Controle de Convenio - Alterar</h3>
		</div>
		<hr>
		<div id="formulario2" >

			<form name="formConvenioAlterar" action="/sce-web-ref/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td>
						<label>Busca por CNPJ:</label>
						</td>
						<td>
						<input id="campo" size="15" type="text" name="txtCNPJ" value="">
						<input id="button" type=button name=btnConsultarCNPJ onclick= ConsultarCNPJ() title="Buscar por CNPJ" value=" ... ">
						</td>
					</tr>
					<tr>
						<td><label>Data inicial:</label></td>
						<td><input id="campo" size="30" type="date" name="txtDataInicio" value="" ></td>
					</tr>
					<tr>
						<td><label>Data final:</label></td>
						<td><input id="campo" size="30" type="date" name="txtDataTermino" value="" "></td>
					</tr>
					<tr>
						<td><label> Nome da Empresa:</label></td>
						<td>
						<input id="campo" size="60" type="text" name="txtNomeDaEmpresa" maxlength="55" value="">
						<input id="button" type=button name=btnConsultarNome onclick= ConsultarNome() title="Buscar por Nome da Empresa" value=" ... ">
						</td>
						
					</tr>
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=submit name=btnAlterar onclick=alterar() value=Alterar>
						<input id="botao" type=reset name=btnLimpar onclick=limpar() value=Limpar>
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    </td>
					</tr>
				</table>
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
			</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>