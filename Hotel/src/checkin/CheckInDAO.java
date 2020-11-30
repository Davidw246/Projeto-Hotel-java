package checkin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;

public class CheckInDAO {
	public void salvar(CheckIn checkin) {
		String sql = "insert into checkin(codecheck, codehospede, data_entrada, add_veiculo) values(?,?,?, ?)";

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

			ps.setInt(1, checkin.getCodecheck());
			ps.setInt(2, checkin.getCodehospede());
			ps.setDate(3, new Date(checkin.getDataentrada().getTime()));
			ps.setBoolean(4, checkin.isAddveiculo());

			

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

	public void alterar(CheckIn checkin, int codecheck) {
		String sql = "update checkin set codehospede = ?, data_saida = ?, add_veiculo = ?, valortotal = ? where codecheck = ? ";

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
			ps.setInt(1, checkin.getCodehospede());
			ps.setDate(2, new Date(checkin.getDatasaida().getTime()));
			ps.setBoolean(3, checkin.isAddveiculo());
			ps.setDouble(4, checkin.getValortotal());
			ps.setInt(5, checkin.getCodecheck());

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
	public void excluir(int codeCheck) {
		String sql = "delete from checkin  where codecheck = ?";

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

			ps.setInt(1, codeCheck);
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

	public List<CheckIn> buscar() { // java.util
		String sql = "select * from checkin";

		List<CheckIn> contatos = new ArrayList<CheckIn>();

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
                CheckIn c = new CheckIn();
                c.setCodecheck(rs.getInt("Codecheck"));
                c.setCodehospede(rs.getInt("Codehospede"));
                c.setDataentrada(rs.getDate("Data_entrada"));
                c.setDatasaida(rs.getDate("data_saida"));
                c.setAddveiculo(rs.getBoolean("Add_veiculo"));
                c.setValortotal(rs.getDouble("Valortotal"));

                contatos.add(c);

            }

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

		return contatos;
	}

}
