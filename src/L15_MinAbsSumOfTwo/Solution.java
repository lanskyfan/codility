package L15_MinAbsSumOfTwo;

import java.util.Arrays;

/**
 * Let A be a non-empty array consisting of N integers.
 *
 * The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 *
 * For example, the following array A:
 *
 *   A[0] =  1
 *   A[1] =  4
 *   A[2] = -3
 * has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
 * The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
 * The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
 * The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
 * The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
 * The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
 * The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of
 * indices in this array.
 *
 * For example, given the following array A:
 *
 *   A[0] =  1
 *   A[1] =  4
 *   A[2] = -3
 * the function should return 1, as explained above.
 *
 * Given array A:
 *
 *   A[0] = -8
 *   A[1] =  4
 *   A[2] =  5
 *   A[3] =-10
 *   A[4] =  3
 * the function should return |(−8) + 5| = 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        boolean hasPositive = false;
        boolean hasNegative = false;
        Integer positiveBegin = 0;
        if (A[0] < 0){
            hasNegative = true;
        }
        for (int i = 0; i < A.length; i++){
            if (A[i] >= 0){
                positiveBegin = i;
                hasPositive = true;
                break;
            }
        }

        if (hasNegative == false){
            return 2 * A[0];
        }
        else if (hasPositive == false){
            return Math.abs(2 * A[A.length - 1]);
        }

        int smallest = Integer.MAX_VALUE;
        int present1;
        int present2;
        int negativeIndex = positiveBegin - 1;
        for (int positiveIndex = positiveBegin; positiveIndex < A.length; positiveIndex++){
            while (Math.abs(A[negativeIndex]) < A[positiveIndex] && negativeIndex != 0){
                negativeIndex--;
            }
            present1 = Math.abs(A[negativeIndex] + A[positiveIndex]);
            present2 = Math.abs(A[negativeIndex + 1] + A[positiveIndex]);
            if (A[negativeIndex + 1] >= 0){
                smallest = Integer.min(smallest, present1);
            }
            else {
                present1 = Integer.min(present1, present2);
                smallest = Integer.min(smallest, present1);
            }

        }
        return smallest;
    }
}
