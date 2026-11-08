class Solution {
    public int leastInterval(char[] tasks, int n) {
        int mostFreq = 0;
        int [] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
            mostFreq = Math.max(mostFreq, freq[task - 'A']);
        }

        int countMost = 0;
        for (int task : freq) {
            if (task == mostFreq) {
                countMost++;
            }
        }

        return Math.max(tasks.length, ((mostFreq - 1) * (n+1)) + countMost);
    }
}
