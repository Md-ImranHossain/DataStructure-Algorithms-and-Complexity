/*
Porblem description
-------------------
Given an area of a rectangle representing by integer N.
If the rectangle's sides are A and B then the area of a rectangle  is A * B 
and the perimeter is 2 * (A + B).

The Goal
--------
to find the minimal perimeter of any rectangle whose area equals N. 
The sides of this rectangle should be only integers.

For example if N = 30, the possible sides and perimeters are:

        (1, 30) = 62,
        (2, 15)= 34,
        (3, 10)= 26,
        (5, 6)= 22.

so the result should be 22

Write a function:

public int minPerimeter(int N);

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

Assumptions:
-----------
N is an integer within the range [1..1,000,000,000].

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
public class MinPerimeterRectangle {
    
    public static int solution(int N){
        Integer x =  ((Double)Math.sqrt(N)).intValue();
        int y = 0 ;
        for(int i = x ; x>0 ; x--){
            if(N%x == 0){
                y = N/x;
                break;
            }
        }
     return 2*(x+y) ;   
    }
    
    public static void main(String[] args) {
        System.out.println(solution (30));
    }
    
}
