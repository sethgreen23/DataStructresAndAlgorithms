import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		System.out.println(isPalandrom("i did, did i?"));
		System.out.println(isPalandrom("Top spot."));
		System.out.println(isPalandrom("helloolleh"));
		System.out.println(isPalandrom("im a nice guy."));
	}
	
	public static boolean isPalandrom(String str) {
		
		//take away all the punctuation and spaces
		str = str.replaceAll("[\s.!?\\-]", "").toLowerCase();
		Stack stack = new Stack();
		stack.pushWord(str);
		String first = reverse(stack);	
		return first.equals(str);
	}
	
	public static String reverse(Stack stack) {
		String first = "";
//		for(Iterator<Character> iterator = stack.iterator();iterator.hasNext();) {
//			first=first+iterator.next();
//		}
		while(!stack.isEmpty()) {
			first = first + stack.pop();
		}
		return first;
	}

}
