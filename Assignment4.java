import java.util.*;

public class Assignment4 {
    static int N = 4;
    public static void main(String[] args) throws Exception {
        char[][] board = new char[N][N];
        for (char[] cs : board) {
            Arrays.fill(cs, 'X');
        }
        System.out.println("By Recursive Method");
        solveNQueensRecursive(board, 0);
        
        System.out.println("By Branch and Bound method");
        List <List<String>> queen = solveNQueens(N);
        for (List < String > it: queen) {
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // Recursive and Backtracking Method
    public static boolean isSafeRecursive(char[][]board,int row,int col){
        // Checking vertically
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Checking for left diagonal
        int i = row, j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        // Checking for right diagonal
        i = row;
        j = col;
        while(i >= 0 && j < board.length){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void displayBoardRecursive(char[][] board){
        for (char[] cs : board) {
            for (char ch : cs) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void solveNQueensRecursive(char[][]board,int row){
        if(row == board.length){
            displayBoardRecursive(board);
            System.out.println();
            return;
        }

        for (int i = 0; i < board.length; i++) {

            // Checking if queen is placed on right position
            if(isSafeRecursive(board, row, i)){
                board[row][i] = 'Q'; // Placing the queen
                solveNQueensRecursive(board, row+1); // Next recursion call for next row
                board[row][i] = 'X'; // Backtracking step
            }
        }
    }
    

    // Branch and Bound Method
    public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = 'X';
        List < List < String >> res = new ArrayList< List < String >> ();
        dfs(0, board, res);
        return res;
    }

    public static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    public static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = 'X';
            }
        }
    }

    public static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
}
