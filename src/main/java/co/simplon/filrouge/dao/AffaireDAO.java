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

@Repository
public class AffaireDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment env;
	
	@Bean 
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;
	}
	

//	@Autowired
//	public AffaireDAO(JdbcTemplate jdbcTemplate) {
//		this.dataSource = jdbcTemplate.getDataSource();
//	}

	public List<Arme> recupererArmesDeAffaire(Long id) throws Exception {

		Arme arme;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Arme> listeArme = new ArrayList<Arme>();

		try {
			// Requete SQL
			sql = " SELECT *\r\n" + 
					"  FROM arme\r\n" + 
					"LEFT JOIN affaire_arme\r\n" + 
					"  ON arme.id = affaire_arme.id_arme\r\n" + 
					"RIGHT JOIN affaire\r\n" + 
					"  ON affaire_arme.id_affaire = affaire.id_affaire\r\n" + 
					"  WHERE affaire.id_affaire !affaire_arme= ?;";
			pstmt = dataSource().getConnection().prepareStatement(sql);
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

}
