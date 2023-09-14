package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 机考3：数状查询
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            int n = Integer.parseInt(in.nextLine());


            while (n > 0) {
                String[] s1 = in.nextLine().split(" ");//父
                ArrayList<String> arrayList = new ArrayList<>();
                if (hashMap.containsKey(s1[1])) {
                    arrayList = hashMap.get(s1[1]);
                }
                arrayList.add(s1[0]);
                hashMap.put(s1[1], arrayList);
                n--;
            }
            String search = in.nextLine();
            ArrayList<String> sub = new ArrayList<>(), ret = new ArrayList<>();
            if (hashMap.containsKey(search)) {
                sub = hashMap.get(search);
            }


            if (sub.size() != 0) {
                search(hashMap, sub, ret);
                ret.sort(String::compareTo);
            }


            for (String r : ret) {
                System.out.println(r);
            }
        }
    }


    public static void search(HashMap<String, ArrayList<String>> hashMap, List<String> list, List<String> ret) {
        if (hashMap.size() == 0 || list.size() == 0) {
            return;
        }
        for (String s : list) {
            ret.add(s);
            if (!hashMap.containsKey(s)) {
                continue;
            }
            List<String> tmp = hashMap.get(s);
            search(hashMap, tmp, ret);
        }
    }
}