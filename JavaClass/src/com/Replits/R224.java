package com.Replits;

import java.util.Scanner;

public class R224 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        System.out.println(reverseInteger(number));
    }
    public  static int reverseInteger(int N){
        StringBuilder s = new StringBuilder(Integer.toString(N));
        s=s.reverse();
        N=Integer.valueOf(s.toString());
        return N;
    }
}
