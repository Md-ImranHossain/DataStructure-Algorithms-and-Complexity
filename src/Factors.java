/*
Porblem description
-------------------
A positive integer D is a factor of a positive integer N if there exists an 
integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above 
condition (24 = 6 * 4).

The Goal
--------
Write a function:

public int countFactors(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, 
namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Assumptions:
-----------
N is an integer within the range [1..2,147,483,647].

Complexity:
-----------
expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).


 */
package lesson;

/**
 *
 * @author Hossain
 */
public class Factors {

    public static int countFactors(int N) {
        int x = ((Double) Math.sqrt(N)).intValue();        
        int factors = 0;
        int y;
        while (x > 0) {
            if (N % x == 0) { 
                y = N / x;
                if( y == x){
                    factors ++;
                }else{
                    factors += 2;
                }                
            }
            x--;
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(countFactors(24));
    }

}
