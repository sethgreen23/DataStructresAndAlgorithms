import java.util.Arrays;

public class List {
	
	public static void main(String[] args) {
		Node start=null ;
		start = createList(start,new int[]{25,19,6,3,12,35,4});
//		toString(start);
		/*size function*/
//		System.out.println(size(start));
		/*sum function*/
//		System.out.println(sum(start));
		/*removeLast function*/
//		removeLast(start);
//		toString(start);
		/*copy function*/
//		Node init = copy(start);
//		toString(start);
//		System.out.println("remove last element from the start list");
//		removeLast(start);
//		removeLast(start);
//		toString(start);
//		System.out.println("Print out the elements of the init list");
//		toString(init);
		/*size function*/
		toString(start);
		Node init = sublist(start,1,5);
		toString(init);
		removeLast(init);
		toString(start);
		toString(init);
		
	}
	
	
//	Write and test this method:
//		Node sublist(Node list, int p, int q)
//		// returns: a new list that contains copies of the q-p nodes of the
//	// specified list, starting with node number p (starting with 0);
//	For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then sublist(list, 2, 7) will
//	return the new list {44, 55, 66, 77, 88}. Note that the two lists must be completely independent of each other. Changing one list should have no effect upon the other
	
	public static Node sublist(Node start, int p, int q) {
		int[] input = getElements(start,p,q);
		Node init=null;
		init=createList(init,input);
		return init;
	}
	
	private static int[] getElements(Node start, int p, int q) {
		int[] input = new int[q-p];
		int i=0,j=0;
		Node init = start;
		while(init.next!=null) {
			if(i>=p && i<q) {
				input[j++]=init.data;
			}
			i++;
			init = init.next;
		}
		return input;
	}	


	//copy function
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
