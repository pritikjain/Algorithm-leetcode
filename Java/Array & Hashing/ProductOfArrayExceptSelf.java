
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductOfArrayExceptSelf {

    public static void main(String args[])
    {
        int arr[] = {1,2,3,4}; 
        productExceptSelf(arr);
    }
    public static int[] productExceptSelf(int[] nums) {

        int size = nums.length;

        // base case 
        if(size == 1){
            System.out.println(0);
            int[] baseCase = {0};
            return (baseCase);
        }

        // initialize memory to all arrays
        int[] left = new int[size];
        int[] right = new int[size];
        int[] prod = new int[size];

        int i , j;

        /* left most element of left array is always 1  */
        left[0] = nums[0];

        /* Right most element of right array is always 1 */
        right[size - 1] = nums[size-1];

        /* Construct the left array */
        for(i = 1; i < size; i++){
            left[i] = nums[i] * left[i - 1];
            System.out.println("left : " + left[i]);
        }

        /* Construct the right array */
        for( j = size-2 ; j >= 0 ; j--) {
            right[j] = nums[j] * right[j + 1];
            System.out.println("right : " + right[j]);
        }

        int preLeft =1;
        int postRight =1;
        
        for(int k = 0 ; k < size ; k++){
            if(k==0)
            {
               prod[k] = preLeft * right[k+1];
            } 
            else if(k==size-1)
            {   
                prod[k] = left[k-1] * postRight;
            } else {
                prod[k] = left[k-1] * right[k+1];
            }
            System.out.println("final : " + prod[k]);
        }
        return prod;
    }
    
}
