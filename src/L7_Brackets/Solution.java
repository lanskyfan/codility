package L7_Brackets;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> brack_stack = new Stack<Character>();
        Character temp_char;
        for (int i = 0; i < S.length(); i++){
            temp_char = S.charAt(i);
            if (brack_stack.isEmpty()){
                if (!is_left(temp_char)){
                    return 0;
                }
                brack_stack.push(temp_char);
                continue;
            }
            if (is_left(temp_char)){
                brack_stack.push(temp_char);
            }
            else if (!is_pair(brack_stack.peek(), temp_char)){
                return 0;
            }
            else{
                brack_stack.pop();
            }
        }
        if (!brack_stack.isEmpty()){
            return 0;
        }
        return 1;
    }

    static Boolean is_left(Character input_char){
        if (input_char == '(' || input_char == '[' || input_char =='{'){
            return true;
        }
        return false;
    }

    static  Boolean is_pair(Character input1, Character input2){
        if (input1 == '(' && input2 == ')'){
            return true;
        }
        if (input1 == '[' && input2 == ']'){
            return true;
        }
        if (input1 == '{' && input2 == '}'){
            return true;
        }
        return false;
    }

}
