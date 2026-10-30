class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int rowFound = -1;

        while (top < bottom) {
            int middle = (top + bottom) / 2;
            if (matrix[middle][0] > target) {
                bottom = middle - 1;
            } else if (matrix[middle][matrix[0].length - 1] < target) {
                top = middle + 1;
            } else {
                rowFound = middle;
                break;
            }
        }

        if (matrix[top][0] <= target && matrix[top][matrix[0].length - 1] >= target) {
            rowFound = top;
        }

        if (rowFound == -1)
            return false;

        int left = 0;
        int right = matrix[rowFound].length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (matrix[rowFound][middle] > target) {
                right = middle - 1;
            } else if (matrix[rowFound][middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return matrix[rowFound][left] == target;
    }
}
