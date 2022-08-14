package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {

	public Igrac(Polje polje) {
		super(polje);
	}

	@Override
	public void crtaj() {
		Graphics g = this.getPolje().getGraphics();
		boolean sme = this.getPolje().dozvoljeno();
		if(sme) {
		g.setColor(Color.RED);
		int x = this.getPolje().getWidth() / 2;
		int y = this.getPolje().getHeight() / 2;
		g.drawLine(x, 0, x, this.getPolje().getHeight());
		g.drawLine(0, y, this.getPolje().getWidth(), y);
	}}

}
