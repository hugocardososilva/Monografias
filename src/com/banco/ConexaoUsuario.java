package com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.classes.Usuario;

public class ConexaoUsuario extends Conexao{
	
	//Connection conn;
	PreparedStatement stmt;
	
	// função para criar o usuario
	public void create(Usuario u) throws Exception{
		open();
		try{
		stmt = con.prepareStatement
				("INSERT INTO usuario(login," +
					" senha, endereco," +
					" instituicao, email," +
					" cpf, nivel) VALUES(?,?,?,?,?,?,?)");
					//inserindo valores da classe usuário
			
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getEndereco());
			stmt.setString(4, u.getInstituicao());
			stmt.setString(5, u.getEmail());
			stmt.setString(6, u.getCpf());
			stmt.setString(7, u.getNivel());
			stmt.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		con.close();
	}
	
	// recebe login e senha e efetua o login
		public Usuario logar(String login, String senha) throws Exception{
			Usuario u= new Usuario();
			open(); 
			try{
			
			stmt= con.prepareStatement("Select * from usuario WHERE login like ? ");
			stmt.setString(1, "%" + login + "%");
			ResultSet rs= stmt.executeQuery();
			if(rs.next()){
				if(rs.getString("senha").equals(senha)){
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setEndereco(rs.getString("endereco"));
				u.setNivel(rs.getString("nivel"));
				u.setInstituicao(rs.getString("instituicao"));
				u.setLogin(login);
				}else{
					return null;
				}
				
			}
				
			
			
			
			}catch (SQLException e) {
	            e.printStackTrace();
	        }
			con.close();
			return u;

			
		}

}
