package huawei;

import java.util.Scanner;

/**
 * 判断字符串子序列
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String target = in.nextLine();
            String source = in.nextLine();

            if (target.isEmpty() || source.isEmpty() || target.length() > source.length()) {
                System.out.println(-1);
            }
            int targetLen = target.length(), sourceLen = source.length();
            int i= targetLen-1, j=sourceLen-1;
            while (i>=0) {
                for (; j>=0; j--) {
                    if (target.charAt(i) == source.charAt(j)) {
                        i--;

                        if (i < 0) {
                            break;
                        }

                    }
                }
            }

            if (i < 0) {
                System.out.println(j);
            } else {
                System.out.println(-1);
            }

        }
    }
}
