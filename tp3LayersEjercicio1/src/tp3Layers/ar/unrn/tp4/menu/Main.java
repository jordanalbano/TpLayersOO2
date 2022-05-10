package tp3Layers.ar.unrn.tp4.menu;

import java.sql.SQLException;

import ar.unrn.tp3.bd.JdbcParticipante;
import ar.unrn.tp3.modelo.Participantes;
import ar.unrn.tp3.ui.AgregarParticipante;

public class Main {

	public static void main(String[] args) throws SQLException {
		AgregarParticipante participante = new AgregarParticipante(new Participantes(new JdbcParticipante()));

	}
}
