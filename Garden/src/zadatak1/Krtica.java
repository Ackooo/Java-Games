package zadatak1;

import java.awt.Color;
import java.awt.Graphics;

public class Krtica extends Zivotinja {
	Color boja = Color.DARK_GRAY;


	public Krtica(Rupa rupa) {
		super(rupa);
		
	}

	@Override
	public void crtaj() {// ovo sam dodao
		Graphics g = rupa.getGraphics();
		g.setColor(boja);
		//System.out.println(rupa.getBrojKoraka());
		//System.out.println(rupa.getUkupanBrojKoraka());
		//System.out.println(rupa.getBrojKoraka()/rupa.getUkupanBrojKoraka());// problem je bilo ovo deljenje
		//System.out.println(rupa.getWidth()*(rupa.getBrojKoraka()*100/rupa.getUkupanBrojKoraka())/100);
		int x = rupa.getWidth()/2 - (rupa.getWidth() *(rupa.getBrojKoraka()*100/rupa.getUkupanBrojKoraka() )/100)/2;
        int y = rupa.getHeight()/2 - (rupa.getHeight()*(rupa.getBrojKoraka()*100/rupa.getUkupanBrojKoraka())/100)/2; 
		
		
		g.fillOval(x, y, rupa.getWidth()*(rupa.getBrojKoraka()*100/rupa.getUkupanBrojKoraka())/100, rupa.getHeight()*(rupa.getBrojKoraka()*100/rupa.getUkupanBrojKoraka())/100);
	}

	@Override
	public void efekatBezanja() {
		rupa.getBasta().smanjiBrojPovrcaZaJedan();
	}

	@Override
	public void efekatUdarca() {
		udarena= true;
		this.rupa.zaustavi();
	}

}
