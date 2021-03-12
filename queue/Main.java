import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import entity.*;

public class Main {

	public static void main(String[] args) {
		var queue = new Queue<Integer>();

		try (var reader = new BufferedReader(new InputStreamReader(System.in))) {		
			for(var line = reader.readLine(); !"exit".equals(line); line = reader.readLine()) {					
	
				String action = line.startsWith("push ") 
							? line.substring(0, line.indexOf(" "))
							: line;
				switch (action) {
					case "size":
						System.out.println(queue.size());
						break;
					case "push":
						Integer val = Integer.valueOf(line.substring(line.indexOf(" ") + 1, line.length()));
						queue.push(val);
						System.out.println("ok");
						break;
					case "pop":
						System.out.println(queue.pop());
						break;
					case "clear":
						queue.clear();
						System.out.println("ok");
						break;
					case "front":
						System.out.println(queue.front());
						break;
					default:
						System.out.println("IDK this command. Type 'exit' to quit");
				}
			}

		System.out.println("bye");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
