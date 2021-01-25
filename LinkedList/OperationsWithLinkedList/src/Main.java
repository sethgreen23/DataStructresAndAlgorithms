
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList(new int[] {33,10,25,31,9,2,56,45});
		System.out.println(l);
//		System.out.println(l.size());
//		System.out.println(l.sum());
		//l.removeLast();
		LinkedList l1=l.copy();
		
		System.out.println("operation of removing last element on l list");
		l.removeLast();
		System.out.println("Print the l1 list that i didnt do anything to it");
		System.out.println(l1);
	}

}
