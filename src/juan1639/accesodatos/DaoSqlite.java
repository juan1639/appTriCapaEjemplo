package juan1639.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import juan1639.accesodatos.AccesoDatosException;

public class DaoSqlite {

	// C:\Users\User\eclipse-workspace\java-2691\webservidor
	// private static final String URL = "jdbc:mysql://localhost:3306/veterinario";
	// private static final String URL = "jdbc:sqlite:sql/veterinario.db";
	private static final String URL = "jdbc:sqlite:C:\\Users\\User\\eclipse-workspace\\clinicaveterinaria\\sql\\ejemplo.db";
	// private static final String URL =
	// "jdbc:sqlite:C:\\Users\\User\\eclipse-workspace\\java-2691\\webservidor\\src\\main\\webapp\\WEB-INF\\sql\\veterinario.db";
	private static final String USER = "root";
	private static final String PASS = "admin";

	// Necesario para que se pueda utilizar desde Tomcat
	static {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}

	protected Connection conectar() {

		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new AccesoDatosException("No ha funcionado la conexión a la base de datos", e);
		}
	}
}
