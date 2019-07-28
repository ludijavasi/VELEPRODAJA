package model;

public class GlavnaGrupa {
	
	private int idGlavneGrupe;
	private String naziv_glavne_grupe;
	
	
	public int getIdGlavneGrupe() {
		return idGlavneGrupe;
	}
	public void setIdGlavneGrupe(int idGlavneGrupe) {
		this.idGlavneGrupe = idGlavneGrupe;
	}
	public String getNaziv_glavne_grupe() {
		return naziv_glavne_grupe;
	}
	public void setNaziv_glavne_grupe(String naziv_glavne_grupe) {
		this.naziv_glavne_grupe = naziv_glavne_grupe;
	}
	public GlavnaGrupa() {
		super();

	}
	public GlavnaGrupa(int idGlavneGrupe, String naziv_glavne_grupe) {
		super();
		this.idGlavneGrupe = idGlavneGrupe;
		this.naziv_glavne_grupe = naziv_glavne_grupe;
	}	
	
	public GlavnaGrupa(String naziv_glavne_grupe) {
		super();
		this.naziv_glavne_grupe = naziv_glavne_grupe;
	}
	
	@Override
	public String toString() {
		return  naziv_glavne_grupe + ",  " + "ID: " + idGlavneGrupe;
	}	

}
