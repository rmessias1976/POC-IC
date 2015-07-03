package br.sceweb.controle;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ServletUpload
 */
@WebServlet("/ServletUpload")
public class ServletUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = "";
		cmd = req.getParameter("CMD");
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if("ENVIAR".equalsIgnoreCase(cmd))
		{
			String nome = req.getParameter("nome");
			
			if(isMultipart) {
	            try {
	                FileItemFactory factory = new DiskFileItemFactory();
	                ServletFileUpload upload = new ServletFileUpload(factory);
	                List<FileItem> items = (List<FileItem>) upload.parseRequest(req);
	                for(FileItem item : items) {
	                    if(item.isFormField()) {
	         
	                        res.getWriter().println("Form field");
	                        res.getWriter().println("Name:"+item.getFieldName());
	                        res.getWriter().println("Value:"+item.getString());
	                    } else {

	                        res.getWriter().println("Nome Arquivo :"+item.getName());
	                        res.getWriter().println("Tamanho :"+item.getSize());
	                        res.getWriter().println("Tipo Arquivo :"+item.getContentType());
	                    }
	                
	                    File uploadedFile = new File("C:/upload/"+item.getString());
	                    item.write(uploadedFile);
	                }
	            } catch (Exception e) {

	            	e.getMessage();
	            }
	 
	        }
		}
	}
}


