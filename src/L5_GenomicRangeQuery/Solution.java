package L5_GenomicRangeQuery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
 * which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor,
 * which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 * You are going to answer several queries of the form: What is the minimal impact factor of
 * nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q
 * consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
public class Solution {



//    public static int simple_case(String S, int[] P, int[] Q, int index){
//        int min_impact = impact.get(S.charAt(P[index]));
//        for (int x = P[index]; x <= Q[index]; x++){
//            if (impact.get(S.charAt(x)) < min_impact){
//                min_impact = impact.get(S.charAt(x));
//            }
//            if (min_impact == 1){
//                break;
//            }
//        }
//        return min_impact;
//    }


    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
//        int min_impact = 0;
        HashMap<Character, Integer> impact = new HashMap<Character, Integer>();
        impact.put('A', 1);
        impact.put('C', 2);
        impact.put('G', 3);
        impact.put('T', 4);
//        int []string_impact = new int[S.length()];
//        for (int i = 0; i < S.length(); i++){
//            string_impact[i] = impact.get(S.charAt(i));
//        }
//        for (int index = 0; index < P.length; index++) {
//            int []subarray = Arrays.copyOfRange(string_impact, P[index], Q[index]);
//        }
        int []result = new int[P.length];
        int [] prefix_A = new int[S.length()];
        int [] prefix_C = new int[S.length()];
        int [] prefix_G = new int[S.length()];
        int [] prefix_T = new int[S.length()];

        for (int index = 0; index < S.length(); index++) {
            if (index != 0) {
                prefix_A[index] = prefix_A[index - 1];
                prefix_C[index] = prefix_C[index - 1];
                prefix_G[index] = prefix_G[index - 1];
                prefix_T[index] = prefix_T[index - 1];
            }
            switch (S.charAt(index)) {
                case 'A':
                    prefix_A[index] += 1;
                    break;
                case 'C':
                    prefix_C[index] += 1;
                    break;
                case 'G':
                    prefix_G[index] += 1;
                    break;
                case 'T':
                    prefix_T[index] += 1;
                    break;
            }
        }
        //For example, for the input ('AC', [0, 0, 1], [0, 1, 1]) the solution returned a wrong answer (got [1, 2, 2] expected [1, 1, 2]).
        for (int index = 0; index < P.length; index++) {
            if (Q[index] == P[index]){
                result[index] =impact.get(S.charAt(Q[index]));
                continue;
            }
            if (P[index] == 0){
                if (prefix_A[Q[index]]  != 0){
                    result[index] = 1;
                }
                else if (prefix_C[Q[index]] != 0){
                    result[index] = 2;
                }
                else if (prefix_G[Q[index]] != 0){
                    result[index] = 3;
                }
                else if (prefix_T[Q[index]]  != 0){
                    result[index] = 4;
                }
            }
            else {
                if (prefix_A[Q[index]] - prefix_A[P[index]-1] != 0){
                    result[index] = 1;
                }
                else if (prefix_C[Q[index]] - prefix_C[P[index]-1] != 0){
                    result[index] = 2;
                }
                else if (prefix_G[Q[index]] - prefix_G[P[index]-1] != 0){
                    result[index] = 3;
                }
                else if (prefix_T[Q[index]] - prefix_T[P[index]-1] != 0){
                    result[index] = 4;
                }
            }

        }
        return result;



//        int [] suffix = new int[S.length()];
//        for (int index = S.length() - 1; index >= 0; index--) {
//            if (index != S.length() - 1){
//                suffix[index] = Integer.min(impact.get(S.charAt(index)), suffix[index + 1]);
//            }
//            else{
//                suffix[index] = impact.get(S.charAt(index));
//            }
//        }
//
//        int pref_left;
//        int pref_right;
//        int suff_left;
//        int suff_right;
//        for (int index = 0; index < P.length; index++){
//            pref_left = prefix[P[index]];
//            pref_right = prefix[Q[index]];
//            suff_left = prefix[P[index]];
//            suff_right = prefix[Q[index]];
//            if (pref_left != pref_right){
//                result[index] = pref_right;
//            }
//            else if (suff_left != suff_right){
//                result[index] = suff_left;
//            }
//            else {
//                result[index] = simple_case(S,P, Q, index);
//            }
//        }
    }
}
