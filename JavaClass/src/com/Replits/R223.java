package com.Replits;

import java.util.Scanner;

public class R223 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number=scanner.nextInt();

        for (int i = 0; i < number; i++) {
            for (int j = number-i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
/*
     2
    2 2

      3
     3 3
    3 3 3

       4
      4 4
     4 4 4
    4 4 4 4
 */