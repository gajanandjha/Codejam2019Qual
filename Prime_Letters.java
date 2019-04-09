import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Prime_Letters {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			br.readLine().trim();
			String[] str = br.readLine().trim().split("\\s+");
			BigInteger[] bi = new BigInteger[str.length];
			for(int i = 0; i < str.length; i++) {
				bi[i] = new BigInteger(str[i]);
			}
			BigInteger[] div = new BigInteger[str.length+1];
			for(int i = 0; i < str.length-1; i++) {
				if(bi[i].compareTo(bi[i+1]) != 0) {
					div[i+1] = bi[i+1].gcd(bi[i]);
					div[i] = bi[i].divide(div[i+1]);
					for(int j = i+1; j < str.length; j++) {
						div[j+1] = bi[j].divide(div[j]);
					}
					for(int j = i; j > 0; j--) {
						div[j-1] =bi[j-1].divide(div[j]);
					}
					break;
				}
			}
			
			String out = ",";
			for(int i = 0; i < str.length+1; i++) {
				out += div[i].toString(10) + ",";
			}

			ArrayList<BigInteger> ll = new ArrayList<>(Arrays.asList(div));
			BigInteger oldMin = Collections.min(ll);
			int val = 65;
			for(int i = 0; i < div.length; i++) {
				BigInteger min = Collections.min(ll);
				if(oldMin.compareTo(min) != 0) val++;
				out = out.replace("," + min + ",", "," + ((char)(val)) + ",");
				ll.remove(min);
				oldMin = min;
			}
			
			out = out.replace(",", "");
			System.out.println("Case #" + t + ": " + out);
		}
	}
}
