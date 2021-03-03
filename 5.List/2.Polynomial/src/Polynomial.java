import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polynomial {

	//using composition here other the extending List class
	private List<Term> list = new LinkedList<>();
	public static final Polynomial ZERO = new Polynomial();
	//this is for ZERO instantiation
	private Polynomial() {
	}
	
	public Polynomial(Term t) {
		if(t.coef!=0)
			list.add(new Term(t));
	}
	
	public Polynomial(double coef, int exp) {
		if(coef!=0) {
			list.add(new Term(coef, exp));
		}
	}
	
	public Polynomial(Polynomial p) {
		for(Term t : p.list) {
			if(t.coef!=0) {
				this.list.add(new Term(t));
			}
		}
	}
	public int degree() {
		if(list.isEmpty()) {
			return -1;
		}else {
			return list.get(list.size()-1).exp;
		}
	}
	
	public Polynomial(double[]a) { //we can use Polynomial(double ... a) same thing with quite a little difference because the second one accept empty array
		for(int i=0;i<a.length;i++) {
			double element = a[i];
			if(element!=0) {
				this.list.add(new Term(element,i));
			}
		}
	}
	public Polynomial(List<Integer> t) {
		Iterator<Integer> iterator = t.iterator();
		int i=0;
		while(iterator.hasNext()) {
			this.list.add(new Term(iterator.next(),i++));
			
		}
	}
	public boolean isZero() {
		return this.list.isEmpty();
	}
	
	
	public Polynomial plus(Polynomial p) {
		//if the implicit argument is zero
		if(this.isZero()) {
			return new Polynomial(p);
		}else if(p.isZero()) {//if the explicit argument is zero
			return new Polynomial(this);
		}
		//prepare a polynom that will hold the result polynom
		Polynomial result = new Polynomial();
		//prepare the polynoms iterators
		ListIterator<Term> iterator = this.list.listIterator();
		ListIterator<Term> iteratorP = p.list.listIterator();
		//while we have still elements in both iterators
		while(iterator.hasNext() && iteratorP.hasNext()) {
			Term to = iterator.next();
			Term tp = iteratorP.next();
			
			//if the implicit term exponenet is gretter the the explicit
			//add the explicit and back the implicit iterator
			if(to.exp>tp.exp) {
				result.list.add(new Term(tp));
				iterator.previous();
			}else if(to.exp<tp.exp) {//if the explicit term exponenet is gretter the the implicit
									//add the implicit and back the explicit iterator
				result.list.add(new Term(to));
				iteratorP.previous();
			}else if(to.exp==tp.exp) {//if they are equal sum the two coeficent and and the shared exponenet
				result.list.add(new Term(to.coef+tp.coef,to.exp));
			}
		}
		//make sure the implicit iterator has element still
		while(iterator.hasNext()) {
			result.list.add(new Term(iterator.next()));
		}
		//make sure the explicit iterator has elements still
		while(iteratorP.hasNext()) {
			result.list.add(new Term(iteratorP.next()));
		}
		return result;
	}
	
	public String toString() {
		//if the polynom is zero then restun its degree "0"
		if(this.isZero())
			return String.valueOf(degree());
		//prepare the singly linked iterator
		Iterator<Term> iterator = this.list.iterator();
		StringBuilder result = new StringBuilder();
		boolean firstElement = true;
		while(iterator.hasNext()) {
			Term t = iterator.next();
			//if we reach the first element
			if(firstElement) {
				result.append(String.format("%.2f", t.coef));
				firstElement = false;
			}else {
				//if we are not on the first element
				//check the display for the coeficient
				if(t.coef>0) {
					result.append(String.format(" + %.2f", t.coef));
				}else {
					result.append(String.format(" - %.2f", -t.coef));
				}	
			}
			int e = t.exp;
			//check the display for the exponenet
			if(e==0) {
				result.append(String.format("",e ));
			}else if(e==1) {
				result.append(String.format("x", e));
			}else if(e>1) {
				result.append(String.format("x^%d",e));
			}
		}
		return result.toString();
	}
	
	//use Term class as static inside the polynomial class
	public static class Term{
		double coef;
		int exp;
		
		Term(double coef, int exp){
			if(coef == 0.0 || exp < 0)
				throw new IllegalArgumentException();
			this.coef = coef;
			this.exp = exp;
		}
		Term(Term that){
			this(that.coef,that.exp);
		}
		
		/*
		public String toString() {
			StringBuilder result = new StringBuilder();
				if(coef<0) {
					result.append(String.format(" - %.2f x^%d", -coef,exp));
				}else if(coef>0) {
					result.append(String.format(" + %.2f x^%d", coef,exp));
				}
				return result.toString();
		}
		*/
	}
	
}