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
<script type="text/javascript" language="javascript">
	function retornar() {
		history.go(-1);
	}
	function upload() {
		document.formUpload.acao.value  = "IncluirUpload";
		document.formUpload.submit();
	}
	</script>
</head>
<body>
<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Upload de Arquivos</h3>
		</div>
		<hr>
		<div id="upload1">
			<form name="Upload" action="/sce-web-ref2/ServletControle" method="post">
				<table id="tabcampos" align="center">
					<tr>
						<td><label> Nome do aquivo:</label></td>
						<td><input id="campo" size="50" type="text" name="txtnome" value=" 
						
						
						"></td>
					</tr>
					<tr> 
						<td> <label>Arquivo:</label> </td>
    					<td> <input type="file" name="arquivo" /><br /> </td>
					</tr>
					<tr>
					
					
						<td colspan=3 id="botoes" align="center">
						<input id="botao" type="button"	name="CMD" onclick="upload()" value="Enviar">
					    <input id="botao" type="button"	name="btnVoltar" onclick="retornar()" value="Voltar">
					    </td>
					</tr>
					
				</table>
				
				<table id="tabcampos" align="center">
				<tr>
					<td> <textarea cols="53" rows="6"> </textarea> </td>
				</tr>
				</table>
				
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

