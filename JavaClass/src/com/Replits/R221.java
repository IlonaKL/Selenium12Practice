package com.Replits;

public class R221 {
    public static void main(String[] args) {
        String s="find MaxLen Even";
        System.out.println(findMaxLenEven(s));
    }

    public static String findMaxLenEven(String str)
    {
        String [] words=str.split(" ");
        String max="";
        boolean flag=false;
        for (String word : words) {
            if (word.length() % 2 == 0 && word.length() > max.length()) {
                max=word;
                flag = true;
            }
        }
        if(!flag)
            max="-1";
        return max;
    }
}
