import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polynomial {

	List<Term> list = new LinkedList<>();
	public static final Polynomial ZERO = new Polynomial();
	
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
	
	public Polynomial(double ...a) {
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
		//if one of the polynomial are zero then the other  will be the result
		if(isZero()) {
			if(p.isZero()) {
				return "";
			}else {
				return p.print();
			}
		}else {
			if(p.isZero()) {
				return this.print();
			}else {
				return this.print(p);
			}
		}
	}
	
	private String print(Polynomial p) {
		StringBuilder result = new StringBuilder();
		ListIterator<Term> iteratorP = p.list.listIterator();
		ListIterator<Term> iterator = this.list.listIterator();
		
		while(iterator.hasNext() && iteratorP.hasNext()) {
			Term to = iterator.next();
			Term tp = iteratorP.next();
			if(to.exp>tp.exp) {
				result.append(tp);
				iterator.previous();
			}else if(to.exp<tp.exp) {
				result.append(to);
				iteratorP.previous();
			}else if(to.exp == tp.exp) {
				Term t = new Term(to.coef+tp.coef,to.exp);
				result.append(t);
			}
		}
		
		while(iterator.hasNext()) {
			result.append(iterator.next());
		}
		
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