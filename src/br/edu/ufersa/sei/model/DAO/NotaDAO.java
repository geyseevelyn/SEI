package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.NotaVO;

public class NotaDAO extends BaseDAO<NotaVO> implements NotaInterDAO{

	@Override
	public void inserir(NotaVO vo) throws SQLException{
		String sql = "insert into notas (n1,n2,n3,frequencia,idAluno,idDisc) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getN1());
			ptst.setDouble(2, vo.getN2());
			ptst.setDouble(3, vo.getN3());
			ptst.setInt(3, vo.getFrequencia());
			ptst.setLong(4, vo.getAluno().getIdAluno());
			ptst.setLong(5, vo.getDisc().getIdDisc());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(NotaVO vo) {
		//implementar
	}

	@Override
	public void deletar(NotaVO vo) {
		//implementar
	}

	@Override
	public ResultSet listar() {
		//implementar
		return null;
	}

	@Override
	public ResultSet buscarPorNome(NotaVO vo) {
		return null;
	}

	@Override
	public void lancarNotas(AlunoVO aluno) {
		//implementar
	}

	@Override
	public void lancarFrequencia(AlunoVO aluno) {
		//implementar
	}

	@Override
	public ResultSet buscarPorId(NotaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
