package co.simplon.filrouge.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.model.Suspect;

@Repository
public class SuspectDAO {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public SuspectDAO(JdbcTemplate jdbcTemplate) {
		this.dataSource = jdbcTemplate.getDataSource();
	}
	
	/**
	 * Rechercher les suspects avec un critère de recherche sur tous les champs
	 * 
	 * @param filtreSuspect
	 * @return
	 * @throws Exception
	 */
	public List <Suspect> filtreSuspect(String filtreSuspect) throws Exception{
		List <Suspect> supectTries = new ArrayList<Suspect>();
		Suspect suspect;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		
		try {
			// Requete SQL
			sql = "SELECT * FROM suspect WHERE nom LIKE ? "
					+ "OR prenom LIKE ? "
					+ "OR adn LIKE ? "
					+ "OR adresse LIKE ? "
					+ "OR date_naissance LIKE ? "
					+ "OR infos_suspect LIKE ? "
					+ "OR poids LIKE ? "
					+ "OR sexe LIKE ? "
					+ "OR signes_particuliers LIKE ? "
					+ "OR taille LIKE ? "
					+ "OR matricule LIKE ?;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%" + filtreSuspect + "%");
			pstmt.setString(2, "%" + filtreSuspect + "%");
			pstmt.setString(3, "%" + filtreSuspect + "%");
			pstmt.setString(4, "%" + filtreSuspect + "%");
			pstmt.setString(5, "%" + filtreSuspect + "%");
			pstmt.setString(6, "%" + filtreSuspect + "%");
			pstmt.setString(7, "%" + filtreSuspect + "%");
			pstmt.setString(8, "%" + filtreSuspect + "%");
			pstmt.setString(9, "%" + filtreSuspect + "%");
			pstmt.setString(10, "%" + filtreSuspect + "%");
			pstmt.setString(11, "%" + filtreSuspect + "%");
			
			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				suspect = recupererSuspectRS(rs);
				supectTries.add(suspect);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return supectTries;
		
	}
	
	private Suspect recupererSuspectRS(ResultSet rs) throws SQLException {
		Suspect suspect = new Suspect();
		suspect.setId(rs.getLong("id"));
		suspect.setNom(rs.getString("nom"));
		suspect.setPrenom(rs.getString("prenom"));
		suspect.setMatricule(rs.getString("matricule"));
		suspect.setAdresse(rs.getString("adresse"));
		suspect.setDate_naissance(rs.getDate("date_naissance"));
		suspect.setTaille(rs.getDouble("taille"));
		suspect.setAdn(rs.getString("adn"));
		suspect.setPoids(rs.getDouble("poids"));
		suspect.setSexe(rs.getString("sexe"));
		suspect.setSignes_particuliers(rs.getString("signes_particuliers"));

		return suspect;
	}
	
	private void logSQL(PreparedStatement pstmt) {
		String sql;

		if (pstmt == null)
			return;

		sql = pstmt.toString().substring(pstmt.toString().indexOf(":") + 2);
		log.debug(sql);
	}
	
	/**
	 * Casser le lien d'une affaire et d'un suspect
	 * 
	 * @param id_affaire
	 * @param id_suspect
	 * @throws Exception
	 */
	public void deleteFromAffaire(Long id_affaire, Long id_suspect) throws Exception {

		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = " DELETE FROM affaire_suspect WHERE `id_affaire`=? AND `id_suspect`=? ";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_suspect);
			int result = pstmt.executeUpdate();
			if(result != 1) {
				throw new Exception("No entry found in database !");
			} else {
				System.out.println("Record is deleted!");
			}
			System.out.println("Result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		
	}
	
	/**
	 * Ajouter un suspect à une affaire
	 * 
	 * @param id_affaire
	 * @param id_suspect
	 * @throws Exception
	 */
	public void lierSuspectAffaire(long id_affaire, long id_suspect) throws Exception {
		PreparedStatement pstmt = null;
		String sql;
		try {
			// Requete SQL
			sql = "INSERT INTO affaire_suspect (id_affaire, id_suspect) VALUES (?, ?) ;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_suspect);
			// Log info
			logSQL(pstmt);
			// Lancement requete
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
	}
}
