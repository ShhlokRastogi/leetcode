import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1;
        int top = 0, bottom = rows - 1;
        List<Integer> list = new ArrayList<>(rows * columns);
        int count = 0;
        int total = rows * columns;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right && count < total; i++) {
                list.add(matrix[top][i]);
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count < total; i++) {
                list.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count < total; i--) {
                list.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count < total; i--) {
                list.add(matrix[i][left]);
                count++;
            }
            left++;
        }

        return list;
    }
}
