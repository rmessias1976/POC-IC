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
<title>Consultar Todas Usuarios</title>
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
			<h3>Relatório de Usuários</h3>
		</div>
		<hr>
		<div id="formulario">
			<form name="formEmpresaConsultaTodos" action="/sce-web-ref2/ServletControle" method="post">
<center>
				<table id="tabcampos">

					<tr id="cabecalho">
						<td> ID      </td>
						<td> Nome       </td>						
					</tr>
					<%
					ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("usuarios");
					if ((lista!=null)&& (lista.size()>0)){
					    Usuario e = null;
						for (int i = 0; i < lista.size(); i++) {
							
							    e = (Usuario) lista.get(i);
								out.println("<TR>");
								out.println("<TD>" + e.getUserID().trim()+ "</TD>");								
								out.println("<TD>" + e.getNome() + "</TD>");								
								out.println("</TR>");
							}
						
						}
						else{
							out.println("</TR><TD> <BR> </TD> <TD> <BR> </TD> </TR>");
							out.println("</TR><TD> <BR> </TD> <TD><BR></TD></TR>");
						}
					%>
					<tr>
						<td colspan=6 id="botoes" align="center">
						
					    <input id="botao" type=button name=btnVoltar onclick=voltar() value=Voltar>
					    <input id="botao" type="button" value="Imprimir" onclick="window.print()" />
					    </td>		    
					  
					    
					    
					</tr>
				

		
				</table>
				</center>
			</form>
		</div>
	</div>
<jsp:include page="Rodape.jsp" />
</body>
</html>