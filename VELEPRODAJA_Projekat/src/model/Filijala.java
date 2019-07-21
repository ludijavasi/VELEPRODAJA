package model;

public class Filijala {
	
	private int idFilijale;
	private String adresaFilijale;
	private String gradOpstinaFilijale;
	private String telefonFilijale;
	private String emailFilijale;
	private int pibFilijale;
	private String tekuciRacunFilijale;
	private String status;
	
	public Filijala(int idFilijale, String adresaFilijale, String gradOpstinaFilijale, String telefonFilijale,
			String emailFilijale, int pibFilijale, String tekuciRacunFilijale, String status) {
		super();
		this.idFilijale = idFilijale;
		this.adresaFilijale = adresaFilijale;
		this.gradOpstinaFilijale = gradOpstinaFilijale;
		this.telefonFilijale = telefonFilijale;
		this.emailFilijale = emailFilijale;
		this.pibFilijale = pibFilijale;
		this.tekuciRacunFilijale = tekuciRacunFilijale;
		this.status = status;
	}

	public Filijala(String adresaFilijale, String gradOpstinaFilijale, String telefonFilijale, String emailFilijale,
			int pibFilijale, String tekuciRacunFilijale, String status) {
		super();
		this.adresaFilijale = adresaFilijale;
		this.gradOpstinaFilijale = gradOpstinaFilijale;
		this.telefonFilijale = telefonFilijale;
		this.emailFilijale = emailFilijale;
		this.pibFilijale = pibFilijale;
		this.tekuciRacunFilijale = tekuciRacunFilijale;
		this.status = status;
	}

	public Filijala() {
		super();
		
	}

	public int getIdFilijale() {
		return idFilijale;
	}

	public void setIdFilijale(int idFilijale) {
		this.idFilijale = idFilijale;
	}

	public String getAdresaFilijale() {
		return adresaFilijale;
	}

	public void setAdresaFilijale(String adresaFilijale) {
		this.adresaFilijale = adresaFilijale;
	}

	public String getGradOpstinaFilijale() {
		return gradOpstinaFilijale;
	}

	public void setGradOpstinaFilijale(String gradOpstinaFilijale) {
		this.gradOpstinaFilijale = gradOpstinaFilijale;
	}

	public String getTelefonFilijale() {
		return telefonFilijale;
	}

	public void setTelefonFilijale(String telefonFilijale) {
		this.telefonFilijale = telefonFilijale;
	}

	public String getEmailFilijale() {
		return emailFilijale;
	}

	public void setEmailFilijale(String emailFilijale) {
		this.emailFilijale = emailFilijale;
	}

	public int getPibFilijale() {
		return pibFilijale;
	}

	public void setPibFilijale(int pibFilijale) {
		this.pibFilijale = pibFilijale;
	}

	public String getTekuciRacunFilijale() {
		return tekuciRacunFilijale;
	}

	public void setTekuciRacunFilijale(String tekuciRacunFilijale) {
		this.tekuciRacunFilijale = tekuciRacunFilijale;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Filijala [idFilijale=" + idFilijale + ", adresaFilijale=" + adresaFilijale + ", gradOpstinaFilijale="
				+ gradOpstinaFilijale + ", telefonFilijale=" + telefonFilijale + ", emailFilijale=" + emailFilijale
				+ ", pibFilijale=" + pibFilijale + ", tekuciRacunFilijale=" + tekuciRacunFilijale + ", status=" + status
				+ "]";
	}	

}
