package leetcode;
// Leetcode 157
//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//The read function will only be called once for each test case

public class ReadNCharaGivenRead4 {
	public int read(char[] buf, int n) {
		boolean eof = false; // end of buffer?
		int charsRead = 0;
		char[] buf4 = new char[4];
		
		while(!eof && charsRead < n) {
			int size = read4(buf4);
			if (size < 4) {
				eof = true;
			}
			
			if (charsRead + size > n) {
				size = n - charsRead;
			}
			
			System.arraycopy(buf4, 0, buf, charsRead, size);
			charsRead += size;
		}
		return charsRead;
	}
	
	public int read4(char[] buf4) {
		return 6; // fictionary function
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
