 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store_Bits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			String[] nbf = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nbf[0]);
			int b = Integer.parseInt(nbf[1]);
			int f = Integer.parseInt(nbf[2]);
			List<Integer> arr = new ArrayList<Integer>();
			char[] inp1 = new char[n];
			int iter = 0;
			if(n > 16) iter = 16;
			else if (n > 8) iter = 8;
			else if(n > 4) iter = 4;
			else if(n > 2) iter = 2;
			else iter = 1;
			Map<String, Integer> map1 = new HashMap<>();
			for(int i = 0; i < n; i+=iter*2) {
				map1.put(i + "," + Math.min(i+(iter*2)-1, n), 0);
			}
			char[] inp2 = new char[n];
			for(int i = 0; i < n; i++) inp2[i] = (char)(((i/16)%2)+48);
			System.out.println(new String(inp1));
			char[] out2 = br.readLine().trim().toCharArray();
			Map<String, Integer> map2 = new HashMap<>();
			int currDefunct = 0;
			for(Map.Entry<String, Integer> entry : map1.entrySet()) {
				String[] sten = entry.getKey().split(",");
				int st = Integer.parseInt(sten[0]);
				int en = Integer.parseInt(sten[1]);
				int ones = 0, zeros = 0;
				for(int i = st - currDefunct; i <= en - (currDefunct + entry.getValue()); i++) {
					if(out2[i] == '0') zeros++; else ones++;
				}

				if((st/16)%2 == 0) {
					if(zeros == 0) {
						for(int i = 0; i < Math.min(16, n-st); i++) arr.add(i + currDefunct);
					} else if(zeros < Math.min(16, n-st)) {
						map2.put(st + "," + (st+Math.min(16, n-st)-1), Math.min(16, n-st)-zeros);
					}
					if(ones == 0) {
						for(int i = 0; i < Math.min(16, n-st-16); i++) arr.add(i + currDefunct + 16);
					} else if(ones < Math.min(16, n-st-16)) {
						map2.put(st+16 + "," + (st+Math.min(32, n-st)-1), Math.min(16, n-st-16)-ones);
					}
				} else {
					if(zeros == 0) {
						for(int i = 0; i < 16; i++) arr.add(i + currDefunct + 16);
					} else if(zeros < 16) {
						map2.put(st+16 + "," + st+31, 16-zeros);
					}
					if(ones == 0) {
						for(int i = 0; i < 16; i++) arr.add(i + currDefunct);
					} else if(ones< 16) {
						map2.put(st + "," + st+15, 16-ones);
					}
				}
				currDefunct += entry.getValue();
			}
		}
	}
}
