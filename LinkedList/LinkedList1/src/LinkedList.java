import java.util.Scanner;

public class LinkedList {
	static enum UserStatus {
		EXIT, START
	};

	static Scanner sn = new Scanner(System.in);
	private Node start;

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
//		l.createList();
//		l.start = l.insert(21);
//		l.print();
//		l.start = l.insert(35);
		System.out.println("-------Welcome to the LinkedList Made by hand-------\n");
		String input;
		UserStatus user = UserStatus.START;
		while (user != UserStatus.EXIT) {
			System.out.println("Please Make a choice :INSERT,DELETE,EXIT,PRINT");
			input = sn.nextLine();
			int value;
			switch (input.toLowerCase()) {
			case "insert":
				System.out.println("Please enter a value: ");
				value = Integer.parseInt(sn.nextLine());
				l.insert(value);
				l.print();
				break;
			case "delete":
				l.print();
				System.out.println("Please which element you want to delete: ");
				value = Integer.parseInt(sn.nextLine());
				l.delete(value);
				l.print();
				break;
			case "exit":
				user = UserStatus.EXIT;
				break;
			case "print":
				l.print();
				break;
			default:
				System.out.println("Please write the choices in the list below!!\n");
				break;
			}
		}
		System.out.println("Thank you for using our application we appreciate it ;)");

	}


//	public void createList() {
//		start = new Node(22,start);
//		Node p = start;
//		for(int i=0;i<2;i++) {
//			p=p.next = new Node(33+11*i,p.next);
//		}
//		print();
//	}
	public void print() {
		Node p = start;
		System.out.println("--------------------");
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
		System.out.println("--------------------");
	}

	public Node insert(int x) {
		if (start == null || start.data > x) {
			start = new Node(x, start);
			return start;
		}
		Node p = start;
		while (p.next != null) {
			if (p.next.data > x) {
				break;
			}
			p = p.next;
		}
		p.next = new Node(x, p.next);
		return start;
	}

	private Node delete(int value) {
		if(start.data == value) {
			start=start.next;
			return start;
		}
		Node p = start;
		while(p!=null) {
			if(p.next.data==value) {
				Node q = p.next;
				p.next=q.next;
				break;
			}
			p=p.next;
		}
		return start;
	}
	static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
