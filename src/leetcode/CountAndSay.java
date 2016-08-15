package leetcode;

//38. Count and Say 
//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.

public class CountAndSay {
	public String countAndSay(int n) {
        if (n <= 0) return new String("");
        String curRes = "1";
        
        int start = 1;
        while (start < n) {
            StringBuilder res = new StringBuilder();
            int cnt = 1;
            for (int j = 1; j < curRes.length(); j++) {
                if (curRes.charAt(j) == curRes.charAt(j-1)) {
                    cnt++;
                }else {
                    res.append(cnt);
                    res.append(curRes.charAt(j-1));
                    cnt= 1;
                }
            }
            res.append(cnt);
            res.append(curRes.charAt(curRes.length() -1));
            curRes = res.toString();
            start++;
        }
        return curRes;
    }
}
