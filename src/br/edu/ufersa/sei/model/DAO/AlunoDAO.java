package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class AlunoDAO<VO extends AlunoVO> extends UsuarioDAO<VO> implements AlunoInterDAO{
	
	@Override
	public void inserir(VO vo) throws SQLException{
		
		try {
			super.inserir(vo);
			String sql = "insert into aluno (matricula, idTurma, idUsu) values (?,?,?)";
			PreparedStatement ptst;
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getMatricula());
			ptst.setLong(2, vo.getTurma().getIdTurma()); //???
			ptst.setLong(3, vo.getIdUsu());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdAluno(generatedKeys.getLong(1));
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
		String sql = "select * from aluno";  //vai mostrar só idAluno, mat., idTurma, idUsu
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
		String sql = "select u.nome, u.cpf, u.endereco, u.email, a.matricula from " + 
				     "usuario u, aluno a WHERE u.nome = ? and u.idUsu = a.idUsu;";
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
		String sql = "select * from aluno where idUsu = ?"; //vai mostrar idAluno, mat., idTurma, idUsu
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

	//buscar alunos por turma (nome, id ou código??)
	@Override
	public ResultSet buscarPorTurma(TurmaVO turma) throws SQLException {
		//implementar
		return null;
	}
}
