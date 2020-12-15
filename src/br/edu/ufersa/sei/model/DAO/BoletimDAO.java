package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;

public class BoletimDAO extends BaseDAO<NotaVO> {

	@Override
	public void inserir(NotaVO vo) throws SQLException {
		String sql = "insert into boletim (idAluno, idDisc,n1, n2, n3, media, faltas, situacao) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getAluno().getIdAluno());
			ptst.setLong(2, vo.getDisc().getIdDisc());
			ptst.setDouble(3, vo.getN1());
			ptst.setDouble(4, vo.getN2());
			ptst.setDouble(5, vo.getN3());
			ptst.setDouble(6, vo.getMedia());
			ptst.setInt(7, vo.getFaltas());
			if(vo.getMedia() >= 7) {
				System.out.println("Entrou no IF!");
				ptst.setString(8, "Aprovado");
			} else {
				System.out.println("Não Entrou no IF!");
				ptst.setString(8, "Reprovado");
			}
			System.out.println(vo);

			ptst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(NotaVO vo) throws SQLException {
		String sql = "update boletim set n1 = ?, n2 = ?, n3 = ?, media = ?, faltas = ?, situacao = ? " +
				"where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getN1());
			ptst.setDouble(2, vo.getN2());
			ptst.setDouble(3, vo.getN3());;
			ptst.setDouble(4, vo.getMedia());
			ptst.setInt(5, vo.getFaltas());
			if(vo.getMedia() >= 7) {
				System.out.println("Entrou no IF!");
				ptst.setString(6, "Aprovado");
			} else {
				System.out.println("Não Entrou no IF!");
				ptst.setString(6, "Reprovado");
			}
			ptst.setLong(7, vo.getAluno().getIdAluno());
			ptst.setLong(8, vo.getDisc().getIdDisc());

			ptst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	@Override
	public void deletar(NotaVO vo) throws SQLException {
		String sql = "delete from boletim where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getAluno().getIdAluno());
			ptst.setLong(2, vo.getDisc().getIdDisc());

			ptst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from boletim"; //"select idDisc, n1, n2, n3, media, faltas from nota";
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

	public ResultSet buscarBoletimAluno(AlunoVO avo, DisciplinaVO dvo) throws SQLException {
		String sql = "select * from boletim where IdAluno = ? and IdDisc = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, avo.getIdAluno());
			ptst.setLong(2, dvo.getIdDisc());
			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet listarNotasAluno(AlunoVO alu) throws SQLException {
		String sql = "select * from boletim where idAluno = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, alu.getIdAluno());
			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet buscarPorNome(NotaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet buscarPorId(NotaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
