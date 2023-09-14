package other;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * test类
 */
public class Test {
    public static void main(String[] args) {
        //HashMap
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        map.get("123");

        map = Collections.synchronizedMap(map);

        map.put("123", "123");

        //ConcurrentHashMap
        ConcurrentMap<String, String> concurrentHashMap  = new ConcurrentHashMap<>();
        concurrentHashMap.put("123", "123");
        concurrentHashMap.get("123");
    }
}
