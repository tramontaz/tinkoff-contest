import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import entity.*;

public class Main {

	public static void main(String[] args) {
		
		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {

		
			var line = reader.readLine();
			if(line == null || line.length() == 0) {
				say("no");
				return;
			}			
	
			var stack = new Stack<Character>(line.length());
			var i = 0;
			while(i != line.length()) {

				char bracket = line.charAt(i++);
				if(!isBracket(bracket)) {
					say("no");
					return;
				}

				if(isOpening(bracket)) {
					stack.push(bracket);
				} else {
					if(stack.size() == 0 || !isClosedCorrectly(stack.pop(), bracket)) {
						say("no");
						return;
					}
				}
			}

			if(stack.size() == 0) {
			 	say("yes");
			} else {
				say("no");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	private static void say(String s) {
		System.out.println(s);
	}
	
	private static boolean isBracket(char candidate) {
		return  '(' == candidate || '{' == candidate || '[' == candidate 
			|| ')' == candidate || '}' == candidate || ']' == candidate;
	}

	private static boolean isOpening(char bracket) {
		return '(' == bracket || '{' == bracket || '[' == bracket;
	}

	private static boolean isClosedCorrectly(char open, char close) {
		switch (close) {
			case '}':
				return '{' == open;
			case ']':
				return '[' == open;
			case ')':
				return '(' == open;
			default:
				return false;	
		}
	}
}
