package br.edu.ufersa.sei.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/SEI";
	private static final String user = "sei";
	private static final String senha = "admin";
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url,user,senha);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}else {
			return conn;
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void inserir(VO vo) throws SQLException;
	public abstract void atualizar(VO vo) throws SQLException;
	public abstract void deletar(VO vo) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ResultSet buscarPorNome(VO vo) throws SQLException;
	public abstract ResultSet buscarPorId(VO vo) throws SQLException;
}
