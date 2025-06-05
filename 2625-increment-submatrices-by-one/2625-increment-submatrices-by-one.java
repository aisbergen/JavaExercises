class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        //process each query to increment the corners of submatrix
        for(int[] query: queries){
            int startX = query[0], startY = query[1], endX=query[2], endY = query[3];
            matrix[startX][startY]++; //top-left corner

            // Prevent out of bounds and mark just outside the bottom boundary if within limits
            if (endX + 1 < n) {
                matrix[endX + 1][startY]--;
            }
          
            // Prevent out of bounds and mark just outside the right boundary if within limits
            if (endY + 1 < n) {
                matrix[startX][endY + 1]--;
            }

            if (endX + 1 < n && endY + 1 < n) {
                matrix[endX + 1][endY + 1]++;
            }

        }

        //to reflect to all range of queries
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; j++){
                 if (i > 0) {
                    // Add the value from the previous row to accumulate the vertical sums
                    matrix[i][j] += matrix[i - 1][j];
                }
                if (j > 0) {
                    // Add the value from the previous column to accumulate the horizontal sums
                    matrix[i][j] += matrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    // Subtract the overlapping value that has been added twice
                    matrix[i][j] -= matrix[i - 1][j - 1];
                }
            }
        } 

        return matrix;       
    }
}