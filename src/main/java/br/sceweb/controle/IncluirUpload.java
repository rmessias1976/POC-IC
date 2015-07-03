package br.sceweb.controle;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import br.sceweb.controle.IComando;
import br.sceweb.dominio.Fachada;

public class IncluirUpload implements IComando {

	Fachada fachada;
	Logger logger = Logger.getLogger(Fachada.class);

	public IncluirUpload() {
		fachada = new Fachada();
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String msg = "";
		String resultado = "";

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = (List<FileItem>) upload.parseRequest(req);
				for (FileItem item : items) {
					if (item.isFormField()) {
						 res.getWriter().println("Form field");
						 res.getWriter().println("Name:"+item.getFieldName());
						 res.getWriter().println("Value:"+item.getString());
						msg = "Upload não realizado";
					} else {

						res.getWriter().println("Nome Arquivo :"+item.getName());
						res.getWriter().println("Tamanho :"+item.getSize());
						res.getWriter().println("Tipo Arquivo :"+item.getContentType());
						
						resultado = fachada.incluirUpload(item.getString());
						req.setAttribute("msg", resultado);
						msg = "Upload na realizado";
					}

					File uploadedFile = new File("C:/upload/"
							+ item.getString());
					item.write(uploadedFile);
				}
			} catch (Exception e) {

				e.getMessage();
			}

		}
		req.setAttribute("erro", msg);
		return "/visao/FormUplad.jsp";
	}

}
