package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banco.ConexaoMonografia;
import com.classes.Monografia;

/**
 * Servlet implementation class CadastrarMonografia
 */
@WebServlet("/CadastrarMonografia.do")
public class CadastrarMonografia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastrarMonografia() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try {
			Monografia monografia;
			ConexaoMonografia con;
			String ref = request.getParameter("ref");
			
			if(ref.equalsIgnoreCase("cadastraMonogradia")){
				monografia= new Monografia();
				monografia.setNome(request.getParameter("nome"));
				monografia.setMatricula(request.getParameter("matricula"));
				monografia.setNomeCurso(request.getParameter("nomeCurso"));
				monografia.setNomeInstituicao(request.getParameter("nomeInstituicao"));
				monografia.setNota(Double.parseDouble(request.getParameter("nota")));
				monografia.setArquivo(request.getParameter("arquivo"));
				
				
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
