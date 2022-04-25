package ar.unrn.tp3.modelo;

import ar.unrn.tp3.excepciones.AppException;

public interface RepositorioDeParticipantes {
	void nuevoParticipante(Participante participante) throws AppException;

}
