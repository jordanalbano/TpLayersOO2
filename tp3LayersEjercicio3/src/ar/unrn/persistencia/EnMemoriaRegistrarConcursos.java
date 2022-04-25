package ar.unrn.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.modelo.Concurso;
import ar.unrn.modelo.RegistroConcursos;

public class EnMemoriaRegistrarConcursos implements RegistroConcursos {

	@Override
	public ArrayList<Concurso> todosLosConcursos() throws IOException {
		List<String> fileData = Files.readAllLines(Paths.get("C:\\Users\\usuario\\Desktop\\concursos.txt"));

		ArrayList<Concurso> listaConcursos = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			String[] camposFechaIni = camposFila[2].split("/");

			LocalDate fechaIni = LocalDate.of(Integer.parseInt(camposFechaIni[0]), Integer.parseInt(camposFechaIni[1]),
					Integer.parseInt(camposFechaIni[2]));

			String[] camposFechaFin = camposFila[3].split("/");
			LocalDate fechaFin = LocalDate.of(Integer.parseInt(camposFechaFin[0]), Integer.parseInt(camposFechaFin[1]),
					Integer.valueOf(camposFechaFin[2]));

			listaConcursos.add(new Concurso(camposFila[0], camposFila[1], fechaIni, fechaFin));
		}
		return listaConcursos;
	}
}
