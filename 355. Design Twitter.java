class Twitter {

    /** Initialize your data structure here. */
    Map<Integer, Set<Integer>> map;
    Stack<Tweet> tweets;
    public Twitter() {
        map = new HashMap<>();
        tweets = new Stack<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(userId, tweetId);
        tweets.push(newTweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();
        Set<Integer> followers = map.getOrDefault(userId, new HashSet<>());
        int count = 0;
        Stack<Tweet> temp = new Stack<>();
        while (!tweets.isEmpty() && count < 10) {
            Tweet cur = tweets.pop();
            if (cur.userId == userId || followers.contains(cur.userId)) {
                feeds.add(cur.tweetId);
                count++;
            }
            temp.push(cur);
        }
        while (!temp.isEmpty()) {
            tweets.push(temp.pop());
        }
        return feeds;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = map.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        map.put(followerId, followers);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = map.getOrDefault(followerId, new HashSet<>());
        if (followers.contains(followeeId)) {
            followers.remove(followeeId);
        }
        map.put(followerId, followers);
    }
    
    class Tweet{
        int userId;
        int tweetId;
        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
