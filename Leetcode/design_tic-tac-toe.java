class TicTacToe {
    int[] checksum1,checksum2;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        checksum1 = new int[n*2+2];
        checksum2 = new int[n*2+2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int[] checksum = player==1 ? checksum1 : checksum2;
        if(++checksum[row]==n 
		|| ++checksum[n+col]==n 
		|| row==col && ++checksum[n*2]==n 
		|| row==n-col-1 && ++checksum[n*2+1]==n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
