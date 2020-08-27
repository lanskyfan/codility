package L12_CommonPrimeDivisors;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are
 * 2, 3, 5, 7, 11 and 13.
 *
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P.
 * For example, 2 and 5 are prime divisors of 20.
 *
 * You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers
 * N and M are exactly the same.
 *
 * For example, given:
 *
 * N = 15 and M = 75, the prime divisors are the same: {3, 5};
 * N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
 * N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
 * Write a function:
 *
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime
 * divisors of A[K] and B[K] are exactly the same.
 *
 * For example, given:
 *
 *     A[0] = 15   B[0] = 75
 *     A[1] = 10   B[1] = 30
 *     A[2] = 3    B[2] = 5
 * the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * Z is an integer within the range [1..6,000];
 * each element of arrays A, B is an integer within the range [1..2,147,483,647].
 */

//https://stackoverflow.com/questions/34251682/finding-common-prime-divisors-in-two-sets-of-numbers-quickly

// unfinished


import java.util.HashSet;
public class Solution {
    static public int gcd(int N, int M){
        int temp;
        if (M > N) {
            temp = M;
            M = N;
            N = temp;
        }
        int remainder = N % M;
        while (true){
            if ( N % M == 0){
                return M;
            }
            remainder = N % M;
            N = M;
            M = remainder;
        }
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
//        int max_element = Integer.MIN_VALUE;
//        for (int x: A){
//            if (max_element < x) max_element = x;
//        }
//        for (int x: B){
//            if (max_element < x) max_element = x;
//        }
//        int [] smallest_factor = new int[max_element + 1];
//        for (int i = 2; i * i <= max_element; i++){
//            int k = i * i;
//            while (k <= max_element){
//                if (smallest_factor[k] == 0){
//                    smallest_factor[k] = i;
//                }
//                k = k + i;
//            }
//        }
//        HashSet<Integer> prime_div_a = new HashSet<>();
//        HashSet<Integer> prime_div_b = new HashSet<>();
//
//        int result = 0;
//        for (int i = 0; i < A.length; i++){
//            int remain = A[i];
//            if (smallest_factor[remain] == 0){
//                prime_div_a.add(remain);
//            }
//            while (smallest_factor[remain] != 0){
//                prime_div_a.add(smallest_factor[remain]);
//                remain = remain / smallest_factor[remain];
//                if (smallest_factor[remain] == 0){
//                    prime_div_a.add(remain);
//                }
//            }
//            remain = B[i];
//            if (smallest_factor[remain] == 0){
//                prime_div_b.add(remain);
//            }
//            while (smallest_factor[remain] != 0){
//                prime_div_b.add(smallest_factor[remain]);
//                remain = remain / smallest_factor[remain];
//                if (smallest_factor[remain] == 0){
//                    prime_div_b.add(remain);
//                }
//            }
//            if (prime_div_a.equals(prime_div_b)){
//                result++;
//            }
//            prime_div_a.clear();
//            prime_div_b.clear();
//        }
//
//        return result;
        int result = 0;
        int gcd_value;
        for (int i = 0; i < A.length; i++){
            gcd_value = gcd(A[i], B[i]);
            if (gcd_value % (A[i] / gcd_value) == 0 && gcd_value % (B[i] / gcd_value) == 0){
                result++;
            }
        }
        return result;
    }
}