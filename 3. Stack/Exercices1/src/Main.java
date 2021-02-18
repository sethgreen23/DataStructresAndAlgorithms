
public class Main {

	public static void main(String[] args) {
		ArrayStack<String> nations = new ArrayStack<String>(1);
		nations.push("FR");
		nations.push("GB");
		nations.push("USA");
		nations.push("CA");
		nations.push("CHN");
//		nations.print();

//		System.out.println("Peek: "+nations.peek());
//		System.out.println("Size: "+nations.size());
//		System.out.println("Is it empty? "+nations.isEmpty());
//		String first = nations.pop();
//		nations.print();
//		System.out.println("Peek: "+nations.peek());
//		System.out.println("Size: "+nations.size());
		//15.
//		nations.reverse();
//		nations.print();
		//17
//		System.out.println("Peek the second: "+nations.penultimate());		
		//19
//		nations.print();
//		System.out.println("Size "+nations.size());
//		System.out.println("Pop the second: "+nations.popPenultimate());
//		nations.print();
//		System.out.println("Size "+nations.size());
//		//21
//		System.out.println("Bottom element: "+nations.bottom());
		//23
		nations.print();
		System.out.println("Removed first element: "+nations.popBottom());
		nations.print();
	}

}
