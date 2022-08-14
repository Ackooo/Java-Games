package zadatak3;

import java.awt.*;

public class Krug {

	public Vektor polozaj_centra;
	private Color boja;
	double precnik;

	public Krug(Vektor polozaj, Color boja, double precnik) {
		this.polozaj_centra = polozaj;
		this.boja = boja;
		this.precnik = precnik;
	}

	public static boolean preklapa(Krug k1, Krug k2) {
		if ((k1.precnik - k2.precnik) * (k1.precnik - k2.precnik)
				- (k1.polozaj_centra.getX() - k2.polozaj_centra.getX())
						* (k1.polozaj_centra.getX() - k2.polozaj_centra.getX())
				- (k1.polozaj_centra.getY() - k2.polozaj_centra.getY()) >= 0) {
			return true;
		} else
			return false;
	}

	public void crtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		int x = (int) (this.polozaj_centra.getX() - this.precnik / 2);
		int y = (int) (this.polozaj_centra.getY() - this.precnik / 2);
		g.setColor(boja);
		g.fillOval(x, y, (int) this.precnik, (int) this.precnik);
	}

}

// > ili >=