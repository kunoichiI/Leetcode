package interviewQ;

import java.util.Arrays;

// Oculus interview question: implement RingBuffer class
//A ring buffer is an array which is used as a queue. 
//The ring buffer has a read position and a write position which marks
//the next position to read from and write to the ring buffer. 
//When the write position reaches the end of the array, the write position is set back to 0. 
//The same is true for the read position.
//
//Setting the read and write position back to zero when they reach then end of the array 
//is also sometimes referred to as "wrapping around". It is this behaviour which turns the array into a ring buffer. 
//When the read and write position reaches the end of the array they continue from the beginning of the array, 
//just as if the array was a ring. Hence the name ring buffer.
public class RingBuffer {
	private static byte[] buffer;
	private static int write;
	private int read;
	private int maxSize;
	private int bufLen;
	public RingBuffer(int c) {
		buffer = new byte[c];
		maxSize = c;
	}
	
	public int getSize() {
		return bufLen;
	}
	
	public boolean isEmpty() {
		return bufLen == 0;
	}
	
	public boolean isFull() {
		return bufLen == maxSize;
	}
	
	/*
	 * push a size of bytes from srcBuf to ringbuffer,
	 * if no enough space to insert, just insert as many as you can. return the actual inserted number
	 */
	public int push(Byte[] srcBuf, int size) {
		int cnt = 0;
		while (!isFull() && size > 0) {
			bufLen++;
			//System.out.println("write here : " + write);
			write = write % maxSize;
			//System.out.println("write then : " + write);
			//System.out.println("write into buffer : " + buffer[write]);
			buffer[write++] = srcBuf[cnt++];
			size--;
		}
		//System.out.println("buffer looks like : " + Arrays.toString(buffer));
		return cnt;
	}

	/*
	 * pop a byte out from buffer, if buffer is empty then stop poping
	 */
	public void pop(int size) {
		while (!isEmpty() && size > 0) {
			bufLen--;
			read = read % maxSize;
			buffer[read++] = (byte)0;
			size--;
		}
	}
	
	
	public static void main(String[] args) {
		RingBuffer rb = new RingBuffer(5);
		//System.out.println("after initialization " + write);
		Byte[] srcBuf = {(byte)1, (byte)2, (byte)3, (byte)4};
		//System.out.println("what's srcBUf like" + Arrays.toString(srcBuf));
		System.out.println(rb.push(srcBuf, 3)); // 3
		System.out.println(rb.push(srcBuf, 3)); // 2
		System.out.println(rb.push(srcBuf, 3)); // 0
		
		rb.pop(3);
		System.out.println(Arrays.toString(buffer)); // [0, 0, 0, 1, 2]
		
		rb.pop(2);
		System.out.println(Arrays.toString(buffer)); // [0,0,0,0,0] all poped out
		
		rb.pop(4);
		System.out.println(Arrays.toString(buffer)); // no more actions.
		
		System.out.println(rb.push(srcBuf, 2)); // 2
		System.out.println(Arrays.toString(buffer)); // [1, 2, 0, 0, 0]
	}

}
