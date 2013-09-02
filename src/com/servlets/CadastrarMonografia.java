package com.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;




import com.banco.ConexaoMonografia;
import com.classes.Monografia;
import com.classes.Usuario;

/**
 * Servlet implementation class CadastrarMonografia
 */
@WebServlet("/CadastrarMonografia.do")

public class CadastrarMonografia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastrarMonografia() {
        super();
        
    }
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		try {
		
		
			
			Monografia monografia;
			ConexaoMonografia con;
			String ref = request.getParameter("ref");
			HttpSession session= request.getSession();
			Usuario user= null;
			if(session.isNew()){
				request.setAttribute("mensagem", "Você precisa estar logado");
				request.getRequestDispatcher("index.jsp").forward(request, response);
					
			
			}else{
						
			

				//if(ref.equalsIgnoreCase("cadastraMonogradia")){
					user= (Usuario)session.getAttribute("user");
					monografia= new Monografia();
					monografia.setNome(request.getParameter("nome"));
					monografia.setMatricula(request.getParameter("matricula"));
					monografia.setNomeCurso(request.getParameter("nomeCurso"));
					monografia.setNomeInstituicao(request.getParameter("nomeInstituicao"));
					
					
					
					monografia.setArquivo(request.getParameter("arquivo"));
					monografia.setId_user((user.getIdUsuario()));
					//monografia.setNota(Double.parseDouble(request.getParameter("nota")));
					//monografia.setId_user(5);
					con= new ConexaoMonografia();
					con.create(monografia);
					
					request.setAttribute("monografia", monografia);
					request.setAttribute("mensagem", "Monografia Cadastrada com sucesso");
					request.getRequestDispatcher("user/user.jsp").forward(request, response);
					



				

				
				
		
				
			}		
			
			} catch (Exception  e) {
				e.printStackTrace();
			}
				
	}
	

}
