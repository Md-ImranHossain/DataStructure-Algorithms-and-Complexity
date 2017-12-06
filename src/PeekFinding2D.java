/*
The Goal
--------
Given an array of size N, find a peak element in the array. Peak element is the 
element which is greater than or equal to its neighbors.
For example - In Array {1,4,3,6,7,5}, 4 and 7 are peak elements. 
We need to return any one peak element.

Write a function:

public int findPeek (int A[]);

so that given array A it returns any peek element of the array

Complexity:
-----------
expected worst-case time complexity is O(log N));
expected worst-case space complexity is O(1).
 */
package mitAlgorithms;

/**
 * @author Hossain
 */
public class PeekFinding2D {

    public static void main(String[] args) {
        int[] test1 = {5, 2, 3, 4, 6, 1, 2, 5, 4, 3};
        int[] test2 = {1, 2, 3};
        System.out.println(findPeek(test2));
    }

    public static int findPeek(int[] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 || inputArray[mid - 1] <= inputArray[mid]) && (mid == inputArray.length - 1 || inputArray[mid] >= inputArray[mid + 1])) {
                return inputArray[mid];
            } else if (mid > 0 && inputArray[mid] < inputArray[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

}
