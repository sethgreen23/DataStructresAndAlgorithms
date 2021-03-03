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
		if(this.isZero()) {
			return new Polynomial(p);
		}else if(p.isZero()) {
			return new Polynomial(this);
		}
		
		Polynomial result = new Polynomial();
		
		ListIterator<Term> iterator = this.list.listIterator();
		ListIterator<Term> iteratorP = p.list.listIterator();
		
		while(iterator.hasNext() && iteratorP.hasNext()) {
			Term to = iterator.next();
			Term tp = iteratorP.next();
			
			if(to.exp>tp.exp) {
				result.list.add(new Term(tp));
				iterator.previous();
			}else if(to.exp<tp.exp) {
				result.list.add(new Term(to));
				iteratorP.previous();
			}else if(to.exp==tp.exp) {
				result.list.add(new Term(to.coef+tp.coef,to.exp));
			}
		}
		
		while(iterator.hasNext()) {
			result.list.add(new Term(iterator.next()));
		}
		while(iteratorP.hasNext()) {
			result.list.add(new Term(iteratorP.next()));
		}
		return result;
	}
	
	public String toString() {
		if(this.isZero())
			return String.valueOf(degree());
		
		ListIterator<Term> iterator = this.list.listIterator();
		StringBuilder result = new StringBuilder();
		while(iterator.hasNext()) {
			result.append(iterator.next());
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
		
		public String toString() {
			StringBuilder result = new StringBuilder();
				if(coef<0) {
					result.append(String.format(" - %.2f x^%d", -coef,exp));
				}else if(coef>0) {
					result.append(String.format(" + %.2f x^%d", coef,exp));
				}
				return result.toString();
		}
	}
	
}