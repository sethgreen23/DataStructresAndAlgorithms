
public class Queue {
/*
	A queue is a waiting line. In computing, a queue is a linear data structure that allows insertions
	only at one end and deletions only at the other end. As a dynamic data structure, this embodies
	the first-in-first-out (FIFO) protocol. The most familiar use of the queue data structure is a print
	queue, which temporarily holds print jobs for a printer.
	The Queue interface was added to the JCF with Java 5.0. Reflecting the print queue prototype,
	the Javadoc states that a queue is a “collection designed for holding elements prior to processing.” It specifies five specialized methods in addition to the 15 methods specified by the
	Collection interface, overriding the add() method. (See Figure 4.10 on page 89.)
	The add() and offer() methods insert the specified element at the back of the queue. The
	only difference between them is their behavior when the queue is full: add() throws an
	unchecked exception, while offer() returns false.
	The element() and peek() methods return the element at the front of the queue. The only
	difference between them is their behavior when the queue is empty: element() throws a
	NoSuchElementException, while peek() returns null.
	The remove() and poll() methods delete and return the element at the front of the queue.
	The only difference between them is their behavior when the queue is empty: remove() throws a
	NoSuchElementException, while poll() returns null.
	The AbstractQueue class implements 5 of the 20 required methods of the Queue interface:
	add(), addAll(), clear(), element(), and remove(). The purpose of this class (as with all
	abstract classes) is to serve as a partial implementation, to be completed in a concrete extension by implementing the other required methods. The Javadoc for the AbstractQueue class
	states: “A Queue implementation that extends this class must minimally define a method
	Queue.offer(E) which does not permit insertion of null elements, along with methods
	Queue.peek(), Queue.poll(), Collection.size(), and a Collection.iterator()
	supporting Iterator.remove(). 
 */
}
