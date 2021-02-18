
public class Main {

	public static void main(String[] args) {
		ListStack<String> nations = new ListStack<String>();
//		System.out.println("isEmpty: "+nations.isEmpty());
//		System.out.println("Size: "+nations.size());
		nations.push("FR");
		nations.push("GB");
		nations.push("USA");
		nations.push("RUS");
//		nations.print();
//		System.out.println("Peek: "+nations.peek());
//		System.out.println("Pop: "+nations.pop());
//		nations.print();
//		System.out.println("isEmpty: "+nations.isEmpty());
//		System.out.println("Size: "+nations.size());
		//16
//		nations.print();
//		nations.reverse();
//		nations.print();
		//18
//		nations.print();
//		System.out.println("Peek the second: "+nations.penultimate());
		//20
//		nations.print();
//		System.out.println("Remove Second: "+nations.popPenultimate());
//		nations.print();
		//22
//		nations.print();
//		System.out.println("Bottom: "+nations.bottom());
//		24
		nations.print();
		System.out.println("Bottom: "+nations.popBottom());
		nations.print();
		
	}

}
