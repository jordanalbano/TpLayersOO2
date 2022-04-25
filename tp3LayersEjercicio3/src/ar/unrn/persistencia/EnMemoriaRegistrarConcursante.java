package ar.unrn.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ar.unrn.modelo.Concursante;
import ar.unrn.modelo.RegistroConcursante;

public class EnMemoriaRegistrarConcursante implements RegistroConcursante {

	@Override
	public void saveInscription(Concursante concursante) {
		String informacionEmpleado = "Nombre: " + concursante.nombre() + " || Apellido: " + concursante.apellido()
				+ " || telefono: " + concursante.telefono() + " || Correo Electronico: " + concursante.email()
				+ " || Id de concurso: " + concursante.idConcurso() + "\n";
		try {

			Files.write(Paths.get("C:\\Users\\usuario\\Desktop\\concursantes.txt"), informacionEmpleado.getBytes(),
					StandardOpenOption.APPEND);

		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir", e);
		}

	}

}
