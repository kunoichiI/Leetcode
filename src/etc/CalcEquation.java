package etc;
// CTCI question: Print all positive integer solutions to the equation : a^3 + b^3 = c^3 + d^3
// where a, b, c and d are integers between 1 and 1000

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalcEquation {
	public static void calcEquation(int n) {
		HashMap<Integer, List<Pair>> map = new HashMap<>();
		for (int c = 1; c <= n; c++) {
			for (int d = 1; d <= n; d++) {
				int result = c * c * c + d * d * d;
//				System.out.println("cubic value: " + result);
//				System.out.println("This pair is : " + c + ", " + d);
				if (!map.containsKey(result))
					map.put(result, new ArrayList<Pair>());
				map.get(result).add(new Pair(c, d));
			}
		}
		
		for (int key : map.keySet()) {
			List<Pair> list = map.get(key);
			if (list.size() == 1) {
				Pair p = list.get(0);
				System.out.println("value is : " + key + ",  a and b are:" + " (" + p.first + 
						", " + p.second + ") " + " c and d are:  (" + p.first + ", " + p.second + ") ");
			}
			else {
				Pair p1 = list.get(0);
				Pair p2 = list.get(1);
				System.out.println("value is : " + key + ",  a and b are:" + " (" + p1.first + 
						", " + p1.second + ") " + " c and d are:  (" + p2.first + ", " + p2.second + ") ");
			}
		}
	}
	public static void main(String[] args) {
		calcEquation(1000);
	}

}
