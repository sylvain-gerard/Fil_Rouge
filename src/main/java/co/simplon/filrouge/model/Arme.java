package co.simplon.filrouge.model;

public class Arme extends Objet{
	
	private String calibre;
	private String numero_serie;
	
	public Arme() {
		super();
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
