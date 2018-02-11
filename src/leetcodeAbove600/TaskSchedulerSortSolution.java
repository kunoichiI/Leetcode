package leetcodeAbove600;

import java.util.Arrays;

// 621. Task Scheduler
//Given a char array representing tasks CPU need to do. 
//It contains capital letters A to Z where different letters represent different tasks.
//Tasks could be done without original order. Each task could be done in one interval. 
//For each interval, CPU could finish one task or just be idle.
//
//However, there is a non-negative cooling interval n that means between two same tasks, 
//there must be at least n intervals that CPU are doing different tasks or just be idle.
//
//You need to return the least number of intervals the CPU will take to finish all the given tasks.
//
//Example 1:
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
public class TaskSchedulerSortSolution { // 题目突破点，任务名字不影响执行时间，只要记录cool interval放不同任务次数不同即可。
	public static int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0)
			return 0;
		/* an int array to record times of each task, index responds to each task name*/
		int[] map = new int[26];
		for (char task : tasks) {
			map[task - 'A']++;
		}
		
		Arrays.sort(map); /* The frequent task is always at the end of array */
		int time = 0; /* return value */
		while (map[25] > 0) {
			int i = 0; 
			while (i <= n) { /* n is the cooling interval */
				if (map[25] == 0)
					break;
				if (i < n && map[25 - i] > 0) /* when i increases, if map[25 - i] > 0, minus 1, starting from i = 0, map[25]-- */
					map[25 - i]--;
				time++;
				i++;
			}
			/* After each while loop here, map[25] should become 0, but not every other element, so sort again to keep largest at map[25]*/
			Arrays.sort(map);
		}
		return time;
	}
	public static void main(String[] args) {
		char[] tasks1 = null;
		char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
		char[] tasks3 = {'A', 'B'};
		char[] tasks4 = {'A', 'A', 'B', 'C'};
		char[] tasks5 = {'C'};
		
		System.out.println("least interval when n is 2: " + leastInterval(tasks1, 2)); // => 0
		System.out.println("least interval when n is 3: " + leastInterval(tasks2, 3)); // => 10, A ->B ->I ->I ->A ->B ->I ->I ->A ->B
		System.out.println("least interval when n is 2: " + leastInterval(tasks3, 2)); // => 2
		System.out.println("least interval when n is 2: " + leastInterval(tasks4, 2)); // => 5
		System.out.println("least interval when n is 2: " + leastInterval(tasks5, 2)); // => 1
	}

}
