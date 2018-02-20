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
	 * @return Utilisateur : The new Utilisateur object
	 */
	private Utilisateur getUtilisateurFromResultSet(ResultSet rs) throws SQLException {
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setId(rs.getLong("id_utilisateur"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
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

	@Override
	public Utilisateur affichertUtilisateur(Long id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs;
		Utilisateur utilisateur = null;
		
		try {
			// Prepare the SQL query
			String sql = "SELECT * FROM utilisateur WHERE id_utilisateur = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);

			// Log info
			logSQL(pstmt);

			// Run the query
			rs = pstmt.executeQuery();
			
			// Handle the query results
			if (rs.next())
				utilisateur = getUtilisateurFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		return utilisateur;
	}

}
