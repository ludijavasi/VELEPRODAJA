package model;

import java.util.Date;

public class Zaposleni {	
	

	private int idZaposlenog;
	private int idFilijale;
	private String imeZaposlenog;
	private String prezimeZaposlenog;
	private String adresaZaposlenog;
	private String gradOpstinaZaposlenog;
	private String polZaposlenog;
	private String telefonZaposlenog;
	private String emailZaposlenog;
	private String strucnaSpremaZaposlenog;
	private Date datumPocetkaZaposlenja;
	private Date datumZavrsetkaZaposlenja;
	private double plataZaposlenog;
	private String tipZaposlenja;
	private String usernameZaposlenog;
	private String passwordZaposlenog;
	
	
	public Zaposleni(int idZaposlenog, int idFilijale, String imeZaposlenog, String prezimeZaposlenog,
			String adresaZaposlenog, String gradOpstinaZaposlenog, String polZaposlenog, String telefonZaposlenog,
			String emailZaposlenog, String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja,
			Date datumZavrsetkaZaposlenja, double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog,
			String passwordZaposlenog) {
		super();
		this.idZaposlenog = idZaposlenog;
		this.idFilijale = idFilijale;
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.polZaposlenog = polZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}


	public Zaposleni(String imeZaposlenog, String prezimeZaposlenog, String adresaZaposlenog,
			String gradOpstinaZaposlenog, String polZaposlenog, String telefonZaposlenog, String emailZaposlenog,
			String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja, Date datumZavrsetkaZaposlenja,
			double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog, String passwordZaposlenog) {
		super();
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.polZaposlenog = polZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}
	


	public Zaposleni(int idZaposlenog, String imeZaposlenog, String prezimeZaposlenog, String adresaZaposlenog,
			String gradOpstinaZaposlenog, String polZaposlenog, String telefonZaposlenog, String emailZaposlenog,
			String strucnaSpremaZaposlenog, Date datumPocetkaZaposlenja, Date datumZavrsetkaZaposlenja,
			double plataZaposlenog, String tipZaposlenja, String usernameZaposlenog, String passwordZaposlenog) {
		super();
		this.idZaposlenog = idZaposlenog;
		this.imeZaposlenog = imeZaposlenog;
		this.prezimeZaposlenog = prezimeZaposlenog;
		this.adresaZaposlenog = adresaZaposlenog;
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
		this.polZaposlenog = polZaposlenog;
		this.telefonZaposlenog = telefonZaposlenog;
		this.emailZaposlenog = emailZaposlenog;
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
		this.plataZaposlenog = plataZaposlenog;
		this.tipZaposlenja = tipZaposlenja;
		this.usernameZaposlenog = usernameZaposlenog;
		this.passwordZaposlenog = passwordZaposlenog;
	}


	public Zaposleni() {
		super();
		
	}


	public int getIdZaposlenog() {
		return idZaposlenog;
	}


	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}


	public int getIdFilijale() {
		return idFilijale;
	}


	public void setIdFilijale(int idFilijale) {
		this.idFilijale = idFilijale;
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


	public String getGradOpstinaZaposlenog() {
		return gradOpstinaZaposlenog;
	}


	public void setGradOpstinaZaposlenog(String gradOpstinaZaposlenog) {
		this.gradOpstinaZaposlenog = gradOpstinaZaposlenog;
	}


	public String getPolZaposlenog() {
		return polZaposlenog;
	}


	public void setPolZaposlenog(String polZaposlenog) {
		this.polZaposlenog = polZaposlenog;
	}


	public String getTelefonZaposlenog() {
		return telefonZaposlenog;
	}


	public void setTelefonZaposlenog(String telefonZaposlenog) {
		this.telefonZaposlenog = telefonZaposlenog;
	}


	public String getEmailZaposlenog() {
		return emailZaposlenog;
	}


	public void setEmailZaposlenog(String emailZaposlenog) {
		this.emailZaposlenog = emailZaposlenog;
	}


	public String getStrucnaSpremaZaposlenog() {
		return strucnaSpremaZaposlenog;
	}


	public void setStrucnaSpremaZaposlenog(String strucnaSpremaZaposlenog) {
		this.strucnaSpremaZaposlenog = strucnaSpremaZaposlenog;
	}


	public Date getDatumPocetkaZaposlenja() {
		return datumPocetkaZaposlenja;
	}


	public void setDatumPocetkaZaposlenja(Date datumPocetkaZaposlenja) {
		this.datumPocetkaZaposlenja = datumPocetkaZaposlenja;
	}


	public Date getDatumZavrsetkaZaposlenja() {
		return datumZavrsetkaZaposlenja;
	}


	public void setDatumZavrsetkaZaposlenja(Date datumZavrsetkaZaposlenja) {
		this.datumZavrsetkaZaposlenja = datumZavrsetkaZaposlenja;
	}


	public double getPlataZaposlenog() {
		return plataZaposlenog;
	}


	public void setPlataZaposlenog(double plataZaposlenog) {
		this.plataZaposlenog = plataZaposlenog;
	}


	public String getTipZaposlenja() {
		return tipZaposlenja;
	}


	public void setTipZaposlenja(String tipZaposlenja) {
		this.tipZaposlenja = tipZaposlenja;
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
		return "Zaposleni [idZaposlenog=" + idZaposlenog + ", idFilijale=" + idFilijale + ", imeZaposlenog="
				+ imeZaposlenog + ", prezimeZaposlenog=" + prezimeZaposlenog + ", adresaZaposlenog=" + adresaZaposlenog
				+ ", gradOpstinaZaposlenog=" + gradOpstinaZaposlenog + ", polZaposlenog=" + polZaposlenog
				+ ", telefonZaposlenog=" + telefonZaposlenog + ", emailZaposlenog=" + emailZaposlenog
				+ ", strucnaSpremaZaposlenog=" + strucnaSpremaZaposlenog + ", datumPocetkaZaposlenja="
				+ datumPocetkaZaposlenja + ", datumZavrsetkaZaposlenja=" + datumZavrsetkaZaposlenja
				+ ", plataZaposlenog=" + plataZaposlenog + ", tipZaposlenja=" + tipZaposlenja + ", usernameZaposlenog="
				+ usernameZaposlenog + ", passwordZaposlenog=" + passwordZaposlenog + "]";
	}
	
		
}
