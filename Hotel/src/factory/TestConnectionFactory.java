package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionFactory {

	public static void main(String[] args) {

		try {
			Connection con = ConnectionFactory.criarConexao();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
