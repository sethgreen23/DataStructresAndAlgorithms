import java.util.EmptyStackException;

public class Stack {

	Player[] stack;
	int top;
	
	//constractor of the stack
	public Stack (int capacity) {
		stack = new Player[capacity];
	}
	
	//push a player to the stack
	public void push(Player p) {
		
		if(top==stack.length) {
			//resize the stack
			Player[] newArray = new Player[2 * stack.length];
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			stack = newArray;
		}
		
		stack[top++]=p;
	}
	
	//pop a player from the stack
	public Player pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		Player popedPlayer = stack[--top];
		stack[top]=null;
		//imagine we have array with 10 items and we resize it to 20 and eventuatualy
		//we resize the array to 40 then we poppd 30 items off the stack
		//now our sized 40 array have 10 items then we check if there is alot of
		//empty space we could consider resizing the array
		if((stack.length-top)>(3*top)) {
			Player[] newArray = new Player[top * 2];
			System.arraycopy(stack, 0, newArray, 0, newArray.length);
			stack = newArray;
		}
		return popedPlayer;
	}
	
	//peek the to element of the stack
	public Player peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return stack[top-1];
	}
	
	//check emptiness of the stack
	public boolean isEmpty() {
		return top == 0;
	}
	
	//print the stack
	public void print() {
		System.out.print("Head -> ");
		for(int i=top-1;i>=0;i--) {
			System.out.printf("%s -> ",stack[i]);
		}
		System.out.println("Null");
	}
	
	//check the size of the stack
	public int size() {
		return top;
	}
}
