package leetcodeAbove400;

public class ThirdMaxNumberOptimizedSolution {
	public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } 
            else if (num < first && num > second) {
                third = second;
                second = num;
            }
            else if (num < second && num > third) {
                third = num;
            }
        }
        
        return (third == Long.MIN_VALUE || third == second) ? (int)first : (int)third;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 解题思路： 维持三个变量first， second， third，分别存第一大数，第二大数和第三大数。
	 * 遇到新元素时，判断这个数值与三个变量的关系，相应进行更新。
	 * 注意这里有个坑，必须初始化三个变量时使用long.MIN_VALUE, 因为int array里的值可能小于Integer.MIN_VALUE!!
	*/
}
