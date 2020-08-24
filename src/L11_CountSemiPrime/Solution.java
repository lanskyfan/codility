package L11_CountSemiPrime;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are
 * 2, 3, 5, 7, 11 and 13.
 *
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers.
 * The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 *
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about
 * the number of semiprimes within specified ranges.
 *
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 *
 * For example, consider an integer N = 26 and arrays P, Q such that:
 *
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 *
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 *
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M
 * elements specifying the consecutive answers to all the queries.
 *
 * For example, given an integer N = 26 and arrays P, Q such that:
 *
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 */
public class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int max_element = Integer.MIN_VALUE;
        for (int x: P){
            if (max_element < x) max_element = x;
        }
        for (int x: Q){
            if (max_element < x) max_element = x;
        }
        int [] smallest_factor = new int[max_element + 1];
        for (int i = 2; i * i <= max_element; i++){
            int k = i * i;
            while (k <= max_element){
                if (smallest_factor[k] == 0){
                    smallest_factor[k] = i;
                }
                k = k + i;
            }
        }

        int [] smallest_factor_suff = new int[max_element + 1];
        int first_factor;
        int second_factor = 0;
        for (int i = 2; i <= max_element; i++){
            first_factor = smallest_factor[i];
            if (first_factor != 0)  second_factor = i / first_factor;
            if (first_factor != 0 && smallest_factor[second_factor] == 0){
                smallest_factor_suff[i]++;
            }
            smallest_factor_suff[i] += smallest_factor_suff[i - 1];
        }

        int [] result = new int[P.length];

        for (int i = 0; i < P.length; i++){
            result[i] = smallest_factor_suff[Q[i]] - smallest_factor_suff[P[i] - 1];
        }
        return result;
    }
}