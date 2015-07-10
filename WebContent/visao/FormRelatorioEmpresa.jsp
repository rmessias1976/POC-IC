<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*"%>
	<%@ page import="br.sceweb.dominio.*"%>
	<%@ page import="br.sceweb.servico.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style type="text/css">
			label {
				font: normal 12px courier !important;
			}
		</style>
		
		<title>Consultar Relatório de Empresa</title>
		<link rel="stylesheet" type="text/css" href="/sce-web-ref2/CSS/formato.css">
	
		<script type="text/javascript" language="javascript">
			function relatorio() {
			document.formEmpresaMenu.acao.value = "ConsultaRelatorioEmpresa";
			document.formEmpresaMenu.submit();
			}
			function voltar() {
				history.go(-1)
			}
		</script>
	</head>

	<body>
	
		<jsp:include page="Cabecalho.jsp" />
		
		<div id="relatorio">
			<div id="titulo">
				<h3>Relatório de Empresa</h3>
			</div>
			
			<% 
				List<Empresa> listaEmpresa = (List<Empresa>)request.getAttribute("PESQUISA");
				if(listaEmpresa == null){
					listaEmpresa = new ArrayList<Empresa>();
					IEmpresaDAO dao = new HibernateEmpresaDAO();
					listaEmpresa = dao.lista();
				}
			%>
			
			<div align="center">
				<table class="table" border="2">
					<tr>
						<td>CNPJ</td>
						<td>Nome</td>
						<td>Responsável</td>
						<td>telefone</td>
						<td>setor</td>
					</tr>
					<%
						if(listaEmpresa.size() > 0){
							for (Empresa empresa : listaEmpresa) {
					%>
						<tr>
							<td style="width: 200px;"><%= empresa.getCnpj() %></td>
							<td style="width: 200px;"><%= empresa.getNomeDaEmpresa() %></td>
							<td style="width: 200px;"><%= empresa.getResponsavel() %></td>
							<td style="width: 200px;"><%= empresa.getTelefone() %></td>
							<td style="width: 200px;"><%= empresa.getSetor() %></td>
						</tr>
					<%
							}
						}
					%>
				</table>
			</div>
		</div>
		
		<jsp:include page="Rodape.jsp" />
		
	</body>
</html>