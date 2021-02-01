import java.util.Arrays;

public class List {
	
	public static void main(String[] args) {
		Node start=null ;
		Node init=null;
		//start = createList(start,new int[]{25,19,6,3,12,35,4});
		start = createList(start,new int[] {22, 33, 44, 55, 66, 77, 88, 99});
		//init = createList(init,new int[] {44, 77, 109, 129});
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
		/*sublist function*/
//		System.out.println("Show list elements");
//		toString(start);
//		Node init = sublist1(start,1,5);
//		System.out.println("Show sublist elements");
//		toString(init);
//		System.out.println("remove last element from  sublist");
//		removeLast(init);
//		toString(init);
//		System.out.println("Show list elements");
//		toString(start);
//		System.out.println("Show sublist elements");
//		toString(init);
		/*append function*/
//		toString(start);
//		toString(init);
//		append(start,init);
//		toString(start);
		/*concat function*/
//		toString(start);
//		toString(init);
//		Node newList = null;
//		newList =concat(start,init);
//		toString(newList);
//		System.out.println("remove last element from the starting list");
//		removeLast(start);
//		System.out.println("remove last element from the init list");
//		removeLast(init);
//		System.out.println("show all the list start, init and new List");
//		toString(start);
//		toString(init);
//		toString(newList);
		/*set function*/
//		toString(start);
//		set(start,2,50);
//		toString(start);
//		removeLast(start);
//		toString(start);
		/*get function*/
//		toString(start);
//		System.out.println(get(start,2));//44
		/*put function*/
//		toString(start);
//		start = put(start,0,11);
//		start = put(start,4,50);
//		toString(start);
		/*swap function*/
//		toString(start);
//		System.out.println("swap the element in index 1 with element in index 3");
//		swap1(start,1,3);
//		toString(start);
		/*merged funtion*/
//		toString(start);
//		toString(init);
//		Node newList=merged(start,init);
//		toString(newList);
//		System.out.println("remove last element form new list");
//		removeLast(newList);
//		System.out.println("show start , init and newlist");
//		toString(start);
//		toString(init);
//		toString(newList);
		/*rotateLeft funtion*/
//		toString(start);
//		start=rotateLeft(start);
//		toString(start);
		/*size1 function*/
		System.out.println(size1(start));
	}
	
	//size function
	public static int size1(Node start) {
		if(start==null)
			return 0;
		return size1(start.next)+1;
	}
	
	
//Write and test this method:
//	void rotateLeft(Node list)
//	// moves the first element of the specified list to its end;
//For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then rotateLeft(list) will
//change list to {33, 44, 55, 66, 77, 88, 99, 22}. Note that no new nodes are created by this
//method
	
	//my own implementation
	public static Node rotateLeft(Node start) {
		if(start == null || start.next==null) {
			throw new IllegalStateException();
		}
		Node nodeToRotate=new Node(start.data);
		start=start.next;
		Node parser=start;
		while(parser.next!=null)
			parser=parser.next;
		parser.next=nodeToRotate;
		return start;
	}
	
	
	
	
//Write and test this method:
//	Node merged(Node list1, Node list2)
//	// precondition: list1 and list2 are both in ascending order;
//// returns: a new list that contains all the elements of list1 and
//// list2 in ascending order;
//For example, if list1 is {22, 33, 55, 88} and list2 is {44, 66, 77, 99}, then
//merged(list1, list2) will return the new list {22, 33, 44, 55, 66, 77, 88, 99}. Note that
//the three lists should be completely independent of each other. Changing one list should have
//no effect upon the others
	public static Node merged(Node start, Node init) {
		//we start the parser for three lists
		Node p=start;
		Node q=init;
		Node newList = null;
		//we do prepare the head of the new list
		//if the data of the start is greater then the init then the new list take the init value otherwise the start value
		//we increment the one that we chosed for the head of the new list
		if(p.data>q.data) {
			newList = new Node(q.data);
			q=q.next;
		}else {
			newList = new Node(p.data);
			p=p.next;
		}
		//System.out.println(newList.data+" "+q.data+" "+p.data);
		//we prepare the parser of the new list
		Node parser = newList;
		//while the two current parsed nodes are not empty we continue parsing
		while(p!=null && q!=null) {
			//we chose the min between the two value of current nodes it will be the value of the parser.next
			//we increment the parser for the list that got the least value for the current objects
			if(p.data>=q.data) {
				parser.next=new Node(q.data);
				//System.out.print(" "+q.data);
				q=q.next;
			}else {
				parser.next=new Node(p.data);
				//System.out.print(" "+p.data);
				p=p.next;
			}
			//we increment the parser for the new list
			parser=parser.next;
		}
		//at the end we will check the last element to add to the new list
		if(p!=null) {
			parser.next=new Node(p.data);
		}else if(q!=null) {
			parser.next=new Node(q.data);
		}
		return  newList;
	}
	
//Write and test this method:
//	void swap(Node list, int i, int j)
//	// swaps the ith element with the jth element;
//For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then swap(list, 2, 5) will change
//list to {22, 33, 77, 55, 66, 44, 88, 99}
	//my idea is little bit clumsy but it works
	public static void swap(Node start, int a, int b) {
		Node parser=start;
		//create two int element to hold the values of the respective nodes
		int one, two;
		//go throw the list till we reach the a index
		for(int i=0;i<a;i++) {
			parser=parser.next;
		}
		//get the value in the a index
		one = parser.data;
		//parser the list from a index till b index
		for(int i=a;i<b;i++) {
			parser=parser.next;
		}
		//when we reach the b index we get the value inside of it
		two = parser.data;
		//System.out.println(one+" "+two);
		//we swap the two values
		int temp=one;
		one=two;
		two=temp;
		//System.out.println(one+" "+two);
		//we parser the list again till the index a 
		parser = start;
		for(int i=0;i<a;i++) {
			parser=parser.next;
		}
		//we put the second value in the first object
		parser.data=one;
		//we parser the list till the b index
		for(int i=a;i<b;i++) {
			parser=parser.next;
		}
		//we put the first value in the second object
		parser.data=two;
		//with this method we parser the 4 times the list in a linear time then it takes 4o(n) =o(n)
	}
	//the author idea
	public static void swap1(Node start, int a, int b) {
		Node p=start;
		Node q=start;
		//we parse the list till the a index
		for(int i=0;i<a;i++) {
			if(p==null) {
				throw new IllegalArgumentException();
			}
			p=p.next;
		}
		//we parse the list till the b index
		for(int i=0;i<b;i++) {
			if(q==null) {
				throw new IllegalArgumentException();
			}
			q=q.next;
		}
		//we get the object with there respective values and we do the swap of the values
		int pValue= p.data,qValue=q.data;
		p.data=qValue;
		q.data=pValue;
	}
	
//Write and test this method:
//	void put(Node list, int i, int x)
//	// inserts x as element number i;
//For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then put(list, 3, 50) will change
//list to {22, 33, 44, 50, 55, 66, 44, 88, 99}. Hint: if i = 0, replace the value of the first node
//with x, and insert a new node immediately after it that contains the previous fist value
	public static Node put(Node list, int i, int x) {
		//if the new element need to be inserted as the first element
		//we point the start to the newly created node and we link its next element to the start object
		if(i==0) {
			list= new Node(x,list);
			return list;
		}
		//otherwise we parse the list till we reach the node before the needed index
		Node parser = list;
		for(int j=0;j<i-1;j++) {
			parser = parser.next;
		}
		//we attribute the next reference of the before element to the newly created object 
		//and the next element of the newly created element to the next element of the before element
		//it is confusing at first but it will be clearer layer ;)
		parser.next=new Node(x,parser.next);
		return list;
	}
	
//Write and test this method:
//	int get(Node list, int i)
//	// returns the value of element number i;
//For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then get(list, 2) will return 44
	public static int get(Node list, int i) {
		//start the parser to the head of the list
		Node parser = list;
		//parser the list till we reach the desired node
		for(int j=0;j<i;j++) {
			parser=parser.next;
		}
		//return the data of the desired node
		return parser.data;
	}
	
//Write and test this method:
//	void set(Node list, int i, int x)
//	// replaces the value of element number i with x;
//For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then set(list, 2, 50) will change
//list to {22, 33, 50, 55, 66, 44, 88, 99}.
	
	public static void set(Node list, int i, int x) {
		//start node parser to the head of the list
		Node p =list;
		//parser the list till the appropriate index
		for(int j=0;j<i;j++) {
			p=p.next;
		}
		//change the data of that node on the approriate index to the desired value
		p.data=x;
		
	}
	
	
	
	
//Write and test this method:
//	Node concat(Node list1, Node list2)
//	// returns: a new list that contains a copy of list1, followed by
//// a copy of list2;
//For example, if list1 is {22, 33, 44, 55} and list2 is {66, 77, 88, 99}, then
//concat(list1, list2) will return the new list {22, 33, 44, 55, 44, 55, 66, 77, 88}. Note
//that the three lists should be completely independent of each other. Changing one list should
//have no effect upon the others
	
	public static Node concat(Node list1, Node list2) {
		Node p= list1;
		//save the head of the new list
		Node init=new Node(list1.data);
		//create a parser for the new list
		Node parser = init;
		//parse the first list and create new node that contains the data of each node from the start list
		while(p.next!=null) {
			parser.next= new Node(p.next.data);
			p=p.next;
			parser=parser.next;
		}
		//save the head of the second node 
		parser.next= new Node(list2.data);
		parser=parser.next;
		Node p1=list2;
		//parse the second list and create new node that contains the data of each node from the start list
		while(p1.next!=null) {
			parser.next=new Node(p1.next.data);
			p1=p1.next;
			parser=parser.next;
		}
		//return the head of the new list
		return init;
	}
	
//Write and test this method:
//	void append(Node list1, Node list2)
//	// precondition: list1 has at least one node;
//// postcondition: list1 has list2 appended to it;
//For example, if list1 is {22, 33, 44, 55} and list2 is {66, 77, 88, 99}, then
//append(list1, list2) will change list1 to {22, 33, 44, 55, 44, 55, 66, 77, 88}. Note that
//no new nodes are created by this method.
	public static void append(Node list1,Node list2) {
		//if the starting node is null or just one element
		if(list1==null || list1.next ==null) {
			throw new IllegalStateException("Node need to have at least one Node!!");
		}
		//otherwise we loop till we reach the last element then
		//on that time we attribute the next element of the last to the head of the second list
		Node p = list1;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=list2;
	}
	
	
	
	
//	Write and test this method:
//		Node sublist(Node list, int p, int q)
//		// returns: a new list that contains copies of the q-p nodes of the
//	// specified list, starting with node number p (starting with 0);
//	For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then sublist(list, 2, 7) will
//	return the new list {44, 55, 66, 77, 88}. Note that the two lists must be completely independent of each other. Changing one list should have no effect upon the other
	//version two complicated one
	public static Node sublist1(Node start, int p, int q) {
		//initialize the list index variable
		int i=0;
		//we stop two element before the q element 
		//because if we stop on element before we will write
		//the object of the last element and that we dont need it here
		q=q-1;
		//here the traker of the origin list
		Node nodeOne=start;
		//here the head of the sublist 
		Node nodeTwo=null;
		//we keep parsing the list till we reach the starting of the sublist
		while(i<q) {
			//if we reached the sublist
			if(i==p) {
				//save the head of the sublist in nodeTwo
				 nodeTwo=new Node(nodeOne.data);
				 //parser of the second node
				 Node parse=nodeTwo;
				 //while we didnt reach the before last element
				while(i<q) {
					//create a new object with the data of the next node obect and give it to the next node of the sublist parser
					parse.next = new Node(nodeOne.next.data);
					//System.out.println(i+" "+q+" inside the second loop"+parse.next.data);
					//increment the parsers of the list and sublist and the index
					nodeOne=nodeOne.next;
					parse = parse.next;
					i++;
				}
			}
			//do the parsing of the list and the traker while we didnt reach the beggining of the sublist
			nodeOne=nodeOne.next;
			i++;
		}
		
		return nodeTwo;
	}
	//version one less complicated
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

