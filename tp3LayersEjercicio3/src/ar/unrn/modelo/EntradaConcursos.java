package ar.unrn.modelo;

import java.io.IOException;
import java.util.ArrayList;

import ar.unrn.excepciones.AppException;

public interface EntradaConcursos {
	ArrayList<Concurso> todosLosConcursos() throws IOException, AppException;
}
