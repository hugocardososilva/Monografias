package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoFuncao;
import com.classes.Administrador;
import com.classes.Funcao;

/**
 * Servlet implementation class CadastrarFuncao
 */
@WebServlet("/CadastrarFuncao.do")
public class CadastrarFuncao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarFuncao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Funcao funcao;
		ConexaoFuncao con;
		HttpSession session= request.getSession();			
		
		String ref= request.getParameter("ref");
		
			
		
		try {	
			if(ref.equalsIgnoreCase("cadastrarFunc")){
				funcao= new Funcao();
				funcao.setDescicao(request.getParameter("descricao"));
				funcao.setPrivilegio(request.getParameter("privilegio"));
				con= new ConexaoFuncao();
				con.create(funcao);
				request.setAttribute("msg", "Funcão cadastrada com sucesso!");
				request.getRequestDispatcher("adminpainel.jsp").forward(request, response);
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
