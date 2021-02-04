
public class DoublyLinkedList {
	public EmployeeNode head;
	public EmployeeNode tail;
	public static int size=0;
	
	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		
		Employee e = new Employee("James","Harden",1);
		Employee e1 = new Employee("Steph","Curry",2);
		Employee e2 = new Employee("Kevin","Durant",3);
		Employee e3 = new Employee("Michael","Jordan",4);
		Employee e4 = new Employee("Mahmoud","Abdul-Rauf",5);
		Employee e5 = new Employee("Jusuf","Nurkic",6);
		
		l.insertAtEnd(e);
		l.insertInFront(e1);
		l.insertAtEnd(e2);
		l.insertInFront(e3);
		l.insertAtEnd(e4);
		l.insertInFront(e5);
		
		System.out.println("Print From End: ");
		l.printFromEnd();
		System.out.println("Print From Front: ");
		l.printFromFront();
		System.out.println("Head : "+ l.head);
		System.out.println("Tail : "+l.tail);
		System.out.println("Delete From Front: ");
		EmployeeNode removed=l.deleteInFront();
		System.out.println("Removed Item From Front: "+removed);
		l.printFromFront();
		System.out.println("Delete From End: ");
		removed=l.deleteFromEnd();
		System.out.println("Removed Item From End: "+removed);
		l.printFromFront();
		
	}
	
	//delete From end
	EmployeeNode deleteFromEnd() {
		//assign tail to the node we want to remove
		EmployeeNode removedNode=tail;
		//set the next node of the previous node of tail to the next node of tail
		tail.getPrev().setNext(tail.getNext());
		//the previous node to tail become tail
		tail=tail.getPrev();
		//we reset the next and previous fields of the removed node to null 
		//it will be more easier to the garbage collector to get rid of
		removedNode.setNext(null);
		removedNode.setPrev(null);
		size--;
		System.out.println("The size of the list: "+size);
		return removedNode;
	}
	
	//delete in front
	//same midset of the method deleteFromEnd
	EmployeeNode deleteInFront() {
		EmployeeNode removedNode=head;
		head.getNext().setPrev(head.getPrev());
		head=head.getNext();
		removedNode.setNext(null);
		removedNode.setPrev(null);
		size--;
		System.out.println("The size of the list: "+size);
		return removedNode;
	}
	
	
	//insert in front
	void insertInFront(Employee e) {
		//if the head is not null
		if(head!=null) {
			//create node to hold the employee object
			EmployeeNode node = new EmployeeNode(e);
			//set the next field of the node to the head node
			node.setNext(head);
			//set the previous node of head to the node we want to insert
			head.setPrev(node);
			//if the next node of head is null then we assign the tail to it
			if(head.getNext()==null)
				head.setNext(tail);
			//the inserted node become the head
			head=node;
		}else {//if the head is null
			//create a node to hold the employee node
			EmployeeNode node = new EmployeeNode(e);
			//the new inserted node become the head
			head=node;
			//set the next node of the head to tail
			head.setNext(tail);
		}
		size++;
		System.out.println("The size of the list: "+size);
	}
	
	//insert at end
	//same mindset of the insertInFront
	void insertAtEnd(Employee e) {
		if(tail!=null) {
			EmployeeNode node = new EmployeeNode(e);
			node.setPrev(tail);
			tail.setNext(node);
			if(tail.getPrev()==null)
				tail.setPrev(head);
			tail=node;
		}else {
			EmployeeNode node = new EmployeeNode(e);
			tail=node;
			tail.setPrev(head);
		}
		size++;
		System.out.println("The size of the list: "+size);
	}
	
	//print from front
	void printFromFront() {
		EmployeeNode parser=head;
		System.out.print("null -> Head :");
		while(parser!=null) {
			if(parser.getNext()!=null) {
				System.out.print(parser.getEmployee()+" -> ");
			}else {
				System.out.print(parser.getEmployee()+" ");
			}
			
			parser = parser.getNext();
		}
		System.out.print(":Tail -> null");
		System.out.println();
	}
	
	//print from end
	void printFromEnd() {
		EmployeeNode parser=tail;
		System.out.print("null -> Tail: ");
		while(parser!=null) {
			if(parser.getPrev()!=null) {
				System.out.print(parser.getEmployee()+" -> ");				
			}else {
				System.out.print(parser.getEmployee()+" ");
			}
			parser = parser.getPrev();
		}
		System.out.print(":Head -> null");
		System.out.println();
	}
}
