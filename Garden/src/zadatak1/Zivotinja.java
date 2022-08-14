package zadatak1;

import java.awt.Graphics;

public abstract class Zivotinja {
	protected boolean udarena;
	protected Rupa rupa;
	
	public Zivotinja(Rupa rupa) {
		this.rupa = rupa;
		udarena= false;
	}
	
	public abstract void crtaj();
	
	public abstract void efekatBezanja();
	
	public abstract void efekatUdarca();
	
	public boolean getUdarena() {
		return udarena;
	}
	
}
