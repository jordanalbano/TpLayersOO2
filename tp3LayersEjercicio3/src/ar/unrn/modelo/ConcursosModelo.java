package ar.unrn.modelo;

import java.io.IOException;
import java.util.ArrayList;

import ar.unrn.excepciones.AppException;

public class ConcursosModelo implements EntradaConcursos {
	private RegistroConcursos registro;

	public ConcursosModelo(RegistroConcursos r) {
		this.registro = r;
	}

	@Override
	public ArrayList<Concurso> todosLosConcursos() throws IOException, AppException {

		return this.registro.todosLosConcursos();
	}

}
