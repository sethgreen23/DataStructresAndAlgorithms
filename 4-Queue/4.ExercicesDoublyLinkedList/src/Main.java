
public class Main {

	public static void main(String[] args) {
		ListQueue<String> nations = new ListQueue<String>();
		nations.add("FR");
		nations.print();
		nations.add("GB");
		nations.print();
		nations.add("IT");
		nations.print();
		nations.add("ARG");
		nations.print();
//		nations.reverse();
//		nations.print();
		System.out.println(nations.second());
		nations.print();
		System.out.println(nations.size());
		System.out.println(nations.removeSecond());
		nations.print();
		System.out.println(nations.size());
	}

}
