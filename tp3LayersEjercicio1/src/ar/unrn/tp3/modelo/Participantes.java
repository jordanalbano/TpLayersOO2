package ar.unrn.tp3.modelo;

import ar.unrn.tp3.excepciones.AppException;
import ar.unrn.tp3.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.tp3.excepciones.ExcepcionPorRegionDesconocida;
import ar.unrn.tp3.excepciones.ExcepcionPorStringNulo;

public class Participantes implements EntradaNuevoParticipante {
	private RepositorioDeParticipantes repositorio;

	public Participantes(RepositorioDeParticipantes repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void nuevoParticipante(String nombre, String telefono, String region) throws AppException,
			ExcepcionPorStringNulo, ExcepcionPorMalFormaDeIngresoDeTelefono, ExcepcionPorRegionDesconocida {
		this.repositorio.nuevoParticipante(new Participante(nombre, telefono, region));

	}

}
