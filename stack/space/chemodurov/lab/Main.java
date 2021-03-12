package space.chemodurov.lab;

import space.chemodurov.lab.entity.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		var stack = new Stack<Integer>();

		try (var reader = new BufferedReader(new InputStreamReader(System.in))) {		
			for(var line = reader.readLine(); !"exit".equals(line); line = reader.readLine()) {					
	
				String action = line.startsWith("push ") 
							? line.substring(0, line.indexOf(" "))
							: line;
				switch (action) {
					case "size":
						System.out.println(stack.size());
						break;
					case "push":
						Integer val = Integer.valueOf(line.substring(line.indexOf(" ") + 1, line.length()));
						stack.push(val);
						System.out.println("ok");
						break;
					case "pop":
						System.out.println(stack.pop());
						break;
					case "clear":
						stack.clear();
						System.out.println("ok");
						break;
					case "back":
						System.out.println(stack.back());
						break;
					case "to string":
						System.out.println(stack.toString());
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
