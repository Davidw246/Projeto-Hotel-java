package hospede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;

public class HospedeDAO {
	public void salvar(Hospede hospede) {
		String sql = "insert into hospede(Codehospede, nome, cpf, telefone) values(?,?,?,?)";

		Connection con = null;
		PreparedStatement ps = null;

		try {

			try {
				con = ConnectionFactory.criarConexao();
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao se Conectar com o banco");
				e.printStackTrace();
			}

			ps = con.prepareStatement(sql);

			ps.setInt(1, hospede.getCodehospede());
			ps.setString(2, hospede.getNome());
			ps.setString(3, hospede.getCpf());
			ps.setString(4, hospede.getTelefone());

			ps.execute();
			System.out.println("Dados Salvos com sucesso");

		} catch (SQLException e) {
			System.err.println("Erro ao salvar dados");
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

	///////////////////////////////////////////////////////////////////////////////////

	public void alterar(Hospede hospede, int codehospede) {
		String sql = "update hospede set nome = ?, cpf = ?, telefone = ? where codehospede = ? ";

		Connection con = null;
		PreparedStatement ps = null;

		try {

			try {
				con = ConnectionFactory.criarConexao();
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao Conectar com o banco");
				e.printStackTrace();
			}
			ps = con.prepareStatement(sql);

			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getCpf());
			ps.setString(3, hospede.getTelefone());
			ps.setInt(4, codehospede);

			ps.executeUpdate();
			System.out.println("Dados alterados com sucesso");

		} catch (SQLException e) {
			System.err.println("Erro ao alterar dados");
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	public void excluir(int codeHospede) {
		String sql = "delete from hospede  where codehospede = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			try {
				con = ConnectionFactory.criarConexao();
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao conectar com o banco");
				e.printStackTrace();
			}
			ps = con.prepareStatement(sql);

			ps.setInt(1, codeHospede);
			ps.executeUpdate();

			System.out.println("Dados excluidos");

		} catch (SQLException e) {
			System.err.println("Erro ao excluir dados");
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

///////////////////////////////////////////////////////////////////////
	public List<Hospede> buscar(String dado, String pesquisa) { // java.util


			String sql = "select * from hospede where " + dado + " = '" + pesquisa + "'";

			List<Hospede> hospedelist = new ArrayList<Hospede>();

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {

				try {
					con = ConnectionFactory.criarConexao();
				} catch (ClassNotFoundException e) {
					System.out.println("Erro ao conectar com o banco");
					e.printStackTrace();
				}
				ps = con.prepareStatement(sql);
					

				rs = ps.executeQuery();
				while (rs.next()) {
					Hospede h = new Hospede();
					h.setCodehospede(rs.getInt("codehospede"));
					h.setNome(rs.getString("nome"));
					h.setCpf(rs.getString("Cpf"));
					h.setTelefone(rs.getString("Telefone"));

					hospedelist.add(h);

				}

			} catch (SQLException e) {
				System.err.println("Erro ao buscar dados");
				e.printStackTrace();
			} finally {

				try {
					if (ps != null) {
						ps.close();
					}

					if (con != null) {
						con.close();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return hospedelist;


	}

	
}
