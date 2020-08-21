package L10_Flags;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that
 *  0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 *
 * You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a
 * figure below. You have to choose how many flags you should take with you. The goal is to set the maximum
 * number of flags on the peaks, according to certain rules.
 *
 *
 *
 * Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be
 * greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.
 *
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 *
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * You can therefore set a maximum of three flags in this case.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the
 * peaks of the array.
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * the function should return 3, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..400,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 */
import java.util.ArrayList;
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        ArrayList<Integer> peaks = new ArrayList<>();
        if (A.length <= 2) return 0;
        for (int i = 1; i < A.length - 1; i++){
            if (A[i - 1] < A[i] && A[i] > A[i + 1]){
                peaks.add(i);
            }
        }
        if (peaks.isEmpty()) return 0;
        int dist = peaks.get(peaks.size() - 1) - peaks.get(0);
        if (dist == 0) return 1;
        int flag_num = 1;
        int largest_flag = 0;
        while (flag_num * (flag_num -1) <= dist){
            int present_position = peaks.get(0);
            int flag_index = 0;
            int flag_count = 1;
            while (flag_index <= peaks.size() - 1 && flag_count < flag_num){
                if (peaks.get(flag_index) - present_position >= flag_num){
                    flag_count++;
                    present_position = peaks.get(flag_index);
                }
                flag_index++;
            }
            if (flag_count >= flag_num){
                largest_flag = flag_num;
            }
            flag_num++;
        }
        return largest_flag;
    }
}

