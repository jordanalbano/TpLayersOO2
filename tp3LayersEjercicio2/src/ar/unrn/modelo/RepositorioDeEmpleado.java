package ar.unrn.modelo;

import java.io.IOException;
import java.util.List;

public interface RepositorioDeEmpleado {
	void agregarEmpleado(Empleado empleado);

	List<Empleado> obtenerEmpleados() throws IOException;
}
