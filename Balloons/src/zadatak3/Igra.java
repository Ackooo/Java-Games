package zadatak3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {

	private Scena scena;

	private void dodaj_osluslivace() {
		addWindowListener(new WindowAdapter() { // ! x button
			@Override
			public void windowClosing(WindowEvent dog) {
				// Scena.class zavrsi;
				dispose();
				scena.zavrsi();
			}
		});

	/*	scena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					scena.igrac.pomeri_igraca(-40);
					break;
				case KeyEvent.VK_RIGHT:
					scena.igrac.pomeri_igraca(+40);
					break;
				}
			}
		});*/
	}

	public Igra() {
		super("Baloni");
		setSize(700, 700);
		setResizable(false);
		
		dodaj_osluslivace();
		// dodaj_centar();
		this.scena = new Scena(this);
		add(scena, BorderLayout.CENTER);
		setVisible(true);

	}
/*
	private void dodaj_centar() {
		scena.setSize(600, 600);
		 Krug krug = new Krug(new Vektor(100, 100), Color.BLACK, 10);
		
	}*/

	public static void main(String[] args) {

		new Igra();
	}
}