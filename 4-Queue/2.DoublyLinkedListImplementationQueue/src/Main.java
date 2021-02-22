
public class Main {

	public static void main(String[] args) {
		ListQueue<String> nations = new ListQueue<String>();
		nations.add("FR");
		nations.add("GB");
		nations.add("HU");
		nations.add("USA");
		nations.add("GER");
		nations.add("NL");
		nations.print();
		System.out.println(nations.remove());
		nations.print();
	}

}
