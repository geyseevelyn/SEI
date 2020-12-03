package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class ProfessorDAO<VO extends ProfessorVO> extends UsuarioDAO<VO>{
	
	//INSERIR TURMAS DO PROFESSOR
	
	@Override
	public void inserir(VO vo) throws SQLException{
		try {
			super.inserir(vo);
			String sql = "insert into professor (idUsu) values (?)";
			PreparedStatement ptst;
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, vo.getIdUsu());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdProf(generatedKeys.getLong(1));
			}else {
				throw new SQLException("A inserção falhou. Nenhum ID foi retornado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	} 
	
	//ATUALIZAR??
	//DELETAR??
	
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from professor";  //vai mostrar só idProf e IdUsu
		PreparedStatement ptst;
		ResultSet rs = null;
		
 		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet buscarPorNome(String nome) throws SQLException {
		String sql = "select p.IdProf, u.nome, u.cpf, u.endereco, u.email from " +
					 "professor p, usuario u where u.nome = ? and p.idUsu = u.idUsu;";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,nome);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet buscarPorId(long id) throws SQLException {
		String sql = "select * from professor where idUsu = ?"; //vai mostrar só idProf
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,id);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
