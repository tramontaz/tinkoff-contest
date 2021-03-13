import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class Heist {

	private static final String SPACE = " ";

	public static void main(String[] args) {
		
		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			var remain = Integer.parseInt(reader.readLine());
			String[] keyboards = reader.readLine().split(SPACE);
			
			int min = Integer.parseInt(keyboards[0]);
			int max = min;

			for(int i = 1; i < keyboards.length; i++) {
				var inventoryNumber = Integer.parseInt(keyboards[i]);
				max = inventoryNumber > max ? inventoryNumber : max;
				min = inventoryNumber < min ? inventoryNumber : min;
			}

			System.out.println(max - min + 1 - remain);	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
