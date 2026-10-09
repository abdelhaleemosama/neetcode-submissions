
class MedianFinder {
    private PriorityQueue<Integer> lower;
    private PriorityQueue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lower.offer(num);
        upper.offer(lower.poll());

        if (lower.size() < upper.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.size() > upper.size()) {
            return lower.peek();
        }

        return ((double) lower.peek() + upper.peek()) / 2;
    }
}
