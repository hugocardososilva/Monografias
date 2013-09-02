package com.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.classes.Administrador;


public class ConexaoAdmin extends Conexao{
	PreparedStatement stmt;
	
	public void create(Administrador admin) throws Exception{
		
		
		try {
			open();
			stmt= con.prepareStatement("INSERT INTO administrador(nome," +
					" senha, endereco, email, telefone)" +
					" VALUES(?,?,?,?,?)");
			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getSenha());
			stmt.setString(3, admin.getEndereco());
			stmt.setString(4, admin.getEmail());
			stmt.setInt(5, admin.getTelefone());
			stmt.execute();
			con.close();
			//adiciona valores relacionados a funcao do admin
			RelacionarFuncao(admin);
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}
	public void RelacionarFuncao(Administrador admin) throws Exception{
		try {
			open();
			PreparedStatement stmt = null;
			stmt= con.prepareStatement("SELECT * FROM administrador WHERE email like ?");
			stmt.setString(1, "%" + admin.getEmail() + "%");
			ResultSet rs= stmt.executeQuery();
				if (rs.next()){
				Integer cod = Integer.parseInt(rs.getString("cod"));
				admin.setCodigo(cod);
					
			
			for(String s: admin.getFuncoes() ){
				PreparedStatement estado= con.prepareStatement("INSERT INTO possui_funcao (" +
						"cod_admin, cod_funcao) VALUES (?,?)");
				estado.setInt(2, Integer.parseInt(s));
				estado.setInt(1, (admin.getCodigo()));
				estado.execute();
			}			
				
				
			}
				con.close();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	
	
	public Administrador logar(String email, String senha) throws Exception{
		Administrador a= new Administrador();
		open(); 
		try{
		
		stmt= con.prepareStatement("Select cod, nome, senha," +
				"endereco, email, telefone FROM administrador WHERE email like ?  and senha like ?");
		stmt.setString(1, "%" + email + "%");
		stmt.setString(2, "%" + senha + "%");
		ResultSet rs= stmt.executeQuery();
		
		if(rs.next()){
			
			a.setCodigo(rs.getInt("cod"));
			a.setEmail(rs.getString("email"));
			a.setSenha(rs.getString("senha"));
			a.setEndereco(rs.getString("endereco"));
			a.setTelefone(rs.getInt("telefone"));
			a.setNome(rs.getString("nome"));
			con.close();
			return a;
						
		}

		}catch (SQLException e) {
            e.printStackTrace();
        }
		con.close();
		return null;
	}
	
	public ArrayList<Administrador> ListarAdmin() throws Exception{
		try {
			PreparedStatement stmt= null;
			ArrayList<Administrador> lista = new ArrayList<Administrador>();
			open();
			stmt= con.prepareStatement("SELECT cod, nome," +
					"endereco, email, telefone" +
					" FROM administrador");
			rs= stmt.executeQuery();
			while(rs.next()){
				Administrador a= new Administrador();
				a.setCodigo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setEndereco(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setTelefone(rs.getInt(5));
				lista.add(a);
				
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