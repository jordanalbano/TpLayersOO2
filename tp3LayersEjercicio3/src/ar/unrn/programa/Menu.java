package ar.unrn.programa;

import ar.unrn.persistencia.EnBaseDeDatosRegistrarConcursante;
import ar.unrn.persistencia.EnBaseDeDatosRegistrarConcursos;
import ar.unrn.ui.RadioCompetition;

public class Menu {
	public static void main(String[] args) {
		// para probar en base de datos
		new RadioCompetition(new EnBaseDeDatosRegistrarConcursante(), new EnBaseDeDatosRegistrarConcursos());

		// para probar en memoria
		// new RadioCompetition(new EnMemoriaRegistrarConcursante(), new
		// EnMemoriaRegistrarConcursos());

	}

}
