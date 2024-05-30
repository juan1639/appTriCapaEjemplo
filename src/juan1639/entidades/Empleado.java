package juan1639.entidades;

import java.math.BigDecimal;

public class Empleado extends Persona {
	
	String nss;
	BigDecimal sueldoMensual;
	
	public Empleado(Long id, String nombre, String apellidos, String nif, String telefono,
			String nss, BigDecimal sueldoMensual) {
		
		super(id, nombre, apellidos, nif, telefono);
		this.nss = nss;
		this.sueldoMensual = sueldoMensual;
	}

	public Empleado() {}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public BigDecimal getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(BigDecimal sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public String toString() {
		return "Empleado [nss=" + nss + ", sueldoMensual=" + sueldoMensual + "]";
	}	
}
