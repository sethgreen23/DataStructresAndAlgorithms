
public class List {
	
	public static void main(String[] args) {
		Node start=null ;
		start = createList(start,new int[]{25,19,6,3,12,35,4});
		toString(start);
		System.out.println(size(start));
		System.out.println(sum(start));
		removeLast(start);
		toString(start);
	}
	
	public static Node removeLast(Node start) {
		if(start==null || start.next==null) {
			throw new IllegalStateException("List needs to have two node at least!!!");
		}
		
		Node p = start;
		while(p.next.next!=null) {
			p=p.next;
		}
		p.next=null;
		return start;
	}
	
	//sum function
	public static int sum(Node start) {
		int sum=0;
		Node p = start;
		
		while(p!=null) {
			sum+=p.data;
			p=p.next;
		}
		return sum;
	}
	
	//size method
	public static int size(Node start) {
		int size = 0;
		Node p = start;
		
		while(p!=null) {
			size++;
			p=p.next;
		}
		return size;
		
	}
	//create list from array input
	public static Node createList(Node start,int[] input) {
		
		for(int i=0;i<input.length;i++) {
			start = insert(start,input[i]);
		}
		return start;
	}
	
	//print out the list
	public static void toString(Node start) {
		Node p = start;
		System.out.printf("{%s", start.data);
		while(p!=null) {
			if(p==start) {
				p=p.next;
				continue;
			}
					
			System.out.printf(", %s", p.data);
			p=p.next;
		}
		System.out.println("}");
	}
	
	//insert new nodes in the list
	private static Node insert(Node start,int x) {
		
		if(start==null || start.data>=x) {
			start = new Node(x,start);
			return start;
		}
		
		Node p = start;
		while(p.next!=null && p.next.data<=x) {
			p=p.next;
		}
		p.next = new Node(x,p.next);
		
		return start;
	}
	
	//static node class
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data,Node next) {
			this.data = data;
			this.next = next;
		}
		
			
	}

}
