class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        int mid = low + (high - low) / 2;
        while(low<=high){
            mid = low + (high - low) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if(target==matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}
