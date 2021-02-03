
public class DoublyLinkedList {
	public EmployeeNode head;
	public EmployeeNode tail;
	
	
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
		
		l.printFromEnd();
		l.printFromFront();
	}

	//insert in front
	void insertInFront(Employee e) {
		if(head!=null) {
			EmployeeNode node = new EmployeeNode(e);
			node.setNext(head);
			head.setPrev(node);
			if(head.getNext()==null)
				head.setNext(tail);
			head=node;
		}else {
			EmployeeNode node = new EmployeeNode(e);
			head=node;
			if(head.getNext()==null)
				head.setNext(tail);
			return;
		}
	}
	
	
	void insertAtEnd(Employee e) {
		if(tail!=null) {
			EmployeeNode node = new EmployeeNode(e);
			node.setPrev(tail);
			if(tail.getPrev()==null)
				tail.setPrev(head);
			tail.setNext(node);
			tail=node;
			}else {
				EmployeeNode node = new EmployeeNode(e);
				tail=node;
				if(tail.getPrev()==null)
					tail.setPrev(head);
				return;
			}
		}
	
	
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
