package BD1;

import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            int string_num = Integer.parseInt(scan.nextLine());
            String input_string;
            for (int i = 0; i < string_num; i++){
                input_string = scan.nextLine();
                int left_position = 0;
                Character char1;
                Character char2;
                Character char3;
                Character char4;
                String new_string;
                int present_length = input_string.length();
                ArrayList<Character> char_list = new ArrayList<>();
                for (int x = 0 ; x < input_string.length(); x++){
                    char_list.add(input_string.charAt(x));
                }
                while (left_position <= present_length - 4){
                    char1 = char_list.get(left_position);
                    char2 = char_list.get(left_position + 1);
                    char3 = char_list.get(left_position + 2);
                    char4 = char_list.get(left_position + 3);
                    if (char1 == char2 && char2 == char3){
                        char_list.remove(left_position + 2);
                        present_length --;
                    }
                    else if (char1 == char2 && char3 == char4){
                        char_list.remove(left_position + 3);
                        present_length --;
                    }
                    else{
                        left_position++;
                    }
                }
                int length = char_list.size();
                if (char_list.get(length - 1) == char_list.get(length - 2) && char_list.get(length - 2) == char_list.get(length - 3)){
                    char_list.remove(length - 1);
                }
                String result = "";
                Iterator<Character> iter = char_list.iterator();
                while (iter.hasNext()){
                    result += iter.next();
                }
                System.out.println(result);
            }
        }
    }
}
