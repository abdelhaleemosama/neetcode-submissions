class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = matrix[0].length, l = 0;
        int top = 0, bottom = matrix.length;

        while (l < r && top < bottom) {
            for (int i = l; i < r; i++) res.add(matrix[top][i]);
            top++;
            for (int i = top; i < bottom; i++) res.add(matrix[i][r-1]);
            r--;
            if(!(l < r && top < bottom)) break;
            for (int i = r - 1; i >= l; i--) res.add(matrix[bottom-1][i]);
            bottom--;
            for (int i = bottom - 1; i >= top; i--) res.add(matrix[i][l]);
            l++;
        }

        return res;
    }
}
