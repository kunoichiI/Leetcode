package leetcodeAbove200;

//278. First Bad Version 
//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
//Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
//		You should minimize the number of calls to the API.

public class IsBadVersion {
	public int firstBadVersion(int n) {
        if (n == 1) return 1;
        
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
	// made-up API for isBadVersion(), it's actually in some parental class
	public static boolean isBadVersion(int i) {
		return true;
	}
}
