package model;

public class Magacin {
	
	private int idMagacina;
	private String adresaMagacina;
	private String gradOpstinaMagacina;
	private String telefonMagacina;
	private String emailMagacina;
	
	
	public Magacin(int idMagacina, String adresaMagacina, String gradOpstinaMagacina, String telefonMagacina,
			String emailMagacina) {
		super();
		this.idMagacina = idMagacina;
		this.adresaMagacina = adresaMagacina;
		this.gradOpstinaMagacina = gradOpstinaMagacina;
		this.telefonMagacina = telefonMagacina;
		this.emailMagacina = emailMagacina;
	}


	public Magacin(String adresaMagacina, String gradOpstinaMagacina, String telefonMagacina, String emailMagacina) {
		super();
		this.adresaMagacina = adresaMagacina;
		this.gradOpstinaMagacina = gradOpstinaMagacina;
		this.telefonMagacina = telefonMagacina;
		this.emailMagacina = emailMagacina;
	}


	public Magacin() {
		super();
		
	}


	public int getIdMagacina() {
		return idMagacina;
	}


	public void setIdMagacina(int idMagacina) {
		this.idMagacina = idMagacina;
	}


	public String getAdresaMagacina() {
		return adresaMagacina;
	}


	public void setAdresaMagacina(String adresaMagacina) {
		this.adresaMagacina = adresaMagacina;
	}


	public String getGradOpstinaMagacina() {
		return gradOpstinaMagacina;
	}


	public void setGradOpstinaMagacina(String gradOpstinaMagacina) {
		this.gradOpstinaMagacina = gradOpstinaMagacina;
	}


	public String getTelefonMagacina() {
		return telefonMagacina;
	}


	public void setTelefonMagacina(String telefonMagacina) {
		this.telefonMagacina = telefonMagacina;
	}


	public String getEmailMagacina() {
		return emailMagacina;
	}


	public void setEmailMagacina(String emailMagacina) {
		this.emailMagacina = emailMagacina;
	}


	@Override
	public String toString() {
		return "Magacin [idMagacina=" + idMagacina + ", adresaMagacina=" + adresaMagacina + ", gradOpstinaMagacina="
				+ gradOpstinaMagacina + ", telefonMagacina=" + telefonMagacina + ", emailMagacina=" + emailMagacina
				+ "]";
	}	

}
