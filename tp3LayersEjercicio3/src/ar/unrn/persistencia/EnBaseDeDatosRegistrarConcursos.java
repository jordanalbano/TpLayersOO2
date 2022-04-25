package ar.unrn.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import ar.unrn.excepciones.AppException;
import ar.unrn.modelo.Concurso;
import ar.unrn.modelo.RegistroConcursos;

public class EnBaseDeDatosRegistrarConcursos implements RegistroConcursos {
	private Connection dbConn;

	@Override
	public ArrayList<Concurso> todosLosConcursos() throws AppException {
		dbConn = ConnectionManager.getConnection();
		PreparedStatement st = null;
		ArrayList<Concurso> concursos = new ArrayList<Concurso>();
		try {
			st = dbConn.prepareStatement("SELECT * FROM concurso ");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				LocalDate fechaFin = LocalDate.parse(rs.getDate(4).toString());
				if (fechaFin.isAfter(LocalDate.now())) {
					LocalDate fechaInicio = LocalDate.parse(rs.getDate(3).toString());
					concursos.add(new Concurso(rs.getString(2), rs.getString(1), fechaInicio, fechaFin));
				}

			}
		} catch (SQLException e) {
			throw new AppException("Error de aplicacion");
		} finally {
			ConnectionManager.disconnect();
		}
		return concursos;

	}

}
