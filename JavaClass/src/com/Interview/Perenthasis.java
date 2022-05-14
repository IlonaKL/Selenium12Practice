package com.Interview;

import java.util.Scanner;

public class Perenthasis {
    public static void main(String[] args) {
    /*String s1="(()";
    print(s1);

    String s2="(";
    print(s2);

    String s3=")";
    print(s3);

    String s4="(()))";
    print(s4);

    String s5="(())";
    print(s5);

    String s6="a(b)";
    print(s6);

    String s7=")()(";
    print(s7); */
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        print(str);
        scanner.close();
    }

    public static boolean isBalanced(String s){
        boolean flag=true;
        int size=s.length();
        if(size%2!=0)
            flag=false;
        else{
            int right=0;
            int left=0;
            for(int i=0; i<size; i++){
                if(s.charAt(i)=='(')
                    right++;
                else
                    left++;
            }
            if(right==left)
                flag=true;
            else
                flag=false;
        }
        return flag;
    }

    public static void print(String s){
        System.out.println("input "+s+" -> "+isBalanced(s));
    }

}

