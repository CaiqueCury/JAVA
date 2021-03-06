package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.fiap.contato.Contato;

public class ContatoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement p;
	
	
	public void inserir(Contato contato) {
		sql = "insert into JAVA_AGENDA values (?, ?, ?, ?)";
		try{
			connection = null;
			p = connection.prepareStatement(sql);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getEndereco());
			p.setString(3, contato.getEmail());
			p.setString(4, contato.getNacimento());
			p.execute();
		}
		catch (SQLException e) {}
	}
	
	
	
}
