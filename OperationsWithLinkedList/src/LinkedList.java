
public class LinkedList {

	private Node start;
	public LinkedList(int[] input) {
		createLinkedList( input);
	}
	
	
	
	private void createLinkedList(int[] input) {
		for(int i=0;i<input.length;i++) {
			start=insert(input[i]);
		}
		
	}

	public String toString() {
		String str = "{"+start.data;
		Node p = start;
		while(p!=null) {
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
	
	public void print() {
		Node p= start;
		while(p.next!=null) {
			System.out.println(p.data+",");
			p=p.next;
		}
		
		System.out.println("STart next data "+start.next.data);
	}

	private Node insert(int x) {
		if(start==null || start.data>=x) {
			start = new Node(x,start);
			return start;
		}
		
		Node p= start;
		while(p.next!=null && p.next.data<x) {
			p=p.next;
		}
		p.next=new Node(x,p.next);
		return start;
	}



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
