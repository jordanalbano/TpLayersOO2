package ar.unrn.modelo;

import ar.unrn.excepciones.ExcepcionPorIdConcursoInvalido;
import ar.unrn.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.excepciones.ExcepcionPorMalIngresoDeEmail;
import ar.unrn.excepciones.ExcepcionPorNoEleccionDeConcurso;
import ar.unrn.excepciones.ExcepcionPorStringVacio;

public class Concursante {
	private String nombre;
	private String apellido;
	private String telefono;
	private String dni;
	private String email;
	private int idConcurso;

	public Concursante(String nombre, String apellido, String telefono, String email, String dni, Integer idConcurso)
			throws ExcepcionPorStringVacio, ExcepcionPorMalIngresoDeEmail, ExcepcionPorMalFormaDeIngresoDeTelefono,
			ExcepcionPorNoEleccionDeConcurso, ExcepcionPorIdConcursoInvalido {
		validarDatos(nombre, apellido, telefono, email, dni);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
		this.idConcurso = idConcurso;
	}

	private void validarDatos(String nombre, String apellido, String telefono, String email, String dni)
			throws ExcepcionPorStringVacio, ExcepcionPorMalIngresoDeEmail, ExcepcionPorMalFormaDeIngresoDeTelefono,
			ExcepcionPorNoEleccionDeConcurso, ExcepcionPorIdConcursoInvalido {

		if (nombre.equals("")) {
			throw new ExcepcionPorStringVacio("nombre no puede ser vacio");
		}
		if (apellido.equals("")) {
			throw new ExcepcionPorStringVacio("apellido no puede ser vacio");

		}
		if (email.equals("")) {
			throw new ExcepcionPorStringVacio("email no puede ser vacio");
		}
		if (dni.equals("")) {
			throw new ExcepcionPorStringVacio("dni no puede ser vacio");
		}
		if (!verificarEmail(email)) {
			throw new ExcepcionPorMalIngresoDeEmail("Email Debe Ser Valido");
		}
		if (!esTelefonoValido(telefono)) {
			throw new ExcepcionPorMalFormaDeIngresoDeTelefono(
					"El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}

	}

	public String dni() {
		return this.dni;
	}

	private boolean verificarEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	private boolean esTelefonoValido(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String apellido() {
		return this.apellido;
	}

	public String nombre() {
		return this.nombre;
	}

	public String email() {
		return this.email;
	}

	public int idConcurso() {
		return this.idConcurso;
	}

	public String telefono() {
		return this.telefono;
	}
}
