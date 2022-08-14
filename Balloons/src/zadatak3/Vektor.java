package zadatak3;

public class Vektor {

	protected double x, y;

	public Vektor(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}*/
	
	@Override
	public Vektor clone() {
		Vektor v = new Vektor(this.getX(), this.getY());
		return v;
	}

	public void pomnozi_vektor(double i) {
		this.x = this.x * i;
		this.y = this.y * i;
	}
	
	public static Vektor saberi_vektore(Vektor v1, Vektor v2) {
		Vektor vv = new Vektor(0, 0);
		vv.x = v1.getX() + v2.getX();
		vv.y = v1.getY() + v2.getY();
		return vv;
		
	}
}
