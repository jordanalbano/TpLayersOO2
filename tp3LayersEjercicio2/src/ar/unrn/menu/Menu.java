package ar.unrn.menu;

import java.time.LocalDate;

import ar.unrn.excepciones.ExcepcionPorStringNulo;
import ar.unrn.memoria.EnMemoriaEmpleado;
import ar.unrn.modelo.Empleado;

public class Menu {

	public static void main(String[] args) {
		EnMemoriaEmpleado empleadosCargar = new EnMemoriaEmpleado();
		try {

			empleadosCargar.agregarEmpleado(
					new Empleado("jordan", "albano", LocalDate.of(1999, 2, 23), "jordanalbano86@gmail.com"));
			empleadosCargar.agregarEmpleado(
					new Empleado("ezequiel", "requete", LocalDate.of(2022, 4, 15), "ezequielrequete@gmail.com"));
			empleadosCargar
					.agregarEmpleado(new Empleado("manco", "dif", LocalDate.of(1993, 5, 12), "requena@gmail.com"));

		} catch (ExcepcionPorStringNulo e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		/*
		 * // AgregarEmpleado empleado = new AgregarEmpleado(new EnMemoriaEmpleado());
		 * EnvioCorreos envio = new EnvioCorreos("jordanalbano86@gmail.com",
		 * "jordanalbano86@gmail.com", "jordan"); envio.enviarCorreo();
		 */
	}

}
