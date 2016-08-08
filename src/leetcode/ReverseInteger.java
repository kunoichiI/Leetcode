package leetcode;

//7. Reverse Integer 
//Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321

public class ReverseInteger {
	public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res != 0 && Integer.MAX_VALUE/res < 10 && Integer.MAX_VALUE / res > -10 ) { // Handle buffer flow case
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}
