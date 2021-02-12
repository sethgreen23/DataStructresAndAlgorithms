
public class Main {

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		
		stack.push("GB");
		stack.push("FR");
		stack.push("USA");
		stack.push("CA");
		
		stack.print();
		System.out.println("Peek() the top element :"+stack.peek());
		System.out.println(stack.size());
		System.out.println("Poop() the top element :"+stack.pop());
		stack.print();
		System.out.println("size :"+stack.size());
		System.out.println("Peek() the top element :"+stack.peek());
		stack.print();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.print();
	}

}

//output:

//CA => USA => FR => GB
//Peek() the top element :CA
//4
//Poop() the top element :CA
//USA => FR => GB
//size :3
//Peek() the top element :USA
//USA => FR => GB
//USA
//FR
//GB
//The Stack is Empty!!