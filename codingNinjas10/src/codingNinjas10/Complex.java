package codingNinjas10;

public class Complex {
private int a;
private int b;
public void print()
{	if(b>=0)
	System.out.println(a+" + "+b+"i");
    else
    System.out.println(a+" "+b+"i");
    
}
public Complex(int a,int b)
{
	this.a = a;
	this.b = b;
}
public static Complex add(Complex c1,Complex c2)
{
	Complex x = new Complex(0,0);
	x.a = c1.a + c2.a;
	x.b = c1.b + c2.b;
	return x;
}
public static Complex subtract(Complex c1,Complex c2)
{
	Complex x = new Complex(0,0);
	x.a = c1.a - c2.a;
	x.b = c1.b - c2.b;
	return x;
}
public static Complex multipy(Complex c1,Complex c2)
{
	Complex x = new Complex(0,0);
	x.a = c1.a*c2.a-c1.b*c2.b;
	x.b = c1.a*c2.b+ c2.a*c1.a;
	return x;
}

}
