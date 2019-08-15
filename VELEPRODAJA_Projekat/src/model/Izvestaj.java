package model;

public class Izvestaj {
	//ARTIKAL
	private int idArtikla;
	private int IdgrupaArtikla;
	private String naziv_grupe_artikala;
	private String naziv_artikla;
	private String jedinica_mere;
	private double neto_cena_artikla;
	private int stopa_PDV;
	private double marza_artikla;
	public int getIdArtikla() {
		return idArtikla;
	}
	public void setIdArtikla(int idArtikla) {
		this.idArtikla = idArtikla;
	}
	public int getIdgrupaArtikla() {
		return IdgrupaArtikla;
	}
	public void setIdgrupaArtikla(int idgrupaArtikla) {
		IdgrupaArtikla = idgrupaArtikla;
	}
	public String getNaziv_grupe_artikala() {
		return naziv_grupe_artikala;
	}
	public void setNaziv_grupe_artikala(String naziv_grupe_artikala) {
		this.naziv_grupe_artikala = naziv_grupe_artikala;
	}
	public String getNaziv_artikla() {
		return naziv_artikla;
	}
	public void setNaziv_artikla(String naziv_artikla) {
		this.naziv_artikla = naziv_artikla;
	}
	public String getJedinica_mere() {
		return jedinica_mere;
	}
	public void setJedinica_mere(String jedinica_mere) {
		this.jedinica_mere = jedinica_mere;
	}
	public double getNeto_cena_artikla() {
		return neto_cena_artikla;
	}
	public void setNeto_cena_artikla(double neto_cena_artikla) {
		this.neto_cena_artikla = neto_cena_artikla;
	}
	public int getStopa_PDV() {
		return stopa_PDV;
	}
	public void setStopa_PDV(int stopa_PDV) {
		this.stopa_PDV = stopa_PDV;
	}
	public double getMarza_artikla() {
		return marza_artikla;
	}
	public void setMarza_artikla(double marza_artikla) {
		this.marza_artikla = marza_artikla;
	}
	//STAVKE RACUNA OTPREMNICE
	private int idracunOtpremnica;
	private Artikli artikal;
	private double kolicinaProdaje;
	private double rabatProdaje;
	
	
	public int getIdracunOtpremnica() {
		return idracunOtpremnica;
	}
	public void setIdracunOtpremnica(int idracunOtpremnica) {
		this.idracunOtpremnica = idracunOtpremnica;
	}
	public Artikli getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikli artikal) {
		this.artikal = artikal;
	}
	public double getKolicinaProdaje() {
		return kolicinaProdaje;
	}
	public void setKolicinaProdaje(double kolicinaProdaje) {
		this.kolicinaProdaje = kolicinaProdaje;
	}
	public double getRabatProdaje() {
		return rabatProdaje;
	}
	public void setRabatProdaje(double rabatProdaje) {
		this.rabatProdaje = rabatProdaje;
	}
	public Izvestaj(int idArtikla, int idgrupaArtikla, String naziv_grupe_artikala, String naziv_artikla,
			String jedinica_mere, double neto_cena_artikla, int stopa_PDV, double marza_artikla, int idracunOtpremnica,
			Artikli artikal, double kolicinaProdaje, double rabatProdaje) {
		super();
		this.idArtikla = idArtikla;
		IdgrupaArtikla = idgrupaArtikla;
		this.naziv_grupe_artikala = naziv_grupe_artikala;
		this.naziv_artikla = naziv_artikla;
		this.jedinica_mere = jedinica_mere;
		this.neto_cena_artikla = neto_cena_artikla;
		this.stopa_PDV = stopa_PDV;
		this.marza_artikla = marza_artikla;
		this.idracunOtpremnica = idracunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
	}

	public Izvestaj(String naziv, double kolicina_prodaje, String jedinica_mere2, double neto_cena_artikla2,
			int stopa_PDV2) {
		this.naziv_artikla = naziv;
		this.kolicinaProdaje = kolicina_prodaje;
		this.jedinica_mere = jedinica_mere2;
		this.neto_cena_artikla = neto_cena_artikla2;
		this.stopa_PDV = stopa_PDV2;
	}
	
	
}
