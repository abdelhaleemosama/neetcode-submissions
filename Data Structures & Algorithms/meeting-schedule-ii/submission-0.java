/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interv : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interv.start){
                minHeap.poll();
            }
            minHeap.offer(interv.end);
        }
        return minHeap.size();
    }
}
