package ar.unrn.modelo;

import java.io.IOException;
import java.util.ArrayList;

import ar.unrn.excepciones.AppException;

public class Concursos implements EntradaConcursos {
	private RegistroConcursos registro;

	public Concursos(RegistroConcursos registro) {
		this.registro = registro;
	}

	@Override
	public ArrayList<Concurso> todosLosConcursos() throws IOException, AppException {
		return this.registro.todosLosConcursos();
	}

}
