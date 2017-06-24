package codingNinjas10;

public class ComplexUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex c1 = new Complex(2,3);
		Complex c2 = new Complex(3,-2);
		Complex sum = Complex.add(c1, c2);
		Complex product = Complex.multipy(c1, c2);
		Complex diff = Complex.subtract(c1, c2);
		c1.print();
		c2.print();
		sum.print();
		diff.print();
		product.print();
	}

}
