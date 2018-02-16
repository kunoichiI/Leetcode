package leetcode;

import java.util.LinkedHashMap;

public class LRUCache_linkedHashMapSolution<K, V> extends LinkedHashMap<K, V> {
	//利用java本身带的LinkedHashMap， 设定doubleLinkedList的order为access order，这样access最少（即LRU）的node就会在capacity满之后再access的时候被删除。
		private static final long serialVersionUID = 1L;

		private final int capacity;

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
			// Remove the eldest element whenever size of cache exceeds the capacity
			return (size() > this.capacity);
		}

		public LRUCache_linkedHashMapSolution(int capacity) {
			// Call constructor of LinkedHashMap with accessOrder set to true to
			// achieve LRU Cache behavior
			super(capacity + 1, 1.0f, true);
			this.capacity = capacity;
		}

		/**
		 * Returns the value corresponding to input key from Cache Map.
		 * 
		 * @param key
		 *            Key for the element whose value needs to be returned
		 * @return Value of the element with input key or null if no such element
		 *         exists
		 */
		public V find(K key) {
			return super.get(key);
		}

		/**
		 * Set the element with input key and value in the cache. If the element
		 * already exits, it updates its value.
		 * 
		 * @param key
		 *            Key of the element
		 * @param value
		 *            Value of the element
		 */
		public void set(K key, V value) {
			super.put(key, value);
		}

		/**
		 * Entry point for testing LRU Cache.
		 */
		public static void main(String[] args) {
			// Create the cache with capacity 2
			LRUCache_linkedHashMapSolution<Integer, Integer> cache = new LRUCache_linkedHashMapSolution<>(2);

			cache.set(2, 1); // Will add an element with key as 2 and value as 1
			cache.set(3, 2); // Will add an element with key as 3 and value as 2

			// Will add an element with key as 4 and value as 3. Also will remove
			// the element with key 2 as it was added least recently and cache can
			// just have two elements at a time
			cache.set(4, 3);

			// Since element with key 2 was removed, it will return null
			System.out.println(cache.find(2)); // null

			// It will return value 2 and move the element with key 3 to the head.
			// After this point, element with key 4 will be least recently accessed
			System.out.println(cache.find(3)); //2

			// Will add an element with key as 5 and value as 4. Also will remove
			// the element with key 4 as it was accessed least recently and cache
			// can just have two elements at a time
			cache.set(5, 4);

			// Since element with key 2 was removed, it will return null
			System.out.println(cache.find(4));
		}
}
