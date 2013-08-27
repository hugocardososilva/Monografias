package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoAdmin;
import com.banco.ConexaoUsuario;
import com.classes.Administrador;
import com.classes.Usuario;

/**
 * Servlet implementation class LogarAdmin
 */
@WebServlet("/LogarAdmin.do")
public class LogarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogarAdmin() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			
			ConexaoAdmin con;
			String ref= request.getParameter("ref");
			HttpSession session= request.getSession();
			
			//verifica se a sessão é nova...
			//if(session.isNew()){
			
				if(ref.equalsIgnoreCase("logar")){
					Administrador admin = new Administrador();
					String login = request.getParameter("email");
					String senha = request.getParameter("senha");
			
					con= new ConexaoAdmin();
				if(con.logar(login, senha)!= null){
				
				request.setAttribute("mensagem", "Administrador logado");
				request.setAttribute("admin", admin);
				
				}else{
					request.setAttribute("mensagem","erro");
				}
				request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
			//}else{
			//	Administrador admin= (Administrador)session.getAttribute("admin");
			//	session.setAttribute("admin", admin);
			//	request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
				
			//	}	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
