package huawei;

import java.util.Arrays;
import java.util.Comparator;

public class TestMain {

    public static void main(String[] args) {
        Integer integer1 = 100;
        Integer integer2 = 10;

        Integer[] arr = new Integer[]{100, 10};
        System.out.println(integer1.compareTo(integer2));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });

        System.out.println(arr);
    }
}
