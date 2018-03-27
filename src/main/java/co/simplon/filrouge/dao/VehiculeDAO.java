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

import co.simplon.filrouge.model.Vehicule;

@Repository
public class VehiculeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataSource dataSource;

	@Autowired
	public VehiculeDAO(JdbcTemplate jdbcTemplate) {
		this.dataSource = jdbcTemplate.getDataSource();
	}

	/**
	 * Rechercher les véhicules avec un critère de recherche sur tous les champs
	 * 
	 * @param filtreVehicule
	 * @return
	 * @throws Exception
	 */
	public List<Vehicule> recupererVehiculesTriees(String rechercheVehicule) throws Exception {
		List<Vehicule> vehiculesTriees = new ArrayList<Vehicule>();

		Vehicule vehicule;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;

		try {
			// Requete SQL
			sql = "SELECT * FROM vehicule WHERE type LIKE ? OR marque LIKE ? or modele LIKE ? OR immatriculation LIKE ? OR couleur_vehicule LIKE ? OR infos_complementaire LIKE ?;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%" + rechercheVehicule + "%");
			pstmt.setString(2, "%" + rechercheVehicule + "%");
			pstmt.setString(3, "%" + rechercheVehicule + "%");
			pstmt.setString(4, "%" + rechercheVehicule + "%");
			pstmt.setString(5, "%" + rechercheVehicule + "%");
			pstmt.setString(6, "%" + rechercheVehicule + "%");

			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				vehicule = recupererVehiculeRS(rs);
				vehiculesTriees.add(vehicule);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return vehiculesTriees;
	}

	/**
	 * Ajouter un véhicule à une affaire
	 * 
	 * @param id_affaire
	 * @param id_vehicule
	 * @throws Exception
	 */
	public void lierVehiculeAffaire(long id_affaire, long id_vehicule) throws Exception {
		PreparedStatement pstmt = null;
		String sql;
		try {
			// Requete SQL
			sql = "INSERT INTO affaire_vehicule (id_affaire, id_vehicule) VALUES (?, ?) ;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_vehicule);
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
	
	/**
	 * Casser le lien d'une affaire et d'un véhicule
	 * 
	 * @param id_affaire
	 * @param id_vehicule
	 * @throws Exception
	 */
	public void deleteFromAffaire(Long id_affaire, Long id_vehicule) throws Exception {

		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = " DELETE FROM affaire_vehicule WHERE `id_affaire`=? AND `id_vehicule`=? ";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_vehicule);
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
	
	public void supprimerVehiculeAffaire(long id_affaire, long id_vehicule) throws Exception {
		PreparedStatement pstmt = null;
		String sql;
		try {
			// Requete SQL
			sql = "DELETE FROM affaire_vehicule WHERE `id_affaire` = ? AND `id_vehicule` = ? ;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_vehicule);
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

	private void logSQL(PreparedStatement pstmt) {
		String sql;

		if (pstmt == null)
			return;

		sql = pstmt.toString().substring(pstmt.toString().indexOf(":") + 2);
		log.debug(sql);
	}
}