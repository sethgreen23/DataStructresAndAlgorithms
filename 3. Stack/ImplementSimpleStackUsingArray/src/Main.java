
public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		Player jamesHarden = new Player("James","Harden",31);
		Player kevinDurant = new Player("Kevin","Durant",32);
		Player lebronJames = new Player("James","Lebron",36);
		Player stephCurry = new Player("Steph","Curry",32);
		
		stack.push(jamesHarden);
		stack.push(kevinDurant);
		stack.push(lebronJames);
		stack.push(stephCurry);
		
		stack.print();
		
		Player peek = stack.peek();
		System.out.printf("First element in the stack: %s%n",peek);
		
		Player pop = stack.pop();
		stack.print();
		System.out.printf("First Element popped from the stack : %s%n",pop);
	}

}
