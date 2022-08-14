package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public class Trava extends Polje {

	public Trava(Mreza mreza) {
		super(mreza);
	}

	@Override
	public boolean dozvoljeno() {
		return true;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		super.paint(g);
	}
	
	

}
