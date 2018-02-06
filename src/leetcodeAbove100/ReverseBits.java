package leetcodeAbove100;

//190. Reverse Bits  (Amazon onsite question)
//Reverse bits of a given 32 bits unsigned integer.
//
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
//return 964176192 (represented in binary as 00111001011110000010100101000000).


public class ReverseBits {

	public static int reverseBits(int n) {
		int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | (n & 1);
            n = (n >> 1);
        }
        return reversed;
	}
	
	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(reverseBits(n));
	}

}
