class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] r1 = new int[rows * cols]; 
        int[] c1 = new int[rows * cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    r1[k] = i;
                    c1[k] = j;
                    k++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            int row = r1[i];
            int col = c1[i];
            for (int j = 0; j < cols; j++) {
                matrix[row][j] = 0;
            }
            for (int j = 0; j < rows; j++) {
                matrix[j][col] = 0;
            }
        }
    }  
    }
