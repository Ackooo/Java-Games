package zadatak2;

import java.awt.GridLayout;
import java.awt.Panel;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Mreza extends Panel implements Runnable {

	protected int dimenzija;
	public Polje[][] matrica_polja;
	private List<Novcic> lista_novcica = new ArrayList<Novcic>();
	private List<Tenk> lista_tenkova = new ArrayList<Tenk>();
	private Igra igra_kojoj_pripada;
	private Thread nit = new Thread(this);
	private boolean radi = false;

	public Mreza(int dimenzija, Igra igra_kojoj_pripada) {
		this.dimenzija = dimenzija;
		this.igra_kojoj_pripada = igra_kojoj_pripada;
		this.matrica_polja = new Polje[dimenzija][dimenzija];
		GridLayout layout = new GridLayout(dimenzija, dimenzija);
		//layout.setHgap();
	
		//this.setBackground(Color.BLUE);
		this.setLayout(layout);
		
		for (int i = 0; i < dimenzija; i++) {
			matrica_polja[i] = new Polje[dimenzija];
			for (int j = 0; j < dimenzija; j++) {
				int r = (int) (Math.random() * 100);
				if (r < 80) {
					
					matrica_polja[i][j] = new Trava(this);
					this.add(matrica_polja[i][j]);				// !
					repaint();
					
				} else {
					
					matrica_polja[i][j] = new Zid(this);
					this.add(matrica_polja[i][j]);
					repaint();
				}
				matrica_polja[i][j].addActionListener();
			}
			//nit.start();
		}

		
		repaint();
	}

	public Mreza(Igra igra_kojoj_pripada) {
		this(17, igra_kojoj_pripada);
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}
				
				//int i = (int) (Math.random() * (brojVrsta ));
			}
		} catch (InterruptedException e) {
		}
	}

	public Polje[][] getMatrica_polja() {
		return matrica_polja;
	}

	public List<Novcic> getLista_novcica() {
		return lista_novcica;
	}

	public List<Tenk> getLista_tenkova() {
		return lista_tenkova;
	}

	public void mis(Polje p) {
		System.out.println("a");
		
	}

	private void dodajOsluskivace() {
		
		
	}



	/*public void paint(Graphics g) {
		g.setColor(new Color(220, 220, 220));
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < dimenzija; i++) {
			for (int j = 0; j < dimenzija; j++) {
				matrica_polja[i][j].paint(this);
				matrica_polja[i][j].paint(getGraphics());
				
			}
		}
			
		
	}*/
	
	
}
/*
 * private Panel panel(int dimenzija) { Panel ploca = new Panel(new
 * GridLayout(dimenzija, dimenzija)); return ploca; } }
 */
