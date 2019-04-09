import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easiest_Maze {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			char[] str = br.readLine().trim().toCharArray();
			StringBuffer out = new StringBuffer();
			for(int i = 0; i < str.length; i++) {
				if(str[i] == 'E') out.append("S");
				else out.append("E");
			}
			System.out.println("Case #" + t + ": " + out);
		}
	}
}
