package ar.unrn.modelo;

import ar.unrn.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.excepciones.ExcepcionPorStringVacio;

public class Telefono {
	private String telefono;

	public Telefono(String numero) throws ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorStringVacio {
		if (numero.equals("")) {
			throw new ExcepcionPorStringVacio("Telefono no puede ser vacio");
		}
		if (!this.esTelefonoValido(numero)) {
			throw new ExcepcionPorMalFormaDeIngresoDeTelefono(
					"El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
		this.telefono = numero;
	}

	private boolean esTelefonoValido(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String telefono() {
		return this.telefono;
	}
}
