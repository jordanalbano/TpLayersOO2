package ar.unrn.memoria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.modelo.Empleado;
import ar.unrn.modelo.RepositorioDeEmpleado;

public class EnDiscoEmpleado implements RepositorioDeEmpleado {
	// asumir que lo tengo creado y leerlo
	// poner una clase donde pongo for(empleado)
	// preguntando si es cumpleaños
	// enviarMail se envia desde el objeto de negocio
	// al crear empleado pregunto si cumple anios, si es asi se envia.
	@Override
	public void agregarEmpleado(Empleado empleado) {
		String informacionEmpleado = "Nombre: " + empleado.nombre() + " || Apellido: " + empleado.apellido()
				+ " || Fecha De Nacimiento: " + empleado.fechaNacimiento() + " || Correo Electronico: "
				+ empleado.email() + "\n";
		try {
			//
			Files.write(Paths.get("C:\\Users\\usuario\\Desktop\\ejercicio2tp3.txt"), informacionEmpleado.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir", e);
		}

	}

	@Override
	public List<Empleado> obtenerEmpleados() throws IOException {
		List<String> fileData = Files.readAllLines(Paths.get("C:\\Users\\usuario\\Desktop\\empleados.txt"));
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			String[] camposFechaIni = camposFila[2].split("/");

			LocalDate fechaCumple = LocalDate.of(Integer.parseInt(camposFechaIni[0]),
					Integer.parseInt(camposFechaIni[1]), Integer.parseInt(camposFechaIni[2]));

			listaEmpleados.add(new Empleado(camposFila[1], camposFila[2], fechaCumple, camposFila[2]));
		}
		return listaEmpleados;
	}
}
