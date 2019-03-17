package programs.general.formulas;

public class FindDGCD
    {
	private int findGcd(int divisor,int dividend) {
	    if(divisor%dividend==0)
		return dividend;
	    else
		return findGcd(dividend, divisor%dividend);
	    
	}
	public static void main(String[] args)
	    {
		FindDGCD gcd=new FindDGCD();
		System.out.println(gcd.findGcd(40, 80));
	    }
    }
