package juan1639.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import juan1639.entidades.Empleado;

public class DaoEmpleadoSqlite extends DaoSqlite implements DaoEmpleado {
	
	private static final String TABLA = "empleados2";
	
	private static final String SQL_SELECT = "SELECT * FROM " + TABLA;
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_NIF = SQL_SELECT + " WHERE nif = ?";
	
	private static final String SQL_INSERT = "INSERT INTO " + TABLA + " (nombre, apellidos, telefono, nif, nss, sueldo_mensual) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE " + TABLA + " SET nombre=?, apellidos=?, telefono=?, nif=?, nss=?, sueldo_mensual=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM " + TABLA + " WHERE id = ?";
	
	// SINGLETON
	private DaoEmpleadoSqlite() {}
	private static DaoEmpleadoSqlite INSTANCIA = new DaoEmpleadoSqlite();
	public static DaoEmpleadoSqlite getInstancia() {return INSTANCIA;}
	// FIN SINGLETON
	
	@Override
	public Iterable<Empleado> obtenerTodos() {
		
		var empleados = new ArrayList<Empleado>();
		
		try (Connection con = conectar(); Statement st = con.createStatement();) {
			
			ResultSet rs = st.executeQuery(SQL_SELECT);
			
			Empleado empleado;
			
			while (rs.next()) {
				empleado = new Empleado(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("telefono"), rs.getString("nif"), rs.getString("nss"),
						rs.getBigDecimal("sueldo_mensual"));
				
				empleados.add(empleado);
			}
			
			return empleados;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los empleados", e);
		}
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		
		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			
			Empleado empleado = null;
			
			if (rs.next()) {
				empleado = new Empleado(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("nif"), rs.getString("telefono"), rs.getString("nss"),
						rs.getBigDecimal("sueldo_mensual"));
			}
			
			return empleado;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el empleado id: " + id, e);
		}
	}
	
	@Override
	public Empleado obtenerPorNif(String nif) {
		
		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_NIF);) {

			pst.setString(1, nif);
			ResultSet rs = pst.executeQuery();

			Empleado empleado = null;

			if (rs.next()) {
				empleado = new Empleado(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("nif"), rs.getString("telefono"), rs.getString("nss"),
						rs.getBigDecimal("sueldo_mensual"));
			}

			return empleado;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el empleado nif: " + nif, e);
		}
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		
		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellidos());
			pst.setString(3, empleado.getTelefono());
			pst.setString(4, empleado.getNif());
			pst.setString(5, empleado.getNss());
			pst.setBigDecimal(6, empleado.getSueldoMensual());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			
			empleado.setId(rs.getLong(1));
			
			return empleado;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el empleado " + empleado, e);
		}
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		
		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellidos());
			pst.setString(3, empleado.getTelefono());
			pst.setString(4, empleado.getNif());
			pst.setString(5, empleado.getNss());
			pst.setBigDecimal(6, empleado.getSueldoMensual());
			pst.setLong(7, empleado.getId());
			
			pst.executeUpdate();
			
			return empleado;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el empleado " + empleado, e);
		}
	}

	@Override
	public void borrar(Long id) {
		
		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			
			pst.setLong(1, id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el empleado id: " + id, e);
		}
	}
}
