package ar.unrn.modelo;

import ar.unrn.excepciones.AppException;
import ar.unrn.excepciones.ExcepcionPorIdConcursoInvalido;
import ar.unrn.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.excepciones.ExcepcionPorMalIngresoDeEmail;
import ar.unrn.excepciones.ExcepcionPorNoEleccionDeConcurso;
import ar.unrn.excepciones.ExcepcionPorStringVacio;

public interface Concursantes {

	void saveInscription(String nombre, String apellido, String telefono, String email, String dni, Integer concursante)
			throws AppException, ExcepcionPorStringVacio, ExcepcionPorMalIngresoDeEmail,
			ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorNoEleccionDeConcurso, ExcepcionPorIdConcursoInvalido;

}
