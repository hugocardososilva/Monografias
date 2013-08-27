package com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.classes.Usuario;

public class ConexaoUsuario extends Conexao{
	
	//Connection conn;
	PreparedStatement stmt;
	
	// função para criar o usuario
	public void create(Usuario u) throws Exception{
		
		
		try{
		open();
		stmt = con.prepareStatement("INSERT INTO usuario(login," +
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
			stmt.execute();
			con.close();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
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
		public ArrayList<Usuario> ListarUsuario() throws Exception{
			try {
				PreparedStatement stmt = null;
				ArrayList<Usuario> lista= new ArrayList<Usuario>();
				open();
				stmt= con.prepareStatement("SELECT idUsuario, login," +
						"endereco, instituicao, email, cpf, nivel" +
						"FROM usuario");
				rs= stmt.executeQuery();
					while(rs.next()){
						Usuario u= new Usuario();
						u.setIdUsuario(rs.getInt(1));
						u.setLogin(rs.getString(2));
						u.setEndereco(rs.getString(3));
						u.setInstituicao(rs.getString(4));
						u.setEmail(rs.getString(5));
						u.setCpf(rs.getString(6));
						u.setNivel(rs.getString(7));
						lista.add(u);
					}
					con.close();
					return lista;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			con.close();
			return null;
		}
}
