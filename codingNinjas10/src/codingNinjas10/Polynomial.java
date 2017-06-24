package codingNinjas10;

public class Polynomial {
DynamicArray coefficients;
public int getCoefficient(int deg)
{	if(deg>coefficients.size())return 0;
	return coefficients.get(deg);
}
public Polynomial()
{
	coefficients = new DynamicArray();
}
public void setCoefficient(int deg,int coeff)
{
	int size = coefficients.size();
	for(int i=size;i<deg;++i)
		coefficients.add(0);
	coefficients.set(deg, coeff);
}
public int degree()
{
	for(int i = coefficients.size()-1;i>=1;i--){
		if(coefficients.get(i)!=0){
			return i;
		}
	}
		return 0;
}
public void print()
{	String s ="";
	for(int i=0;i<=this.degree();++i)
	{
		int coeff = this.getCoefficient(i);
		if(coeff!=0)s = s + coeff+"*"+"x^"+i+" + ";
	}
	s = s.substring(0,s.length()-2);
	System.out.println(s);
}
//function to add,multiply a polynomial
//to evaluate a polynomial
public void addition(Polynomial a)
{
	Polynomial p = new Polynomial();
	for(int i=0;i<=this.degree();++i)
		p.setCoefficient(i, this.getCoefficient(i));
	for(int i=0;i<=a.degree();++i)
		p.setCoefficient(i, p.getCoefficient(i)+a.getCoefficient(i));
	for(int i=0;i<=this.degree();++i)
		this.setCoefficient(i, 0);
	for(int i=0;i<p.degree();++i)
		this.setCoefficient(i, p.getCoefficient(i));
}

}

