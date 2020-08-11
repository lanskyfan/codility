package L1_binary_gap;

public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String s = Integer.toBinaryString(N);
        int longest_gap = 0;
        int beginning = 0;
        int end = 0;
        int gap_length = 0;
        int starting_position = 0;
        int ending_position = s.length() - 1;
        while (s.charAt(starting_position) != '1' && starting_position < s.length() - 1){
            starting_position++;
        }
        while (s.charAt(ending_position) != '1' && ending_position > 0){
            ending_position--;
        }
        for (int i = starting_position; i <= ending_position;  i++){
            if (s.charAt(i) == '1' && end == beginning){
                end = i;
                beginning = i;
            }
            else if (s.charAt(i) == '1' && end != beginning){
                gap_length = end - beginning;
                if (gap_length > longest_gap){
                    longest_gap = gap_length;
                }
                beginning = i;
                end = i;
            }
            else if (i != '0'){
                end = i;
            }
        }
        return longest_gap;
    }
}