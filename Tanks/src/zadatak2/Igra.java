package zadatak2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {

	// private boolean rezim = true;
	private Mreza mreza = new Mreza(this);
	private Button pocni = new Button("Pocni");
	private Label novcica = new Label("Novcica:"), poena = new Label("Poena: ");
	private TextField br_novcica = new TextField("0");

	private enum Rezim {
		izmena, igranje
	}

	private Rezim rezim;

	private Panel dole() {
		Panel p = new Panel(new GridLayout(1, 6));
		// setPreferredSize(new Dimension(500, 50));
		// p.setSize(500, 50);
		p.add(novcica);
		p.add(br_novcica);
		p.add(poena);
		pocni.setBounds(30, 30, 30, 30);
		p.add(pocni);
		return p;
	}

	private Panel desno() {
		Panel p = new Panel(new GridLayout(1, 1));
		Label podloga = new Label("Podloga");
		podloga.setBackground(Color.LIGHT_GRAY);
		p.add(podloga);

		return p;
	}

	private Panel skroz_desno() {
		Panel q = new Panel (new GridLayout(1,1));
		Label podloga = new Label("Podloga");
		podloga.setBackground(Color.LIGHT_GRAY);
		q.add(podloga);
		
		
		Panel p = new Panel(new GridLayout(2, 1));
		Checkbox c1 = new Checkbox("Trava");
		c1.setBackground(Color.GREEN);
		Checkbox c2 = new Checkbox("Zid");
		c2.setBackground(Color.GRAY);
		p.add(c1);
		p.add(c2);

		return p;
	}

	private void dodajMeni() {
		MenuBar bar = new MenuBar();
		setMenuBar(bar);
		Menu menu = new Menu("Rezim");
		bar.add(menu);
		MenuItem rezim_izmena = new MenuItem("Rezim izmena");
		menu.add(rezim_izmena);
		rezim_izmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rezim = Rezim.izmena;
				//System.out.println(rezim);
			}
		});
		MenuItem rezim_igranje = new MenuItem("Rezim igranje");
		menu.add(rezim_igranje);
		rezim_igranje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rezim = Rezim.igranje;
				//System.out.println(rezim);

			}
		});
		menu.add(rezim_igranje);

	}

	private void dodajOsluskivace() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// nesto.zavrsi
				dispose();
			}
		});
		
		
		
		
		
		
	}

	public Igra() {
		super("Igra");
		setSize(700, 700);
		setResizable(false);			//ne prefarbaju se
		
	//	add(desno(), BorderLayout.PAGE_END);
		add(skroz_desno(), BorderLayout.EAST);
		add(dole(), BorderLayout.PAGE_END);
		add(mreza, BorderLayout.CENTER);
		dodajMeni();
		dodajOsluskivace();
		setVisible(true);
	}

	public static void main(String[] args) {
		Igra igra = new Igra();
		Polje[][] p = igra.mreza.getMatrica_polja();
		System.out.println(p[2][3]);

	}

}
