class Twitter {
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class TweetNode {
        int userId;
        int index;
        Tweet tweet;

        TweetNode(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    int time;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> users = new HashSet<>(followMap.getOrDefault(userId, Collections.emptySet()));

        users.add(userId);

        PriorityQueue<TweetNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.time, a.tweet.time));

        for (int uid : users) {
            List<Tweet> tweets = tweetMap.get(uid);

            if (tweets != null && !tweets.isEmpty()) {
                int index = tweets.size() - 1;

                pq.offer(new TweetNode(uid, index, tweets.get(index)));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            TweetNode node = pq.poll();

            result.add(node.tweet.tweetId);

            if (node.index > 0) {
                int nextIndex = node.index - 1;

                Tweet nextTweet = tweetMap.get(node.userId).get(nextIndex);

                pq.offer(new TweetNode(node.userId, nextIndex, nextTweet));
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
