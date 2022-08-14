package zadatak3;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Scena extends Canvas implements Runnable {

	private Thread nit = new Thread(this);
	private Igra igra;
	private boolean radi;
	protected List<Kruzna_figura> lista = new ArrayList<Kruzna_figura>();
	protected Igrac igrac;

	private synchronized void azuriraj() {

	}

	public void obavestava() {
		for (Kruzna_figura k : lista) {
			k.pomeri();
		}
		for (Kruzna_figura k1 : lista) {
			igrac.sudarile_se(k1);
			for (Kruzna_figura k2 : lista) {
				// Krug.preklapa(k1, k2);
				k1.sudarile_se(k2);
			}
		}
	}

	public Scena(Igra igra) {
		this.igra = igra;
		nit.start();
		setSize(500, 500);
	}

	public synchronized void kreni() {

		igrac = new Igrac(new Vektor(this.getWidth() / 2, this.getHeight() - 30), Color.GREEN, 30, new Vektor(1, 1),
				this);
		// igrac.crtaj(this);
		System.out.println(this.getWidth() / 2);
		System.out.println(this.getHeight() - 30);
		// repaint();
		radi = true;
		notify();
	}

	public synchronized void zavrsi() {
		nit.interrupt();
	}

	private void generisi_balon() {
		while (true) {
			int x = (int) (Math.random() * this.getWidth());
			int y = (int) (Math.random() * this.getHeight());
			int r = (int) (Math.random() * 100);
			if (r < 10) {
				Balon balon = new Balon(new Vektor(x, y), Color.RED, 20, new Vektor(10, 10), this);
				lista.add(balon);
			}

		}
	}

	public void dodaj_figuru(Kruzna_figura k) {
		lista.add(k);
	}

	public void izbaci_figuru(Kruzna_figura k) {
		lista.remove(k);
	}

	@Override
	public synchronized void addKeyListener(KeyListener l) {

		super.addKeyListener(l);
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}
				generisi_balon();
				azuriraj();
				obavestava();
				repaint();
				System.out.println("z");
				Thread.sleep(60);
			}
		} catch (InterruptedException e) {
		}
	}

	public void paint(Graphics g) {
		g.setColor(new Color(230, 230, 230));
		g.fillRect(0, 0, igra.getWidth(), igra.getHeight());
		Kruzna_figura z = new Kruzna_figura(new Vektor(250, 250), Color.BLACK, 40, new Vektor(30, 30), this);
		g.setColor(Color.BLACK);
		z.crtaj(this);
		g.setColor(Color.CYAN);
		igrac = new Igrac(new Vektor(this.getWidth() / 2, this.getHeight() - 30), Color.GREEN, 30, new Vektor(1, 1),
				this);
		
		igrac.crtaj(this);
		for (Kruzna_figura k : lista) {
			k.crtaj(this);
		}
	}

}
