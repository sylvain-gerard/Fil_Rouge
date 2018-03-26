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

@Repository
public class ArmeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataSource dataSource;

	@Autowired
	public ArmeDAO(JdbcTemplate jdbcTemplate) {
		this.dataSource = jdbcTemplate.getDataSource();
	}

	public List<Arme> recupererArmesTriees(String rechercheArme) throws Exception {
		List<Arme> armesTriees = new ArrayList<Arme>();

		Arme arme;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;

		try {
			// Requete SQL
			sql = "SELECT * FROM arme WHERE marque LIKE ? OR modele LIKE ? or type LIKE ? OR calibre LIKE ? OR numero_serie LIKE ? OR infos_complementaire LIKE ?;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%" + rechercheArme + "%");
			pstmt.setString(2, "%" + rechercheArme + "%");
			pstmt.setString(3, "%" + rechercheArme + "%");
			pstmt.setString(4, "%" + rechercheArme + "%");
			pstmt.setString(5, "%" + rechercheArme + "%");
			pstmt.setString(6, "%" + rechercheArme + "%");

			// Log info
			logSQL(pstmt);
			// Lancement requete
			rs = pstmt.executeQuery();
			// resultat requete
			while (rs.next()) {
				arme = recupererArmeRS(rs);
				armesTriees.add(arme);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return armesTriees;
	}

	public void lierArmeAffaire(long id_affaire, long id_arme) throws Exception {
		PreparedStatement pstmt = null;
		String sql;
		try {
			// Requete SQL
			sql = "INSERT INTO affaire_arme (id_affaire, id_arme) VALUES (?, ?) ;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_arme);
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
	
	public void supprimerArmeAffaire(long id_affaire, long id_arme) throws Exception {
		PreparedStatement pstmt = null;
		String sql;
		try {
			// Requete SQL
			sql = "DELETE FROM affaire_arme WHERE `id_affaire` = ? AND `id_arme` = ? ;";
			pstmt = dataSource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id_affaire);
			pstmt.setLong(2, id_arme);
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
}
