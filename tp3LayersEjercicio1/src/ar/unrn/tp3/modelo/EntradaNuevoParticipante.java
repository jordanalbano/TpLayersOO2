package ar.unrn.tp3.modelo;

import ar.unrn.tp3.excepciones.AppException;
import ar.unrn.tp3.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.tp3.excepciones.ExcepcionPorRegionDesconocida;
import ar.unrn.tp3.excepciones.ExcepcionPorStringNulo;

public interface EntradaNuevoParticipante {
	void nuevoParticipante(String nombre, String telefono, String region) throws AppException, ExcepcionPorStringNulo,
			ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorRegionDesconocida;
}
