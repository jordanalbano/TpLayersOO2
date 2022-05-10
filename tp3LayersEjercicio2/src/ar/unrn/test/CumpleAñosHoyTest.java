package ar.unrn.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.unrn.modelo.Empleado;

class CumpleAñosHoyTest {

	@Test
	void test() throws RuntimeException {

		Empleado juanBola;
		boolean seEnvio = false;

		juanBola = new Empleado("juan", "bola", LocalDate.of(1980, 05, 7), "juanBola2@gmail.com");

		assertEquals(seEnvio, true);
	}

}
