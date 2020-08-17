package L5_MinAvgTwoSlice;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
 * is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice
 * with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */

// Cannot pass the test
    // Correct answer: https://stackoverflow.com/questions/21635397/min-average-two-slice-codility


public class Solution {
    static public int solution(int[] A) {
        Float[] final_result = new Float[1];
        int beginning = find_max(A, 0, A.length - 1, final_result);
        System.out.println(beginning);
        System.out.println(final_result[0]);
        return beginning;
    }

    static int find_max(int[] A, int low, int high, Float[] final_result){
        float average = 0;
        int beginning = 0;
        if (high - low == 1){
            average = (float)(A[high] + A[low]) / 2;
            final_result[0] = average;
            return low;
        }
//        else if (high - low == 0){
//            average = A[low];
//            final_result[0] = average;
//            return low;
//        }
        else {
            Float[] left_average = new Float[1];
            Float[] right_average = new Float[1];
            Float[] middle_average = new Float[1];
            int left_start;
            int right_start;
            int []middle_start;
            int middle = (low + high) / 2;
            left_start = find_max(A, low, middle, left_average);
            right_start = find_max(A, middle + 1, high, right_average);
            middle_start = find_max_crossing(A,low, middle, high, middle_average);
            if (left_average[0] < middle_average[0] && left_average[0] < right_average[0]){
                average = left_average[0];
                beginning = left_start;
            }
            else if (left_average[0] > middle_average[0] && middle_average[0] < right_average[0]){
                average = middle_average[0];
                beginning = middle_start[0];
            }
            else {
                average = right_average[0];
                beginning = right_start;
            }
            final_result[0] = average;
            return beginning;
        }
    }

        static int[] find_max_crossing(int[] A, int low, int mid, int high, Float[] result){
        float left_average = Float.MAX_VALUE;
        float right_average = Float.MAX_VALUE;
        float average = 0;
        int present_count = 0;
        int min_left = 0;
        int min_right = 0;
        for (int i = mid; i >= low; i--){
            average = (float)(average * present_count+ A[i]) / (present_count + 1);
//            System.out.printf("Ave = %f,count = %d\n", average, present_count);
            if (Float.compare(average, left_average)<0){
                left_average = average;
                min_left = i;
            }
            present_count++;
        }

        average = 0;
        present_count = 0;
        for (int i = mid + 1; i <= high; i++){
            average = (average * present_count+ A[i]) / (present_count + 1);
            if (average < right_average){
                right_average = average;
                min_right = i;
            }
//            System.out.printf("right Ave = %f,count = %d\n", average, present_count);

            present_count++;
        }
        result[0] =  (left_average * (mid - min_left + 1) + right_average * (min_right - mid)) / (min_right - min_left + 1);
        int [] result_array = new int[]{min_left, min_right};
        return result_array;
    }

    public static void main(String[] args) {
//        int [] result_array;
//        Float []result = new Float[1];
//        result_array = find_max_crossing(new int[]{1,2,3}, 0, 1, 2, result);
//        System.out.printf("length = %d\n", result_array.length);
//        for (int i: result_array) System.out.println(i);
//        System.out.printf("\nresult = %f\n", result[0]);
        solution(new int[]{4,2,2,5,1,5,8});
    }
}
