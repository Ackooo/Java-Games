package zadatak1;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/*import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;*/
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {

	protected int a = 0;
	private Basta basta = new Basta(4, 4);
	private CheckboxGroup grupa = new CheckboxGroup();
	Checkbox lako = new Checkbox("Lako", grupa, false);
	Checkbox srednje = new Checkbox("Srednje", grupa, false);
	Checkbox tesko = new Checkbox("Tesko", grupa, false);
	private Button dugme = new Button("Kreni");
	private boolean basta_radi = false;
	// public Label povrce = new Label("Povrce: 100");

	public Igra() {
		super("Igra");
		add(basta, BorderLayout.CENTER);
		add(napraviPanel(), BorderLayout.EAST);
		setSize(800, 600);
		dodajOsluskivace();
		setResizable(false);

		// basta.setIntervalCekanja(1000);
		// basta.setBrojKoraka(10);
		// basta.pokreni();

		setVisible(true);

	}

	private class OsnovaPromena implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			String ozn = ((Checkbox) e.getSource()).getLabel();
			if (ozn == "Lako")
				a = 1;
		}

	}

	private Panel napraviPanel() {
		Panel panelmoj = new Panel(new GridLayout(2, 1));
		Panel panel = new Panel(new GridLayout(4, 1));
		panel.add(new Label("Tezina:"));

		Panel panel1 = new Panel(new GridLayout(3, 1));
		panel1.add(lako);
		panel1.add(srednje);
		panel1.add(tesko);
		panel.add(panel1);
		panel.setSize(200, this.getHeight());

		panel.add(dugme);
		panelmoj.add(panel);
		panelmoj.add(basta.lduzina);

		return panelmoj;
	}

	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				basta.zaustavi();
				dispose();
			}
		});

		dugme.addActionListener(e -> {
			if (basta_radi == false) {

				// dugme.setLabel("kreni");
				if (grupa.getSelectedCheckbox() == lako) {
					basta_radi = true;
					basta.setIntervalCekanja(1000);
					basta.setBrojKoraka(10);
					basta.pokreni();
					dugme.setLabel("stani");
					srednje.setEnabled(false);
					tesko.setEnabled(false);
				} else if (grupa.getSelectedCheckbox() == srednje) {
					dugme.setLabel("stani");
					basta_radi = true;
					basta.setIntervalCekanja(750);
					basta.setBrojKoraka(8);
					basta.pokreni();
					lako.setEnabled(false);
					tesko.setEnabled(false);
				} else if (grupa.getSelectedCheckbox() == tesko) {
					dugme.setLabel("stani");
					basta_radi = true;
					basta.setIntervalCekanja(500);
					basta.setBrojKoraka(6);
					basta.pokreni();
					lako.setEnabled(false);
					srednje.setEnabled(false);
				} else {
					System.out.println("izabrati nivo");
				}

				// basta.pokreni();

			} else {
				// basta_radi = false;
				dugme.setLabel("kraj");
				basta.zaustavi();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Igra i = new Igra();
		/*
		 * i.basta.setIntervalCekanja(1000); i.basta.setBrojKoraka(10);
		 * i.basta.pokreni();
		 */

	}

}
