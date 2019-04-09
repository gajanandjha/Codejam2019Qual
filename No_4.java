import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			String orig = br.readLine().trim();
			StringBuffer n = new StringBuffer(orig);
			//int b = 0;
			for(int i = n.length()-1; i >= 0; i--) {
				if(n.charAt(i) == '4') {
					n.setCharAt(i, '3');
					//b += (int) Math.pow(10, n.length()-i-1);
				}
			}
			System.out.println("Case #" + t + ": " + n.toString() + " " + (new BigInteger(orig).subtract(new BigInteger(n.toString()))).toString(10));
		}
	}
}
