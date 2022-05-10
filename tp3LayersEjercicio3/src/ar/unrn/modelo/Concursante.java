package ar.unrn.modelo;

import ar.unrn.excepciones.ExcepcionPorIdConcursoInvalido;
import ar.unrn.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.excepciones.ExcepcionPorMalIngresoDeEmail;
import ar.unrn.excepciones.ExcepcionPorNoEleccionDeConcurso;
import ar.unrn.excepciones.ExcepcionPorStringVacio;

public class Concursante {
	private String nombre;
	private String apellido;
	private Telefono telefono;
	private String dni;
	private Email email;
	private int idConcurso;

	public Concursante(String nombre, String apellido, String telefono, String email, String dni, Integer idConcurso)
			throws ExcepcionPorStringVacio, ExcepcionPorMalIngresoDeEmail, ExcepcionPorMalFormaDeIngresoDeTelefono,
			ExcepcionPorNoEleccionDeConcurso, ExcepcionPorIdConcursoInvalido {
		validarDatos(nombre, apellido, telefono, email, dni);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = new Telefono(telefono);
		this.email = new Email(email);
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
		if (dni.equals("")) {
			throw new ExcepcionPorStringVacio("dni no puede ser vacio");
		}

	}

	public String dni() {
		return this.dni;
	}

	public String apellido() {
		return this.apellido;
	}

	public String nombre() {
		return this.nombre;
	}

	public String email() {
		return this.email.email();
	}

	public int idConcurso() {
		return this.idConcurso;
	}

	public String telefono() {
		return this.telefono.telefono();
	}
}
