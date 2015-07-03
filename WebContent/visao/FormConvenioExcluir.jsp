
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
<title>Excluir Convenio - formConvenioExcluir.jsp</title>
<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
<script type="text/javascript" language="javascript">
	
	function excluir() {		
		document.formConvenioExcluir.acao.value = "MostraFormConsultarConvenioConfirmaExclusao";		
		document.formConvenioExcluir.submit();
	}
	
	function voltar() {
		history.go(-1);
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Controle de Convenios - exclusão</h3>
		</div>
		<hr>
		<div id="formulario2">

			<form name="formConvenioExcluir" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> Nome:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeDaEmpresa"
							value=""></td>
					</tr>
					<tr>
						<td><label> CNPJ:</label></td>
						<td><input id="campo" size="15" type="text" name="txtCNPJ"
							value=""></td>
					</tr>
										
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnExcluir onclick=excluir() value=Excluir>
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