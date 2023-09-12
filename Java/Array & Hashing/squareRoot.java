public class squareRoot {

    public static void main(String arg[])
    {
        int input1 = 4;
        int expectedOutput1 = 2;
        int result1 = sqrt(input1);
        System.out.println(result1); // Expecte
    }
    public static int sqrt(int x)
    {
        if(x <= 2){
            return x;
        }

        int left =2;
        int right = x/2;
        int pivot;  // The 'pivot' essentially represents our current guess for the square root.
        long num;

        while(left<=right)
        {
            pivot = left + (right -left) / 2 ; // find the middle element 

            num = (long) pivot * pivot;

            if(num > x)
                right = pivot -1;
            else if(num < x)
                left = pivot + 1;
            else {
                return pivot;
            }
        }
        return right; // return right after the loop
        
    }
    
}
