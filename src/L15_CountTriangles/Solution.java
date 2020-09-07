package L15_CountTriangles;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int totalCount = 0;
        int pointer1 = 0;
        int pointer2 = 1;
        int pointer3 = 2;

        for (pointer1 = 0; pointer1 < A.length - 2; pointer1++){
            pointer3 = pointer1 + 2;
            for (pointer2 = pointer1 + 1; pointer2 < A.length - 1; pointer2++){
                while (pointer3 < A.length && A[pointer1] + A[pointer2] > A[pointer3]){
                    pointer3++;
                }
                totalCount += pointer3 - pointer2 - 1;
            }
        }
        return totalCount;
    }
}
