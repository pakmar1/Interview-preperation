class Solution {
        int TO_DIE = 2, TO_REBORN = -1;

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                changeState(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == TO_DIE) board[i][j] = 0;
                else if (board[i][j] == TO_REBORN) board[i][j] = 1;
            }
        }
    }
    
    private void changeState(int[][] board, int x, int y) {
        int count = getLiveCount(board, x, y);
        if (isLive(board, x, y)) {
            if (count < 2 || count > 3) board[x][y] = TO_DIE;
        } else {
            if (count == 3) board[x][y] = TO_REBORN;
        }
    }
    
    private int getLiveCount(int[][] board, int x, int y) {
        int count = 0;
        count += isLive(board, x - 1, y - 1) ? 1 : 0;
        count += isLive(board, x - 1, y) ? 1 : 0;
        count += isLive(board, x - 1, y + 1) ? 1 : 0;
        count += isLive(board, x, y - 1) ? 1 : 0;
        count += isLive(board, x, y + 1) ? 1 : 0;
        count += isLive(board, x + 1, y - 1) ? 1 : 0;
        count += isLive(board, x + 1, y) ? 1 : 0;
        count += isLive(board, x + 1, y + 1) ? 1 : 0;
        return count;
    }
    
    private boolean isLive(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] > 0;
    }
}
