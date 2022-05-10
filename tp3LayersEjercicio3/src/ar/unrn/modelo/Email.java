package ar.unrn.modelo;

import ar.unrn.excepciones.ExcepcionPorMalIngresoDeEmail;
import ar.unrn.excepciones.ExcepcionPorStringVacio;

public class Email {
	private String email;

	public Email(String email) throws ExcepcionPorStringVacio, ExcepcionPorMalIngresoDeEmail {
		if (email.equals("")) {
			throw new ExcepcionPorStringVacio("email no puede ser vacio");
		}
		if (!this.esEmailValido(email)) {
			throw new ExcepcionPorMalIngresoDeEmail("Email Debe Ser Valido");
		}
		this.email = email;
	}

	public String email() {
		return this.email;
	}

	private boolean esEmailValido(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public String toString() {
		return "Email: " + this.email;
	}

}
