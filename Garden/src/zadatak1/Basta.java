package zadatak1;

import java.awt.*;


public class Basta extends Panel implements Runnable {
	private Thread nit = new Thread(this);
	private boolean radi = false;
	private Rupa[][] matricaRupa;
	private boolean[][] matricaSlobodnihRupa;
	private int intervalCekanja;
	private int kolicinaPovrca;
	private int brojKoraka;
	private int ukupanBrojKoraka;
	private int brojKolona;
	private int brojVrsta;
	public Label lduzina = new Label("Povrce: " + getKolicinaPovrca());

	public Basta(int brojVrsta, int brojKolona) {
		
		matricaRupa = new Rupa[brojVrsta][brojKolona];
		GridLayout layout = new GridLayout(brojVrsta, brojKolona);
		layout.setHgap(5);
		layout.setVgap(5);
		this.setLayout(layout);
		
		this.brojKolona = brojKolona;
		this.brojVrsta = brojVrsta;
		
		matricaSlobodnihRupa = new boolean[brojVrsta][brojKolona];
		
		for (int i = 0; i < brojVrsta; i++) {
			matricaRupa[i] = new Rupa[brojKolona];
			for (int j = 0; j < brojKolona; j++) {
				matricaRupa[i][j] = new Rupa(this);
				matricaSlobodnihRupa[i][j] = true;
				this.add(matricaRupa[i][j]);
			}
		}
		this.setBackground(Color.GREEN);
		kolicinaPovrca = 1;
		nit.start();
	}

	public synchronized void pokreni() {
		radi = true;
//		for (Rupa[] rupa : matricaRupa) {
//			for (Rupa rupa2 : rupa) {
//				rupa2.pokreni();
//			}
//		}
		notify();
	}

	public synchronized void zaustavi() {
		for (int i = 0; i < brojVrsta; i++) {
			for (int j = 0; j < brojKolona; j++) {
				if (matricaSlobodnihRupa[i][j] == false) {
					//System.out.println(i);
					//System.out.println(j);

					matricaRupa[i][j].zaustavi();
				}
			}
		}
		radi = false;
		nit.interrupt();
	}

	public void smanjiBrojPovrcaZaJedan() {
		kolicinaPovrca--;

	}

	public void postaviLabelu() {
		lduzina.setText("Povrce:" + getKolicinaPovrca());
	}
	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}

				int i = (int) (Math.random() * (brojVrsta ));
				int j = (int) (Math.random() * (brojKolona));
				while (!matricaSlobodnihRupa[i][j]) {// generise novo i i j ako je rupa zauzeta
					i = (int) (Math.random() * (brojVrsta ));
					j = (int) (Math.random() * (brojKolona));
				}
				matricaSlobodnihRupa[i][j] = false;// ovo sam dodao
				Rupa randomRupa = matricaRupa[i][j];
				randomRupa.setZivotinja(new Krtica(randomRupa));
				randomRupa.setBrojKoraka(brojKoraka);// ovo je bio problem isto
				randomRupa.stvoriNit();
				randomRupa.pokreni();
				intervalCekanja = (int) (intervalCekanja * 0.99);
				postaviLabelu();
				if(kolicinaPovrca==0)zaustavi();
				Thread.sleep(intervalCekanja);
			}
		} catch (InterruptedException e) {
		}
	}

	public void oslobodiRupu(Rupa rupa) {
		for (int i = 0; i < brojVrsta; i++) {
			for (int j = 0; j < brojKolona; j++) {
				if (matricaRupa[i][j] == rupa) {
					matricaSlobodnihRupa[i][j] = true;
					return;
				}
			}
		}
	}

	public int getIntervalCekanja() {
		return intervalCekanja;
	}

	public void setIntervalCekanja(int intervalCekanja) {
		this.intervalCekanja = intervalCekanja;
	}

	public boolean radi() {
		return radi;
	}

	public int getKolicinaPovrca() {
		return kolicinaPovrca;
	}

	public void setKolicinaPovrca(int kolicinaPovrca) {
		this.kolicinaPovrca = kolicinaPovrca;
	}

	public int getUkupanBrojKoraka() {
		return ukupanBrojKoraka;
	}

	public int getBrojKoraka() {
		return brojKoraka;
	}

	public void setBrojKoraka(int brojKoraka) {
		this.brojKoraka = brojKoraka;
		for (int i = 0; i < brojVrsta; i++) {
			for (int j = 0; j < brojKolona; j++) {
					matricaRupa[i][j].setBrojKoraka(brojKoraka);
				}
			}
		}

	public int getBrojKolona() {
		return brojKolona;
	}

	public void setBrojKolona(int brojKolona) {
		this.brojKolona = brojKolona;
	}

	public int getBrojVrsta() {
		return brojVrsta;
	}

	public void setBrojVrsta(int brojVrsta) {
		this.brojVrsta = brojVrsta;
	}
	
	
}
