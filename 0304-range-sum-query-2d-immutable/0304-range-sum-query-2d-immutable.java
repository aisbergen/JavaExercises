class NumMatrix {
    private int[][] prefixSum;
    public NumMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = matrix.length;
        prefixSum = new int[rows+1][cols+1];
        for (int i=1; i<= rows; i++){
            for(int j=1; j<=cols; j++){
                prefixSum[i][j] = matrix[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];      
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2+1][col2+1] - prefixSum[row1][col2+1] - prefixSum[row2+1][col1]+prefixSum[row1][col1];
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */