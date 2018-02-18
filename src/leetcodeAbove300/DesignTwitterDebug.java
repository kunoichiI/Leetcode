package leetcodeAbove300;

import java.util.*;

public class DesignTwitterDebug {
	private int postCount;
    private Map<Integer, Integer> tweetCountMap;
    private Map<Integer, List<Integer>> tweetIdMap;
    private Map<Integer, Set<Integer>> followeeMap;
    /** Initialize your data structure here. */
    public DesignTwitterDebug() {
        postCount = 0;
        tweetCountMap = new HashMap<Integer, Integer>();
        tweetIdMap = new HashMap<Integer, List<Integer>>();
        followeeMap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetCountMap.put(tweetId, ++postCount);
        if (!tweetIdMap.containsKey(userId))
            tweetIdMap.put(userId, new ArrayList<Integer>());
        tweetIdMap.get(userId).add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followees = getFolloweeSet(userId);
       
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> tweetCountMap.get(i2) - tweetCountMap.get(i1));
        // add all tweets into priorityqueue, tweet with biggest postCount comes first, max heap style
        // if tweets are less than 10, retrieve all tweets, if larger than 10, maintain 10 most recent tweets

        //System.out.println("debug: followees are" + followees);
        for (int followee: followees) {
        	//System.out.println("debug: how many tweets" + getTweetIdList(followee));		
            for (int post : getTweetIdList(followee)) {
                queue.add(post);
            }
        }
        //System.out.println("debug: what is queue like now" + queue);
        while (result.size() < 10 && !queue.isEmpty()) {
            int post = queue.poll();
            result.add(post);
            //System.out.println("debug: what is added to the result" + result);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId != followerId) {
            getFolloweeSet(followerId).add(followeeId);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            getFolloweeSet(followerId).remove(followeeId);
        }
    }
    
    public Set<Integer> getFolloweeSet(int userId) {
        if (!followeeMap.containsKey(userId))
            followeeMap.put(userId, new HashSet<Integer>());
        Set<Integer> followeeSet = followeeMap.get(userId);
        followeeSet.add(userId);
        return followeeSet;
    }
    
    public List<Integer> getTweetIdList(int userId) {
    		if (!tweetIdMap.containsKey(userId))
    			tweetIdMap.put(userId, new ArrayList<Integer>());
    		List<Integer> tweetIdList = tweetIdMap.get(userId);
    		return tweetIdList;
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
	public static void main(String[] args) {
		DesignTwitterDebug twitter = new DesignTwitterDebug();
		
		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);
		System.out.println("tweetIdMap : " + twitter.tweetIdMap); // { 1=[5] }

		// User 1's news feed should return a list with 1 tweet id -> [5].
		List<Integer> feed = twitter.getNewsFeed(1);
		System.out.println("feed : " + feed); // [5]

		// User 1 follows user 2.
		twitter.follow(1, 2);
		System.out.println("followeeMap : " + twitter.followeeMap); // { 1 = [1, 2] }

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);
		System.out.println("tweetIdMap : " + twitter.tweetIdMap); // { 1=[5], 2=[6] }

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		List<Integer> feed1 = twitter.getNewsFeed(1);
		System.out.println("feed1 is : " + feed1); // [6, 5]
		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);
		System.out.println("followeeMap : " + twitter.followeeMap); // { 1=[1]}
		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		twitter.getNewsFeed(1);
		System.out.println("feed : " + feed); // [5]
	}

}
