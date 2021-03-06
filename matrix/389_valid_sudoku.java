/*
Determine whether a Sudoku is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character ..

Notice
    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

// method 1
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        // check row
        for (int i = 0; i < 9; i++) {
            boolean[] numUsed = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (isDuplicate(board[i][j], numUsed)) return false;
            }
        }
        // check column
        for (int i = 0; i < 9; i++) {
            boolean[] numUsed = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (isDuplicate(board[j][i], numUsed)) return false;
            }
        }
        // check sub box
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidBox(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] box, int x, int y) {
        boolean[] numUsed = new boolean[9];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (isDuplicate(box[i][j], numUsed)) return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(char c, boolean[] numUsed) {
        if (c == '.') {
            return false;
        } else if (numUsed[c-'1']) {
            return true;
        } else {
            numUsed[c-'1'] = true;
            return false;
        }
    }
}

// method 2
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> cols = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
                if (board[i][j]!='.' && !rows.add(board[i][j])) return false;
                if (board[j][i]!='.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j/3][colIndex+j%3]!='.' && !cube.add(board[rowIndex+j/3][colIndex+j%3])) return false;
            }
        }
        return true;
    }
}
