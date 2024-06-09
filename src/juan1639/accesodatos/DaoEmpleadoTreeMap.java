package juan1639.accesodatos;

import java.util.TreeMap;

import juan1639.entidades.Empleado;

public class DaoEmpleadoTreeMap implements DaoEmpleado {
	
	protected static TreeMap<Long, Empleado> empleadosTreeMap = new TreeMap<>();

	@Override
	public Iterable<Empleado> obtenerTodos() {
		return empleadosTreeMap.values();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return empleadosTreeMap.get(id);
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		Long id = empleadosTreeMap.size() > 0 ? empleadosTreeMap.lastKey() + 1L : 1L;
		empleado.setId(id);
		empleadosTreeMap.put(id, empleado);
		
		return empleado;
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		empleadosTreeMap.put(empleado.getId(), empleado);
		
		return empleado;
	}

	@Override
	public void borrar(Long id) {
		if (!empleadosTreeMap.containsKey(id)) {
			throw new AccesoDatosException("Id No encontrada " + id);
		}
		
		empleadosTreeMap.remove(id);
	}

	@Override
	public Empleado obtenerPorNif(String nif) {
		// values() : Devuelve una colección con sólo los valores ya sin las claves asociadas
		// stream() : Crea un bucle for each automático que recorre cada empleado
		// filter() : Filtra los datos de los empleados según la expresión lambda
		// e -> nif.equals(e.getNif()) : Para cada empleado e comprueba si tiene un nif igual al que se busca. En la colección final, sólo quedan los que en esta expresión dan true
		// findFirst() : De todos los elementos que pueden salir del filtro sólo pedimos el primero que puede o no existir (Optional)
		// orElse() : Convertimos el optional en un valor de referencia normal, o null en el caso de que no tenga valor
		return empleadosTreeMap.values().stream().filter(empl -> nif.equals(empl.getNif()))
				.findFirst().orElse(null);
	}
	
	// Clases anónimas ***************************************************************
	//	return empleados.values().stream().filter(new Predicate<Empleado>() {
	//		@Override
	//		public boolean test(Empleado e) {
	//			return e.getNif() == nif;
	//		}
	//	}).findFirst().orElse(null);
	
	// Java 1.1 **********************************************************************
	//		static class Predicado implements java.util.function.Predicate<Empleado> {
	//			private String nif;
	//			
	//			public Predicado(String nif) {
	//				this.nif = nif;
	//			}
	//			
	//			@Override
	//			public boolean test(Empleado e) {
	//				return e.getNif() == nif;
	//			}
	//		}
}
