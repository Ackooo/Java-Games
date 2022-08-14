package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public class Novcic extends Figura {

	public Novcic(Polje polje) {
		super(polje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crtaj() {

		Graphics g = this.getPolje().getGraphics();
		boolean sme = this.getPolje().dozvoljeno();
		if(sme) {
		g.setColor(Color.YELLOW);
		int x = this.getPolje().getWidth() / 4;
		int y = this.getPolje().getHeight() / 4;
		g.fillOval(x, y, 2*x, 2*y);
	}}

}
