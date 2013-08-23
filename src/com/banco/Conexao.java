package com.banco;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.DriverManager;

import java.sql.SQLException;



//Início da classe de conexão//

public class Conexao {

	 	Connection con;  
	   PreparedStatement stmt;  
	   ResultSet rs;  
	     
	   private final String URL = "jdbc:mysql://localhost:3306/biblioteca";  
	   private final String USER = "root";  
	   private final String PASS = "";  
	     
	   protected void open()throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		  
	      con = DriverManager.getConnection(URL, USER, PASS);  
	   }  
	     
	   public Connection getConn(){
		   return con;
	   }
	   protected void close()throws Exception{  
	      con.close();  
	   }  
	     
}



