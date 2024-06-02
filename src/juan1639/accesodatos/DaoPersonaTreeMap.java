package juan1639.accesodatos;

import java.util.TreeMap;

import juan1639.entidades.Persona;

public class DaoPersonaTreeMap implements DaoPersona {
	
	private static TreeMap<Long, Persona> personasTreeMap = new TreeMap<>();

	@Override
	public Iterable<Persona> obtenerTodos() {
		return personasTreeMap.values();
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return personasTreeMap.get(id);
	}

	@Override
	public Persona insertar(Persona persona) {
		
		Long id = personasTreeMap.size() > 0 ? personasTreeMap.lastKey() + 1L : 1L;
		personasTreeMap.put(id, persona);
		
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		
		personasTreeMap.put(persona.getId(), persona);
		
		return persona;
	}

	@Override
	public void borrar(Long id) {
		
		if (!personasTreeMap.containsKey(id)) {
			throw new AccesoDatosException("id No encontrada " + id);
		}
		
		personasTreeMap.remove(id);
	}

	@Override
	public Persona obtenerPorNif(String nif) {
		
		return personasTreeMap.values().stream().filter(pers -> nif.equals(pers.getNif())).findFirst().orElse(null);
	}
}
