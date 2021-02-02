import java.util.ArrayList;
import java.util.List;

public class EmployeeLinkedList {

	private EmployeeNode start;
	static int size=0;
	public static void main(String[] args) {
		Employee michael = new Employee("Michael","Jackson",5);
		Employee mary = new Employee("Maria","Carey",15);
		Employee james = new Employee("James","Blunt",30);
		EmployeeLinkedList l = new EmployeeLinkedList();
		l.addFirst(james);
		l.addFirst(mary);
		l.addFirst(michael);
		
		l.print();
		System.out.println("Size of List : "+l.size());
		EmployeeNode em = l.deleteFromFirst();
		System.out.println("Deleted "+em);
		l.print();
		System.out.println("Size of List : "+l.size());
		Employee gorge = new Employee("Gorge","Michael",31);
		l.add(gorge);
		l.print();
	}
	
	public void addFirst(Employee e) {
		EmployeeNode node = new EmployeeNode(e);
		node.setNext(start);
		start=node;
		size++;
	}
	
	public void print() {
		EmployeeNode parse = start;
		System.out.print("Head -> ");
		while(parse!=null) {
			System.out.print(parse.getEmployee());
			System.out.print(" -> ");
			parse = parse.next;
		}
		System.out.println("null");
	}
	
	public EmployeeNode deleteFromFirst() {
		EmployeeNode node = start;
		start = start.next;
		node.setNext(null);
		size--;
		return node;
	}
	
	
	public int size() {
		return size;
	}
	
	public void add(Employee e) {
		EmployeeNode parse = start, prev=null;
		EmployeeNode element = new EmployeeNode(e);
		if(start.getEmployee().compareTo(e)==1) {
			element.setNext(start);
			start = element;
			return ;
		}
		
		//look at an element on advance that you can use the parse to insert the node
		//if it is null then insert the element before the null
		//if it is not then add the node after the previous and attribute the next of the previous to the next element
		while(parse.getNext()!=null && parse.getNext().getEmployee().compareTo(e)!=1) {
			parse = parse.next;
		}
			
		element.setNext(parse.next);
		parse.setNext(element);
			
		
	}
	
}
