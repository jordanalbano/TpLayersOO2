package ar.unrn.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.unrn.excepciones.ExcepcionPorStringNulo;
import ar.unrn.memoria.EnvioCorreos;
import ar.unrn.modelo.Empleado;

class CumpleA�osHoyTest {

	@Test
	void test() {

		Empleado juanBola;
		boolean seEnvio = false;
		try {
			juanBola = new Empleado("juan", "bola", LocalDate.of(1980, 04, 25), "juanBola2@gmail.com");
			if (juanBola.cumpleA�osHoy()) {
				seEnvio = EnvioCorreos.enviarCorreo(juanBola.email(), "jordanalbano86@gmail.com", juanBola.nombre());
			}
		} catch (ExcepcionPorStringNulo e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		assertEquals(seEnvio, true);
	}

}
