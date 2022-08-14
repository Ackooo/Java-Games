package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public class Tenk extends Figura implements Runnable {

	private boolean radi = false;
	private Thread nit = new Thread(this);

	public Tenk(Polje polje) {
		super(polje);
		nit.start();
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}

				Thread.sleep(500);
				this.pomeri();

			}
		} catch (InterruptedException e) {
		}

	}

	public synchronized void pokreni() {
		radi = true;
		notify();
	}

	public synchronized void zaustavi() {
		radi = false;
		nit.interrupt();
	}

	public void pomeri() {
		// if (this.getPolje().dohvati_udaljeno(1, 0) != null &&
		// this.getPolje().dohvati_udaljeno(1, 0) instanceof Trava) {};
		int a = (int) (Math.random() * 4 + 1);
	//	a = 1;
		switch (a) {
		case 1:
			int dim1 = this.getPolje().odredi_poziciju()[0];
			if (this.getPolje().dohvati_udaljeno(1, 0) != null
					&& this.getPolje().dohvati_udaljeno(1, 0).dozvoljeno()
					&& dim1 < this.getPolje().getMreza().dimenzija) {
				this.getPolje().repaint();
				this.pomeri(this.getPolje().dohvati_udaljeno(1, 0));
				this.crtaj();
			} /*
				 * else if(dim< this.getPolje().getMreza().dimenzija ) {
				 * 
				 * }
				 */
			break;
		case 2:
			int dim2 = this.getPolje().odredi_poziciju()[0];
			if (this.getPolje().dohvati_udaljeno(-1, 0) != null
					&& this.getPolje().dohvati_udaljeno(-1, 0).dozvoljeno() && dim2 > 0) {
				this.getPolje().repaint();
				this.pomeri(this.getPolje().dohvati_udaljeno(-1, 0));
				this.crtaj();
			}
			break;
		case 3:
			int dim3 = this.getPolje().odredi_poziciju()[1];
			if (this.getPolje().dohvati_udaljeno(0, 1) != null
					&& this.getPolje().dohvati_udaljeno(0, 1).dozvoljeno()
					&& dim3 < this.getPolje().getMreza().dimenzija) {
				this.getPolje().repaint();
				this.pomeri(this.getPolje().dohvati_udaljeno(0, 1));
				this.crtaj();
			}
			break;
		case 4:
			int dim4 = this.getPolje().odredi_poziciju()[1];
			if (this.getPolje().dohvati_udaljeno(0, -1) != null
					&& this.getPolje().dohvati_udaljeno(0, -1).dozvoljeno() && dim4 > 0) {
				this.getPolje().repaint();
				this.pomeri(this.getPolje().dohvati_udaljeno(0, -1));
				this.crtaj();
			}
			break;
		}

	}

	@Override
	public void crtaj() {
		Graphics g = this.getPolje().getGraphics();
		boolean sme = this.getPolje().dozvoljeno();
		if (sme) {
			g.setColor(Color.BLACK);
			g.drawLine(0, 0, this.getPolje().getWidth(), this.getPolje().getHeight());
			g.drawLine(0, this.getPolje().getHeight(), this.getPolje().getWidth(), 0);
		}
	}

}
