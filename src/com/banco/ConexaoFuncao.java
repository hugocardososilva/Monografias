package com.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.classes.Funcao;


public class ConexaoFuncao extends Conexao{
	PreparedStatement stmt= null;
	ResultSet rs= null;
	
	public void create(Funcao funcao)throws Exception{
		
		try {
			open();
			stmt= con.prepareStatement("INSERT INTO funcao(privilegios," +
					"descricao) VALUES(?,?)");	
			stmt.setString(1, funcao.getPrivilegios());
			stmt.setString(2, funcao.getDescricao());
			stmt.execute();
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		con.close();
		
	}
	
	public ArrayList<Funcao> ListarFuncao() throws Exception{
		try {
			
			ArrayList<Funcao> lista = new ArrayList<Funcao>();
			open();
			stmt= con.prepareStatement("SELECT cod, privilegios, descricao FROM funcao");
			rs= stmt.executeQuery();
			
				while(rs.next()){
					Funcao f= new Funcao();
					f.setCodigo(rs.getInt(1));
					f.setPrivilegios(rs.getString(2));
					f.setDescricao(rs.getString(3));
					lista.add(f);
					
					
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
