import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polynomial {

	private LinkedList<Term> list = new LinkedList<Term>();
	public static final Polynomial ZERO = new Polynomial();
	
	private Polynomial() {
		
	}
	
	public Polynomial(Term t) {
		if(t.coef!=0) {
			list.add(new Term(t.coef,t.exp));
		}
	}
	
	public Polynomial(double[] a) {
		for(int i=0;i<a.length;i++) {
			list.add(new Term(a[i],i));
		}
	}
	
	public Polynomial(List<Double> l) {
		int i=0;
		Iterator<Double> iterator = l.iterator();
		while(iterator.hasNext()) {
			list.add(new Term(iterator.next(),i++));
		}
	}
	public Polynomial(Polynomial p) {
		Iterator<Term> iterator = p.list.iterator();
		while(iterator.hasNext()) {
			Term t = iterator.next();
			list.add(new Term(t.coef,t.exp));
		}
	}
	
	public boolean isZero() {
		return list.size()==0;
	}
	
	public int degree() {
		if(isZero()) {
			return 0;
		}else {
			return list.get(list.size()-1).exp;
		}
	}
	
	public Polynomial plus(Polynomial p) {
		if(this.isZero()) {
			return new Polynomial(p);
		}
		if(p.isZero()) {
			return new Polynomial(this);
		}
		ListIterator<Term> iterator = this.list.listIterator();
		ListIterator<Term> iterator1 = p.list.listIterator();
		Polynomial result = new Polynomial();
		while(iterator.hasNext() && iterator1.hasNext()) {
			Term t = iterator.next();
			Term tp = iterator1.next();
			if(t.exp>tp.exp) {
				result.list.add(new Term(tp.coef,tp.exp));
				iterator.previous();
			}else if(t.exp<tp.exp) {
				result.list.add(new Term(t.coef,t.exp));
				iterator1.previous();
			}else if(t.exp == tp.exp) {
				result.list.add(new Term(t.coef+tp.coef,t.exp));
			}
		}
		while(iterator.hasNext()) {
			Term t = iterator.next();
			result.list.add(new Term(t.coef,t.exp));
		}
		while(iterator1.hasNext()) {
			Term t = iterator1.next();
			result.list.add(new Term(t.coef,t.exp));
		}
		return result;
	}
	
	public String toString() {
		boolean firstTerm = true;
		StringBuilder result = new StringBuilder();
		Iterator<Term> it = this.list.iterator();
		while(it.hasNext()) {
			Term t = it.next();
			if(firstTerm) {
				result.append(t.coef);
				firstTerm = false;
			}else {
				if(t.coef>0) {
					result.append(String.format(" + %.2f" , t.coef));
				}else {
					result.append(String.format(" - %.2f", -t.coef));
				}
			}
			if(t.exp==0) {
				result.append("");
			}else if(t.exp==1) {
				result.append("x");
			}else {
				result.append(String.format("x^%d", t.exp));
			}
		}
		return result.toString();
	}
	
//	Write and test this method for the Polynomial class:
//		public double valueAt(double x)
//		// returns the y-value of p at the specified x-value
	public double valueAt(double x) {
		double result =0;
		Iterator<Term> it = this.list.iterator();
		while(it.hasNext()) {
			Term t = it.next();
			result+=Math.pow(x, t.exp)*t.coef;
		}
		return result;
	}
	
//	7.7 Write and test this method for the Polynomial class:
//		public Polynomial times(double factor)
//		// returns a new polynomial that is equal to this polynomial
	
	public Polynomial times(double factor) {
		if(factor == 0.0 || this.isZero()) {
			return ZERO;
		}
		Polynomial p = new Polynomial();
		Iterator<Term> t = this.list.iterator();
		while(t.hasNext()) {
			Term term = t.next();
			p.list.add(new Term(factor*term.coef,term.exp));
		}
		return p;
		
	}
	static class Term{
		double coef;
		int exp;
		
		Term(double coef,int exp){
			if(coef==0.0 || exp<0)
				throw new IllegalArgumentException();
			this.coef=coef;
			this.exp =exp;
		}
		Term(Term that){
			this(that.coef, that.exp);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = new double[] {2,-9,8,7,5};
		Polynomial p = new Polynomial(a);
		System.out.println("p : "+p);
		double[] a1 = new double[] {1,3,4};
		Polynomial p1 = new Polynomial(a1);
		System.out.println("p1 : "+p1);
		System.out.println("p+p1 : "+p.plus(p1));
		double[] a2 = new double[] {3,4,5};
		Polynomial p2 = new Polynomial(a2);
		System.out.println("p2 : "+p2);
		System.out.println("p2.valueAt(2) : "+p2.valueAt(2));
		System.out.println("p2.valueAt(2) : "+p2.valueAt(-3));
		System.out.println("p2 times 3 : "+p2.times(3));
	}

}

/**
 * OUTPUT
 * **/
/*
p : 2.0 - 9,00x + 8,00x^2 + 7,00x^3 + 5,00x^4
p1 : 1.0 + 3,00x + 4,00x^2
p+p1 : 3.0 - 6,00x + 12,00x^2 + 7,00x^3 + 5,00x^4
p2 : 3.0 + 4,00x + 5,00x^2
p2.valueAt(2) : 31.0
p2.valueAt(2) : 36.0
p2 times 3 : 9.0 + 12,00x + 15,00x^2
 */
