package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class ProfessorDAO<VO extends ProfessorVO> extends UsuarioDAO<VO>  implements ProfessorInterDAO{
	
	@Override
	public void inserir(VO vo) throws SQLException{
		String sql = "insert into professor (idUsu) values (?)";
		PreparedStatement ptst;
		
		try {
			super.inserir(vo);
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
	
	@Override
	public void atualizar(VO vo) throws SQLException {
		
		try {		
			super.atualizar(vo);  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletar(VO vo) throws SQLException {
		String sql = "delete from professor where idProf = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdProf());
			ptst.executeUpdate();
			
			super.deletar(vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from usuario inner join professor using (Idusu)";  //select * from professor
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
	public ResultSet buscarPorNome(VO vo) throws SQLException {
		String sql = "select p.IdProf, u.nome, u.cpf, u.endereco, u.email from " +
					 "professor p, usuario u where u.nome like ? and p.idUsu = u.idUsu;";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%"+vo.getNome()+"%");
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet buscarPorId(VO vo) throws SQLException {
		String sql = "select * from usuario u, professor p where u.idUsu = ? and p.idUsu = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdUsu());
			ptst.setLong(2, vo.getIdUsu());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//TurmaProf (atribuir turmas)
	@Override
	public void cadastrarTurmas(TurmaVO tur, ProfessorVO prof) throws SQLException {
		String sql = "insert into turmaprof (idturma, idprof) values (?,?)";
		PreparedStatement ptst;

			try {		
				ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ptst.setLong(1, tur.getIdTurma());
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
}
