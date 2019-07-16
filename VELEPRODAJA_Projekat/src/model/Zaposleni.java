package model;

import java.util.Date;

public class Zaposleni {	
	

	private int idZaposlenog;
	private String imeZaposlenog;
	private String prezimeZaposlenog;
	private String adresaZaposlenog;
	private String opstinaZaposlenog;
	private String drzavljanstvoZaposlenog;
	private String polZaposlenog;
	private String emailZaposlenog;
	private String telefonZaposlenog;
	private Date datumZasnivanjaRadnogOdnosa;
	private String tipUgovoraZaposlenog;
	private Date datumPrestankaRadnogOdnosa;
	private String tipZaposlenja;
	private String stepenStrucneSpreme;
	//private String filijala nova klasa
	private double plataZaposlenog;
	private boolean status;
	private String usernameZaposlenog;
	private String passwordZaposlenog;
	
	
	
	public Zaposleni(int idZaposlenog, String imeZaposlenog, String prezimeZaposlenog, String adresaZaposlenog,
			String opstinaZaposlenog, String drzavljanstvoZaposlenog, String polZaposlenog, String emailZaposlenog,
			String telefonZaposlenog, Date datumZasnivanjaRadnogOdnosa, String tipUgovoraZaposlenog,
			Date datumPrestankaRadnogOdnosa, String tipZaposlenja, String stepenStrucneSpreme, double plataZaposlenog,
			boolean status, String usernameZaposlenog, String passwordZaposlenog) {
		super();
		this.idZaposlenog = idZaposlenog;
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.opstinaZaposlenog = opstinaZaposlenog;
		this.drzavljanstvoZaposlenog = drzavljanstvoZaposlenog;
		this.polZaposlenog = polZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.datumZasnivanjaRadnogOdnosa = datumZasnivanjaRadnogOdnosa;
		this.tipUgovoraZaposlenog = tipUgovoraZaposlenog;
		this.datumPrestankaRadnogOdnosa = datumPrestankaRadnogOdnosa;
		this.tipZaposlenja = tipZaposlenja;
		this.stepenStrucneSpreme = stepenStrucneSpreme;
		this.plataZaposlenog = plataZaposlenog;
		this.status = status;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}



	public Zaposleni() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdZaposlenog() {
		return idZaposlenog;
	}



	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}



	public String getImeZaposlenog() {
		return imeZaposlenog;
	}



	public void setImeZaposlenog(String imeZaposlenog) {
		this.imeZaposlenog = imeZaposlenog;
	}



	public String getPrezimeZaposlenog() {
		return prezimeZaposlenog;
	}



	public void setPrezimeZaposlenog(String prezimeZaposlenog) {
		this.prezimeZaposlenog = prezimeZaposlenog;
	}



	public String getAdresaZaposlenog() {
		return adresaZaposlenog;
	}



	public void setAdresaZaposlenog(String adresaZaposlenog) {
		this.adresaZaposlenog = adresaZaposlenog;
	}



	public String getOpstinaZaposlenog() {
		return opstinaZaposlenog;
	}



	public void setOpstinaZaposlenog(String opstinaZaposlenog) {
		this.opstinaZaposlenog = opstinaZaposlenog;
	}



	public String getDrzavljanstvoZaposlenog() {
		return drzavljanstvoZaposlenog;
	}



	public void setDrzavljanstvoZaposlenog(String drzavljanstvoZaposlenog) {
		this.drzavljanstvoZaposlenog = drzavljanstvoZaposlenog;
	}



	public String getPolZaposlenog() {
		return polZaposlenog;
	}



	public void setPolZaposlenog(String polZaposlenog) {
		this.polZaposlenog = polZaposlenog;
	}



	public String getEmailZaposlenog() {
		return emailZaposlenog;
	}



	public void setEmailZaposlenog(String emailZaposlenog) {
		this.emailZaposlenog = emailZaposlenog;
	}



	public String getTelefonZaposlenog() {
		return telefonZaposlenog;
	}



	public void setTelefonZaposlenog(String telefonZaposlenog) {
		this.telefonZaposlenog = telefonZaposlenog;
	}



	public Date getDatumZasnivanjaRadnogOdnosa() {
		return datumZasnivanjaRadnogOdnosa;
	}



	public void setDatumZasnivanjaRadnogOdnosa(Date datumZasnivanjaRadnogOdnosa) {
		this.datumZasnivanjaRadnogOdnosa = datumZasnivanjaRadnogOdnosa;
	}



	public String getTipUgovoraZaposlenog() {
		return tipUgovoraZaposlenog;
	}



	public void setTipUgovoraZaposlenog(String tipUgovoraZaposlenog) {
		this.tipUgovoraZaposlenog = tipUgovoraZaposlenog;
	}



	public Date getDatumPrestankaRadnogOdnosa() {
		return datumPrestankaRadnogOdnosa;
	}



	public void setDatumPrestankaRadnogOdnosa(Date datumPrestankaRadnogOdnosa) {
		this.datumPrestankaRadnogOdnosa = datumPrestankaRadnogOdnosa;
	}



	public String getTipZaposlenja() {
		return tipZaposlenja;
	}



	public void setTipZaposlenja(String tipZaposlenja) {
		this.tipZaposlenja = tipZaposlenja;
	}



	public String getStepenStrucneSpreme() {
		return stepenStrucneSpreme;
	}



	public void setStepenStrucneSpreme(String stepenStrucneSpreme) {
		this.stepenStrucneSpreme = stepenStrucneSpreme;
	}



	public double getPlataZaposlenog() {
		return plataZaposlenog;
	}



	public void setPlataZaposlenog(double plataZaposlenog) {
		this.plataZaposlenog = plataZaposlenog;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getUsernameZaposlenog() {
		return usernameZaposlenog;
	}



	public void setUsernameZaposlenog(String usernameZaposlenog) {
		this.usernameZaposlenog = usernameZaposlenog;
	}



	public String getPasswordZaposlenog() {
		return passwordZaposlenog;
	}



	public void setPasswordZaposlenog(String passwordZaposlenog) {
		this.passwordZaposlenog = passwordZaposlenog;
	}



	@Override
	public String toString() {
		return "Zaposleni [idZaposlenog=" + idZaposlenog + ", imeZaposlenog=" + imeZaposlenog + ", prezimeZaposlenog="
				+ prezimeZaposlenog + ", adresaZaposlenog=" + adresaZaposlenog + ", opstinaZaposlenog="
				+ opstinaZaposlenog + ", drzavljanstvoZaposlenog=" + drzavljanstvoZaposlenog + ", polZaposlenog="
				+ polZaposlenog + ", emailZaposlenog=" + emailZaposlenog + ", telefonZaposlenog=" + telefonZaposlenog
				+ ", datumZasnivanjaRadnogOdnosa=" + datumZasnivanjaRadnogOdnosa + ", tipUgovoraZaposlenog="
				+ tipUgovoraZaposlenog + ", datumPrestankaRadnogOdnosa=" + datumPrestankaRadnogOdnosa
				+ ", tipZaposlenja=" + tipZaposlenja + ", stepenStrucneSpreme=" + stepenStrucneSpreme
				+ ", plataZaposlenog=" + plataZaposlenog + ", status=" + status + ", usernameZaposlenog="
				+ usernameZaposlenog + ", passwordZaposlenog=" + passwordZaposlenog + "]";
	}
	
}
