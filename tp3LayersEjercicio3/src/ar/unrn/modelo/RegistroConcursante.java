package ar.unrn.modelo;

import ar.unrn.excepciones.AppException;

public interface RegistroConcursante {
	void saveInscription(Concursante concursante) throws AppException;
}
