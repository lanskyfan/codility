package L1_binary_gap;



/**
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
 */
public class Solution {
    static int solution(int N) {
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

    public static void main(String[] Args){
        System.out.printf("%d\n",solution(9));
        System.out.printf("%d\n",solution(529));
        System.out.printf("%d\n",solution(20));
        System.out.printf("%d\n",solution(15));
        System.out.printf("%d\n",solution(32));
    }
}
