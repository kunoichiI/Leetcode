package leetcode;
//This is a Java Program to implement Sparse Vector. Sparse vectors are useful implementation of vectors that mostly contains zeroes. 
//Here sparse vectors consists of (index, value) pairs.
import java.util.*;
public class SparseVector {
	private TreeMap<Integer, Double> st; // Treemap is used to maintain sorted order
	private int N;
	
	// constructor
	public SparseVector(int N) {
		this.N = N;
		st = new TreeMap<Integer, Double>();
	}
	
	// Function to insert a (key, value) pair
	public void put(int i, double value) {
		if (i < 0 || i >= N) {
			throw new RuntimeException("\nError: out of bounds");
		}
		
		if (value == 0.0) {
			st.remove(i);
		}else {
			st.put(i, value);
		}
	}
	
	// Function to get a (key, value )pair
	public double get(int i) {
		if (i < 0 || i >= N) {
			throw new RuntimeException("\nError: out of bounds");
		}
		if (st.containsKey(i)) {
			return st.get(i);
		}else {
			return 0.0;
		}
	}
	
	// Function to get the size of vector
	public int size() {
		return N;
	}
	
	// Function to get dot product of two vectors
	public double dot(SparseVector b) {
		SparseVector a = this;
		if (a.N != b.N) {
			throw new RuntimeException("\nError: Vector lengths are not the same");
		}
		
		double sum = 0.0;
		if (a.st.size() <= b.st.size()) {
			for (Map.Entry<Integer, Double> entry: a.st.entrySet()) {
				if (b.st.containsKey(entry.getKey())) {
					sum += a.st.get(entry.getKey()) * b.get(entry.getKey());
				}
			}
		}else {
			for (Map.Entry<Integer, Double> entry: b.st.entrySet()) {
				if (a.st.containsKey(entry.getKey())){
					sum += b.st.get(entry.getKey()) * a.get(entry.getKey());
				}
			}
		}
		return sum;
	}
	
	// Function to get sum of two vectors
	public SparseVector plus(SparseVector b) {
		SparseVector a = this;
		if (a.N != b.N) {
			throw new RuntimeException("\nError: Vector lengths are not the same");
		}
		
		SparseVector c = new SparseVector(N);
		
		for (Map.Entry<Integer, Double> entry :a.st.entrySet()) {
			c.put(entry.getKey(), a.get(entry.getKey()));
		}
		
		for (Map.Entry<Integer, Double> entry: b.st.entrySet()) {
			c.put(entry.getKey(), b.get(entry.getKey()) + c.get(entry.getKey()));
		}
		
		return c;
	}
	
	// Function to print out vector
	public String toString() {
		String s = "";
		for (Map.Entry<Integer, Double> entry: st.entrySet()) {
			s += "(" + entry.getKey() + "," + st.get(entry.getKey()) + ") ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println("Sparse Vector Test\n");
		int n = 70000;
		SparseVector v1 = new SparseVector(n);
		SparseVector v2 = new SparseVector(n);
		v1.put(3, 1.0);
		v1.put(2500, 6.3);
		v1.put(5000, 10.0);
		v1.put(60000, 5.7);
		v2.put(1, 7.5);
		v2.put(3, 5.7);
		v2.put(2500, -6.3);
		
		System.out.println("\n");
		System.out.println("Vector v1 = " + v1);
		System.out.println("Vector v2 = " + v2);
		System.out.println("\nv1 dot v2 = " + v1.dot(v2));
		System.out.println("v1  +  v2   = " + v1.plus(v2));
	}
}
