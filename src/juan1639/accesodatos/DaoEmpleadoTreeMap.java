package juan1639.accesodatos;

import java.util.TreeMap;

import juan1639.entidades.Empleado;

public class DaoEmpleadoTreeMap implements DaoEmpleado {
	
	protected static TreeMap<Long, Empleado> empleadosTreeMap = new TreeMap<>();

	@Override
	public Iterable<Empleado> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado modificar(Empleado objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado obtenerPorNif(String nif) {
		// TODO Auto-generated method stub
		return null;
	}
}
