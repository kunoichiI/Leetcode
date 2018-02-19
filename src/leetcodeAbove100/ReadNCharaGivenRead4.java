package leetcodeAbove100;
// Leetcode 157
//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, 
//it returns 3 if there is only 3 characters left in the file.
//By using the read4 API, implement the function int read(char *buf, int n) that 
//reads n characters from the file.
//
//The read function will only be called once for each test case
/*开始理解题意错误，每次读入4个字符，不是从buf里读入的，而是从文件里读入的，存入buf. 
 * 如果read4 < 4, 则说明已读到文件结尾。同时想到file.length > n, 则每次要确定读入Buf的正确长度，
 * 即Max.min(count, n - total)
 */
public class ReadNCharaGivenRead4 {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	public int read(char[] buf, int n) {
		boolean eof = false; // end of file, in case that file.length > n
		char[] tmp = new char[4];
		int total = 0;
		while (!eof && total < n) {
			int count = read4(tmp);
			if (count < 4) {
				eof = true; // reach end of file
			}
			// get the actual count
			count = Math.min(count, n - total);
			for (int i = 0; i < count; i++) {
				buf[total++] = tmp[i];
			}
		}
		return total;
	}
	
	public int read4(char[] buf4) {
		return 3; // fictionary function
	}
}

//Read N Characters Given Read4 II – Call multiple times
//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//Note:
//The read function may be called multiple times.

//public class Solution extends Reader4 {
//    private char[] buffer = new char[4];
//    int offset = 0, bufsize = 0;
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/
//    public int read(char[] buf, int n) {
//        int readBytes = 0;
//        boolean eof = false;
//        while (!eof && readBytes < n) {
//            int sz = (bufsize > 0) ? bufsize : read4(buffer);
//            if (bufsize == 0 && sz < 4) eof = true;
//            int bytes = Math.min(n - readBytes, sz);
//            System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, 
//                readBytes /* destPos */, bytes /* length */);
//            offset = (offset + bytes) % 4;
//            bufsize = sz - bytes;
//            readBytes += bytes;
//        }
//        return readBytes;
//    }
//}
