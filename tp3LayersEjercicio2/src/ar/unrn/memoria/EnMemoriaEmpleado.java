package ar.unrn.memoria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ar.unrn.modelo.Empleado;
import ar.unrn.modelo.RepositorioDeEmpleado;

public class EnMemoriaEmpleado implements RepositorioDeEmpleado {

	@Override
	public void agregarEmpleado(Empleado empleado) {
		String informacionEmpleado = "Nombre: " + empleado.nombre() + " || Apellido: " + empleado.apellido()
				+ " || Fecha De Nacimiento: " + empleado.fechaNacimiento() + " || Correo Electronico: "
				+ empleado.email() + "\n";
		if (empleado.cumpleAñosHoy()) {
			EnvioCorreos.enviarCorreo(empleado.email(), "jordanalbano86@gmail.com", empleado.nombre());
		}
		try {

			Files.write(Paths.get("C:\\Users\\usuario\\Desktop\\ejercicio2tp3.txt"), informacionEmpleado.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir", e);
		}

	}

}
