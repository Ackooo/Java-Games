package zadatak2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Polje extends Canvas implements MouseListener {

	private Mreza mreza;

	public Polje(Mreza mreza) {
		this.mreza = mreza;
		// Igrac igrac = new Igrac(this);
		Tenk tenk = new Tenk(this);

		/*addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				e.getSource();
				e.getComponent();
				
				
				// igrac.crtaj();
				tenk.pokreni();
				//tenk.crtaj();
				//tenk.pomeri();

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

		});*/

	}

	public Mreza getMreza() {
		return mreza;
	}

	public int[] odredi_poziciju() {
		int[] niz = new int[2];
		Polje[][] polje = mreza.getMatrica_polja();
		for (int i = 0; i < mreza.dimenzija; i++) {
			for (int j = 0; j < mreza.dimenzija; j++) {

				if (polje[i][j] == this) {
					niz[0] = i;
					niz[1] = j;
				}
			}
		}
		return niz;
	}

	public Polje dohvati_udaljeno(int pomeraj_vrsta, int pomeraj_kolona) {
		int[] niz = this.odredi_poziciju();
		int a = niz[0];
		int b = niz[1];
		Polje[][] polje = mreza.getMatrica_polja();

		if (a + pomeraj_vrsta >= mreza.dimenzija || a + pomeraj_vrsta <0 ) {
			return null;
		} else if (b + pomeraj_kolona >= mreza.dimenzija || b + pomeraj_kolona < 0) {
			return null;
		} 
		
		else {
			return polje[a + pomeraj_vrsta][b + pomeraj_kolona];
		}

		/*
		 * if (polje[a + pomeraj_vrsta][b + pomeraj_kolona] == null) {
		 * 
		 * return null; } else {
		 * 
		 * return polje[a + pomeraj_vrsta][b + pomeraj_kolona]; }
		 */
	}

	public boolean dozvoljeno() {
		return false;
	}

	public void addActionListener() {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		this.setSize(mreza.getWidth() / mreza.dimenzija, mreza.getHeight() / mreza.dimenzija);
		g.fillRect(0, 0, mreza.getWidth() / mreza.dimenzija, mreza.getHeight() / mreza.dimenzija);
		// if(figura !=null) figura.crtaj;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//this.mreza.mis(this);
		System.out.println("a");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
