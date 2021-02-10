
public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		Player jamesHarden = new Player("James","Harden",31);
		Player kevinDurant = new Player("Kevin","Durant",32);
		Player lebronJames = new Player("James","Lebron",36);
		Player stephCurry = new Player("Steph","Curry",32);
		
		stack.push(jamesHarden);
		stack.push(kevinDurant);
		stack.push(lebronJames);
		stack.push(stephCurry);
		
		stack.print();
		
		Player peekedNodeData = stack.peek();
		System.out.println("Data of the peeked Node : "+peekedNodeData);
		
		Player poppedNodeData = stack.pop();
		stack.print();
		System.out.println("Data of the popped Node : "+poppedNodeData);
		
		stack.push(new Player("Chaith","Dridi",34));
		stack.print();

	}

}
