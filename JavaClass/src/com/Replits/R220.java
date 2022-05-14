package com.Replits;

public class R220 {
    public static void main(String[] args) {
        String s="00-44 48 555555";
        System.out.println(formatString(s).toString());
    }
    public static String formatString(String s){
        s=s.replaceAll("[^0-9]", "");
        StringBuilder str=new StringBuilder(s);

        for(int i = 0; i<str.length(); i++){
            i+=3;
            str.insert(i,'-');
        }
        str.deleteCharAt(str.length()-1);

        return str.toString();
    }
}
