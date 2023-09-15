import java.util.Arrays;

public class SquaringASortedArray {

    public static void main(String args[]) {
        int[] nums = { -3, -1, 0, 1, 2 };
        makeSquares(nums);
        int[] values = makeSquaresWithPointers(nums);
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ",");
        }
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];

        for (int i = 0; i < n; i++) {
            squares[i] = arr[i] * arr[i];
            System.out.print(squares[i] + ",");
        }
        System.out.println();
        Arrays.sort(squares);

        return squares;
    }

    public static int[] makeSquaresWithPointers(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int higestSquareIdx = n - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[higestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[higestSquareIdx--] = rightSquare;
                rightSquare--;
            }
        }
        return squares;

    }

}
