public class ArrListTest {
	public static void main(String[] args) {
	
		var list = new ArrList<Integer>(2);
		list.add(1);
		list.add(2);
		
		System.out.println(list.toString());
		
		list.add(3);
		System.out.println(list.toString());
		
		list.add(4);
		System.out.println(list.toString());
		
		list.add(5);
		System.out.println(list.toString());
		System.out.println("length: " + list.getLength());		
		
		System.out.println(list.get(4));
		System.out.println(list.get(5));
		System.out.println(list.get(6));
		
					
	}
}
