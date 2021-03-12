public class StackTest {

	public static void main(String[] arg) {
		
		var stack = new Stack<Integer>(2);
		System.out.printf("stack created with size 2, size: %d, stack: %s%n", stack.size(), stack.toString());
		
		stack.push(1);
		System.out.printf("pushed 1, size: %d, stack: %s%n", stack.size(), stack.toString());
		
		stack.push(2);
		System.out.printf("pushed 2, size: %d, stack: %s%n", stack.size(), stack.toString());
		
		stack.push(3);
		System.out.printf("pushed 3, size: %d, stack: %s%n", stack.size(), stack.toString());
		
		stack.push(4);
		System.out.printf("pushed 4, size: %d, stack: %s%n", stack.size(), stack.toString());
		
		System.out.printf("pop: %d, size: %d, stack: %s%n", stack.pop(), stack.size(), stack.toString());
		
		stack.push(10);	
		System.out.printf("pushed 10, size: %d, stack: %s%n", stack.size(), stack.toString());
	
		stack.clear();
		System.out.printf("stack is cleared, size: %d, stack: %s", stack.size(), stack.toString());	
	}	

}
