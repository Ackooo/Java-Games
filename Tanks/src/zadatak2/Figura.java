package zadatak2;

import java.awt.*;

public abstract class Figura {

	private Polje polje;

	public Figura(Polje polje) {
		this.polje = polje;
	}

	public Polje getPolje() {
		return polje;
	}

	public void pomeri(Polje polje) {
		
		if(polje.dozvoljeno()) {this.polje = polje;}		// nisam siguran
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Figura))
			return false;
		Figura f = (Figura) obj;
		if (f.polje == this.polje) {
			return true;
		} else
			return false;

	}

	public abstract void crtaj();

}
