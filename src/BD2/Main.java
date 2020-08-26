package BD2;

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String input_line_1 = scan.nextLine();
            String[] first_line = input_line_1.split(" ");
            String input_line_2 = scan.nextLine();
            String[] second_line = input_line_2.split(" ");
            int total_building = Integer.parseInt(first_line[0]);
            int max_dist = Integer.parseInt(first_line[1]);
            int [] building_array = new int[total_building];
            for (int i =0 ; i < building_array.length; i++){
                building_array[i] = Integer.parseInt(second_line[i]);
            }
            int left_index = 0;
            int right_index = 2;
            int total_solution = 0;
            while (right_index < building_array.length){
                if (right_index - left_index < 2){
                    right_index++;
                    continue;
                }
                if (building_array[right_index] - building_array[left_index] > max_dist){
                    left_index++;
                    continue;
                }
                total_solution += (right_index - left_index) * (right_index - left_index - 1) / 2;
                right_index++;
                total_solution = total_solution % 99997867;
            }
            System.out.println(total_solution);
        }
    }
}
