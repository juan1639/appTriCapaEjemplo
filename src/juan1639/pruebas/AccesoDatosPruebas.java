package juan1639.pruebas;

import java.math.BigDecimal;

import juan1639.accesodatos.DaoEmpleado;
import juan1639.accesodatos.DaoEmpleadoTreeMap;
import juan1639.entidades.Empleado;

public class AccesoDatosPruebas {

	public static void main(String[] args) {
		
		  DaoEmpleado dao = new DaoEmpleadoTreeMap();
		  
		  for (var e : dao.obtenerTodos()) {
			  System.out.println("Antes: " + e);
		  }
		  
		  dao.insertar(new Empleado(null, "Javier", "Lete", "12345678A", "654321654",
		  "1234123412341234", new BigDecimal(23456)));
		  
		  dao.insertar(new Empleado(null, "Pepe", "Pérez", "87654321A", "654123456",
		  "4321432143214321", new BigDecimal(12345)));
		  
		  dao.insertar(new Empleado(null, "La", "Hormiga", "37654321W", "650125450",
		  "4821432043214321", new BigDecimal(10345)));
		  
		  for (var e : dao.obtenerTodos()) {
			  System.out.println("Después: " + e);
		  }
		  
		  System.out.println("Id: " + dao.obtenerPorId(3L));
		  
		  System.out.println("NIF: " + dao.obtenerPorNif("12345678A"));
		 
		
		/*
		 * DaoPersona daop = new DaoPersonaTreeMap();
		 * 
		 * daop.insertar(new Persona(null, "Javier", "Lete", "12345678A", "654321654"));
		 * 
		 * daop.insertar(new Persona(null, "Arnold", "Suartxe", "87654321A",
		 * "654123456"));
		 * 
		 * daop.insertar(new Persona(null, "La", "Hormiga", "37654321W", "650125450"));
		 * 
		 * for (var pers : daop.obtenerTodos()) { System.out.println("Después: " +
		 * pers); }
		 * 
		 * System.out.println("Id: " + daop.obtenerPorId(2L));
		 * 
		 * System.out.println("NIF: " + daop.obtenerPorNif("12345678A"));
		 */
	}
}
