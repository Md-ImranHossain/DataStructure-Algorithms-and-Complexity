/*
Porblem description
-------------------
If a positive integer is converted to its binary representation, a binary gap is
the maximum occurance of consecutive zeros with ones at both end.

For example, binary representation of integer 5 is 101 which has a binary gap of
length 1 as there is only one zero surrounded by ones. Binary representation of 
3 is 11 which has no binary gap. The integer 529 could be binary represented 
binary as 1000010001 and contains two binary gaps: one of length 4 and one of 
length 3. Therefor the longest binary gap for integer 529 is 4.

The Goal
--------
Write a function:

public int BinaryGap(int N);

that, given a positive integer N, the function should returns the length of its 
longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 529 it should return 4, because 529 has binary 
representation 1000010001 and so its longest binary gap is of length 4.

Assumptions:
-----------
N is an integer which range is [1..2,147,483,647].

Complexity:
-----------
expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Hossain
 */
public class BinaryGap {
    
    public static void main(String[] args) {
        //System.out.println(solution (3));
        //System.out.println(solution (5));
        System.out.println(solution (529));
    }
    
    public static int solution(int N) {
        String binaryIntInStr = Integer.toBinaryString(N);
        ArrayList list = new ArrayList();
        String[] split = binaryIntInStr.split("((?<=1)|(?=1))");
        int ret = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("1") && (i + 2) < split.length && !split[i + 1].equals("1")) {
                list.add(split[i + 1].length());
            }
        }
        if (!list.isEmpty()) {
            ret = (int) Collections.max(list);
        } else if (list.isEmpty()) {
            ret = 0;
        }
        return ret;
    }

}
