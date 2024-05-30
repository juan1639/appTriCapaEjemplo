package juan1639.accesodatos;

import juan1639.entidades.Empleado;

public interface DaoEmpleado extends Dao<Empleado> {
	
	Empleado obtenerPorNif(String nif);
}
