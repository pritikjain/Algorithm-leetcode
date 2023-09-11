import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class validSudoku {

    public static void main(String args[])
    {
        char arr[][] = {'5','3','.','.','7','.','.','.','.'}
        ,['6',".",".","1","9","5",".",".","."]
        ,{".","9","8",".",".",".",".","6","."}
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]];
        isValidSudoku(arr[][]);
    }
    public static boolean  isValidSudoku(char[][] board) {
        return true;
    }
}
