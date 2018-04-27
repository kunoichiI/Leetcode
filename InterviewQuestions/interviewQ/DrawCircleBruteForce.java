package interviewQ;

import java.util.HashSet;
import java.util.Set;

public class DrawCircleBruteForce {
	public static Set<Point> drawCircle(int x, int y, int r) {
		Set<Point> set = new HashSet<>();
		for (int i = -r; i <= r; i++) {
			for (int j = -r; j <= r; j++) {
				if (i * i + j * j == r * r)
					set.add(new Point(i, j));
			}
		}
		return set;
	}
	public static void main(String[] args) {
		// draw a circle at (0, 0)
		Set<Point> set = drawCircle(0, 0, 5);
		set.stream().forEach(item -> System.out.printf("x is %s, y is %s ", item.i, item.j));
	}

}
