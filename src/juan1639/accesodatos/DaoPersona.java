package juan1639.accesodatos;

import juan1639.entidades.Persona;

public interface DaoPersona extends Dao<Persona> {
	
	Persona obtenerPorNif(String nif);
}
