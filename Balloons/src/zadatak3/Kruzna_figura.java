package zadatak3;

import java.awt.Color;
import java.awt.Graphics;

public class Kruzna_figura extends Krug {

	private Vektor vektor_brzine;
	protected
	Scena scena;

	public Kruzna_figura(Vektor polozaj, Color boja, double precnik, Vektor vektor_brzine, Scena scena) {
		super(polozaj, boja, precnik);
		this.vektor_brzine = vektor_brzine;
		this.scena = scena;
	}

	public void pomeri() {
		this.polozaj_centra = Vektor.saberi_vektore(polozaj_centra, vektor_brzine);
		if (this.polozaj_centra.getX() < 0 || this.polozaj_centra.getX() > this.scena.getWidth()
				|| this.polozaj_centra.getY() < 0 || this.polozaj_centra.getY() > this.scena.getHeight()) {
			this.scena.izbaci_figuru(this);
		}
	}

	public boolean sudarile_se(Kruzna_figura k) {
		if (Krug.preklapa(this, k))
			return true;
		else
			return false;
	}

	@Override
	public void crtaj(Scena scena) {
		// TODO Auto-generated method stub
		super.crtaj(scena);
	}

	
	
	
}
