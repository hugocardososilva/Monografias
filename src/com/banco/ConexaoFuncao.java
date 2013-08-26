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
			stmt.setString(1, funcao.getPrivilegio());
			stmt.setString(2, funcao.getDescicao());
			stmt.executeUpdate();
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		close();
		
	}
	
	public ArrayList<Funcao> ListarFuncao() throws Exception{
		try {
			Funcao f= null;
			ArrayList<Funcao> lista = new ArrayList<Funcao>();
			open();
			stmt= con.prepareStatement("SELECT cod, privilegio, descricao INTO funcao");
			rs= stmt.executeQuery();
			
				while(rs.next()){
					f.setCodigo(rs.getInt(1));
					f.setPrivilegio(rs.getString(2));
					f.setDescicao(rs.getString(3));
					lista.add(f);
					
				}
			return lista;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	
	}
	
		

}
