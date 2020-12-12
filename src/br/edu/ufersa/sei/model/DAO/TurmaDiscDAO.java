package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

//Tabela TurmaDisc (cadastrar, excluir, buscar disciplinas de uma turma)
public class TurmaDiscDAO extends BaseDAO<TurmaVO>{
	
	public void cadastrarDisicplinasTurma(TurmaVO turma, DisciplinaVO disc) throws SQLException {
		String sql = "insert into turmadisc (idturma, iddisc) values (?,?)";
		PreparedStatement ptst;
		
			try {		
				ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ptst.setLong(1, turma.getIdTurma());
				ptst.setLong(2, disc.getIdDisc());
			
				int affectedRows = ptst.executeUpdate();
				if (affectedRows == 0) {
					throw new SQLException("Não foi possível cadastrar disciplina");
				}
				
				ResultSet generatedKeys = ptst.getGeneratedKeys();
				if (!generatedKeys.next()) {
					throw new SQLException("Não foi possível cadastrar disciplina");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

	public void excluirDisicplinasTurma(TurmaVO turma, DisciplinaVO disc) throws SQLException {
		String sql = "delete from turmadisc where idturma = ? and iddisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, turma.getIdTurma());
			ptst.setLong(2, disc.getIdDisc());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//buscar disciplinas de uma turma
	public ResultSet buscarDiscTurma(TurmaVO turma) throws SQLException{
		
			String sql = "select d.coddisc, d.nome from disciplina d where d.iddisc in " + 
						 "(select td.iddisc from turmadisc td where td.idturma = ?)";
			PreparedStatement ptst;
			ResultSet rs = null;
					
	 		try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, turma.getIdTurma());
				rs = ptst.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}

	@Override
	public void inserir(TurmaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(TurmaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(TurmaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet buscarPorNome(TurmaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet buscarPorId(TurmaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
