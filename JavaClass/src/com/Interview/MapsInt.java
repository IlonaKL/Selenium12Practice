package com.Interview;

import java.util.Map;
import java.util.TreeMap;

public class MapsInt {
    public static String groupTotals(String[] strArr) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String str : strArr) {
            String[] arr = str.split(":");
            String key = arr[0];
            Integer value = Integer.parseInt(arr[1]);

            Integer gotValue = treeMap.get(key);
            if (gotValue == null) {
                treeMap.put(key, value);
            } else {
                treeMap.put(key, treeMap.get(key) + gotValue);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() != 0) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(":");
                stringBuilder.append(entry.getValue());
                stringBuilder.append(",");

            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String [] arr={"A:2", "B:3", "A:-1","C:5"};
        System.out.println(groupTotals(arr));
    }
}
