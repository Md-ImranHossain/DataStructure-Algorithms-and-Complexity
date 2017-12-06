/*
Porblem description
-------------------
A string S consisting of N characters is considered to be properly nested if any 
of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

The Goal
--------
Write a function:

public boolean isNestedProperly(String S); 

that, given a string S consisting of N characters, returns true if S is properly 
nested and false otherwise.

For example, given S = "{[()()]}", the function should return true and 
given S = "([)()]", the function should return false, as explained above.

Assumptions:
-----------
N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

Complexity:
-----------
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required 
for input arguments).
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hossain
 */
public class StacknQueue1 {
    
    public static void main(String[] args) {
        System.out.println(isNestedProperly("[{()}]"));
    }
    
    public static boolean isNestedProperly(String S) {
        
        Map<Character, Character> oposites = new HashMap<>();
        oposites.put('(', ')');
        oposites.put('{', '}');
        oposites.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();
        
        for (Character chr : S.toCharArray()) {
            if (oposites.keySet().contains(chr)) {
                stack.addFirst(chr);
            } else {
                Character closed = stack.pollFirst();
                if (!chr.equals(oposites.get(closed))) {
                    return false;
                }
            }
        }
        return 0 == stack.size();
    }

}
