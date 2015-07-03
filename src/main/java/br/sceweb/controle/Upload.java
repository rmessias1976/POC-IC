package br.sceweb.controle;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload implements IComando{
	
    
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException{
	boolean isMultipart = ServletFileUpload.isMultipartContent(req);
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

        	res.getWriter().println("erro no download "+ e.getMessage());
        }

	}
	return "/sce-web-ref2/WebContent/visao/Upload.jsp";
}

}
