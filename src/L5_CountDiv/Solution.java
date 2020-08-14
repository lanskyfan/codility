package L5_CountDiv;

/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because
 * there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */

public class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
//        int times = (B-A) /K;
//        if ((B-A)%K == 0){
//            if (A % K == 0){
//                return times + 1;
//            }
//            else{
//                return times;
//            }
//        }
//        else{
//            int left = 0;
//            int right = 0;
//            if (A%K == 0) left = 1;
//            if (B%K == 0) right = 1;
//            return times + left + right;
//        }
        int add = 0;
        if (A % K == 0) add = 1;
        return (B / K) - A / K + add;
    }
}
