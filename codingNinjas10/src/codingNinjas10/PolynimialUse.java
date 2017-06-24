package codingNinjas10;

public class PolynimialUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial poly = new Polynomial();
		poly.setCoefficient(0, 3);
		poly.setCoefficient(2, 3);
		poly.print();
		Polynomial poly2 = new Polynomial();
		poly2.setCoefficient(1, 3);
		poly2.setCoefficient(3, 3);
		poly2.print();
		poly.addition(poly2);
		poly.print();
	}

}
