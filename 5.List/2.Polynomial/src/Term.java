public class Term{
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