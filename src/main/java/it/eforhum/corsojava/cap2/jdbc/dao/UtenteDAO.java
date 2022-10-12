package it.eforhum.corsojava.cap2.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.eforhum.corsojava.cap2.jdbc.entity.Utente;

public class UtenteDAO {
	private static final Logger LOG = LogManager.getLogger(UtenteDAO.class);
	private static UtenteDAO instance = new UtenteDAO();

	private UtenteDAO() {

	}

	public static UtenteDAO getInstance() {
		return instance;
	}

	public Utente findById(long id) {
		Utente result = null;

		try {
			// ottenere connessione alla base dati
			Connection conn = openConnection();

			// preparare SQL di interrogazione
			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT id_utente, nome, cognome, username, password, utente_ins, data_ins, utente_mod, data_mod");
			sql.append(" FROM jdbcdemo.utenti");
			sql.append(" WHERE id_utente = ?");

			// ottenere Statement per invio comando
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			pstm.setLong(1, id);

			// invio comandi di selezione
			ResultSet rs = pstm.executeQuery();

			// leggere le informazioni incluse nel ResultSet
			if (rs.next()) {
				result = new Utente();

				result.setIdUtente(id);
				result.setNome(rs.getString("nome"));
				result.setCognome(rs.getString("cognome"));
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				result.setUtenteIns(rs.getString("utente_ins"));
				result.setDataIns(rs.getTimestamp("data_ins").toLocalDateTime());
				result.setUtenteMod(rs.getString("utente_mod"));

				if (rs.getTimestamp("data_mod") != null)
					result.setDataMod(rs.getTimestamp("data_mod").toLocalDateTime());
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("errore nella lettura del database", e);
		}

		return result;
	}

	public boolean insertUtente(Utente user) {
		try {
			// ottenere connessione alla base dati
			Connection conn = openConnection();

			// preparare SQL di interrogazione
			StringBuilder sql = new StringBuilder();
			sql.append("insert into utenti (nome, cognome, username, password, utente_ins, data_ins)");
			sql.append(" values (?, ?, ?, ?, ?, ?)");

			PreparedStatement pstm = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getCognome());
			pstm.setString(3, user.getUsername());
			pstm.setString(4, user.getPassword());
			pstm.setString(5, user.getUtenteIns());
			pstm.setTimestamp(6, Timestamp.valueOf(user.getDataIns()));

			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();

			if (rs.next())
				user.setIdUtente(rs.getLong(1));
			else
				user.setIdUtente(-1);

		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}

		catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("errore nella lettura del database", e);
		}

		return true;
	}

	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// CentOS VM Docker
//		return DriverManager.getConnection("jdbc:mysql://192.168.64.16:3306/jdbcdemo", "root", "root");

		// Localhost Docker
		return DriverManager.getConnection("jdbc:mysql://localhost:5000/jdbcdemo", "root", "root");

		// Localhost
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
	}

}
