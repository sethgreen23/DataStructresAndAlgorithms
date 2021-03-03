import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList l = new LinkedList();
//		loadRandomLetters(l,10);
//		System.out.println(l);
		
		LinkedList l = new LinkedList();
		l.add("BR");
		l.add(8);
		l.add(3.5);
		l.add(true);
//		print(l);
		printReverse(l);
	}

//	7.1 Implement the following method:
//		public static void loadRandomLetters(LinkedList list, int n)
//		// fills list with n randomly generated capital letters
	public static void loadRandomLetters(LinkedList list,int n) {
		for(int i=0;i<n;i++) {
			list.add(randomLetter1());
		}
	}
	public static char randomLetter() {
		int index = (int)(Math.random()*26);
		return "ABCDEFGHIJIKLMNOBQRSTUVWXYZ".charAt(index);
	}
	
	public static char randomLetter1() {
		return (char)('A'+((int)(Math.random()*26)));
	}
	
//	7.2 Write a method that uses an iterator to print the contents of a linked list, one object per line.
	public static void print(LinkedList l) {
		ListIterator iterator = l.listIterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
	
//	7.3 Write a method that uses an iterator to print the contents of a linked list in reverse order, one
//	object per line.
	public static void printReverse(LinkedList l) {
		ListIterator iterator = l.listIterator(l.size());
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
	}
}
