package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoAdmin;
import com.classes.Administrador;

/**
 * Servlet implementation class CadastrarAdmin
 */

public class CadastrarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int AI = 0;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			Administrador admin;
			ConexaoAdmin con;
			String ref = request.getParameter("ref");
		//	HttpSession session= request.getSession();
				//if(ref.equalsIgnoreCase("cadastrarAdmin")){
					admin= new Administrador();
					//session.setAttribute("administrador", admin);
					
					admin.setEmail(request.getParameter("email"));
					admin.setEndereco(request.getParameter("endereco"));
					admin.setNome(request.getParameter("nome"));
					admin.setSenha(request.getParameter("senha"));
					admin.setTelefone(Integer.parseInt(request.getParameter("telefone")));
					String[] funcoes= request.getParameterValues("funcao");					
					ArrayList<String> funcoesArray= new ArrayList<String>();
					Collections.addAll(funcoesArray, funcoes);
					admin.setFuncoes(funcoesArray);
					con = new ConexaoAdmin();
					con.create(admin);
					request.setAttribute("administrador", admin);
					request.setAttribute("mensagem", "Administrador cadastrado com sucesso");
					request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
					
				
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
