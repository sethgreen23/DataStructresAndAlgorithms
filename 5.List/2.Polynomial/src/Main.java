import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		double[] poly = new double[] {5,2,4,8};
		Polynomial p = new Polynomial(poly);
		System.out.println("p: "+p);
		List<Integer> l= new ArrayList<>();
		l.add(2);
		l.add(-8);
		l.add(4);
		l.add(7);
		Polynomial p1 = new Polynomial(l);
		System.out.println("p1: "+p1);
		System.out.println("p + p1 :"+p.plus(p1));
		Polynomial p3=Polynomial.ZERO;
		System.out.println("p3 :"+p3);
		System.out.println("p + p3 :"+p.plus(p3));
		System.out.println("p3 + p1 :"+p3.plus(p1));
	}

}

/*output*/
/*
p:  + 5,00 x^0 + 2,00 x^1 + 4,00 x^2 + 8,00 x^3
p1:  + 2,00 x^0 - 8,00 x^1 + 4,00 x^2 + 7,00 x^3
p + p1 : + 7,00 x^0 - 6,00 x^1 + 8,00 x^2 + 15,00 x^3
p3 :-1
p + p3 : + 5,00 x^0 + 2,00 x^1 + 4,00 x^2 + 8,00 x^3
p3 + p1 : + 2,00 x^0 - 8,00 x^1 + 4,00 x^2 + 7,00 x^3
 */