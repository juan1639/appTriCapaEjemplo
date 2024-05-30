package juan1639.accesodatos;

//Creamos una excepción propia de la capa para que no se cree
//una dependencia fuerte entre la capa de accesodatos y la de negocio
public class AccesoDatosException extends RuntimeException {

	public AccesoDatosException() {
		super();
	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message) {
		super(message);
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	}
}
