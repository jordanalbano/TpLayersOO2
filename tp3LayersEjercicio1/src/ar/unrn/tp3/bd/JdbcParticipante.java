package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.excepciones.AppException;
import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class JdbcParticipante implements RepositorioDeParticipantes {
	private Connection dbConn;

	@Override
	public void nuevoParticipante(Participante participante) throws AppException {
		dbConn = ConnectionManager.getConnection();
		PreparedStatement st = null;
		try {
			st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
			st.setString(1, participante.nombre());
			st.setString(2, participante.telefono());
			st.setString(3, participante.region());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("Error de aplicacion");
		} finally {
			ConnectionManager.disconnect();
		}

	}

}
