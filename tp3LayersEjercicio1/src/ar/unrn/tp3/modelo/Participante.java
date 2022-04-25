package ar.unrn.tp3.modelo;

import ar.unrn.tp3.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.tp3.excepciones.ExcepcionPorRegionDesconocida;
import ar.unrn.tp3.excepciones.ExcepcionPorStringNulo;

public class Participante {
	private String telefono;
	private String nombre;
	private String region;

	public Participante(String nombre, String telefono, String region)
			throws ExcepcionPorStringNulo, ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorRegionDesconocida {
		validarDatos(nombre, telefono, region);

		this.telefono = telefono;
		this.nombre = nombre;
		this.region = region;
	}

	private void validarDatos(String nombre, String telefono, String region)
			throws ExcepcionPorStringNulo, ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorRegionDesconocida {
		if (nombre.equals("")) {
			throw new ExcepcionPorStringNulo("Debe cargar un nombre");
		}
		if (telefono.equals("")) {
			throw new ExcepcionPorStringNulo("Debe cargar un telefono");
		}
		if (region.equals("")) {
			throw new ExcepcionPorStringNulo("Debe cargar una region");
		}
		if (!validarTelefono(telefono)) {
			throw new ExcepcionPorMalFormaDeIngresoDeTelefono(
					"El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			throw new ExcepcionPorRegionDesconocida("Region desconocida. Las conocidas son: China, US, Europa");
		}
	}

	public String nombre() {
		return this.nombre;
	}

	public String telefono() {
		return this.telefono;
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String region() {
		return this.region;
	}

}
