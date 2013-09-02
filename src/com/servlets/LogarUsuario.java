package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoUsuario;
import com.classes.Usuario;

/**
 * Servlet implementation class LogarUsuario
 */
@WebServlet("/LogarUsuario.do")
public class LogarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConexaoUsuario conuser;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
					
		//if(ref.equalsIgnoreCase("logar")){
		//verifica se a sessão é nova...		
			
				Usuario usuario = new Usuario();
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
		
				conuser= new ConexaoUsuario();
				HttpSession session= request.getSession(false);
				usuario= conuser.logar(login, senha);
				
				
				 
				
			if(usuario == null){
				session.invalidate();
				request.setAttribute("mensagem","erro: nome de usuario ou senha inválido.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else{
				
				request.setAttribute("mensagem", "Usuario logado com sucesso");
						
				session.setAttribute("user", usuario);
						
				request.getRequestDispatcher("user/user.jsp").forward(request, response);
			}
			//}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
