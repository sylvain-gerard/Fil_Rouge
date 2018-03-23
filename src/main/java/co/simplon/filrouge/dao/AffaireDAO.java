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
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.model.Suspect;
import co.simplon.filrouge.model.Vehicule;

@Repository
public class AffaireDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment env;
	private DataSource dataSource;
	
//	@Bean 
//	public DataSource dataSource() {
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		dataSource.setUsername("admin");
//		dataSource.setPassword("admin");
//		return dataSource;
//	}
	

	@Autowired
	public AffaireDAO(JdbcTemplate jdbcTemplate) {
		this.dataSource = jdbcTemplate.getDataSource();
	}

	public List<Arme> recupererArmesDeAffaire(Long id) throws Exception {
		Arme arme;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Arme> listeArme = new ArrayList<Arme>();

		try {
			// Requete SQL
			sql = " SELECT arme.*\r\n" + 
			"  FROM arme\r\n" + 
			"INNER JOIN affaire_arme\r\n" + 
			"  ON arme.id = affaire_arme.id_arme\r\n" + 
			"INNER JOIN affaire\r\n" + 
			"  ON affaire_arme.id_affaire = affaire.id_affaire\r\n" + 
			"  WHERE affaire.id_affaire = ?;";
		
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				arme = recupererArmeRS(rs);
				listeArme.add(arme);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return listeArme;
	}

	private Arme recupererArmeRS(ResultSet rs) throws SQLException {
		Arme arme = new Arme();
		arme.setId(rs.getLong("id"));
		arme.setType(rs.getString("type"));
		arme.setMarque(rs.getString("marque"));
		arme.setModele(rs.getString("modele"));
		arme.setCalibre(rs.getString("calibre"));
		arme.setNumero_serie(rs.getString("numero_serie"));
		arme.setInfos_complementaire(rs.getString("infos_complementaire"));

		return arme;
	}

	private void logSQL(PreparedStatement pstmt) {
		String sql;

		if (pstmt == null)
			return;

		sql = pstmt.toString().substring(pstmt.toString().indexOf(":") + 2);
		log.debug(sql);
	}

	public List<Suspect> recupererSuspectsDeAffaire(long id) throws SQLException {
		Suspect suspect;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Suspect> listeSuspect = new ArrayList<Suspect>();
		
		try {
			// Requete SQL
			sql = " SELECT suspect.*\r\n" + 
			"  FROM suspect\r\n" + 
			"INNER JOIN affaire_suspect\r\n" + 
			"  ON suspect.id = affaire_suspect.id_suspect\r\n" + 
			"INNER JOIN affaire\r\n" + 
			"  ON affaire_suspect.id_affaire = affaire.id_affaire\r\n" + 
			"  WHERE affaire.id_affaire = ?;";
		
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				suspect = recupererSuspectRS(rs);
				listeSuspect.add(suspect);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return listeSuspect;
	}
	
	private Suspect recupererSuspectRS(ResultSet rs) throws SQLException {
		Suspect suspect = new Suspect();
		suspect.setId(rs.getLong("id"));
		suspect.setNom(rs.getString("nom"));
		suspect.setPrenom(rs.getString("prenom"));
		//suspect.setMatricule(rs.getString("matricule"));
		suspect.setAdresse(rs.getString("adresse"));
		suspect.setDate_naissance(rs.getDate("date_naissance"));
		suspect.setTaille(rs.getDouble("taille"));
		suspect.setAdn(rs.getString("adn"));
		suspect.setPoids(rs.getDouble("poids"));
		suspect.setSexe(rs.getString("sexe"));
		suspect.setSignes_particuliers(rs.getString("signes_particuliers"));

		return suspect;
	}

	public List<Vehicule> recupererVehiculesDeAffaire(Long id) throws Exception {
		Vehicule vehicule;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Vehicule> listeVehicule = new ArrayList<Vehicule>();

		try {
			// Requete SQL
			sql = " SELECT vehicule.*\r\n" + 
			"  FROM vehicule\r\n" + 
			"INNER JOIN affaire_vehicule\r\n" + 
			"  ON vehicule.id = affaire_vehicule.id_vehicule\r\n" + 
			"INNER JOIN affaire\r\n" + 
			"  ON affaire_vehicule.id_affaire = affaire.id_affaire\r\n" + 
			"  WHERE affaire.id_affaire = ?;";
		
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				vehicule = recupererVehiculeRS(rs);
				listeVehicule.add(vehicule);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return listeVehicule;
	}

	private Vehicule recupererVehiculeRS(ResultSet rs) throws SQLException {
		Vehicule vehicule = new Vehicule();
		vehicule.setId(rs.getLong("id"));
		vehicule.setType(rs.getString("type"));
		vehicule.setMarque(rs.getString("marque"));
		vehicule.setModele(rs.getString("modele"));
		vehicule.setImmatriculation(rs.getString("immatriculation"));
		vehicule.setCouleur_vehicule(rs.getString("couleur_vehicule"));
		vehicule.setInfos_complementaire(rs.getString("infos_complementaire"));

		return vehicule;
		}
}
