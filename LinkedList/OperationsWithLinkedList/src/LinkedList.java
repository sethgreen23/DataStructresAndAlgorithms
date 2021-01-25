
public class LinkedList {

	private Node start;
	public LinkedList(int[] input) {
		createLinkedList( input);
	}
	
	
	//removeLast
	public void removeLast() {
		//iterate throw the list and when we reach p where its p.next = null
		if(start==null | start.next==null) {
			throw new  IllegalStateException("List need to contain at least two nodes!!");
		}
		Node p = start;
		
		while(p.next.next!=null) {
			p=p.next;
		}
		p.next=null;
		System.out.println(this.toString());
	}
	
	//create list from array
	private void createLinkedList(int[] input) {
		for(int i=0;i<input.length;i++) {
			start=insert(input[i]);
		}
		
	}
	
	//toString method
	public String toString() {
		String str = "{"+start.data;
		Node p = start;
		//we continue while the current node is different then null (end of linked list)
		while(p!=null) {
			//if p is on start we skip it
			if(p==start) {
				p=p.next;
				continue;
			}
			str+=", "+p.data;
			p=p.next;
		}
		str+="}";
		return str;
	}
	

	//insert method
	private Node insert(int x) {
		//if start next node is null or the data of the start node is >= then the value we want to insert
		if(start==null || start.data>=x) {
			start = new Node(x,start);
			return start;
		}
		//otherwise
		Node p= start;
		//we loop on the list till we catch a node where its next node is null (end of list) or its data is >= to the value we want to insert
		while(p.next!=null && p.next.data<x) {
			p=p.next;
		}
		//on that moment we attribute the next node of the current element to the node created and we attribute the the next node to the one created
		p.next=new Node(x,p.next);
		return start;
	}
	
	//size method
	public int size() {
		Node p = start;
		int size=0;
		//loop throw the list and count each node to get the size of the list
		while(p!=null) {
			size++;
			p=p.next;
		}
		return size;
	}
	
	//loop throw each nodes till you get to the last one which is null and save 
	//the value of each one in them in the sum variable
	public int sum() {
		Node p=start;
		int sum=0;
		while(p!=null) {
			sum+=p.data;
			p=p.next;
		}
		return sum;
	}
	
	//static class node
	static class Node{
		int data;
		Node next;
		
		Node (int data){
			this.data = data;
		}
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
}
