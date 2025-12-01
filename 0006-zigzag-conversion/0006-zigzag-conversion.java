class Solution {
    public String convert(String s, int numRows) {
        
        // If only one row, no zigzag needed
        if (numRows == 1) return s;
        
        // Create a list of StringBuilder (one for each row)
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = true;  // direction flag

        // Go through each character in the string
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            // If at top or bottom, change direction
            if (currentRow == 0) {
                goingDown = true;
            } else if (currentRow == numRows - 1) {
                goingDown = false;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
