class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                max = Math.max(max, top[1] * (i - top[0]));

                start = top[0];
            }

            stack.push(new int[] {start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            max = Math.max(max, height * (heights.length - index));
        }

        return max;
    }
}
