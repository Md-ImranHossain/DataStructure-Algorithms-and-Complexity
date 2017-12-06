/*
The Goal
--------
Write test function:

public int findMissing(int[] A); }

that, given an array A of N integers, returns the smallest positive 
integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.

Assumptions:
-----------
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

Complexity:
-----------
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage 
(not counting the storage required for input arguments).
 */
package lesson;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hossain
 */
public class ValueMissingInArray {

    public static void main(String[] args) {
        int[] test = {0, 1, 6, 3};
        System.out.println(findMissing(test));
    }

    public static int findMissing(int[] A) {
        long max = A[0];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (set.add(A[i])) {
                    if (max < A[i]) {
                        max = A[i];
                    }
                }
            }
        }

        for (int i = 1; i < max + 2; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

}
