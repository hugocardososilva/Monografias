package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoMonografia;

/**
 * Servlet implementation class ExcluirMonografia
 */
@WebServlet("/ExcluirMonografia.do")
public class ExcluirMonografia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirMonografia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session= request.getSession();
		ConexaoMonografia con;
		if (session.isNew()){
			request.setAttribute("mensagem", "Você precisa efetuar o login primeiro");
			request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
		}else{
		
				
			
			int cod= Integer.parseInt((request.getParameter("exc")));
			con= new ConexaoMonografia();
			String mensagem= con.ExcluirMonografia(cod);
			if(mensagem== null){
				request.setAttribute("mensagem", "Ocorreu um erro");
				request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
			}else{
				request.setAttribute("mensagem", "Monografia removida com sucesso");
				request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
			}
	}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
