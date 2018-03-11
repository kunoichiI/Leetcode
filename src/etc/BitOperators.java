package etc;

public class BitOperators {

	public static void main(String[] args) {
		// Bitwise AND, OR, XOR
		System.out.println(0x000F);  // 15
		System.out.println(0x2222);  // 8738
		System.out.println(0x000F & 0x2222); // 2 AND
		System.out.println(0x000F ^ 0x2222); // 8749 XOR
		System.out.println(0x000F | 0x2222); //  8751 OR
		System.out.println("--------");
		// Right shift(signed), left shift, Rightshift(unsigned)
		System.out.println(0x000F >> 2); // 3
		System.out.println(0x000F >>> 2); // 3
		System.out.println(0x000F << 4); // 240
	}

}
