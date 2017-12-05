/*
Porblem description
-------------------
An array A which is zero indexed and contain N integers is given. Now if we rotate
the array 1 time it should result each element of the array moved right by one 
index and the last element become the first element.

For example, the rotation of array 
A = [1, 2, 3, 4, 5] one time is [5, 1, 2, 3, 4] (elements are shifted right by one index 
and 5 is moved to the first place).

The Goal
--------
is to rotate array A K times, means each element of A will be shifted 
to the right K times.

Write a function:

public int[] rotateArray (int A[], int K);

that, given an array A which is zero indexed containing N integersand and
a given integer K, returns the array A rotated K times.

Examples
--------
given
    A = [1, 2, 3, 4, 5]
    K = 3

the function should return [3, 4, 5, 1, 2] since the three rotations should look
like following:

    [1, 2, 3, 4, 5] -> [5, 1, 2, 3, 4]
    [5, 1, 2, 3, 4] -> [4, 5, 1, 2, 3]
    [4, 5, 1, 2, 3] -> [3, 4, 5, 1, 2]

For another example, given
    A = [0, 0, 0]
    K = 1

the function should return [0, 0, 0]

Assumptions:
-----------
N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].

Complexity:
-----------
expected worst-case time complexity is O(N));
expected worst-case space complexity is O(1).
 */

/**
 *
 * @author Hossain
 */
public class ArrayRotation {

    public  int[] rotateArray(int[] A, int K) {
       int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[(i + K) % A.length] = A[i];
        }
        return B;
    }

}
