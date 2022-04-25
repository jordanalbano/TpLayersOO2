package ar.unrn.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.excepciones.AppException;
import ar.unrn.modelo.Concursante;
import ar.unrn.modelo.RegistroConcursante;

public class EnBaseDeDatosRegistrarConcursante implements RegistroConcursante {
	private Connection dbConn;

	@Override
	public void saveInscription(Concursante concursante) throws AppException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO concursante"
					+ "(nombre, apellido, dni, email, telefono, id_concurso)" + "VALUES (?,?,?,?,?,?)");
			statement.setString(1, concursante.nombre());
			statement.setString(2, concursante.apellido());
			statement.setString(3, concursante.dni());
			statement.setString(4, concursante.email());
			statement.setString(5, concursante.telefono());
			statement.setInt(6, concursante.idConcurso());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("error al procesar la consulta" + e.getMessage());

		} finally {
			ConnectionManager.disconnect();
		}

	}

}
