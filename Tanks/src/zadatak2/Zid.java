package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public class Zid extends Polje {

	public Zid(Mreza mreza) {
		super(mreza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dozvoljeno() {
		return false;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		super.paint(g);
	}

}
