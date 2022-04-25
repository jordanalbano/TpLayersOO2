package ar.unrn.modelo;

import java.time.LocalDate;

import ar.unrn.excepciones.ExcepcionPorStringNulo;

public class Empleado {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String email;

	public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String email)
			throws ExcepcionPorStringNulo {
		validarDatos(nombre, apellido, fechaNacimiento, email);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public String nombre() {
		return this.nombre;
	}

	public String apellido() {
		return this.apellido;
	}

	public String fechaNacimiento() {
		return this.fechaNacimiento.toString();
	}

	public String email() {
		return this.email;
	}

	private void validarDatos(String nombre, String apellido, LocalDate fechaNacimiento, String email)
			throws ExcepcionPorStringNulo {
		if (nombre.equals("")) {
			throw new ExcepcionPorStringNulo("rellene el campo nombre ");
		}
		if (apellido.equals("")) {
			throw new ExcepcionPorStringNulo("rellene el campo apellido");
		}
		if (fechaNacimiento.equals(null)) {
			throw new ExcepcionPorStringNulo("rellene el campo fecha de nacimiento");
		}
		if (email.equals("")) {
			throw new ExcepcionPorStringNulo("rellene el campo email");
		}
	}

	public boolean cumpleA�osHoy() {
		LocalDate hoy = LocalDate.now();
		return this.fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth()
				&& this.fechaNacimiento.getMonthValue() == hoy.getMonthValue();
	}

}
