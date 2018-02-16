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

import co.simplon.filrouge.model.Utilisateur;


@Repository
public class JdbcUtilisateurDAO implements UtilisateurDAO{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource datasource;

	/**
	 * Constructor
	 * @param jdbcTemplate : the JDBCTemplace connected to the Database (thanks to Spring)
	 */
	@Autowired
	public JdbcUtilisateurDAO(JdbcTemplate jdbcTemplate) {
		this.datasource = jdbcTemplate.getDataSource();
	}

	@Override
	public List<Utilisateur> listUtilisateurs() throws Exception {
		Utilisateur utilisateur;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Utilisateur> arrayListOfUtilisateur = new ArrayList<Utilisateur>();
		
		try {
			// Prepare the SQL query
			sql = "SELECT * FROM utilisateur ";
			pstmt = datasource.getConnection().prepareStatement(sql);
			
			// Log info
			logSQL(pstmt);

			// Run the query
			rs = pstmt.executeQuery();

			// Handle the query results
			while (rs.next()) {
				utilisateur = getUtilisateurFromResultSet(rs);
				arrayListOfUtilisateur.add(utilisateur);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		
		return arrayListOfUtilisateur;
		
	}
	
	/**
	 * Build an actor object with data from the ResultSet
	 * @param rs : the ResultSet to process.
	 * @return Actor : The new Actor object
	 */
	private Utilisateur getUtilisateurFromResultSet(ResultSet rs) throws SQLException {
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setId_utilisateur(rs.getLong("id_utilisateur"));
		utilisateur.setNom_utilisateur(rs.getString("nom_utilisateur"));
		utilisateur.setPrenom_utilisateur(rs.getString("prenom_utilisateur"));
		utilisateur.setPassword(rs.getString("password"));
		utilisateur.setHabilitation(rs.getString("habilitation"));
		utilisateur.setMatricule(rs.getString("matricule"));
		
		
		return utilisateur;
	}

	/**
	 * Debug function used to log information on the database requests
	 * @param pstmt : The PreparedStatement.
	 */
	private void logSQL(PreparedStatement pstmt) {
		String sql;
		
		if (pstmt == null)
			return;
		
		sql = pstmt.toString().substring(pstmt.toString().indexOf(":") + 2);
		log.debug(sql);
	}

}
