
public class Main {

	public static void main(String[] args) {
		ArrayQueue<String> nations = new ArrayQueue<String>();
		nations.add("CA");
		nations.add("FR");
		nations.add("GB");
		nations.remove();
		nations.remove();
		nations.add("UK");
		nations.remove();
		nations.add("USA");
		nations.add("TN");
		nations.print();
		nations.add("HU");
		nations.print();
	}

}
