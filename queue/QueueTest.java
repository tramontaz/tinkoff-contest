import entity.*;

public class QueueTest {
	public static void main(String[] args) {

		var queue = new Queue<Integer>();
		say("queue is created. size: " + queue.size());

		
		queue.push(1);
		queue.push(2);
		queue.push(3);

		say("added 1, 2 and 3. Size: " + queue.size());

		say("pop element: " + queue.pop() + " , size: " + queue.size());
		say("front element: " + queue.front() + " , size: " + queue.size());

		queue.push(4);
		queue.push(5);

		say("added 4 and 5. Size: " + queue.size());
		
		say("front element: " + queue.front() + " , size: " + queue.size());
		
		say("pop element: " + queue.pop() + " , size: " + queue.size());
		say("pop element: " + queue.pop() + " , size: " + queue.size());
		say("pop element: " + queue.pop() + " , size: " + queue.size());
		say("pop element: " + queue.pop() + " , size: " + queue.size());

		say("front element from empty queue. Should be an runtime exception: " + queue.front() + " , size: " + queue.size());
		
	}

	private static void say(String s) {
		System.out.println(s);
	}
}
