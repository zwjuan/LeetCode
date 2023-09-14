package huawei;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 机考2：组成的最大数
 *
 * 对相邻两个数进行排序
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("0");
            }

            String[] arr = input.split(",");

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });

            StringBuilder output = new StringBuilder();
            for (String tmp : arr) {
                output.append(tmp);
            }
            System.out.println(output.toString());
        }

    }
}
