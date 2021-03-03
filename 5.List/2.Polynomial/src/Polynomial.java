import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polynomial {

	List<Term> list = new LinkedList<>();
	public static final Polynomial ZERO = new Polynomial();
	//this is for ZERO instantiation
	private Polynomial() {
	}
	
	public Polynomial(Term t) {
		list.add(t);
	}
	
	public Polynomial(double coef, int exp) {
		if(coef!=0) {
			list.add(new Term(coef, exp));
		}
	}
	
	public Polynomial(Polynomial p) {
		for(Term t : p.list) {
			if(t.coef!=0) {
				this.list.add(t);
			}
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
	public Polynomial(List<Term> t) {
		Iterator<Term> iterator = t.iterator();
		while(iterator.hasNext()) {
			this.list.add(iterator.next());
			
		}
	}
	public boolean isZero() {
		return this.equals(ZERO);
	}
	
	public String plus(Polynomial p) {
		
		if(isZero()) {
			if(p.isZero()) {
				//if the two polynomes are zeroes
				return "";
			}else {
				//if the explicite argement is not zero and the implecite one is zero
				return p.print();
			}
		}else {
			
			if(p.isZero()) {
				//if the implicite one is not zero and the explicite one is zero
				return this.print();
			}else {
				//if the implicite one is not zero and the explicite one is not zero
				return this.print(p);
			}
		}
	}
	
	private String print(Polynomial p) {
		//prepare the string builder to get results
		StringBuilder result = new StringBuilder();
		//prepare the iterator to parse the lists of the lists of polynomials
		ListIterator<Term> iteratorP = p.list.listIterator();
		ListIterator<Term> iterator = this.list.listIterator();
		//we parse the polynomials till one of the has no elements
		while(iterator.hasNext() && iteratorP.hasNext()) {
			Term to = iterator.next();
			Term tp = iteratorP.next();
			// if the exponent of the current implicit term is greater the the one of the explicit one
			//we append the one of explicit term with least exponent and we previous the iterator of the implicit iterator
			if(to.exp>tp.exp) {
				result.append(tp);
				iterator.previous();
				// if the exponent of the current explicit term is greater the the one of the implicit term
				//we append the one of implicit term with least exponent and we previous the iterator of the explicit iterator
			}else if(to.exp<tp.exp) {
				result.append(to);
				iteratorP.previous();
			}else if(to.exp == tp.exp) {
				//if the exponent are equal for boths then we add the coefficients and we put the shared exponent
				Term t = new Term(to.coef+tp.coef,to.exp);
				result.append(t);
			}
		}
		
		//here we make sure that the implicit polynomial has extra terms
		while(iterator.hasNext()) {
			result.append(iterator.next());
		}
		//here we make sure that the explicit polynomial has extra terms
		while(iteratorP.hasNext()) {
			result.append(iteratorP.next());
		}
		return result.toString();
		
		
	}
	public String print() {
		Iterator<Term> iterator = this.list.iterator();
		StringBuilder result = new StringBuilder();
		while(iterator.hasNext()) {
			Term t = iterator.next();
			result.append(t);
		}
		return result.toString();
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}
	
	//we compare there lists emptiness
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polynomial other = (Polynomial) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
}