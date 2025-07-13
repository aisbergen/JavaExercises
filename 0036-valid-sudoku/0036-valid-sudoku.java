class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
            char c = board[i][j];
            if (c != '.') {

            if(rows[i].contains(c)){
                return false;
            }

            if(cols[j].contains(c)){
                return false;
            }

            int boxIndex = (i / 3) * 3 + (j / 3);
            if (boxes[boxIndex].contains(c)){ return false;}
        
            rows[i].add(c);
            cols[j].add(c);
            boxes[boxIndex].add(c);
            }
        }
    }
        return true;
    }
}