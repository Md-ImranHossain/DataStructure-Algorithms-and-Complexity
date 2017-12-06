/*
Porblem description
-------------------
A zero-indexed array A consisting of N integers is given. The dominator of array 
A is the value that occurs in more than half of the elements of A.

For example, consider array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in 
those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

The Goal
--------
Write a function

public int findDominator(int[] A); 

that, given a zero-indexed array A consisting of N integers, returns index of any 
element of array A in which the dominator of A occurs. The function should 
return −1 if array A does not have a dominator.

Assumptions:
-----------
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

For example, given array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3

the function may return 0, 2, 4, 6 or 7, as explained above.

Complexity:
-----------
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting 
the storage required for input arguments).
 */
package lesson;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Hossain
 */
public class DominatValInArray {

    public static void main(String[] args) {
        int[] test = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(findDominator(test));
    }

    public static int findDominator(int[] A) {
        if (A.length == 0) {
            return -1;
        } else if (A.length == 1) {
            return 0;
        } else {
            Map<Integer, Integer> list = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                if (list.containsKey(A[i])) {
                    list.put(A[i], list.get(A[i]) + 1);
                    if (list.get(A[i]) > A.length / 2) {
                        return i;
                    }
                } else {
                    list.put(A[i], 1);
                }
            }
        }
        return -1;
    }

}
