package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static final String URL = "jdbc:postgresql://localhost:5432/Desafio?useTimezone=true&serverTimezone=UTC";
	static final String USUARIO = "postgres";
	static final String SENHA = "david.oliveira";

	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection ConnectionFactory = DriverManager.getConnection(URL, USUARIO, SENHA);
		if (ConnectionFactory != null) {
			System.out.print("Conexão efetuada com sucesso...");
			return ConnectionFactory;
		}
		return null;
	}

}
