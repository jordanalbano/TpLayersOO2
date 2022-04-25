package ar.unrn.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.unrn.excepciones.ExcepcionPorStringNulo;
import ar.unrn.modelo.Empleado;

class EnMemoriaEmpleadoTest {

	@Test
	void testAgregarEmpleado() {

		try {
			// inicializacion/setup
			Empleado juanBola = new Empleado("juan", "bola", LocalDate.of(1980, 3, 12), "juanBola2@gmail.com");

			String informacionEmpleado = "Nombre: " + juanBola.nombre() + " || Apellido: " + juanBola.apellido()
					+ " || Fecha De Nacimiento: " + juanBola.fechaNacimiento() + " || Correo Electronico: "
					+ juanBola.email();
			Files.write(Paths.get("C:\\Users\\usuario\\Desktop\\ejercicio2tp3.txt"), informacionEmpleado.getBytes(),
					StandardOpenOption.APPEND);
			// verificacion
			assertEquals(
					"Nombre: juan || Apellido: bola || Fecha De Nacimiento: 1980-03-12 || Correo Electronico: juanBola2@gmail.com",
					Files.readString(Paths.get("C:\\Users\\usuario\\Desktop\\ejercicio2tp3.txt")));
			// Files.(Paths.get("C:\\Users\\usuario\\Desktop\\ejercicio2tp3.txt"),
			// "".getBytes(),
			// StandardOpenOption.APPEND);
		} catch (IOException | ExcepcionPorStringNulo e) {
			throw new RuntimeException("No se pudo persistir", e);
		}
	}

}
