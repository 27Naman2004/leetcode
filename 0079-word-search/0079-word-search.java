class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean ans = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '!' || board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '!';
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int [] d: dir){
            int new_i = i + d[0];
            int new_j = j + d[1];
            if(helper(board, word, new_i, new_j, index+1)){
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}