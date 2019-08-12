package model;

public class StavkeRacunaOtpremnice {
	
	private int idStavkeProdaje;
	private RacunOtpremnica racunOtpremnica;
	private Artikli artikal;
	private double kolicinaProdaje;
	private double rabatProdaje;
	
	public StavkeRacunaOtpremnice(int idStavkeProdaje, RacunOtpremnica racunOtpremnica, Artikli artikal,
			double kolicinaProdaje, double rabatProdaje) {
		super();
		this.idStavkeProdaje = idStavkeProdaje;
		this.racunOtpremnica = racunOtpremnica;
		this.artikal = artikal;
		this.kolicinaProdaje = kolicinaProdaje;
		this.rabatProdaje = rabatProdaje;
	}

	public StavkeRacunaOtpremnice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdStavkeProdaje() {
		return idStavkeProdaje;
	}

	public void setIdStavkeProdaje(int idStavkeProdaje) {
		this.idStavkeProdaje = idStavkeProdaje;
	}

	public RacunOtpremnica getRacunOtpremnica() {
		return racunOtpremnica;
	}

	public void setRacunOtpremnica(RacunOtpremnica racunOtpremnica) {
		this.racunOtpremnica = racunOtpremnica;
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
	
	
	
	

}
