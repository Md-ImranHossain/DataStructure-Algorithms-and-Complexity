/*
Porblem description
-------------------
An array A which is zero indexed and contain N integers is given. There are 
always odd number of elements in the array. Except one element all the other 
elements in A have pairs means elements with same value. 

For example in array A = [2,4,4,1,2,3,1]
        the elements at indexes 0 and 4 have value 2,
        the elements at indexes 1 and 2 have value 4,
        the elements at indexes 3 and 6 have value 1,
        the element at index 5 has value 3 and is unpaired.

The Goal
--------
Write currentVal function:

public int oddOccurrence(int[] A);

that, An array A which is zero indexed and contain N integers, 
returns the value of the unpaired element.

For example, given array A = [2,4,4,1,2,3,1]
the function should return 3.

Assumptions:
-----------
N is an odd integer which ranges from 1..1,000,000
Each element of A is an integer ranges from 1..1,000,000,000
All but one of the values in A occur an even number of times.

Complexity:
-----------
expected worst-case time complexity is O(N)
expected worst-case space complexity is O(1).
 */
import java.util.HashSet;
import java.util.Iterator;
/**
 *
 * @author Hossain
 */
public class OddOccurrencesInArray {

    public static int oddOccurrence(int[] A) {
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int currentVal = A[i];
            if (!list.contains(currentVal)) {
                list.add(currentVal);
            } else {
                list.remove(currentVal);
            }
        }
        Iterator it = list.iterator();
        return (int) it.next();
    }
    
    public static void main(String[] args) {
        int []A={2,4,4,1,2,3,1};
        System.out.println(oddOccurrence(A));
    }
    
}


