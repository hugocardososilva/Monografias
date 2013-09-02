package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoUsuario;
import com.classes.Usuario;

/**
 * Servlet implementation class CadastrarUsuario
 */

public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int AI = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try{			
			
			Usuario usuario;
			ConexaoUsuario conuser;
			
						
			
			String ref= request.getParameter("ref");
			
				//se tudo estiver ok cadastra o usuario e envia um atributo para um listener
				if(ref.equalsIgnoreCase("cadastrar")){
					
					usuario= new Usuario();
					
					
					
					usuario.setLogin(request.getParameter("login"));
					usuario.setSenha(request.getParameter("senha"));
					usuario.setCpf(request.getParameter("cpf"));
					usuario.setEndereco(request.getParameter("endereco"));
					usuario.setInstituicao(request.getParameter("instituicao"));
					usuario.setEmail(request.getParameter("email"));
					usuario.setNivel(request.getParameter("nivel"));										
						
					conuser= new ConexaoUsuario();
					
					conuser.create(usuario);
					
					//session.setAttribute("usuario", usuario);
					request.setAttribute("usuario", usuario);
					request.setAttribute("mensagem", "Usuário Cadastrado com sucesso;");
					request.getRequestDispatcher("user/user.jsp").forward(request, response);
					
				}	
	}catch (Exception e) {  
		 e.printStackTrace();  
			      }  

		
					
		
			
		
		
		
	
		
		
		
		
	}

}
