package leetcode;

import java.util.*;
//295. Find Median from Data Stream   
//Contributors: Admin
//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
//
//Examples: 
//[2,3,4] , the median is 3
//
//[2,3], the median is (2 + 3) / 2 = 2.5
//
//Design a data structure that supports the following two operations:
//
//void addNum(int num) - Add a integer number from the data stream to the data structure.
//double findMedian() - Return the median of all elements so far.
//For example:
//
//add(1)
//add(2)
//findMedian() -> 1.5
//add(3) 
//findMedian() -> 2

public class FindMedianFromDataStream {
	PriorityQueue<Integer> maxHeap; // Lower half
    PriorityQueue<Integer> minHeap;  // Higher half
    
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }else {
            return (double)maxHeap.peek();
        }
    }
}
