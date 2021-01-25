
public class List {
	
	public static void main(String[] args) {
		Node start=null ;
		start = createList(start,new int[]{25,19,6,3,12,35,4});
		//toString(start);
		//System.out.println(size(start));
		//System.out.println(sum(start));
		//removeLast(start);
		//toString(start);
		Node init = copy(start);
		toString(start);
		System.out.println("remove last element from the start list");
		removeLast(start);
		removeLast(start);
		toString(start);
		System.out.println("Print out the elements of the init list");
		toString(init);
	}
	
	public static Node copy(Node start) {
		//make sure the list doesnt contain 1 or 0 elements
		if(start==null || start.next==null) {
			throw new IllegalStateException("List has to contain at least two nodes");
		}
		Node init = new Node(start.data);
		// here we put p.next!=null it means we need to make sure that the next element of the current element is not null
		//like that we dont have to write on its next element of the newely created one
		for(Node p = start,q=init;p.next!=null;p=p.next,q=q.next) {
			q.next=new Node(p.next.data);
		}
		
		return init;
	}
	
	public static Node removeLast(Node start) {
		if(start==null || start.next==null) {
			throw new IllegalStateException("List needs to have two node at least!!!");
		}
		
		//we need to make sure that we stop one node before the last node
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
