package co.simplon.filrouge.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "arme")
public class Arme extends Objet {

	@Size(max = 100)
	private String calibre;
	@Size(max = 100)
	private String numero_serie;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "arme")
	private Set<Affaire> affaire = new HashSet<>();

	public Arme() {
		super();
	}

	public Arme(String calibre, String numero_serie) {
		super();
		this.calibre = calibre;
		this.numero_serie = numero_serie;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

}
