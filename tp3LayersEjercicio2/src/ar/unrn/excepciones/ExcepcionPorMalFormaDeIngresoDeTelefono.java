package ar.unrn.excepciones;

public class ExcepcionPorMalFormaDeIngresoDeTelefono extends RuntimeException {
	public ExcepcionPorMalFormaDeIngresoDeTelefono(String message) {
		super(message);
	}
}
