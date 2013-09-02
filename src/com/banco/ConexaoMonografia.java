package com.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.classes.Monografia;
import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

public class ConexaoMonografia extends Conexao {
	PreparedStatement stmt= null;
	public void create(Monografia m) throws Exception{
		try {
			
			open();
			stmt= con.prepareStatement("INSERT INTO `monografia`" +
					"(`nome_aluno`, `matricula`, `nota`, `arquivo`, " +
					"`id_user`, `nome_curso`," +
					" `nome_instituicao`)" +
					" VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, m.getNome());
			stmt.setString(2, m.getMatricula());
			stmt.setDouble(3, m.getNota());
			stmt.setString(4, m.getArquivo());
			stmt.setInt(5, m.getId_user());
			stmt.setString(6, m.getNomeCurso());
			stmt.setString(7, m.getNomeInstituicao());
			
			stmt.execute();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public ArrayList<Monografia> ListarMonografias() throws Exception{
	try {
	ArrayList<Monografia> lista= new ArrayList<Monografia>();
	open();
	stmt= con.prepareStatement("SELECT * FROM monografia");
	rs= stmt.executeQuery();
	while(rs.next()){
		Monografia m = new Monografia();
		m.setId(rs.getInt("cod_mono"));
		m.setId_user(rs.getInt("id_user"));
		m.setMatricula(rs.getString("matricula"));
		m.setNome(rs.getString("nome_aluno"));
		m.setNomeCurso(rs.getString("nome_curso"));
		m.setNomeInstituicao(rs.getString("nome_instituicao"));
		m.setNota(rs.getDouble("nota"));
		m.setCod_admin(rs.getInt("cod_admin"));
		m.setArquivo(rs.getString("arquivo"));
		lista.add(m);
		
		
	}
	
		con.close();
		return lista;
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	con.close();
	return null;
	
}
public ArrayList<Monografia> ListarMonografiasPublicadas() throws Exception{
	try {
	ArrayList<Monografia> lista= new ArrayList<Monografia>();
	open();
	stmt= con.prepareStatement("SELECT * FROM monografia where cod_admin IS NOT NULL");
	rs= stmt.executeQuery();
	while(rs.next()){
		if(rs.getString("cod_admin")!= null){
			
		
		Monografia m = new Monografia();
		m.setId(rs.getInt("cod_mono"));
		m.setId_user(rs.getInt("id_user"));
		m.setMatricula(rs.getString("matricula"));
		m.setNome(rs.getString("nome_aluno"));
		m.setNomeCurso(rs.getString("nome_curso"));
		m.setNomeInstituicao(rs.getString("nome_instituicao"));
		m.setNota(rs.getDouble("nota"));
		m.setArquivo(rs.getString("arquivo"));
		m.setCod_admin(rs.getInt("cod_admin"));
		lista.add(m);
		}
		
	}
	
		con.close();
		return lista;
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	con.close();
	return null;
	
}

 public String PublicarMonografia(int cod, int cod_admin) throws Exception, MySQLDataException{
	 try {
		 
		 open();
		 stmt= con.prepareStatement("update monografia mono set mono.cod_admin=? where mono.cod_mono like ?" );
		 stmt.setInt(1, cod_admin );
		 stmt.setInt(2, cod);
		 stmt.executeUpdate();
		 
		 
		con.close();
			 return "atualizado com sucesso";
		 
		 
		
	} catch (MySQLDataException e) {

		e.printStackTrace();
	}
		con.close();
		 return null;
	}
	 
 
}
