package zadatak3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Kruzna_figura {

	public Igrac(Vektor polozaj, Color boja, double precnik, Vektor vektor_brzine, Scena scena) {
		super(polozaj, Color.GREEN, precnik, vektor_brzine, scena);
	}

	@Override
	public void pomeri() {

	}

	@Override
	public boolean sudarile_se(Kruzna_figura k) {
		boolean a = this.sudarile_se(k);
		if (a==true) {
			this.scena.zavrsi();
		}
		return a;
	}

	public void pomeri_igraca(double pomeraj) {
		 if(this.polozaj_centra.getX()>0 && this.polozaj_centra.getX()< super.scena.getWidth()) {
			 this.polozaj_centra.x += pomeraj;
		 }
	}

	@Override
	public void crtaj(Scena scena) {
		super.crtaj(scena);
		
		Krug k = new Krug(this.polozaj_centra, Color.BLUE, this.precnik / 2);
		k.crtaj(scena);
	}

	
}
