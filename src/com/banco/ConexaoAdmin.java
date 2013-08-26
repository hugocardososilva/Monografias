package com.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.classes.Administrador;
import com.classes.Usuario;

public class ConexaoAdmin  extends Conexao{
	PreparedStatement stmt = null;
	
	public void create (Administrador admin) throws Exception{
		try {
			open();
			stmt= con.prepareStatement("INSERT INTO administrador(nome, senha, endereco, email, telefone)" +
					"VALUES(?,?,?,?,?)");
			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getSenha());
			stmt.setString(3, admin.getEndereco());
			stmt.setString(4, admin.getEmail());
			stmt.setInt(5, admin.getTelefone());
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	
	
	public Administrador logar(String nome, String senha) throws Exception{
		Administrador a= new Administrador();
		open(); 
		try{
		
		stmt= con.prepareStatement("Select * from usuario WHERE login like ? ");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs= stmt.executeQuery();
		if(rs.next()){
			if(rs.getString("senha").equals(senha)){
		
			a.setEmail(rs.getString("email"));
			a.setSenha(rs.getString("senha"));
			a.setEndereco(rs.getString("endereco"));
			a.setTelefone(rs.getInt("telefone"));
			a.setNome(rs.getString("nome"));
			
			}else{
				return null;
			}
		
}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		con.close();
		return a;
	}
}