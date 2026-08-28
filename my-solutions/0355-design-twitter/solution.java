import java.util.*;

class Tweet implements Comparable<Tweet> {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }

    @Override
    public int compareTo(Tweet other) {
        // Newest tweet comes first
        return Integer.compare(other.time, this.time);
    }
}

class Twitter {

    HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    HashMap<Integer, HashSet<Tweet>> posts = new HashMap<>();

    int time = 0;

    public Twitter() {
        
    }

    public void postTweet(int userId, int tweetId) {

        Tweet t = new Tweet(tweetId, time++);

        posts.putIfAbsent(userId, new HashSet<>());

        posts.get(userId).add(t);
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        List<Integer> feed = new ArrayList<>();

        // User's own tweets
        if (posts.containsKey(userId)) {
            for (Tweet t : posts.get(userId)) {
                pq.offer(t);
            }
        }

        // Followees' tweets
        if (following.containsKey(userId)) {

            for (int followee : following.get(userId)) {

                if (posts.containsKey(followee)) {

                    for (Tweet t : posts.get(followee)) {
                        pq.offer(t);
                    }
                }
            }
        }

        // Get latest 10 tweets
        while (!pq.isEmpty() && feed.size() < 10) {

            Tweet t = pq.poll();

            feed.add(t.tweetId);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
