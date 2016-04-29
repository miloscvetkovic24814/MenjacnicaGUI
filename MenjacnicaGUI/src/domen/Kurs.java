package domen;

public class Kurs {

	private String sifra;
	private String naziv;
	private double prodajni;
	private double kupovni;
	private double srednji;
	private String skraceniNaziv;

	public Kurs(String sifra, String naziv, double prodajni, double kupovni, double srednji, String skraceniNaziv) {
		setSifra(sifra);
		setNaziv(naziv);
		setProdajni(prodajni);
		setKupovni(kupovni);
		setSrednji(srednji);
		setSkraceniNaziv(skraceniNaziv);
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		if (sifra == null || sifra.isEmpty()) {
			throw new RuntimeException();
		}
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty()) {
			throw new RuntimeException();
		}
		this.naziv = naziv;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		if (prodajni < 0) {
			throw new RuntimeException();
		}
		this.prodajni = prodajni;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		if (kupovni < 0) {
			throw new RuntimeException();
		}
		this.kupovni = kupovni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		if (srednji < 0) {
			throw new RuntimeException();
		}
		this.srednji = srednji;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		if (skraceniNaziv == null || skraceniNaziv.isEmpty()) {
			throw new RuntimeException();
		}
		this.skraceniNaziv = skraceniNaziv;
	}

}
