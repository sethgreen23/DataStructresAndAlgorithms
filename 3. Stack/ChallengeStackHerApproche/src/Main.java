import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		System.out.println(isPalandrom("i did, did i?"));
		System.out.println(isPalandrom("Iam a nice guy!!"));
		System.out.println(isPalandrom("stots"));
		System.out.println(isPalandrom("Deed"));
		System.out.println(isPalandrom("Top spot!"));

	}
	
	public static boolean isPalandrom(String str) {
		
		//clean up the string from punctuation and spaces
		//add the caracter the stack and to the string for ulter comparison
		LinkedList<Character> stack = new LinkedList<Character>();
		StringBuilder normal = new StringBuilder(str.length());
		str = str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>='a' && c<='z') {
				normal.append(c);
				stack.push(c);
			}
		}
		//make the reverse word
		StringBuilder reversedWord =new StringBuilder(str.length());
		while(!stack.isEmpty()) {
			reversedWord.append(stack.pop());
		}
		//look at the equality of the two words;
		return normal.toString().equals(reversedWord.toString());
	}

}
