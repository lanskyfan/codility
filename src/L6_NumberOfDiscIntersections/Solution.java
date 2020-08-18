package L6_NumberOfDiscIntersections;

import java.util.TreeMap;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int [] left_boundary = new int[A.length];
        int [] right_boundary = new int[A.length];
        int temp_point = 0;
        for (int i = 0; i < A.length; i++){
            temp_point = i - A[i];
            if (temp_point < 0){
                temp_point = 0;
            }
            left_boundary[temp_point]++;

            temp_point = i + A[i];
            if (A[i] < A.length && temp_point < A.length){
                right_boundary[temp_point]++;
            }
        }

        int temp_open = 0;
        int total_pair = 0;
        int temp_pair = 0;
        for (int i = 0; i < A.length; i++){
            temp_pair = left_boundary[i] * (left_boundary[i] - 1) / 2;
            total_pair += temp_pair;
            total_pair += temp_open * left_boundary[i];
            temp_open += left_boundary[i];
            temp_open -= right_boundary[i];
            if (total_pair > 10000000){
                return -1;
            }
        }
        return total_pair;
    }
}
