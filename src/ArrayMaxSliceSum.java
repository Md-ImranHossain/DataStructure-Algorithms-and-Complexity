/*
Porblem description
-------------------
A non-empty zero-indexed array A consisting of N integers is given. A pair of 
integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum 
of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

The Goal
--------
Write a function:

public int maxSumSlice(int[] A);

that, given an array A consisting of N integers, returns the maximum sum of any 
slice of A.

For example, given array A such that:
A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0

the function should return 5 because:

        (3, 4) is a slice of A that has sum 4,
        (2, 2) is a slice of A that has sum −6,
        (0, 1) is a slice of A that has sum 5,
        no other slice of A has sum greater than (0, 1).

Assumptions:
-----------

        N is an integer within the range [1..1,000,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000];
        the result will be an integer within the range [−2,147,483,648..2,147,483,647].

Complexity:
-----------

        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
/**
 *
 * @author Hossain
 */
public class ArrayMaxSliceSum {

    public static void main(String[] args) {
        int[] test = {-2, 1};
        System.out.println(maxSumSlice(test));
    }

    public static int maxSumSlice(int[] A) {
        int max = A[0];
        for (int i = 0, current = 0; i < A.length; i++) {
            current = A[i] + (current < 0 ? 0 : current);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

}
