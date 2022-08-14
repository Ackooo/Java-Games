package zadatak1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class Rupa extends Canvas implements Runnable {

	private Basta basta;
	private Zivotinja zivotinja;
	private boolean radi;
	private Thread nit;
	private int brojKoraka;
	private int ukupanBrojKoraka;

	@Override
	public synchronized void addMouseListener(MouseListener l) {

		super.addMouseListener(l);
	}

	public Rupa(Basta basta) {
		zivotinja = null;
		this.basta = basta;
		radi = false;

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("Mouse was clicked");
				zivotinja.efekatUdarca();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
	}

	public void stvoriNit() {
		nit = new Thread(this);
		nit.start();
	}

	public synchronized void pokreni() {
		radi = true;
		notify();
	}

	public synchronized void zaustavi() {
		radi = false;
		if (!zivotinja.getUdarena()) {
			zivotinja.efekatBezanja();
		}
		zivotinja = null;
		repaint();
		basta.oslobodiRupu(this);
		nit.interrupt();
		//System.out.println("Zaustavljeno");
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}
				repaint();
				Thread.sleep(1000);
				brojKoraka--;
				if (brojKoraka == 0) {
					Thread.sleep(2000);// 2s
					zaustavi();
				}
			}
		} catch (InterruptedException e) {
		}

	}

	public boolean radi() {
		return radi;
	}

	public void zgazitiRupu() {
		if (zivotinja != null) {
			zivotinja.efekatUdarca();
		}
	}

	public Zivotinja getZivotinja() {
		return zivotinja;
	}

	public void setZivotinja(Zivotinja zivotinja) {
		this.zivotinja = zivotinja;
	}

	public int getBrojKoraka() {
		return brojKoraka;
	}

	public void setBrojKoraka(int brojKoraka) {
		this.brojKoraka = brojKoraka;
		this.ukupanBrojKoraka = brojKoraka;
	}

	public Basta getBasta() {
		return basta;
	}

	public int getUkupanBrojKoraka() {
		return ukupanBrojKoraka;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(210, 105, 30));
		this.setSize(basta.getWidth() / basta.getBrojKolona() - 3 * 5,
				basta.getHeight() / basta.getBrojVrsta() - 3 * 5);
		g.fillRect(0, 0, basta.getWidth() / basta.getBrojKolona() - 3 * 5,
				basta.getHeight() / basta.getBrojVrsta() - 3 * 5);
		if (zivotinja != null) {
			zivotinja.crtaj();
		}
	}

}
