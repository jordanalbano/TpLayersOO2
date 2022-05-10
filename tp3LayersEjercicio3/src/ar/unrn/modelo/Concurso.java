package ar.unrn.modelo;

import java.time.LocalDate;

public class Concurso {
	private int idConcurso;
	private String nombre;
	private LocalDate fechaInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(String idConcurso, String nombre, LocalDate fechaIni, LocalDate fechaFin) {

		this.idConcurso = Integer.parseInt(idConcurso);
		this.nombre = nombre;
		this.fechaInscripcion = fechaIni;
		this.fechaFinInscripcion = fechaFin;
	}

	public int idConcurso() {
		return this.idConcurso;
	}

	public String nombre() {
		return this.nombre;
	}

	public String fechaFin() {
		return this.fechaFinInscripcion.toString();
	}

	public String fechaIni() {
		return this.fechaInscripcion.toString();
	}
}
