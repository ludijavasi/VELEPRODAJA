package model;

public class Grupa_Artikla {
	
	private GlavnaGrupa glavna_grupa;
	private int idGrupeArtikala;
	private String naziv_grupe_artikla;
	
	public GlavnaGrupa getGlavna_grupa() {
		return glavna_grupa;
	}
	public void setGlavna_grupa(GlavnaGrupa glavna_grupa) {
		this.glavna_grupa = glavna_grupa;
	}
	public int getIdGrupeArtikala() {
		return idGrupeArtikala;
	}
	public void setIdGrupeArtikala(int idGrupeArtikala) {
		this.idGrupeArtikala = idGrupeArtikala;
	}
	public String getNaziv_grupe_artikla() {
		return naziv_grupe_artikla;
	}
	public void setNaziv_grupe_artikla(String naziv_grupe_artikla) {
		this.naziv_grupe_artikla = naziv_grupe_artikla;
	}
	public Grupa_Artikla() {
		
	}
	public Grupa_Artikla(GlavnaGrupa glavna_grupa, int idGrupeArtikala, String naziv_grupe_artikla) {
		super();
		this.glavna_grupa = glavna_grupa;
		this.idGrupeArtikala = idGrupeArtikala;
		this.naziv_grupe_artikla = naziv_grupe_artikla;
	}
	@Override
	public String toString() {
		return "Grupa_Artikla [glavna_grupa=" + glavna_grupa + ", idGrupeArtikala=" + idGrupeArtikala
				+ ", naziv_grupe_artikla=" + naziv_grupe_artikla + "]";
	}

}
