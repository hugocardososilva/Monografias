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
	Usuario user;
       
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
		String ref= request.getParameter("ref");
		HttpSession session= request.getSession();
		
		if(session.isNew()){
		
		if(ref.equalsIgnoreCase("logar")){
		Usuario usuario = new Usuario();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		conuser= new ConexaoUsuario();
		
		try {
			if(conuser.logar(login, senha)!= null){
				
				request.setAttribute("mensagem", "Usuario logado");
				session.setAttribute("user", usuario);
				
			}else{
				request.setAttribute("mensagem","erro");
			}
			request.getRequestDispatcher("user.jsp").forward(request, response);
		} catch (Exception e) {


			e.printStackTrace();
		}
		
	}
	
	}else{
		Usuario usuario= (Usuario)session.getAttribute("user");
		session.setAttribute("user", usuario);
		request.getRequestDispatcher("user.jsp").forward(request, response);
		
	}	
	}
}
