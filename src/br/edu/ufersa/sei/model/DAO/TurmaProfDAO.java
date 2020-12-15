package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

//Tabela TurmaProf (atribuir ou remover turmas de um professor)

public class TurmaProfDAO extends BaseDAO<TurmaVO>{

	public void cadastrarTurmasProf(TurmaVO turma, ProfessorVO prof) throws SQLException {
		String sql = "insert into turmaprof (idturma, idprof) values (?,?)";
		PreparedStatement ptst;

		try {		
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, turma.getIdTurma());
			ptst.setLong(2, prof.getIdProf());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Não foi possível atribuir turma");
			}

			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (!generatedKeys.next()) {
				throw new SQLException("Não foi possível atribuir turma");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirTurmasProf(TurmaVO turma, ProfessorVO prof) throws SQLException {
		String sql = "delete from turmaprof where idturma = ? and idprof = ?";
		PreparedStatement ptst;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, turma.getIdTurma());
			ptst.setLong(2, prof.getIdProf());

			ptst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//buscar turmas de um professor
	public ResultSet buscarTurmasProf(ProfessorVO prof) {		
		String sql = "select t.idturma, t.codturma, t.nome, t.sala, t.turno from turma t where t.idturma in" + 
				"(select tp.idturma from turmaprof tp where idprof = ?)";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, prof.getIdProf());
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
