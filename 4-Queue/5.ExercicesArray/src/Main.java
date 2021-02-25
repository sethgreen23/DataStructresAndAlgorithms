
public class Main {

	public static void main(String[] args) {
		ArrayQueue<String> nations = new ArrayQueue<String>();
		nations.add("FR");
		nations.add("GB");
		nations.add("GER");
		nations.remove();
		nations.remove();
		nations.add("HU");
		nations.add("USA");
		nations.print();
//		nations.reverse();
//		nations.print();
//		nations.remove();
//		System.out.println(nations.second());
//		nations.print();
		System.out.println(nations.removeSecond1()+"------------");
		nations.print();
		nations.add("URG");
		nations.print();
		System.out.println(nations.removeSecond1()+"------------");
		nations.print();
		System.out.println(nations.element());
		

	}
	


}
