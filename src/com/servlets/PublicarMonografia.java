package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banco.ConexaoAdmin;
import com.banco.ConexaoMonografia;
import com.classes.Administrador;
import com.classes.Monografia;

/**
 * Servlet implementation class PublicarMonografia
 */
@WebServlet("/PublicarMonografia.do")
public class PublicarMonografia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicarMonografia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		ConexaoMonografia con;
		if (session.isNew()){
			request.setAttribute("mensagem", "Você precisa efetuar o login primeiro");
			request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
		}else{
			
		Administrador admin = (Administrador) session.getAttribute("admin");
		int cod_admin= admin.getCodigo();
		Monografia m= new Monografia();
		m.setCod_admin(cod_admin);
		int cod =Integer.parseInt(request.getParameter("cod"));
		con= new ConexaoMonografia();
		try {
			String mensagem=  con.PublicarMonografia(cod, cod_admin);
			if(mensagem== null){
				request.setAttribute("mensagem", "ocorreu um erro");
				request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
				
			}else{
				request.setAttribute("mensagem", mensagem);
				request.getRequestDispatcher("admin/adminpainel.jsp").forward(request, response);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
