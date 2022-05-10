package ar.unrn.menu;

import java.io.IOException;
import java.util.List;

import ar.unrn.excepciones.ExcepcionPorStringNulo;
import ar.unrn.memoria.EnDiscoEmpleado;
import ar.unrn.modelo.Empleado;

public class Menu {

	public static void main(String[] args) {
		EnDiscoEmpleado empleadosCargar = new EnDiscoEmpleado();
		try {
			List<Empleado> empleados = empleadosCargar.obtenerEmpleados();
			for (Empleado e : empleados) {
				System.out.println(e.toString());
			}

		} catch (ExcepcionPorStringNulo | IOException e) {

			e.printStackTrace();
		}
	}

}
