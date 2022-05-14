package com.Replits;

import java.util.Scanner;

public class R226 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(reverse(str));
        scanner.close();
    }
    public static String reverse(String strToRev) {
        String [] words=strToRev.split(" ");
        String newStr="";
        for (int i = words.length-1; i >= 0; i--) {
            newStr=newStr+words[i]+" ";
        }
        return newStr.trim();
    }
}
