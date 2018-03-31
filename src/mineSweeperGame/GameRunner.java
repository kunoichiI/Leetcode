package mineSweeperGame;

import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
//		Game g = new Game();
		System.out.println("Starting new game ? (y/n): " );
		Scanner sc = new Scanner(System.in);
		try {
			if (sc.hasNext() && sc.nextLine().equalsIgnoreCase("y")) {
				System.out.println("Input width: ");
				int w = sc.nextInt();
				System.out.println("Input height: ");
				int h = sc.nextInt();
				System.out.println("Set number of mines: ");
				int num = sc.nextInt();
				System.out.println("w is: " + w + ", h is: " + h + ", there are mines: " + num);
				Game g = new Game(w, h);
				System.out.println("g is: " + g);
				g.printGame();
			}
			else {
				System.out.println("Game is not started!");
			}
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
		
	}

}
