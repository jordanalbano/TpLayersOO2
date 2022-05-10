package ar.unrn.excepciones;

public class ExcepcionPorRegionDesconocida extends RuntimeException {
	public ExcepcionPorRegionDesconocida(String message) {
		super(message);
	}
}
