
public class Main {

	public static void main(String[] args) {
		Pair<Month,Integer> christmas = new Pair<Month,Integer>(Month.DEC,25);
		System.out.printf("Month : %s%n",christmas.getFirst());
		System.out.printf("Day : %s%n",christmas.getSecond());
		
		System.out.printf("Christmas is in %s %s%n", christmas.getFirst(),christmas.getSecond());

	}

}
